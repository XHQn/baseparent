package com.auth.dao.impl;
import com.auth.pojo.RolePermissionDTO;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemRoleDao;
import com.auth.mapper.SystemRoleMapper;
import com.auth.pojo.SystemRole;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemRoleDaoImpl extends BaseDaoImpl<SystemRole> implements SystemRoleDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemRoleMapper systemRoleMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemRole systemRole) {
        systemRoleMapper.insert(systemRole);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemRole systemRole) {
        systemRoleMapper.updateById(systemRole);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemRoleMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public SystemRole selectById(String id) {
        return systemRoleMapper.selectById(id);
    }

    @Override
    public PageResult<SystemRole> selectList(int pageSize, int page, SystemRole systemRole) {
        Page<SystemRole> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemRole> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemRoleMapper);

        if(StringUtil.isNotNull(systemRole.getName() + "" )) {
            lambdaQueryChainWrapper.like(SystemRole::getName,"%"+ systemRole.getName() +"%");
        }

        if(StringUtil.isNotNull(systemRole.getDescription() + "" )) {
            lambdaQueryChainWrapper.like(SystemRole::getDescription,"%"+ systemRole.getDescription() +"%");
        }

        if(StringUtil.isNotNull(systemRole.getCompanyId() + "" )) {
            lambdaQueryChainWrapper.like(SystemRole::getCompanyId,"%"+ systemRole.getCompanyId() +"%");
        }

        Page<SystemRole> systemRolePage = (Page<SystemRole>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemRole> pageResult = new PageResult<SystemRole>(systemRolePage.getTotal(),systemRolePage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemRole> selectAll() {
        return systemRoleMapper.selectList(null);
    }

    @Override
    public RolePermissionDTO selectRoleAndPermission(String roleId) {

        return systemRoleMapper.selectRoleWithPermission(roleId);
    }
}
