package com.auth.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class UserRoleDTO {
    private String id;
    private String loginname;
    private String username;
    List<SystemRole> systemRoleList;
}
