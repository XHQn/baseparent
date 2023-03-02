package com.auth.service;
import com.auth.dao.SystemUserDao;
import com.auth.dao.SystemUserRoleDao;
import com.auth.pojo.SystemRole;
import com.auth.pojo.SystemUser;
import com.auth.pojo.SystemUserRole;
import com.auth.pojo.UserRoleDTO;
import com.baseCommon.entity.PageResult;
import com.commonTool.utils.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;
import java.util.List;

@Service
public class SystemUserRoleService extends BaseService {
    @Autowired
    private SystemUserDao systemUserDao;
    @Autowired
    private SystemUserRoleDao systemUserRoleDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void insert(SystemUserRole systemUserRole) {
        //基本属性的设置
//        String id = idWorker.nextId()+"";
//        systemUserRole.setId(id);
        systemUserRoleDao.add(systemUserRole);
    }

    /**
     * 更新
     */
    public void update(SystemUserRole systemUserRole) {
        systemUserRoleDao.update(systemUserRole);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemUserRoleDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemUserRole selectById(String id) {
        return systemUserRoleDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemUserRole> selectList(int pagesize, int page,SystemUserRole systemUserRole) {
        return systemUserRoleDao.selectList(pagesize,page,systemUserRole);
    }

    /**
     * 查询全部列表
     */
    public List<SystemUserRole> selectAll() {
        return systemUserRoleDao.selectAll();
    }


}
