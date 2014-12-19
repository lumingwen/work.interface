package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;
/**
 * 订单详情
 *  
 * @author 邱全松 2014-11-18 下午1:21:16
 */
public class CPubOrdersDetailResponseDto extends ResponseDto{
    private String orderId;//订单ID
    private String serialNumber;//订单编号
    private String type;//订单类型1:方案订单,2:尾单订单
    private String productName;//订单名称
    private String createTime;//下单时间
    private String planId;//方案ID
    private String requirementId;//需求ID
    private String requirementType;//需求类型
    private String startTime;//出行时间（关联方案的出行时间）
    private String peopleCount;//成人数量
    private String childPeopleCount;//儿童数量
    private String price;//成人报价
    private String childPrice;//儿童报价
    private String totalMoney;//订单总价
    private String preferentialMoney;//优惠价格
    private String payMoney;//需支付价格
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getPlanId() {
        return planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    public String getRequirementId() {
        return requirementId;
    }
    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }
    public String getRequirementType() {
        return requirementType;
    }
    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getPeopleCount() {
        return peopleCount;
    }
    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
    }
    public String getChildPeopleCount() {
        return childPeopleCount;
    }
    public void setChildPeopleCount(String childPeopleCount) {
        this.childPeopleCount = childPeopleCount;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getChildPrice() {
        return childPrice;
    }
    public void setChildPrice(String childPrice) {
        this.childPrice = childPrice;
    }
    public String getTotalMoney() {
        return totalMoney;
    }
    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }
    public String getPreferentialMoney() {
        return preferentialMoney;
    }
    public void setPreferentialMoney(String preferentialMoney) {
        this.preferentialMoney = preferentialMoney;
    }
    public String getPayMoney() {
        return payMoney;
    }
    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }
}
