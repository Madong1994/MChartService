package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

/**
 * Created by 马东 on 2017/9/23.
 */
public class BaseController {
    @Autowired
    UserService userService;
}
