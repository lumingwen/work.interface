package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 评价详情查看请求dto
 * 
 * @author 邱全松 2014-6-27 上午11:33:55
 */
public class AppraisalDetailRequestDto extends RequestDto {
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
