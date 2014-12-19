package cn.com.ubing.pub.dto;

/**
 * 订单列表
 * 
 * @author 邱全松 2014-11-17 下午3:30:11
 */
public class PubOrdersListDto {
    private String productName;// 订单标题
    private String peopleCount;// 成人数量
    private String childPeopleCount;// 儿童数量
    private String totalMoney;// 订单总价
    private String payStatus;// 支付状态(0:未支付,1:已支付,3:已过期)
    private String lastPayTime;// 最后支付时间
    private String confirmTravelStatus;// 确认出行状态(0:未出行,1:已出行)
    private String fromAppraisal;// 评价
    private String toAppraisal;// 被评价
    private String orderType;//订单类型。1方案2尾单
    private String orderId;//订单id
    private String requirementType;//需求类型
    private String lastConfirmTravelTime;//最后确认出行时间
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getLastPayTime() {
        return lastPayTime;
    }

    public void setLastPayTime(String lastPayTime) {
        this.lastPayTime = lastPayTime;
    }

    public String getConfirmTravelStatus() {
        return confirmTravelStatus;
    }

    public void setConfirmTravelStatus(String confirmTravelStatus) {
        this.confirmTravelStatus = confirmTravelStatus;
    }

    public String getFromAppraisal() {
        return fromAppraisal;
    }

    public void setFromAppraisal(String fromAppraisal) {
        this.fromAppraisal = fromAppraisal;
    }

    public String getToAppraisal() {
        return toAppraisal;
    }

    public void setToAppraisal(String toAppraisal) {
        this.toAppraisal = toAppraisal;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getLastConfirmTravelTime() {
        return lastConfirmTravelTime;
    }

    public void setLastConfirmTravelTime(String lastConfirmTravelTime) {
        this.lastConfirmTravelTime = lastConfirmTravelTime;
    }
}
