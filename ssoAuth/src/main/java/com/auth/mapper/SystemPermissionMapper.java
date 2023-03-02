package com.auth.mapper;

import com.auth.pojo.PermissionRoleDTO;
import com.auth.pojo.PermissionUserDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.auth.pojo.SystemPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface SystemPermissionMapper extends BaseMapper<SystemPermission> {
    PermissionRoleDTO selectPermissionAndRole(String id);
    PermissionUserDTO selectUserIdWithPermission(String userId);
}
