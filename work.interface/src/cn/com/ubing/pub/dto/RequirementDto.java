package cn.com.ubing.pub.dto;

/**
 * 历史需求
 * 
 * @author 邱全松 2014-6-25 上午10:29:38
 */
public class RequirementDto {
    private String requirementId;
    private String requirementTitle;
    private String planStatus;
    private String planCreateTime;
    private String planDeadline;
    private String grapStatus;
    private String readStatus;
    private String requirementType;
    private String requirementBy;
    private String requirementById;
    private String planTitle;
    private String appraisalStatus;
    private String userMessage;
    private String status;
    private String sendTime;
    private String groupId;

    private String coupon;//优惠卷id
    private String contactsTel;//常用联系人电话号码
    
    
    
    
    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
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

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getAppraisalStatus() {
        return appraisalStatus;
    }

    public void setAppraisalStatus(String appraisalStatus) {
        this.appraisalStatus = appraisalStatus;
    }

    public String getPlanCreateTime() {
        return planCreateTime;
    }

    public void setPlanCreateTime(String planCreateTime) {
        this.planCreateTime = planCreateTime;
    }

    public String getRequirementTitle() {
        return requirementTitle;
    }

    public void setRequirementTitle(String requirementTitle) {
        this.requirementTitle = requirementTitle;
    }


    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public String getPlanDeadline() {
        return planDeadline;
    }

    public void setPlanDeadline(String planDeadline) {
        this.planDeadline = planDeadline;
    }

    public String getGrapStatus() {
        return grapStatus;
    }

    public void setGrapStatus(String grapStatus) {
        this.grapStatus = grapStatus;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequirementBy() {
        return requirementBy;
    }

    public void setRequirementBy(String requirementBy) {
        this.requirementBy = requirementBy;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}