package cn.com.ubing.pub.model;

import java.util.Date;

public class PubRequirementCheck {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer requirementType;

    private Long requirementId;

    private Integer checkStatus;

    private Date checkTime;

    private String checkRemark;

    private Long checkUserId;

    private String updateRequirementContent;

    private Long updateRequirementUserId;

    private Date updateRequirementTime;

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

    public Integer getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
    }

    public Long getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    public Long getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Long checkUserId) {
        this.checkUserId = checkUserId;
    }

    public String getUpdateRequirementContent() {
        return updateRequirementContent;
    }

    public void setUpdateRequirementContent(String updateRequirementContent) {
        this.updateRequirementContent = updateRequirementContent == null ? null : updateRequirementContent.trim();
    }

    public Long getUpdateRequirementUserId() {
        return updateRequirementUserId;
    }

    public void setUpdateRequirementUserId(Long updateRequirementUserId) {
        this.updateRequirementUserId = updateRequirementUserId;
    }

    public Date getUpdateRequirementTime() {
        return updateRequirementTime;
    }

    public void setUpdateRequirementTime(Date updateRequirementTime) {
        this.updateRequirementTime = updateRequirementTime;
    }
}