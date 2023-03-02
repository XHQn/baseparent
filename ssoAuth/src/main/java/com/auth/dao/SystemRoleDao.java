package com.auth.dao;
import com.auth.pojo.RolePermissionDTO;
import com.baseCommon.dao.BaseDao;
import com.auth.pojo.SystemRole;

public interface SystemRoleDao  extends BaseDao<SystemRole> {
    RolePermissionDTO selectRoleAndPermission(String roleId);
}
