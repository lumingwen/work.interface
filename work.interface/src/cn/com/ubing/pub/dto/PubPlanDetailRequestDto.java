package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * C端历史方案详情请求dto
 * @author Administrator
 *
 */
public class PubPlanDetailRequestDto extends RequestDto {
    private String requirementId;
    private String planId;// 方案ID

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
