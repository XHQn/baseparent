package com.esd.auth.service;
import com.baseCommon.service.BaseService;
import com.esd.auth.mapper.UserMapper;
import com.esd.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl extends BaseService {
    @Autowired
    private UserMapper userMapper;
    //查询全部
    public List<User> queryAll() {
        return userMapper.selectList(null);
    }
}