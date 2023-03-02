package com.auth.pojo;

import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
public class PermissionRoleDTO {
    private String id;
    private String description;
    private String name;
    List<SystemRole> systemRoleList;
}
