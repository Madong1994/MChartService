package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired(required=true)
    private UserDao userDao;
    public User selectUserByUserNumAndPwd(String userNum, String pwd){
        return userDao.selectByNumAndPwd(userNum,pwd);
    }
    public int insertUser(User user){
        return userDao.insertUser(user.getUserName(),user.getUserNum(),user.getPwd());
    }

    @Override
    public User selectByNum(String userNum) {
        return userDao.selectByNum(userNum);
    }
}
