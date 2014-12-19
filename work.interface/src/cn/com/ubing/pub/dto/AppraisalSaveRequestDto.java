package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 评价信息保存请求dto
 *  
 * @author 邱全松 2014-8-14 下午1:31:24
 */
public class AppraisalSaveRequestDto extends RequestDto {
    private String requirementUserId;
    private String planId;
    private String appraisalResponseContent;
   
    public String getRequirementUserId() {
        return requirementUserId;
    }
    public void setRequirementUserId(String requirementUserId) {
        this.requirementUserId = requirementUserId;
    }
    public String getPlanId() {
        return planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    public String getAppraisalResponseContent() {
        return appraisalResponseContent;
    }
    public void setAppraisalResponseContent(String appraisalResponseContent) {
        this.appraisalResponseContent = appraisalResponseContent;
    }
}
