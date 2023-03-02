package com.saasMode.dao.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baseCommon.dao.BaseDaoImpl;
import com.baseCommon.entity.PageResult;
import com.commonTool.utils.IdWorker;
import com.saasMode.dao.CompanyDao;
import com.saasMode.mapper.CompanyMapper;
import com.saasMode.pojo.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDaoImpl extends BaseDaoImpl<Company> implements CompanyDao {
    @Autowired
    private IdWorker idWorker;

    @Autowired(required=true)
    private CompanyMapper companyMapper;

    /**
     * 保存
     */
    @Override
    public void add(Company company) {
        //基本属性的设置
        String id = idWorker.nextId()+"";
        company.setId(id);
        companyMapper.insert(company);
    }

    /**
     * 更新
     */
    @Override
    public void update(Company company) {
        companyMapper.updateById(company);
    }

    /**
     * 删除
     */
    @Override
    public void deleteById(String id) {
        companyMapper.deleteById(id);
    }

    /**
     * 根据id查询
     */
    @Override
    public Company selectById(String id) {
        return companyMapper.selectById(id);
    }

    @Override
    public PageResult<Company> selectList(int pagesize, int page, Company company) {
        return null;
    }
    //    @Override
    public List<Company> selectList(Company company) {
        Wrapper<Company> queryWrapper = null;
        return companyMapper.selectList(queryWrapper);
    }

    /**
     * 查询全部列表
     */
    @Override
    public List<Company> selectAll() {
        return companyMapper.selectList(null);
    }

}
