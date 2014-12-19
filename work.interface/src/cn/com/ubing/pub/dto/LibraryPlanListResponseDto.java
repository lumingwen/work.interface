package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;
/**
 * 方案库列表响应dto  
 * @author 邱全松 2014-6-25 下午8:20:07
 */
public class LibraryPlanListResponseDto extends ResponseDto{
    private String requirementId;//需求ID
    private List<LibraryPlanListDto> planList;//方案列表
    public String getRequirementId() {
        return requirementId;
    }
    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }
    public List<LibraryPlanListDto> getPlanList() {
        return planList;
    }
    public void setPlanList(List<LibraryPlanListDto> planList) {
        this.planList = planList;
    }
    
}
