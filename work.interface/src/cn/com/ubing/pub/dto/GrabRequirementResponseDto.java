package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 抢单返回dto
 * 
 * @author 邱全松 2014-9-3 下午6:37:17
 */
public class GrabRequirementResponseDto extends ResponseDto {
    private String result;// String 抢单结果 非空 仅包含数字（0失败，1成功）
    private String lose;// 抢单失败低于多少人 仅数字
    private String requirementId;// 需求ID 非空 仅数字
    private String requirementTitle;// 需求标题 非空
    private String requirementType;// 需求类型 非空 仅数字（1机票，2酒店，3自由行，4跟团行）
    private String requirementDetail;// 补充说明
    private String requirementBy;// 需求提交人

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLose() {
        return lose;
    }

    public void setLose(String lose) {
        this.lose = lose;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getRequirementTitle() {
        return requirementTitle;
    }

    public void setRequirementTitle(String requirementTitle) {
        this.requirementTitle = requirementTitle;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRequirementDetail() {
        return requirementDetail;
    }

    public void setRequirementDetail(String requirementDetail) {
        this.requirementDetail = requirementDetail;
    }

    public String getRequirementBy() {
        return requirementBy;
    }

    public void setRequirementBy(String requirementBy) {
        this.requirementBy = requirementBy;
    }

}
