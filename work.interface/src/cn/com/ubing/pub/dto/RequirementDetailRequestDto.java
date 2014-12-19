package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * B端订单详情请求dto
 * 
 * @author 邱全松 2014-6-25 下午2:35:26
 */
public class RequirementDetailRequestDto extends RequestDto {
    private String requirementId;// 需求ID
    private String requirementType;// 需求类型

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

}
