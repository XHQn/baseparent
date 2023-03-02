package com.auth.mapper;

import com.auth.pojo.UserRoleDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.auth.pojo.SystemUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface SystemUserMapper extends BaseMapper<SystemUser> {
        UserRoleDTO selectUserWithRole(String userId);

}
