package com.baseCommon.dao;

import com.baseCommon.entity.PageResult;

import java.util.List;

public interface BaseDao<T> {

    /**
     * 添加
     */
    public void add(T t);

    /**
     * 更新
     */
    public void update(T t);

    /**
     * 删除
     */
    public void deleteById(String id);

    /**
     * 根据id查询
     */
    public T selectById(String id);

    /**
     * 查询列表
     */
    public PageResult<T> selectList(int pagesize, int page,T t);

    /**
     * 查询全部列表
     */
    public List<T> selectAll();
}
