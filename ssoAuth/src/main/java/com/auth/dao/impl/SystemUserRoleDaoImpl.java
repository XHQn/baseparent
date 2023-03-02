package com.auth.dao.impl;
import com.auth.pojo.SystemRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemUserRoleDao;
import com.auth.mapper.SystemUserRoleMapper;
import com.auth.pojo.SystemUserRole;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemUserRoleDaoImpl extends BaseDaoImpl<SystemUserRole> implements SystemUserRoleDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemUserRoleMapper systemUserRoleMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemUserRole systemUserRole) {
        systemUserRoleMapper.insert(systemUserRole);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemUserRole systemUserRole) {
        systemUserRoleMapper.updateById(systemUserRole);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemUserRoleMapper.deleteById(id);
    }

    public void deleteUserId(String UserId) {
        LambdaQueryWrapper<SystemUserRole> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtil.isNotNull(UserId),SystemUserRole::getUserId,UserId);
        systemUserRoleMapper.delete(lambdaQueryWrapper);
    }
    /**
     * 根据id查询
     */
    @Override
    public SystemUserRole selectById(String id) {
        return systemUserRoleMapper.selectById(id);
    }

    @Override
    public PageResult<SystemUserRole> selectList(int pageSize, int page, SystemUserRole systemUserRole) {
        Page<SystemUserRole> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemUserRole> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemUserRoleMapper);

        Page<SystemUserRole> systemUserRolePage = (Page<SystemUserRole>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemUserRole> pageResult = new PageResult<SystemUserRole>(systemUserRolePage.getTotal(),systemUserRolePage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemUserRole> selectAll() {
        return systemUserRoleMapper.selectList(null);
    }

    @Override
    public List<SystemUserRole> selectByID(String id) {
        LambdaQueryWrapper<SystemUserRole> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SystemUserRole::getUserId,id);
        return  systemUserRoleMapper.selectList(lambdaQueryWrapper);
    }
}
