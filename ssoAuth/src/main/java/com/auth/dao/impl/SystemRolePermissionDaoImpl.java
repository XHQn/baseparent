package com.auth.dao.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemRolePermissionDao;
import com.auth.mapper.SystemRolePermissionMapper;
import com.auth.pojo.SystemRolePermission;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemRolePermissionDaoImpl extends BaseDaoImpl<SystemRolePermission> implements SystemRolePermissionDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemRolePermissionMapper systemRolePermissionMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemRolePermission systemRolePermission) {
        systemRolePermissionMapper.insert(systemRolePermission);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemRolePermission systemRolePermission) {
        systemRolePermissionMapper.updateById(systemRolePermission);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemRolePermissionMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public SystemRolePermission selectById(String id) {
        return systemRolePermissionMapper.selectById(id);
    }

    @Override
    public PageResult<SystemRolePermission> selectList(int pageSize, int page, SystemRolePermission systemRolePermission) {
        Page<SystemRolePermission> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemRolePermission> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemRolePermissionMapper);

        Page<SystemRolePermission> systemRolePermissionPage = (Page<SystemRolePermission>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemRolePermission> pageResult = new PageResult<SystemRolePermission>(systemRolePermissionPage.getTotal(),systemRolePermissionPage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemRolePermission> selectAll() {
        return systemRolePermissionMapper.selectList(null);
    }

    /**
     * 删除Permission表中对应ID的数据
     * @param id
     */
    @Override
    public void deleteByIdPermission(String id) {
        LambdaQueryWrapper<SystemRolePermission> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtil.isNotNull(id),SystemRolePermission::getPermissionId,id);
        systemRolePermissionMapper.delete(lambdaQueryWrapper);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public List<SystemRolePermission> selectByIdPermission(String id) {
        LambdaQueryWrapper<SystemRolePermission> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtil.isNotNull(id),SystemRolePermission::getPermissionId,id);
        return systemRolePermissionMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<SystemRolePermission> selectByID(String roleId) {
        LambdaQueryWrapper<SystemRolePermission> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtil.isNotNull(roleId),SystemRolePermission::getRoleId,roleId);
        return  systemRolePermissionMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public void deleteRoleAndPermission(String roleId) {
        LambdaQueryWrapper<SystemRolePermission> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StringUtil.isNotNull(roleId),SystemRolePermission::getRoleId,roleId);
        systemRolePermissionMapper.delete(lambdaQueryWrapper);
    }
}
