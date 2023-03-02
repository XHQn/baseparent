package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_permission_point")
public class SystemPermissionPoint implements Serializable {
    @TableId
    private String id;
    private String pointClass;
    private String pointIcon;
    private Integer pointStatus;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setPointClass(String value) {
        this.pointClass = value;
    }
    public String getPointClass() {
       return this.pointClass;
    }
    public void setPointIcon(String value) {
        this.pointIcon = value;
    }
    public String getPointIcon() {
       return this.pointIcon;
    }
    public void setPointStatus(Integer value) {
        this.pointStatus = value;
    }
    public Integer getPointStatus() {
       return this.pointStatus;
    }
}
