package cn.com.ubing.rms.model;

import java.util.Date;

/**
 * 用户
 * 
 * @author zhangxujun
 * 
 * 
 */
public class RmsUser {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer userType;

    private String username;

    private String password;

    private String passwordKey;

    private String nickname;

    private String tel;

    private String email;

    private String number;

    private Double score;

    private Integer status;

    private Integer realNameCheckStatus;

    private Integer companyCheckStatus;

    private Long imageAttahcmentId;

    private Long roleId;

    private String weixinOpenId;

    private Integer weixinBoundFlag;

    private String signature;
    private String xingeToken;
    private String appType;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Integer getDeleteFlag() {
        return deleteFlag;
    }
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    public Integer getUserType() {
        return userType;
    }
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordKey() {
        return passwordKey;
    }
    public void setPasswordKey(String passwordKey) {
        this.passwordKey = passwordKey;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getRealNameCheckStatus() {
        return realNameCheckStatus;
    }
    public void setRealNameCheckStatus(Integer realNameCheckStatus) {
        this.realNameCheckStatus = realNameCheckStatus;
    }
    public Integer getCompanyCheckStatus() {
        return companyCheckStatus;
    }
    public void setCompanyCheckStatus(Integer companyCheckStatus) {
        this.companyCheckStatus = companyCheckStatus;
    }
    public Long getImageAttahcmentId() {
        return imageAttahcmentId;
    }
    public void setImageAttahcmentId(Long imageAttahcmentId) {
        this.imageAttahcmentId = imageAttahcmentId;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public String getWeixinOpenId() {
        return weixinOpenId;
    }
    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }
    public Integer getWeixinBoundFlag() {
        return weixinBoundFlag;
    }
    public void setWeixinBoundFlag(Integer weixinBoundFlag) {
        this.weixinBoundFlag = weixinBoundFlag;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getXingeToken() {
        return xingeToken;
    }
    public void setXingeToken(String xingeToken) {
        this.xingeToken = xingeToken;
    }
    public String getAppType() {
        return appType;
    }
    public void setAppType(String appType) {
        this.appType = appType;
    }

}