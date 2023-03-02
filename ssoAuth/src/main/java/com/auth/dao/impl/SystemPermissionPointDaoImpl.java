package com.auth.dao.impl;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baseCommon.entity.PageResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.commonTool.utils.IdWorker;
import com.auth.dao.SystemPermissionPointDao;
import com.auth.mapper.SystemPermissionPointMapper;
import com.auth.pojo.SystemPermissionPoint;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class SystemPermissionPointDaoImpl extends BaseDaoImpl<SystemPermissionPoint> implements SystemPermissionPointDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private SystemPermissionPointMapper systemPermissionPointMapper;

    /**
     * 保存
     */
    @Override
    public void add(SystemPermissionPoint systemPermissionPoint) {
        systemPermissionPointMapper.insert(systemPermissionPoint);
    }

    /**
     * 更新
     */
    @Override
    public void update(SystemPermissionPoint systemPermissionPoint) {
        systemPermissionPointMapper.updateById(systemPermissionPoint);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        systemPermissionPointMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public SystemPermissionPoint selectById(String id) {
        return systemPermissionPointMapper.selectById(id);
    }

    @Override
    public PageResult<SystemPermissionPoint> selectList(int pageSize, int page, SystemPermissionPoint systemPermissionPoint) {
        Page<SystemPermissionPoint> producePage = new Page<>(page,pageSize);
        LambdaQueryChainWrapper<SystemPermissionPoint> lambdaQueryChainWrapper = new LambdaQueryChainWrapper(systemPermissionPointMapper);

        if(StringUtil.isNotNull(systemPermissionPoint.getPointClass() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionPoint::getPointClass,"%"+ systemPermissionPoint.getPointClass() +"%");
        }

        if(StringUtil.isNotNull(systemPermissionPoint.getPointIcon() + "" )) {
            lambdaQueryChainWrapper.like(SystemPermissionPoint::getPointIcon,"%"+ systemPermissionPoint.getPointIcon() +"%");
        }


        Page<SystemPermissionPoint> systemPermissionPointPage = (Page<SystemPermissionPoint>) lambdaQueryChainWrapper.page(producePage);
        PageResult<SystemPermissionPoint> pageResult = new PageResult<SystemPermissionPoint>(systemPermissionPointPage.getTotal(),systemPermissionPointPage.getRecords());
        return pageResult;
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<SystemPermissionPoint> selectAll() {
        return systemPermissionPointMapper.selectList(null);
    }

}
