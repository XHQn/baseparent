package com.auth.dao.impl;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemPermissionApiDao;
import com.auth.mapper.SystemPermissionApiMapper;
import com.auth.pojo.SystemPermissionApi;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemPermissionApiDaoImpl extends BaseDaoImpl<SystemPermissionApi> implements SystemPermissionApiDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemPermissionApiMapper systemPermissionApiMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemPermissionApi systemPermissionApi) {
        systemPermissionApiMapper.insert(systemPermissionApi);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemPermissionApi systemPermissionApi) {
        systemPermissionApiMapper.updateById(systemPermissionApi);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemPermissionApiMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public SystemPermissionApi selectById(String id) {
        return systemPermissionApiMapper.selectById(id);
    }

    @Override
    public PageResult<SystemPermissionApi> selectList(int pageSize, int page, SystemPermissionApi systemPermissionApi) {
        Page<SystemPermissionApi> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemPermissionApi> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemPermissionApiMapper);

        if(StringUtil.isNotNull(systemPermissionApi.getApiLevel() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionApi::getApiLevel,"%"+ systemPermissionApi.getApiLevel() +"%");
        }

        if(StringUtil.isNotNull(systemPermissionApi.getApiMethod() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionApi::getApiMethod,"%"+ systemPermissionApi.getApiMethod() +"%");
        }

        if(StringUtil.isNotNull(systemPermissionApi.getApiUrl() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionApi::getApiUrl,"%"+ systemPermissionApi.getApiUrl() +"%");
        }

        Page<SystemPermissionApi> systemPermissionApiPage = (Page<SystemPermissionApi>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemPermissionApi> pageResult = new PageResult<SystemPermissionApi>(systemPermissionApiPage.getTotal(),systemPermissionApiPage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemPermissionApi> selectAll() {
        return systemPermissionApiMapper.selectList(null);
    }

}
