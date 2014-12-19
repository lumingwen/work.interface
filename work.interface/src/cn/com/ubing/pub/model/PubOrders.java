package cn.com.ubing.pub.model;

import java.util.Date;

public class PubOrders {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer type;

    private String serialNumber;

    private String productName;

    private Long sellUserId;

    private Long buyUserId;

    private Double totalMoney;

    private Double preferentialMoney;

    private Double payMoney;

    private Long pubPlanId;

    private Long endRequirmentId;

    private Integer payStatus;

    private Date payTime;

    private String alipaySerailNumber;

    private String paySerailNumber;

    private Date lastPayTime;

    private Integer confirmTravelStatus;

    private Date confirmTravelTime;

    private Date lastConfirmTravelTime;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Long getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(Long sellUserId) {
        this.sellUserId = sellUserId;
    }

    public Long getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(Long buyUserId) {
        this.buyUserId = buyUserId;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getPreferentialMoney() {
        return preferentialMoney;
    }

    public void setPreferentialMoney(Double preferentialMoney) {
        this.preferentialMoney = preferentialMoney;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Long getPubPlanId() {
        return pubPlanId;
    }

    public void setPubPlanId(Long pubPlanId) {
        this.pubPlanId = pubPlanId;
    }

    public Long getEndRequirmentId() {
        return endRequirmentId;
    }

    public void setEndRequirmentId(Long endRequirmentId) {
        this.endRequirmentId = endRequirmentId;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getAlipaySerailNumber() {
        return alipaySerailNumber;
    }

    public void setAlipaySerailNumber(String alipaySerailNumber) {
        this.alipaySerailNumber = alipaySerailNumber == null ? null : alipaySerailNumber.trim();
    }

    public String getPaySerailNumber() {
        return paySerailNumber;
    }

    public void setPaySerailNumber(String paySerailNumber) {
        this.paySerailNumber = paySerailNumber == null ? null : paySerailNumber.trim();
    }

    public Date getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(Date lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public Integer getConfirmTravelStatus() {
        return confirmTravelStatus;
    }

    public void setConfirmTravelStatus(Integer confirmTravelStatus) {
        this.confirmTravelStatus = confirmTravelStatus;
    }

    public Date getConfirmTravelTime() {
        return confirmTravelTime;
    }

    public void setConfirmTravelTime(Date confirmTravelTime) {
        this.confirmTravelTime = confirmTravelTime;
    }

    public Date getLastConfirmTravelTime() {
        return lastConfirmTravelTime;
    }

    public void setLastConfirmTravelTime(Date lastConfirmTravelTime) {
        this.lastConfirmTravelTime = lastConfirmTravelTime;
    }
}