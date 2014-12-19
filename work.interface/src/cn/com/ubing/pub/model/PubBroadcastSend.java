package cn.com.ubing.pub.model;

import java.util.Date;

public class PubBroadcastSend {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long userId;

    private Long pubFirstLevelId;

    private Long pubSecondLevelId;

    private Long pubThirdLevelId;

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

    public Long getPubFirstLevelId() {
        return pubFirstLevelId;
    }

    public void setPubFirstLevelId(Long pubFirstLevelId) {
        this.pubFirstLevelId = pubFirstLevelId;
    }

    public Long getPubSecondLevelId() {
        return pubSecondLevelId;
    }

    public void setPubSecondLevelId(Long pubSecondLevelId) {
        this.pubSecondLevelId = pubSecondLevelId;
    }

    public Long getPubThirdLevelId() {
        return pubThirdLevelId;
    }

    public void setPubThirdLevelId(Long pubThirdLevelId) {
        this.pubThirdLevelId = pubThirdLevelId;
    }
}