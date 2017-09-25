package com.example.demo.controller;

import entity.User;
import im.common.util.tool.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 马东 on 2017/9/23.
 */
@Controller
@RequestMapping("/regist")
public class RegistController extends BaseController{
    @RequestMapping("/user")
    @ResponseBody
    public String regist(HttpServletRequest request,@RequestBody String userJson){
        User user = User.toUser(userJson);
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
