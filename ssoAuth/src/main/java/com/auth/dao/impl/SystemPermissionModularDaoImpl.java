package com.auth.dao.impl;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemPermissionModularDao;
import com.auth.mapper.SystemPermissionModularMapper;
import com.auth.pojo.SystemPermissionModular;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemPermissionModularDaoImpl extends BaseDaoImpl<SystemPermissionModular> implements SystemPermissionModularDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemPermissionModularMapper systemPermissionModularMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemPermissionModular systemPermissionModular) {
        systemPermissionModularMapper.insert(systemPermissionModular);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemPermissionModular systemPermissionModular) {
        systemPermissionModularMapper.updateById(systemPermissionModular);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemPermissionModularMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public SystemPermissionModular selectById(String id) {
        return systemPermissionModularMapper.selectById(id);
    }

    @Override
    public PageResult<SystemPermissionModular> selectList(int pageSize, int page, SystemPermissionModular systemPermissionModular) {
        Page<SystemPermissionModular> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemPermissionModular> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemPermissionModularMapper);

        if(StringUtil.isNotNull(systemPermissionModular.getModularIcon() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionModular::getModularIcon,"%"+ systemPermissionModular.getModularIcon() +"%");
        }

        if(StringUtil.isNotNull(systemPermissionModular.getModularOrder() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionModular::getModularOrder,"%"+ systemPermissionModular.getModularOrder() +"%");
        }

        if(StringUtil.isNotNull(systemPermissionModular.getModularTitle() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionModular::getModularTitle,"%"+ systemPermissionModular.getModularTitle() +"%");
        }

        if(StringUtil.isNotNull(systemPermissionModular.getModularContent() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionModular::getModularContent,"%"+ systemPermissionModular.getModularContent() +"%");
        }

        if(StringUtil.isNotNull(systemPermissionModular.getModularSub() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionModular::getModularSub,"%"+ systemPermissionModular.getModularSub() +"%");
        }



        Page<SystemPermissionModular> systemPermissionModularPage = (Page<SystemPermissionModular>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemPermissionModular> pageResult = new PageResult<SystemPermissionModular>(systemPermissionModularPage.getTotal(),systemPermissionModularPage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemPermissionModular> selectAll() {
        return systemPermissionModularMapper.selectList(null);
    }

}
