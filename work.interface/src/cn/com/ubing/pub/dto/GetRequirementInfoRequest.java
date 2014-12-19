package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class GetRequirementInfoRequest extends RequestDto{
    private String requirementId;
    private String requirementType;
    
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
