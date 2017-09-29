package im.common.handlers.impl;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import im.common.IMPacket;
import im.common.handlers.BaseHandler;
import im.common.protof.RequestModel;
import im.common.protof.ResponseModel;
import im.common.util.HandlerCode;
import im.common.util.RequestCode;
import im.common.util.ResponseCode;
import im.common.util.annotation.IMInterceptor;
import im.common.util.annotation.IMRequest;
import im.common.util.tool.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.tio.core.Aio;
import org.tio.core.ChannelContext;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;



@IMRequest(requestCode = RequestCode.LOGIN)
@IMInterceptor
public class LoginHandler implements BaseHandler {
    @Autowired
    UserService userService;
    private static Logger log = LoggerFactory.getLogger(LoginHandler.class);
    @Override
    public String init(RequestModel.ImRequest imRequest, ChannelContext<Object, IMPacket, Object> channelContext) {
        String userJson = imRequest.getData();
        User user = User.toUser(userJson);
        String pwd = "";
        try {
            pwd= MD5Util.EncoderByMD5(user.getPwd());
        } catch (NoSuchAlgorithmException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            log.info(e.getMessage());
            e.printStackTrace();
        }
        User muser = userService.selectUserByUserNumAndPwd(user.getUserNum(),pwd);
        if(muser == null){
            //没有注册
            ResultMsg resultMsg = new ResultMsg();
            resultMsg.setResultCode(ResultMsgCode.LOGIN_FAIL);
            resultMsg.setResultMsg("登录失败");
            ResponseModel.ImResponse imResponse = ProtoBufUtil.responseModelFactory(ResponseCode.RES_LOGIN, HandlerCode.RESPONSE,"0","0", System.currentTimeMillis()+"", JSONObject.toJSONString(resultMsg));
            IMSend.send(channelContext,imResponse);
            return null;
        }
        //绑定tio
        Aio.bindUser(channelContext,user.getUserNum());
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setResultCode(ResultMsgCode.LOGIN_SCUSSE);
        resultMsg.setResultMsg("登录成功");
        ResponseModel.ImResponse imResponse = ProtoBufUtil.responseModelFactory(ResponseCode.RES_LOGIN,HandlerCode.RESPONSE,"0","0", System.currentTimeMillis()+"", JSONObject.toJSONString(resultMsg));
        IMSend.send(channelContext,imResponse);
        return null;
    }
}
