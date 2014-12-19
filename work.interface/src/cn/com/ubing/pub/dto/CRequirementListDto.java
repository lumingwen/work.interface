package cn.com.ubing.pub.dto;

public class CRequirementListDto {
    private String requirementId;//需求ID
    private String requirementType;//需求类型
    private String title;//需求标题
    private String createTime;//需求提交时间
    private String grapCount;//抢单数
    private String planCount;//报价数
    
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
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCreateTime() {
        return createTime;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getGrapCount() {
        return grapCount;
    }
    public void setGrapCount(String grapCount) {
        this.grapCount = grapCount;
    }
    public String getPlanCount() {
        return planCount;
    }
    public void setPlanCount(String planCount) {
        this.planCount = planCount;
    }
}
