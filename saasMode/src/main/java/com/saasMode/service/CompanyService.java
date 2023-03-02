package com.saasMode.service;
import com.baseCommon.service.BaseService;
import com.commonTool.utils.IdWorker;
import com.saasMode.dao.CompanyDao;
import com.saasMode.pojo.Company;
import com.saasMode.service.initdb.InitDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyService extends BaseService {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private InitDataBase initDataBase;

    /**
     * 保存
     */
    public void insert(Company company) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        company.setId(id);
        companyDao.add(company);
    }

    /**
     * 更新
     */
    public void update(Company company) {
        companyDao.update(company);
    }

    /**
     * 删除
     */
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    /**
     * 根据id查询
     */
    public Company selectById(String id) {
        return companyDao.selectById(id);
    }

    /**
     * 查询列表
     */
//    public List<Company> selectList(Company company) {
//        return companyDao.selectList(company);
//    }

    /**
     * 查询全部列表
     */
    public List<Company> selectAll() {
        return companyDao.selectAll();
    }

    /**
     * 初始化数据库
     * 可以有多种方案进行初始化数据库
     */
    public boolean initDB(String id) throws Exception {
        Company company = companyDao.selectById(id);
        return initDataBase.initDB(company.getDatabaseUrl(),company.getDatabaseName(),company.getDatabaseUserName(),company.getDatabaseUserPassword());
    }
}
