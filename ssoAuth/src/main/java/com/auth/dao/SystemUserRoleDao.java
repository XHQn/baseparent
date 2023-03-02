package com.auth.dao;
import com.auth.pojo.SystemRole;
import com.baseCommon.dao.BaseDao;
import com.auth.pojo.SystemUserRole;

import java.util.List;

public interface SystemUserRoleDao  extends BaseDao<SystemUserRole> {
        List<SystemUserRole> selectByID(String id);
        public void deleteUserId(String UserId);
}
