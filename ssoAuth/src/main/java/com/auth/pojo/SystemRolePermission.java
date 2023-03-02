package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_role_permission")
public class SystemRolePermission implements Serializable {

    private String roleId;
    private String permissionId;

    public void setRoleId(String value) {
        this.roleId = value;
    }
    public String getRoleId() {
       return this.roleId;
    }
    public void setPermissionId(String value) {
        this.permissionId = value;
    }
    public String getPermissionId() {
       return this.permissionId;
    }
}
