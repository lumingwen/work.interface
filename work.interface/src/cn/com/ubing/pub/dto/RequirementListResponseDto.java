package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;
/**
 * 历史需求列表
 *  
 * @author 邱全松 2014-8-13 下午4:21:04
 */
public class RequirementListResponseDto extends ResponseDto {
    private List<RequirementDto> requirementList;

    public List<RequirementDto> getRequirementList() {
        return requirementList;
    }

    public void setRequirementList(List<RequirementDto> requirementList) {
        this.requirementList = requirementList;
    }

}
