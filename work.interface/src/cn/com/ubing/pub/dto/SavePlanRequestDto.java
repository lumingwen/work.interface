package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class SavePlanRequestDto extends RequestDto {
    private String requirementId;//需求id
    private String requirementType;//需求类型
    private String planType;//方案类型
    private PubPlanHistoryDto pubPlan;//方案
    private PubPlanHistoryTicketDto pubPlanHistoryTicketDto;//机票
    private PubPlanHistoryHotelDto pubPlanHistoryHotelDto;//酒店
    private PubPlanHistoryPersonalVisitDto pubPlanHistoryPersonalVisitDto;//自由行
    private PubPlanHistoryGroupVisitDto pubPlanHistoryGroupVisitDto;//跟团行

   

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

    public PubPlanHistoryDto getPubPlan() {
        return pubPlan;
    }

    public void setPubPlan(PubPlanHistoryDto pubPlan) {
        this.pubPlan = pubPlan;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public PubPlanHistoryTicketDto getPubPlanHistoryTicketDto() {
        return pubPlanHistoryTicketDto;
    }

    public void setPubPlanHistoryTicketDto(PubPlanHistoryTicketDto pubPlanHistoryTicketDto) {
        this.pubPlanHistoryTicketDto = pubPlanHistoryTicketDto;
    }

    public PubPlanHistoryHotelDto getPubPlanHistoryHotelDto() {
        return pubPlanHistoryHotelDto;
    }

    public void setPubPlanHistoryHotelDto(PubPlanHistoryHotelDto pubPlanHistoryHotelDto) {
        this.pubPlanHistoryHotelDto = pubPlanHistoryHotelDto;
    }

    public PubPlanHistoryPersonalVisitDto getPubPlanHistoryPersonalVisitDto() {
        return pubPlanHistoryPersonalVisitDto;
    }

    public void setPubPlanHistoryPersonalVisitDto(PubPlanHistoryPersonalVisitDto pubPlanHistoryPersonalVisitDto) {
        this.pubPlanHistoryPersonalVisitDto = pubPlanHistoryPersonalVisitDto;
    }

    public PubPlanHistoryGroupVisitDto getPubPlanHistoryGroupVisitDto() {
        return pubPlanHistoryGroupVisitDto;
    }

    public void setPubPlanHistoryGroupVisitDto(PubPlanHistoryGroupVisitDto pubPlanHistoryGroupVisitDto) {
        this.pubPlanHistoryGroupVisitDto = pubPlanHistoryGroupVisitDto;
    }

}
