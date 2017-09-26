package com.example.demo.controller.other;

import com.example.demo.controller.BaseController;
import com.example.demo.entity.User;
import im.common.util.tool.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 马东 on 2017/9/23.
 */
@Controller
@RequestMapping("/regist")
public class RegistController extends BaseController {
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        User user = userService.selectUserByUserNumAndPwd("123456","123456");
        System.out.println("------------>"+user.getUserName());
        return "test";
    }
    @RequestMapping("/user")
    @ResponseBody
    public String regist(){//HttpServletRequest request,@RequestBody String userJson
//        User user = User.toUser(userJson);
        User user = new User();
        user.setId(2);
        user.setUserName("md1994");
        user.setPwd("123456");
        user.setUserNum("123456");
        User offUser = userService.selectByNum(user.getUserNum());
        if(offUser != null){
            return "该账号已经被注册!";
        }
        String pwd = "";
        try {
            pwd = MD5Util.EncoderByMD5(user.getPwd());
            user.setPwd(pwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "注册失败";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "注册失败";
        }
        int i = 0;
        if(!"".equals(pwd)){
            i = userService.insertUser(user);
        }
        if(i > 0){
            return "注册成功";
        }
        return "注册失败";
    }
}
