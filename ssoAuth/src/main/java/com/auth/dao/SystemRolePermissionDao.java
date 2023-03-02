package com.auth.dao;
import com.baseCommon.dao.BaseDao;
import com.auth.pojo.SystemRolePermission;

import java.util.List;

public interface SystemRolePermissionDao  extends BaseDao<SystemRolePermission> {
    void deleteByIdPermission(String id);

    List<SystemRolePermission> selectByIdPermission(String id);

    List<SystemRolePermission> selectByID(String roleId);
    void deleteRoleAndPermission(String roleId);
}
