package cn.com.ubing.res.model;

import java.util.Date;

public class ResLastGoodsTrip {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long lastGoodsId;

    private Integer dayOfTrip;

    private String title;

    private String description;

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

    public Long getLastGoodsId() {
        return lastGoodsId;
    }

    public void setLastGoodsId(Long lastGoodsId) {
        this.lastGoodsId = lastGoodsId;
    }

    public Integer getDayOfTrip() {
        return dayOfTrip;
    }

    public void setDayOfTrip(Integer dayOfTrip) {
        this.dayOfTrip = dayOfTrip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}