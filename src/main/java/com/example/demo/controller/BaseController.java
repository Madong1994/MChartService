package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 马东 on 2017/9/23.
 */
public class BaseController {
    @Autowired
    public UserService userService;
}
