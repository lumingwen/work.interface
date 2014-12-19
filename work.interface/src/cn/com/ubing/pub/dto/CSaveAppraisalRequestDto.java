package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class CSaveAppraisalRequestDto extends RequestDto{
    private String fromId;//评价人
    private String toId;//被评价人
    private String content;//评价内容
    private String doneServiceLabelId;//交易完成:服务态度星级1-5
    private String doneDescriptionLabelId;//交易完成:描述相符星级1-5
    private String appraisalResult;//1好评，2中评，3差评
    private String planId;//方案ID
    public String getFromId() {
        return fromId;
    }
    public void setFromId(String fromId) {
        this.fromId = fromId;
    }
    public String getToId() {
        return toId;
    }
    public void setToId(String toId) {
        this.toId = toId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getDoneServiceLabelId() {
        return doneServiceLabelId;
    }
    public void setDoneServiceLabelId(String doneServiceLabelId) {
        this.doneServiceLabelId = doneServiceLabelId;
    }
    public String getDoneDescriptionLabelId() {
        return doneDescriptionLabelId;
    }
    public void setDoneDescriptionLabelId(String doneDescriptionLabelId) {
        this.doneDescriptionLabelId = doneDescriptionLabelId;
    }
    public String getAppraisalResult() {
        return appraisalResult;
    }
    public void setAppraisalResult(String appraisalResult) {
        this.appraisalResult = appraisalResult;
    }
    public String getPlanId() {
        return planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
