package com.auth.service;
import com.auth.dao.SystemPermissionDao;
import com.auth.dao.SystemRolePermissionDao;
import com.auth.dao.SystemUserRoleDao;
import com.auth.pojo.*;
import com.baseCommon.entity.PageResult;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemPermissionService extends BaseService {
    @Autowired
    private SystemRolePermissionDao systemRolePermissionDao;
    @Autowired
    private SystemPermissionDao systemPermissionDao;
    @Autowired
    private SystemUserRoleDao systemUserRoleDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void insert(SystemPermission systemPermission) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        systemPermission.setId(id);
        systemPermissionDao.add(systemPermission);
    }

    /**
     * 更新
     */
    public void update(SystemPermission systemPermission) {
        systemPermissionDao.update(systemPermission);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemPermissionDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemPermission selectById(String id) {
        return systemPermissionDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemPermission> selectList(int pagesize, int page,SystemPermission systemPermission) {
        return systemPermissionDao.selectList(pagesize,page,systemPermission);
    }

    /**
     * 查询全部列表
     */
    public List<SystemPermission> selectAll() {
        return systemPermissionDao.selectAll();
    }

    /**
     * 查询Permission和Role的数据
     */
    //修改过
    public PermissionRoleDTO selectPermisssionAndRole(String id)
    {
        if(!StringUtil.isNotNull(id))
        {
            return null;
        }
        PermissionRoleDTO permissionRoleDTO = systemPermissionDao.selectPermissionWithRole(id);
        return  permissionRoleDTO;
    }

    public int deleteByIdRolePermission(String id) {
        if(!StringUtil.isNotNull(id))
        {
           return 0;
        }
        systemPermissionDao.deleteById(id);

        systemRolePermissionDao.deleteByIdPermission(id);
        return 1;
    }

    public PermissionUserDTO selectUserIdAndPermission(String userId) {
        if(!StringUtil.isNotNull(userId)){
           return null;
        }
        PermissionUserDTO permissionUserDTO = systemPermissionDao.selectUserIdwithPermission(userId);
        return permissionUserDTO;
    }
}
