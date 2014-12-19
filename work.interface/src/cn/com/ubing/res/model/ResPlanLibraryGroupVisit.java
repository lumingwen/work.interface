package cn.com.ubing.res.model;

import java.util.Date;

public class ResPlanLibraryGroupVisit {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long userId;

    private String name;

    private String days;

    private String nights;

    private Long leaveLocation;

    private Integer type;

    private Long trafficLeave;

    private Long trafficReach;

    private String feeRemark;

    private Long imageId;

    private String introduction;

    private String remark;

    private String a1;

    private String a2;

    private String a3;

    private String a4;

    private String a5;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days == null ? null : days.trim();
    }

    public String getNights() {
        return nights;
    }

    public void setNights(String nights) {
        this.nights = nights == null ? null : nights.trim();
    }

    public Long getLeaveLocation() {
        return leaveLocation;
    }

    public void setLeaveLocation(Long leaveLocation) {
        this.leaveLocation = leaveLocation;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getTrafficLeave() {
        return trafficLeave;
    }

    public void setTrafficLeave(Long trafficLeave) {
        this.trafficLeave = trafficLeave;
    }

    public Long getTrafficReach() {
        return trafficReach;
    }

    public void setTrafficReach(Long trafficReach) {
        this.trafficReach = trafficReach;
    }

    public String getFeeRemark() {
        return feeRemark;
    }

    public void setFeeRemark(String feeRemark) {
        this.feeRemark = feeRemark == null ? null : feeRemark.trim();
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1 == null ? null : a1.trim();
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2 == null ? null : a2.trim();
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3 == null ? null : a3.trim();
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4 == null ? null : a4.trim();
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5 == null ? null : a5.trim();
    }
}