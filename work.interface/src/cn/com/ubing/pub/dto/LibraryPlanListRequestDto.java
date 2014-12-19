package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class LibraryPlanListRequestDto extends RequestDto{
    private String requirementId;//需求ID
    private String planType;//方案类型
    public String getRequirementId() {
        return requirementId;
    }
    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }
    public String getPlanType() {
        return planType;
    }
    public void setPlanType(String planType) {
        this.planType = planType;
    }
}
