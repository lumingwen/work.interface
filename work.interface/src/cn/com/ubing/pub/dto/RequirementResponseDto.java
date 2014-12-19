package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

public class RequirementResponseDto extends ResponseDto{
    private List<RequirementDto> requirementList;//订单列表

    public List<RequirementDto> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<RequirementDto> requirementList) {
        this.requirementList = requirementList;
    }

   
    
}
