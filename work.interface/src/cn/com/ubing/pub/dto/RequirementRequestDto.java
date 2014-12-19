package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class RequirementRequestDto extends RequestDto {
    private String requirementStatus;// 订单状态
    private String planStatus;// 方案状态

    public String getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(String requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

}
