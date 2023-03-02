package com.auth.controller;

import com.auth.pojo.ResponseResult;
import com.auth.pojo.SystemUser;
import com.auth.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody SystemUser systemUser){
        //登录
        return loginServcie.login(systemUser);
    }

    @RequestMapping("/user/logout")
    public ResponseResult logout(){
        return loginServcie.logout();
    }
}
