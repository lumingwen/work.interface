package cn.com.ubing.res.model;

import java.util.Date;
/**
 * 风向标(经营线路分析)
 * @author zhangxujun
 * 
 *
 */
public class ResVaneLineAnalysis {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long lineId;

    private Integer lastMonthCount;

    private Integer currentMonthCount;

    private Date statisticsTime;

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

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Integer getLastMonthCount() {
        return lastMonthCount;
    }

    public void setLastMonthCount(Integer lastMonthCount) {
        this.lastMonthCount = lastMonthCount;
    }

    public Integer getCurrentMonthCount() {
        return currentMonthCount;
    }

    public void setCurrentMonthCount(Integer currentMonthCount) {
        this.currentMonthCount = currentMonthCount;
    }

    public Date getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Date statisticsTime) {
        this.statisticsTime = statisticsTime;
    }
}