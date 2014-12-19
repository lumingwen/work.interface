package cn.com.ubing.pub.dto;

public class BPubOrdersListDto {
    private String orderId;//订单id
    private String payStatus;//支付状态
    private String confirmTravelStatus;//确认出行状态
    private String payMoney;//支付金额
    
    private String requirementId;//需求ID
    private String requirementType;//需求类型
    private String requirementTitle;//需求标题
    private String requirementCreateTime;//需求发布时间
    private String coupon;//优惠卷
    private String contacts;//联系人
    private String contactsTel;//联系人电话
    private String requirementById;//需求提交人id
    
    private String planCreateTime;//方案提交时间
    private String planTitle;//方案标题
    private String orderById;//方案标题
    
    private String groupId;//消息组ID
    private String planId;//方案id
    private String orderResStatus;//订单状态1等待付款    2付款超时    3已付款    4已出行    5已评价    6已完成


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getConfirmTravelStatus() {
        return confirmTravelStatus;
    }

    public void setConfirmTravelStatus(String confirmTravelStatus) {
        this.confirmTravelStatus = confirmTravelStatus;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
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

    public String getRequirementTitle() {
        return requirementTitle;
    }

    public void setRequirementTitle(String requirementTitle) {
        this.requirementTitle = requirementTitle;
    }

    public String getRequirementCreateTime() {
        return requirementCreateTime;
    }

    public void setRequirementCreateTime(String requirementCreateTime) {
        this.requirementCreateTime = requirementCreateTime;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
    }

    public String getPlanCreateTime() {
        return planCreateTime;
    }

    public void setPlanCreateTime(String planCreateTime) {
        this.planCreateTime = planCreateTime;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getRequirementById() {
        return requirementById;
    }

    public void setRequirementById(String requirementById) {
        this.requirementById = requirementById;
    }

    public String getOrderById() {
        return orderById;
    }

    public void setOrderById(String orderById) {
        this.orderById = orderById;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getOrderResStatus() {
        return orderResStatus;
    }

    public void setOrderResStatus(String orderResStatus) {
        this.orderResStatus = orderResStatus;
    }

}
