package com.auth.service;
import com.auth.dao.SystemPermissionDao;
import com.auth.dao.SystemRolePermissionDao;
import com.auth.pojo.PermissionRoleDTO;
import com.auth.pojo.SystemPermission;
import com.auth.pojo.SystemRole;
import com.auth.pojo.SystemRolePermission;
import com.baseCommon.entity.PageResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commonTool.utils.IdWorker;
import com.baseCommon.service.BaseService;
import java.util.List;

@Service
public class SystemRolePermissionService extends BaseService {
    @Autowired
    private SystemPermissionDao systemPermissionDao;
    @Autowired
    private SystemRolePermissionDao systemRolePermissionDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 保存
     */
    public void insert(SystemRolePermission systemRolePermission) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
//        systemRolePermission.setId(id);
        systemRolePermissionDao.add(systemRolePermission);
    }

    /**
     * 更新
     */
    public void update(SystemRolePermission systemRolePermission) {
        systemRolePermissionDao.update(systemRolePermission);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        systemRolePermissionDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public SystemRolePermission selectById(String id) {
        return systemRolePermissionDao.selectById(id);
    }

    /**
     * 查询列表
     */
    public PageResult<SystemRolePermission> selectList(int pagesize, int page,SystemRolePermission systemRolePermission) {
        return systemRolePermissionDao.selectList(pagesize,page,systemRolePermission);
    }

    /**
     * 查询全部列表
     */
    public List<SystemRolePermission> selectAll() {
        return systemRolePermissionDao.selectAll();
    }

    public int savaPermissionAndRole(PermissionRoleDTO permissionRoleDTO) {
        if(permissionRoleDTO==null && permissionRoleDTO.getId()==null)
        {
            return 0;
        }

        SystemPermission systemPermission=new SystemPermission();
        BeanUtils.copyProperties(permissionRoleDTO,systemPermission);
        systemPermissionDao.update(systemPermission);

        List<SystemRole> systemRoleList = permissionRoleDTO.getSystemRoleList();
        if(systemRoleList==null && systemRoleList.size()<=0)
        {
            return 0;
        }

        systemRolePermissionDao.deleteByIdPermission(systemPermission.getId());
        for(SystemRole systemRole:systemRoleList)
        {
            SystemRolePermission systemRolePermission=new SystemRolePermission();
            systemRolePermission.setPermissionId(permissionRoleDTO.getId());
            systemRolePermission.setRoleId(systemRole.getId());
            systemRolePermissionDao.add(systemRolePermission);
        }
        return 1;
    }
}
