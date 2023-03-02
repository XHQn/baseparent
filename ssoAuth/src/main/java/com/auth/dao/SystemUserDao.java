package com.auth.dao;
import com.auth.pojo.UserRoleDTO;
import com.baseCommon.dao.BaseDao;
import com.auth.pojo.SystemUser;

import java.util.List;

public interface SystemUserDao  extends BaseDao<SystemUser>{
    public UserRoleDTO selectUserwithRole(String userId);
}
