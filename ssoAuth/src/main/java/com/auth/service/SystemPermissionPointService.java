package com.auth.service;
import com.auth.dao.SystemPermissionPointDao;
import com.auth.pojo.SystemPermissionPoint;
import com.baseCommon.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;
import java.util.List;

@Service
public class SystemPermissionPointService extends BaseService {

    @Autowired
    private SystemPermissionPointDao systemPermissionPointDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void insert(SystemPermissionPoint systemPermissionPoint) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        systemPermissionPoint.setId(id);
        systemPermissionPointDao.add(systemPermissionPoint);
    }

    /**
     * 更新
     */
    public void update(SystemPermissionPoint systemPermissionPoint) {
        systemPermissionPointDao.update(systemPermissionPoint);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemPermissionPointDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemPermissionPoint selectById(String id) {
        return systemPermissionPointDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemPermissionPoint> selectList(int pagesize, int page,SystemPermissionPoint systemPermissionPoint) {
        return systemPermissionPointDao.selectList(pagesize,page,systemPermissionPoint);
    }

    /**
     * 查询全部列表
     */
    public List<SystemPermissionPoint> selectAll() {
        return systemPermissionPointDao.selectAll();
    }
}
