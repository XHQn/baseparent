package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_permission_api")
public class SystemPermissionApi implements Serializable {
    @TableId
    private String id;
    private String apiLevel;
    private String apiMethod;
    private String apiUrl;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setApiLevel(String value) {
        this.apiLevel = value;
    }
    public String getApiLevel() {
       return this.apiLevel;
    }
    public void setApiMethod(String value) {
        this.apiMethod = value;
    }
    public String getApiMethod() {
       return this.apiMethod;
    }
    public void setApiUrl(String value) {
        this.apiUrl = value;
    }
    public String getApiUrl() {
       return this.apiUrl;
    }
}
