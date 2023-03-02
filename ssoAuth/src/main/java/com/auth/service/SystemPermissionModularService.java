package com.auth.service;
import com.auth.dao.SystemPermissionModularDao;
import com.auth.pojo.SystemPermissionModular;
import com.baseCommon.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;
import java.util.List;

@Service
public class SystemPermissionModularService extends BaseService {

    @Autowired
    private SystemPermissionModularDao systemPermissionModularDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void insert(SystemPermissionModular systemPermissionModular) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        systemPermissionModular.setId(id);
        systemPermissionModularDao.add(systemPermissionModular);
    }

    /**
     * 更新
     */
    public void update(SystemPermissionModular systemPermissionModular) {
        systemPermissionModularDao.update(systemPermissionModular);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemPermissionModularDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemPermissionModular selectById(String id) {
        return systemPermissionModularDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemPermissionModular> selectList(int pagesize, int page,SystemPermissionModular systemPermissionModular) {
        return systemPermissionModularDao.selectList(pagesize,page,systemPermissionModular);
    }

    /**
     * 查询全部列表
     */
    public List<SystemPermissionModular> selectAll() {
        return systemPermissionModularDao.selectAll();
    }
}
