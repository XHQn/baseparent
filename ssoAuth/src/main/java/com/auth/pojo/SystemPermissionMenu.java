package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_permission_menu")
public class SystemPermissionMenu implements Serializable {
    @TableId
    private String id;
    private String menuIcon;
    private String menuOrder;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setMenuIcon(String value) {
        this.menuIcon = value;
    }
    public String getMenuIcon() {
       return this.menuIcon;
    }
    public void setMenuOrder(String value) {
        this.menuOrder = value;
    }
    public String getMenuOrder() {
       return this.menuOrder;
    }
}
