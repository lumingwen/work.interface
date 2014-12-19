package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 抢单请求接口
 *  
 * @author 邱全松 2014-9-3 下午6:35:28
 */
public class GrabRequirementRequestDto extends RequestDto{
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
