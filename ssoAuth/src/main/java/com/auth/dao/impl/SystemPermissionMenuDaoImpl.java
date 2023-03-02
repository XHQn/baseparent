package com.auth.dao.impl;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemPermissionMenuDao;
import com.auth.mapper.SystemPermissionMenuMapper;
import com.auth.pojo.SystemPermissionMenu;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemPermissionMenuDaoImpl extends BaseDaoImpl<SystemPermissionMenu> implements SystemPermissionMenuDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemPermissionMenuMapper systemPermissionMenuMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemPermissionMenu systemPermissionMenu) {
        systemPermissionMenuMapper.insert(systemPermissionMenu);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemPermissionMenu systemPermissionMenu) {
        systemPermissionMenuMapper.updateById(systemPermissionMenu);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemPermissionMenuMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public SystemPermissionMenu selectById(String id) {
        return systemPermissionMenuMapper.selectById(id);
    }

    @Override
    public PageResult<SystemPermissionMenu> selectList(int pageSize, int page, SystemPermissionMenu systemPermissionMenu) {
        Page<SystemPermissionMenu> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemPermissionMenu> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemPermissionMenuMapper);

        if(StringUtil.isNotNull(systemPermissionMenu.getMenuIcon() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionMenu::getMenuIcon,"%"+ systemPermissionMenu.getMenuIcon() +"%");
        }

        if(StringUtil.isNotNull(systemPermissionMenu.getMenuOrder() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionMenu::getMenuOrder,"%"+ systemPermissionMenu.getMenuOrder() +"%");
        }

        Page<SystemPermissionMenu> systemPermissionMenuPage = (Page<SystemPermissionMenu>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemPermissionMenu> pageResult = new PageResult<SystemPermissionMenu>(systemPermissionMenuPage.getTotal(),systemPermissionMenuPage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemPermissionMenu> selectAll() {
        return systemPermissionMenuMapper.selectList(null);
    }

}
