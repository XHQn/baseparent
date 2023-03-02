package com.auth.service;
import com.auth.dao.SystemPermissionApiDao;
import com.auth.pojo.SystemPermissionApi;
import com.baseCommon.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;
import java.util.List;

@Service
public class SystemPermissionApiService extends BaseService {

    @Autowired
    private SystemPermissionApiDao systemPermissionApiDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void insert(SystemPermissionApi systemPermissionApi) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        systemPermissionApi.setId(id);
        systemPermissionApiDao.add(systemPermissionApi);
    }

    /**
     * 更新
     */
    public void update(SystemPermissionApi systemPermissionApi) {
        systemPermissionApiDao.update(systemPermissionApi);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemPermissionApiDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemPermissionApi selectById(String id) {
        return systemPermissionApiDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemPermissionApi> selectList(int pagesize, int page,SystemPermissionApi systemPermissionApi) {
        return systemPermissionApiDao.selectList(pagesize,page,systemPermissionApi);
    }

    /**
     * 查询全部列表
     */
    public List<SystemPermissionApi> selectAll() {
        return systemPermissionApiDao.selectAll();
    }
}
