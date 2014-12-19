package cn.com.ubing.pub.model;

import java.util.Date;

public class PubPlanHistoryGroupVisitDestination {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long groupVisitId;

    private Long destinationId;

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

    public Long getGroupVisitId() {
        return groupVisitId;
    }

    public void setGroupVisitId(Long groupVisitId) {
        this.groupVisitId = groupVisitId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }
}