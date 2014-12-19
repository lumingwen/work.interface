package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 保存评论信息请求dto
 * 
 * @author 邱全松 2014-6-27 下午1:49:32
 */
public class SaveAppraisalRequestDto extends RequestDto {
    private String planId;// 方案ID
    private String appraisalContent;// 评价内容

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getAppraisalContent() {
        return appraisalContent;
    }

    public void setAppraisalContent(String appraisalContent) {
        this.appraisalContent = appraisalContent;
    }

}
