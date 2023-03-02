package com.saasMode.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@TableName(value = "co_company")//指定表名
public class Company implements Serializable {

    @TableId
    private String id;
    private String name;
    private java.util.Date renewalDate;
    private java.util.Date expirationDate;
    private String companyArea;
    private String companyAddress;
    private String businessLicenseId;
    private String legalRepresentative;
    private String companyPhone;
    private String mailbox;
    private String companySize;
    private String industry;
    private String remarks;
    private String auditState;
    private Integer state;
    private Double balance;
    private java.util.Date createTime;
    private String databaseUrl;
    private String databaseName;
    private String databaseUserName;
    private String databaseUserPassword;
    private Integer databaseState;

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
    public void setRenewalDate(java.util.Date value) {
        this.renewalDate = value;
    }
    public java.util.Date getRenewalDate() {
       return this.renewalDate;
    }
    public void setExpirationDate(java.util.Date value) {
        this.expirationDate = value;
    }
    public java.util.Date getExpirationDate() {
       return this.expirationDate;
    }
    public void setCompanyArea(String value) {
        this.companyArea = value;
    }
    public String getCompanyArea() {
       return this.companyArea;
    }
    public void setCompanyAddress(String value) {
        this.companyAddress = value;
    }
    public String getCompanyAddress() {
       return this.companyAddress;
    }
    public void setBusinessLicenseId(String value) {
        this.businessLicenseId = value;
    }
    public String getBusinessLicenseId() {
       return this.businessLicenseId;
    }
    public void setLegalRepresentative(String value) {
        this.legalRepresentative = value;
    }
    public String getLegalRepresentative() {
       return this.legalRepresentative;
    }
    public void setCompanyPhone(String value) {
        this.companyPhone = value;
    }
    public String getCompanyPhone() {
       return this.companyPhone;
    }
    public void setMailbox(String value) {
        this.mailbox = value;
    }
    public String getMailbox() {
       return this.mailbox;
    }
    public void setCompanySize(String value) {
        this.companySize = value;
    }
    public String getCompanySize() {
       return this.companySize;
    }
    public void setIndustry(String value) {
        this.industry = value;
    }
    public String getIndustry() {
       return this.industry;
    }
    public void setRemarks(String value) {
        this.remarks = value;
    }
    public String getRemarks() {
       return this.remarks;
    }
    public void setAuditState(String value) {
        this.auditState = value;
    }
    public String getAuditState() {
       return this.auditState;
    }
    public void setState(Integer value) {
        this.state = value;
    }
    public Integer getState() {
       return this.state;
    }
    public void setBalance(Double value) {
        this.balance = value;
    }
    public Double getBalance() {
       return this.balance;
    }
    public void setCreateTime(java.util.Date value) {
        this.createTime = value;
    }
    public java.util.Date getCreateTime() {
       return this.createTime;
    }
    public void setDatabaseUrl(String value) {
        this.databaseUrl = value;
    }
    public String getDatabaseUrl() {
       return this.databaseUrl;
    }
    public void setDatabaseName(String value) {
        this.databaseName = value;
    }
    public String getDatabaseName() {
       return this.databaseName;
    }
    public void setDatabaseUserName(String value) {
        this.databaseUserName = value;
    }
    public String getDatabaseUserName() {
       return this.databaseUserName;
    }
    public void setDatabaseUserPassword(String value) {
        this.databaseUserPassword = value;
    }
    public String getDatabaseUserPassword() {
       return this.databaseUserPassword;
    }
    public void setDatabaseState(Integer value) {
        this.databaseState = value;
    }
    public Integer getDatabaseState() {
       return this.databaseState;
    }
}
