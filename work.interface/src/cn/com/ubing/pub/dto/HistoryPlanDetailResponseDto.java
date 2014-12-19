package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.pub.model.PubPlan;

/**
 * B端历史方案详情响应dto
 * 
 * @author lumingwe2014-6-25 下午2:40:56
 */
public class HistoryPlanDetailResponseDto extends ResponseDto {
    private String type;// 方案类型 非空 仅数字，（1机票，2酒店，3自由行，4跟团行）
    private String requirementId;
    private PubPlanHistoryDto pubPlan;
    private PubPlanHistoryTicketDto pubPlanHistoryTicketDto;
    private PubPlanHistoryHotelDto pubPlanHistoryHotelDto;
    private PubPlanHistoryPersonalVisitDto pubPlanHistoryPersonalVisitDto;
    private PubPlanHistoryGroupVisitDto pubPlanHistoryGroupVisitDto;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
