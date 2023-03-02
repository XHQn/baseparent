package com.auth.mapper;

import com.auth.pojo.RolePermissionDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.auth.pojo.SystemRole;
import org.apache.ibatis.annotations.Mapper;

public interface SystemRoleMapper extends BaseMapper<SystemRole> {
    RolePermissionDTO selectRoleWithPermission(String roleId);
}
