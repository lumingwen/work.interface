package cn.com.ubing.res.model;

import java.util.Date;

public class ResPlanLibraryPersonalVisitDestination {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long personalVisitId;

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

    public Long getPersonalVisitId() {
        return personalVisitId;
    }

    public void setPersonalVisitId(Long personalVisitId) {
        this.personalVisitId = personalVisitId;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }
}