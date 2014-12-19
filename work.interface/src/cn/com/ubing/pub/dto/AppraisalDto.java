package cn.com.ubing.pub.dto;

/**
 * 评价详情
 * 
 * @author 邱全松 2014-8-14 上午11:41:45
 */
public class AppraisalDto {
    private String requirementId;
    private String requirementTitle;
    private String requirementUserId;
    private String requirementUserName;
    private String requirementType;
    private String requirementTime;
    private String planId;
    private String planPrice;
    private String planChildPrice;
    private String appraisalService;
    private String appraisalDescription;
    private String appraisalResult;
    private String appraisalContent;
    private String requirementUserPhotoUrl;
    
    private String appraisalTime;//c端评价时间
    private String appraisalResponseTime;//我评价的时间
    private String appraisalResponseContent;//我评价的内容

    
    public String getAppraisalTime() {
        return appraisalTime;
    }

    public void setAppraisalTime(String appraisalTime) {
        this.appraisalTime = appraisalTime;
    }

    public String getAppraisalResponseTime() {
        return appraisalResponseTime;
    }

    public void setAppraisalResponseTime(String appraisalResponseTime) {
        this.appraisalResponseTime = appraisalResponseTime;
    }

    public String getAppraisalResponseContent() {
        return appraisalResponseContent;
    }

    public void setAppraisalResponseContent(String appraisalResponseContent) {
        this.appraisalResponseContent = appraisalResponseContent;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirementTitle() {
        return requirementTitle;
    }

    public void setRequirementTitle(String requirementTitle) {
        this.requirementTitle = requirementTitle;
    }

    public String getRequirementUserId() {
        return requirementUserId;
    }

    public void setRequirementUserId(String requirementUserId) {
        this.requirementUserId = requirementUserId;
    }

    public String getRequirementUserName() {
        return requirementUserName;
    }

    public void setRequirementUserName(String requirementUserName) {
        this.requirementUserName = requirementUserName;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequirementTime() {
        return requirementTime;
    }

    public void setRequirementTime(String requirementTime) {
        this.requirementTime = requirementTime;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(String planPrice) {
        this.planPrice = planPrice;
    }

    public String getPlanChildPrice() {
        return planChildPrice;
    }

    public void setPlanChildPrice(String planChildPrice) {
        this.planChildPrice = planChildPrice;
    }

    public String getAppraisalService() {
        return appraisalService;
    }

    public void setAppraisalService(String appraisalService) {
        this.appraisalService = appraisalService;
    }

    public String getAppraisalDescription() {
        return appraisalDescription;
    }

    public void setAppraisalDescription(String appraisalDescription) {
        this.appraisalDescription = appraisalDescription;
    }

    public String getAppraisalResult() {
        return appraisalResult;
    }

    public void setAppraisalResult(String appraisalResult) {
        this.appraisalResult = appraisalResult;
    }

    public String getAppraisalContent() {
        return appraisalContent;
    }

    public void setAppraisalContent(String appraisalContent) {
        this.appraisalContent = appraisalContent;
    }

    public String getRequirementUserPhotoUrl() {
        return requirementUserPhotoUrl;
    }

    public void setRequirementUserPhotoUrl(String requirementUserPhotoUrl) {
        this.requirementUserPhotoUrl = requirementUserPhotoUrl;
    }
}
