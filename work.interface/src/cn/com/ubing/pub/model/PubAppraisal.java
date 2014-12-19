package cn.com.ubing.pub.model;

import java.util.Date;

public class PubAppraisal {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long fromId;

    private Long toId;

    private String content;

    private Integer type;

    private Long scoreId;

    private Long planId;

    private String rejectContent;

    private Long rejectLabelId;

    private Long doneServiceLabelId;

    private Long doneDescriptionLabelId;

    private Integer status;

    private Integer appraisalResult;

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

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getRejectContent() {
        return rejectContent;
    }

    public void setRejectContent(String rejectContent) {
        this.rejectContent = rejectContent == null ? null : rejectContent.trim();
    }

    public Long getRejectLabelId() {
        return rejectLabelId;
    }

    public void setRejectLabelId(Long rejectLabelId) {
        this.rejectLabelId = rejectLabelId;
    }

    public Long getDoneServiceLabelId() {
        return doneServiceLabelId;
    }

    public void setDoneServiceLabelId(Long doneServiceLabelId) {
        this.doneServiceLabelId = doneServiceLabelId;
    }

    public Long getDoneDescriptionLabelId() {
        return doneDescriptionLabelId;
    }

    public void setDoneDescriptionLabelId(Long doneDescriptionLabelId) {
        this.doneDescriptionLabelId = doneDescriptionLabelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAppraisalResult() {
        return appraisalResult;
    }

    public void setAppraisalResult(Integer appraisalResult) {
        this.appraisalResult = appraisalResult;
    }
}