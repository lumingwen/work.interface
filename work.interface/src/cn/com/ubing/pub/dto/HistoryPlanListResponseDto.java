package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 历史方案列表响应dto
 * 
 * @author 邱全松 2014-6-25 下午8:22:16
 */
public class HistoryPlanListResponseDto extends ResponseDto{
    private String requirementId;// 需求ID
    private List<HistoryPlanListDto> planList;// 方案列表

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public List<HistoryPlanListDto> getPlanList() {
        return planList;
    }

    public void setPlanList(List<HistoryPlanListDto> planList) {
        this.planList = planList;
    }

}
