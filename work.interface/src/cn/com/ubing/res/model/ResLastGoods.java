package cn.com.ubing.res.model;

import java.util.Date;

public class ResLastGoods {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private String serialNumber;

    private String title;

    private Date startTime;

    private Date endTime;

    private String popularReasons;

    private String feeDescription;

    private Integer displayInHomePage;

    private Integer focusImageInHomePage;

    private Long mainImageId;

    private String departurePlace;
    
    private String feeExclude;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPopularReasons() {
        return popularReasons;
    }

    public void setPopularReasons(String popularReasons) {
        this.popularReasons = popularReasons == null ? null : popularReasons.trim();
    }

    public String getFeeDescription() {
        return feeDescription;
    }

    public void setFeeDescription(String feeDescription) {
        this.feeDescription = feeDescription == null ? null : feeDescription.trim();
    }

    public Integer getDisplayInHomePage() {
        return displayInHomePage;
    }

    public void setDisplayInHomePage(Integer displayInHomePage) {
        this.displayInHomePage = displayInHomePage;
    }

    public Integer getFocusImageInHomePage() {
        return focusImageInHomePage;
    }

    public void setFocusImageInHomePage(Integer focusImageInHomePage) {
        this.focusImageInHomePage = focusImageInHomePage;
    }

    public Long getMainImageId() {
        return mainImageId;
    }

    public void setMainImageId(Long mainImageId) {
        this.mainImageId = mainImageId;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace == null ? null : departurePlace.trim();
    }

    public String getFeeExclude() {
        return feeExclude;
    }

    public void setFeeExclude(String feeExclude) {
        this.feeExclude = feeExclude;
    }
    
}