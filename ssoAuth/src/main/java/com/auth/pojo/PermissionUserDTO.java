package com.auth.pojo;

import lombok.Data;

import java.util.List;
@Data
public class PermissionUserDTO {
    private String userId;
    private List<SystemPermission> systemPermissionList;
}
