package com.example.demo.service;


import com.example.demo.entity.User;

/**
 * Created by 马东 on 2017/9/24.
 */
public interface UserService {
    public User selectUserByUserNumAndPwd(String userNum, String pwd);
    public int insertUser(User user);
    public User selectByNum(String userNum);
}
