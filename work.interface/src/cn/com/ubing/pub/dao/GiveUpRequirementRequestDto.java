package cn.com.ubing.pub.dao;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 放弃抢单请求dto
 *  
 * @author 邱全松 2014-9-3 下午7:17:22
 */
public class GiveUpRequirementRequestDto extends RequestDto{
    private Long requirementId;//需求id
    private Integer requirementType;//需求类型1机票，2酒店，3自由行，4跟团行
    public Long getRequirementId() {
        return requirementId;
    }
    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
    }
    public Integer getRequirementType() {
        return requirementType;
    }
    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
    }
    
}
