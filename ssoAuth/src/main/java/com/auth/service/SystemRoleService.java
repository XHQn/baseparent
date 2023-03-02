package com.auth.service;
import com.auth.dao.SystemRoleDao;
import com.auth.dao.SystemRolePermissionDao;
import com.auth.dao.SystemUserDao;
import com.auth.dao.SystemUserRoleDao;
import com.auth.pojo.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baseCommon.entity.PageResult;
import com.baseCommon.entity.Result;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;

import java.util.Iterator;
import java.util.List;

@Service
public class SystemRoleService extends BaseService {
    @Autowired
    private SystemUserRoleDao systemUserRoleDao;

    @Autowired
    private SystemRoleDao systemRoleDao;

    @Autowired
    private IdWorker idWorker;
    @Autowired
    private SystemRolePermissionDao systemRolePermissionDao;

    /**
     * 保存
     */
    public void insert(SystemRole systemRole) {
//        //基本属性的设置
//        String id = idWorker.nextId()+"";
//        systemRole.setId(id);
        systemRoleDao.add(systemRole);
    }

    /**
     * 更新
     */
    public void update(SystemRole systemRole) {
        systemRoleDao.update(systemRole);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemRoleDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemRole selectById(String id) {
        return systemRoleDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemRole> selectList(int pagesize, int page,SystemRole systemRole) {
        return systemRoleDao.selectList(pagesize,page,systemRole);
    }

    /**
     * 查询全部列表
     */
    public List<SystemRole> selectAll() {
        return systemRoleDao.selectAll();
    }

    /**
     * 根据roleId，查询permssion实体类
     */
    public RolePermissionDTO selectRolePermission(String roleId)
    {
        if(!StringUtil.isNotNull(roleId))
        {
            return null;
        }
        RolePermissionDTO rolePermissionDTO = systemRoleDao.selectRoleAndPermission(roleId);
        return  rolePermissionDTO;
    }

    public int savaRoleAndPermission(RolePermissionDTO rolePermissionDTO) {
        if(rolePermissionDTO==null && rolePermissionDTO.getId()==null)
        {
            return 0;
        }

        SystemRole systemRole=new SystemRole();
        BeanUtils.copyProperties(rolePermissionDTO,systemRole);
        systemRoleDao.update(systemRole);

        List<SystemPermission> systemPermissionList = rolePermissionDTO.getSystemPermissionList();
        if(systemPermissionList==null && systemPermissionList.size()<=0)
        {
            return 0;
        }

        systemRolePermissionDao.deleteRoleAndPermission(systemRole.getId());
        for(SystemPermission systemPermission:systemPermissionList)
        {
            SystemRolePermission systemRolePermission=new SystemRolePermission();
            systemRolePermission.setPermissionId(systemPermission.getId());
            systemRolePermission.setRoleId(rolePermissionDTO.getId());
            systemRolePermissionDao.add(systemRolePermission);
        }
        return 1;
    }

    public int deleteRoleAndPermission(String roleId) {
        //判断roleId是否存在
        if(!StringUtil.isNotNull(roleId))
        {
            return 0;
        }
        //删除roleId
        systemRoleDao.deleteById(roleId);
        //删除RolePermission中数据
        systemRolePermissionDao.deleteRoleAndPermission(roleId);
        return 1;
    }

    public int insertRoleAndPermission(RolePermissionDTO rolePermissionDTO) {
        //roleId是否存在
        if(!StringUtil.isNotNull(rolePermissionDTO.getId()))
        {
            return 0;
        }
        //添加role实体
        SystemRole systemRole=new SystemRole();
        BeanUtils.copyProperties(rolePermissionDTO,systemRole);
        systemRoleDao.add(systemRole);
        //判断prtmissionList是否存在
        List<SystemPermission> systemPermissionList = rolePermissionDTO.getSystemPermissionList();
        if(systemPermissionList==null &&systemPermissionList.size()<=0)
        {
            return 0;
        }
        //添加
        for(SystemPermission systemPermission:systemPermissionList)
        {
            SystemRolePermission systemRolePermission=new SystemRolePermission();
            systemRolePermission.setRoleId(rolePermissionDTO.getId());
            systemRolePermission.setPermissionId(systemPermission.getId());
            systemRolePermissionDao.add(systemRolePermission);
        }
       return 1;
    }
}
