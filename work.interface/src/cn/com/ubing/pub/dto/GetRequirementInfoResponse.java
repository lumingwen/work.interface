package cn.com.ubing.pub.dto;

import java.util.Date;

import cn.com.ubing.common.dto.ResponseDto;

public class GetRequirementInfoResponse extends ResponseDto{
    private String requirementId;
    private String requirementType;
    private String requirementTitle;
    private Date endTime;
    private String endTimeLong;
    
    public Date getEndTime() {
        return endTime;
    }
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public String getEndTimeLong() {
        return endTimeLong;
    }
    public void setEndTimeLong(String endTimeLong) {
        this.endTimeLong = endTimeLong;
    }
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
    public String getRequirementTitle() {
        return requirementTitle;
    }
    public void setRequirementTitle(String requirementTitle) {
        this.requirementTitle = requirementTitle;
    }
}
