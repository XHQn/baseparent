package com.auth.service.impl;

import com.auth.mapper.SystemUserMapper;
import com.auth.pojo.SystemUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.auth.pojo.LoginUser;
import com.auth.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {

        //查询用户信息
        LambdaQueryWrapper<SystemUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SystemUser::getLoginname,loginName);
        SystemUser systemUser = systemUserMapper.selectOne(queryWrapper);
        //如果没有查询到用户就抛出异常
        if(Objects.isNull(systemUser)){
            throw new RuntimeException("用户名或者密码错误");
        }

//        List<String> list = new ArrayList<>(Arrays.asList("test","admin"));
        List<String> list = menuMapper.selectPermsByUserId(systemUser.getId());
        System.out.println("list： " + list);

        //把数据封装成UserDetails返回
        return new LoginUser(systemUser,list);
    }
}
