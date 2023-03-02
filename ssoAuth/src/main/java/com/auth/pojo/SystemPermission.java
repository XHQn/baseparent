package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_permission")
public class SystemPermission implements Serializable {

    @TableId
    private String id;
    private String description;
    private String name;
    private Integer type;
    private String pid;
    private String code;
    private Integer enVisible;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setDescription(String value) {
        this.description = value;
    }
    public String getDescription() {
       return this.description;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setType(Integer value) {
        this.type = value;
    }
    public Integer getType() {
       return this.type;
    }
    public void setPid(String value) {
        this.pid = value;
    }
    public String getPid() {
       return this.pid;
    }
    public void setCode(String value) {
        this.code = value;
    }
    public String getCode() {
       return this.code;
    }
    public void setEnVisible(Integer value) {
        this.enVisible = value;
    }
    public Integer getEnVisible() {
       return this.enVisible;
    }
}
