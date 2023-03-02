package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_user_role")
public class SystemUserRole implements Serializable {
    private String roleId;
    private String userId;

    public void setRoleId(String value) {
        this.roleId = value;
    }
    public String getRoleId() {
       return this.roleId;
    }
    public void setUserId(String value) {
        this.userId = value;
    }
    public String getUserId() {
       return this.userId;
    }

}
