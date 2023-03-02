package com.auth.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RolePermissionDTO {
    private String id;
    private String description;
    private String name;
    private String companyId;
    List<SystemPermission> systemPermissionList;
}
