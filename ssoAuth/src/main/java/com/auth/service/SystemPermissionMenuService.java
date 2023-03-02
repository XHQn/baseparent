package com.auth.service;
import com.auth.dao.SystemPermissionMenuDao;
import com.auth.pojo.SystemPermissionMenu;
import com.baseCommon.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;
import java.util.List;

@Service
public class SystemPermissionMenuService extends BaseService {

    @Autowired
    private SystemPermissionMenuDao systemPermissionMenuDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void insert(SystemPermissionMenu systemPermissionMenu) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        systemPermissionMenu.setId(id);
        systemPermissionMenuDao.add(systemPermissionMenu);
    }

    /**
     * 更新
     */
    public void update(SystemPermissionMenu systemPermissionMenu) {
        systemPermissionMenuDao.update(systemPermissionMenu);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemPermissionMenuDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemPermissionMenu selectById(String id) {
        return systemPermissionMenuDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemPermissionMenu> selectList(int pagesize, int page,SystemPermissionMenu systemPermissionMenu) {
        return systemPermissionMenuDao.selectList(pagesize,page,systemPermissionMenu);
    }

    /**
     * 查询全部列表
     */
    public List<SystemPermissionMenu> selectAll() {
        return systemPermissionMenuDao.selectAll();
    }
}
