package com.auth.dao.impl;
import com.auth.pojo.PermissionRoleDTO;
import com.auth.pojo.PermissionUserDTO;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemPermissionDao;
import com.auth.mapper.SystemPermissionMapper;
import com.auth.pojo.SystemPermission;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemPermissionDaoImpl extends BaseDaoImpl<SystemPermission> implements SystemPermissionDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemPermissionMapper systemPermissionMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemPermission systemPermission) {
        systemPermissionMapper.insert(systemPermission);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemPermission systemPermission) {
        systemPermissionMapper.updateById(systemPermission);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemPermissionMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public SystemPermission selectById(String id) {
        return systemPermissionMapper.selectById(id);
    }

    @Override
    public PageResult<SystemPermission> selectList(int pageSize, int page, SystemPermission systemPermission) {
        Page<SystemPermission> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemPermission> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemPermissionMapper);

        if(StringUtil.isNotNull(systemPermission.getDescription() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermission::getDescription,"%"+ systemPermission.getDescription() +"%");
        }

        if(StringUtil.isNotNull(systemPermission.getName() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermission::getName,"%"+ systemPermission.getName() +"%");
        }


        if(StringUtil.isNotNull(systemPermission.getPid() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermission::getPid,"%"+ systemPermission.getPid() +"%");
        }

        if(StringUtil.isNotNull(systemPermission.getCode() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermission::getCode,"%"+ systemPermission.getCode() +"%");
        }


        Page<SystemPermission> systemPermissionPage = (Page<SystemPermission>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemPermission> pageResult = new PageResult<SystemPermission>(systemPermissionPage.getTotal(),systemPermissionPage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemPermission> selectAll() {
        return systemPermissionMapper.selectList(null);
    }

    /**
     * 查询Permission和role的数据
     * @param id
     * @return
     */
    @Override
    public PermissionRoleDTO selectPermissionWithRole(String id) {

        return systemPermissionMapper.selectPermissionAndRole(id);
    }

    @Override
    public PermissionUserDTO selectUserIdwithPermission(String userId) {
        return systemPermissionMapper.selectUserIdWithPermission(userId);
    }
}
