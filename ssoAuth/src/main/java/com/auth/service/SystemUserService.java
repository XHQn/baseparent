package com.auth.service;
import com.auth.dao.SystemUserDao;
import com.auth.dao.SystemUserRoleDao;
import com.auth.pojo.SystemRole;
import com.auth.pojo.SystemUser;
import com.auth.pojo.SystemUserRole;
import com.auth.pojo.UserRoleDTO;
import com.baseCommon.entity.PageResult;
import com.commonTool.utils.StringUtil;
import org.assertj.core.error.ElementsShouldBeAtLeast;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;

import java.rmi.StubNotFoundException;
import java.util.List;

@Service
public class SystemUserService extends BaseService {
    @Autowired
    private SystemUserRoleDao systemUserRoleDao;
    @Autowired
    private SystemUserDao systemUserDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void insert(SystemUser systemUser) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        systemUser.setId(id);
        systemUserDao.add(systemUser);
    }

    /**
     * 更新
     */
    public void update(SystemUser systemUser) {
        systemUserDao.update(systemUser);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemUserDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemUser selectById(String id) {
        return systemUserDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemUser> selectList(int pagesize, int page,SystemUser systemUser) {
        return systemUserDao.selectList(pagesize,page,systemUser);
    }

    /**
     * 查询全部列表
     */
    public List<SystemUser> selectAll() {
        return systemUserDao.selectAll();
    }

    /**
     * 查询User和Role
     * @param userId
     * @return
     */
    //修改
    public UserRoleDTO selectUserandRole(String userId)
    {
        if(userId==null)
        {
            return null;
        }
        UserRoleDTO userRoleDTO = systemUserDao.selectUserwithRole(userId);
        if(userRoleDTO==null)
        {
            return null;
        }
        return userRoleDTO;
    }


    /**
     *删除用户实体并且删除system_user_role表中的信息
     */
    //修改
    public int deleteByIdAndUserRole(String id) {
        if(!StringUtil.isNotNull(id))
        {
            return 0;
        }

        SystemUser systemUser = systemUserDao.selectById(id);

        systemUserDao.deleteById(id);

        systemUserRoleDao.deleteUserId(id);

        return 1;
    }

    public int updateByPassword(String userId) {
        if(!StringUtil.isNotNull(userId))
        {
            return 0;
        }

        SystemUser systemUser = systemUserDao.selectById(userId);
        if(systemUser == null)
        {
            return 0;
        }
        systemUser.setPassword("123456");
        systemUserDao.update(systemUser);
        return 1;
    }

    public int updateByStatus(String userId, Integer status) {
        //判断userId是否存在
        if(!StringUtil.isNotNull(userId))
        {
            return 0;
        }
        //查询SystemUser
        SystemUser systemUser = systemUserDao.selectById(userId);
        //判断SystemUser是否存在
        if(systemUser ==null )
        {
            return 0;
        }
        //修改状态
        systemUser.setInServiceStatus(status);
        systemUserDao.update(systemUser);
        return 1;
    }
    /**
     * 修改User重构UserRole
     * @param userRoleDTO
     * @return
     */
    public int saveUserAndRole(UserRoleDTO userRoleDTO) {
        if(userRoleDTO == null){
            return 0;
        }

        if(!StringUtil.isNotNull(userRoleDTO.getId()))
        {
            return 0;
        }

        SystemUser systemUser = new SystemUser();
        BeanUtils.copyProperties(userRoleDTO,systemUser);
        systemUserDao.update(systemUser);

        List<SystemRole> systemRoleList = userRoleDTO.getSystemRoleList();

        if(systemRoleList == null && systemRoleList.size() <= 0 ){
            return 0;
        }

        systemUserRoleDao.deleteUserId(userRoleDTO.getId());
        for (SystemRole systemRole : systemRoleList) {
            SystemUserRole systemUserRole = new SystemUserRole();
            systemUserRole.setRoleId(systemRole.getId());
            systemUserRole.setUserId(userRoleDTO.getId());
            systemUserRoleDao.add(systemUserRole);
        }
        return 1;
    }
}
