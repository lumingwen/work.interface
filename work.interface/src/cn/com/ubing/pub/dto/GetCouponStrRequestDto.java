/**
 * 
 */
package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * @author zhangxujun
 * 
 *
 */
public class GetCouponStrRequestDto extends RequestDto {
    
    /**
     * 需求类型
     */
    private String requirementType;
    
    
    /**
     * 需求id
     */
    private String requirementId;


    public String getRequirementType() {
        return requirementType;
    }


    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }


    public String getRequirementId() {
        return requirementId;
    }


    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }
    
    

}
