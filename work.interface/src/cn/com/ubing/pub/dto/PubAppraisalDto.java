package cn.com.ubing.pub.dto;

import cn.com.ubing.pub.model.PubAppraisal;

public class PubAppraisalDto extends PubAppraisal {
    private String appraisalName;
    private String labelName;
    private Long uid;

    public String getAppraisalName() {
        return appraisalName;
    }

    public void setAppraisalName(String appraisalName) {
        this.appraisalName = appraisalName;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

}
