package com.auth.dao;
import com.auth.pojo.PermissionRoleDTO;
import com.auth.pojo.PermissionUserDTO;
import com.baseCommon.dao.BaseDao;
import com.auth.pojo.SystemPermission;

public interface SystemPermissionDao  extends BaseDao<SystemPermission> {
    PermissionRoleDTO selectPermissionWithRole(String id);
    PermissionUserDTO selectUserIdwithPermission(String userId);
}
