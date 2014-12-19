package cn.com.ubing.res.model;

import java.util.Date;

public class ResLastGoodsSales {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long userId;

    private Long lastGoodsId;

    private Date travelTime;

    private Integer travelCount;

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

    public Long getLastGoodsId() {
        return lastGoodsId;
    }

    public void setLastGoodsId(Long lastGoodsId) {
        this.lastGoodsId = lastGoodsId;
    }

    public Date getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Date travelTime) {
        this.travelTime = travelTime;
    }

    public Integer getTravelCount() {
        return travelCount;
    }

    public void setTravelCount(Integer travelCount) {
        this.travelCount = travelCount;
    }
}