package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_permission_modular")
public class SystemPermissionModular implements Serializable {
    @TableId
    private String id;
    private String modularIcon;
    private String modularOrder;
    private String modularTitle;
    private String modularContent;
    private String modularSub;
    private Integer modularWidthRatio;
    private java.util.Date modularDate;

    public void setId(String value) {
        this.id = value;
    }
    public String getId() {
       return this.id;
    }
    public void setModularIcon(String value) {
        this.modularIcon = value;
    }
    public String getModularIcon() {
       return this.modularIcon;
    }
    public void setModularOrder(String value) {
        this.modularOrder = value;
    }
    public String getModularOrder() {
       return this.modularOrder;
    }
    public void setModularTitle(String value) {
        this.modularTitle = value;
    }
    public String getModularTitle() {
       return this.modularTitle;
    }
    public void setModularContent(String value) {
        this.modularContent = value;
    }
    public String getModularContent() {
       return this.modularContent;
    }
    public void setModularSub(String value) {
        this.modularSub = value;
    }
    public String getModularSub() {
       return this.modularSub;
    }
    public void setModularWidthRatio(Integer value) {
        this.modularWidthRatio = value;
    }
    public Integer getModularWidthRatio() {
       return this.modularWidthRatio;
    }
    public void setModularDate(java.util.Date value) {
        this.modularDate = value;
    }
    public java.util.Date getModularDate() {
       return this.modularDate;
    }
}
