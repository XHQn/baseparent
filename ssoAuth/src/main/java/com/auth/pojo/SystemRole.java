package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_role")
public class SystemRole implements Serializable {
    @TableId
    private String id;
    private String name;
    private String description;
    private String companyId;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setName(String value) {
        this.name = value;
    }
    public String getName() {
       return this.name;
    }
    public void setDescription(String value) {
        this.description = value;
    }
    public String getDescription() {
       return this.description;
    }
    public void setCompanyId(String value) {
        this.companyId = value;
    }
    public String getCompanyId() {
       return this.companyId;
    }
}
