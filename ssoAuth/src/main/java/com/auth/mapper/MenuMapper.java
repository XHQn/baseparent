package com.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.auth.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(String userid);
}
