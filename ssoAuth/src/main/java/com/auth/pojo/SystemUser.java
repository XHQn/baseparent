package com.auth.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


@Setter
@Getter
@TableName(value = "system_user")
public class SystemUser implements Serializable {
    @TableId
    private String id;
    private String loginname;
    private String username;
    private String password;
    private String openid;
    private Integer enableState;
    private java.util.Date createTime;
    private String departmentId;
    private java.util.Date timeOfEntry;
    private Integer formOfEmployment;
    private String workNumber;
    private String formOfManagement;
    private String workingCity;
    private java.util.Date correctionTime;
    private Integer inServiceStatus;
    private String companyId;
    private String companyName;
    private String level;
    private String staffPhoto;
    private java.util.Date timeOfDimission;
    private String stationid;
    private String stationname;
    private String firstid;
    private String firstclass;
    private String secondid;
    private String secondclass;
    private String thirdid;
    private String thirdclass;
    private String displayname;
}
