package com.auth.dao.impl;
import com.auth.pojo.UserRoleDTO;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemUserDao;
import com.auth.mapper.SystemUserMapper;
import com.auth.pojo.SystemUser;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemUserDaoImpl extends BaseDaoImpl<SystemUser> implements SystemUserDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemUserMapper systemUserMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemUser systemUser) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        systemUser.setId(id);
        systemUserMapper.insert(systemUser);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemUser systemUser) {
        systemUserMapper.updateById(systemUser);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemUserMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public SystemUser selectById(String id) {
        return systemUserMapper.selectById(id);
    }

    @Override
    public PageResult<SystemUser> selectList(int pageSize, int page, SystemUser systemUser) {
        Page<SystemUser> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemUser> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemUserMapper);

        if(StringUtil.isNotNull(systemUser.getLoginname() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getLoginname,"%"+ systemUser.getLoginname() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getUsername() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getUsername,"%"+ systemUser.getUsername() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getPassword() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getPassword,"%"+ systemUser.getPassword() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getOpenid() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getOpenid,"%"+ systemUser.getOpenid() +"%");
        }



        if(StringUtil.isNotNull(systemUser.getDepartmentId() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getDepartmentId,"%"+ systemUser.getDepartmentId() +"%");
        }



        if(StringUtil.isNotNull(systemUser.getWorkNumber() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getWorkNumber,"%"+ systemUser.getWorkNumber() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getFormOfManagement() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getFormOfManagement,"%"+ systemUser.getFormOfManagement() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getWorkingCity() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getWorkingCity,"%"+ systemUser.getWorkingCity() +"%");
        }



        if(StringUtil.isNotNull(systemUser.getCompanyId() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getCompanyId,"%"+ systemUser.getCompanyId() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getCompanyName() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getCompanyName,"%"+ systemUser.getCompanyName() +"%");
        }

//        if(StringUtil.isNotNull(systemUser.getDepartmentName() + "" )) {
//            lambdaQueryChainWrapper.like(SystemUser::getDepartmentName,"%"+ systemUser.getDepartmentName() +"%");
//        }

        if(StringUtil.isNotNull(systemUser.getLevel() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getLevel,"%"+ systemUser.getLevel() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getStaffPhoto() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getStaffPhoto,"%"+ systemUser.getStaffPhoto() +"%");
        }


        if(StringUtil.isNotNull(systemUser.getStationid() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getStationid,"%"+ systemUser.getStationid() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getStationname() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getStationname,"%"+ systemUser.getStationname() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getFirstid() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getFirstid,"%"+ systemUser.getFirstid() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getFirstclass() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getFirstclass,"%"+ systemUser.getFirstclass() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getSecondid() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getSecondid,"%"+ systemUser.getSecondid() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getSecondclass() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getSecondclass,"%"+ systemUser.getSecondclass() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getThirdid() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getThirdid,"%"+ systemUser.getThirdid() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getThirdclass() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getThirdclass,"%"+ systemUser.getThirdclass() +"%");
        }

        if(StringUtil.isNotNull(systemUser.getDisplayname() + "" )) {
            lambdaQueryChainWrapper.like(SystemUser::getDisplayname,"%"+ systemUser.getDisplayname() +"%");
        }

        Page<SystemUser> systemUserPage = (Page<SystemUser>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemUser> pageResult = new PageResult<SystemUser>(systemUserPage.getTotal(),systemUserPage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemUser> selectAll() {
        return systemUserMapper.selectList(null);
    }
    public UserRoleDTO selectUserwithRole(String userId)
    {
        return systemUserMapper.selectUserWithRole(userId);
    }

}
