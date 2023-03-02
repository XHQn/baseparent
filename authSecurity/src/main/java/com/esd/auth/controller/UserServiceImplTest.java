package com.esd.auth.controller;

import com.esd.auth.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
@Scope(value = "prototype")
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "getAll",method = RequestMethod.GET)
    public void queryAll(HttpServletRequest request) {
        String datasource = request.getHeader("datasource");
        System.out.println(datasource);
        userService.queryAll().forEach(System.out::println);
    }
}