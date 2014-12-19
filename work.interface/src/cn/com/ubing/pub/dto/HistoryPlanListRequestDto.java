package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 历史方案列表请求dto
 * 
 * @author 邱全松 2014-6-25 下午8:24:56
 */
public class HistoryPlanListRequestDto extends RequestDto {
    private String requirementId;// 需求ID
    private String planType;// 方案类型
    private String startTime;// 开始时间
    private String endTime;// 结束时间

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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
