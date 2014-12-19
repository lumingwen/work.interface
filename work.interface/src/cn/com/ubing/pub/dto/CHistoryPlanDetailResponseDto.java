package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * C端历史方案详情响应dto
 * 
 * @author lumingwe2014-6-25 下午2:40:56
 */
public class CHistoryPlanDetailResponseDto extends ResponseDto {
    private String type;// 方案类型 非空 仅数字，（1机票，2酒店，3自由行，4跟团行）
    private String requirementId;
    private CPubPlanHistoryDto pubPlan;
    private CPubPlanHistoryTicketDto cPubPlanHistoryTicketDto;
    private CPlanHistoryHotelDto cPlanHistoryHotelDto;
    private CPubPlanHistoryPersonalVisitDto pubPlanHistoryPersonalVisitDto;
    private CPubPlanHistoryGroupVisitDto pubPlanHistoryGroupVisitDto;

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

    public CPubPlanHistoryDto getPubPlan() {
        return pubPlan;
    }

    public void setPubPlan(CPubPlanHistoryDto pubPlan) {
        this.pubPlan = pubPlan;
    }

    public CPubPlanHistoryTicketDto getcPubPlanHistoryTicketDto() {
		return cPubPlanHistoryTicketDto;
	}

	public void setcPubPlanHistoryTicketDto(
			CPubPlanHistoryTicketDto cPubPlanHistoryTicketDto) {
		this.cPubPlanHistoryTicketDto = cPubPlanHistoryTicketDto;
	}

	public CPlanHistoryHotelDto getcPlanHistoryHotelDto() {
		return cPlanHistoryHotelDto;
	}

	public void setcPlanHistoryHotelDto(CPlanHistoryHotelDto cPlanHistoryHotelDto) {
		this.cPlanHistoryHotelDto = cPlanHistoryHotelDto;
	}

	public CPubPlanHistoryPersonalVisitDto getPubPlanHistoryPersonalVisitDto() {
		return pubPlanHistoryPersonalVisitDto;
	}

	public void setPubPlanHistoryPersonalVisitDto(
			CPubPlanHistoryPersonalVisitDto pubPlanHistoryPersonalVisitDto) {
		this.pubPlanHistoryPersonalVisitDto = pubPlanHistoryPersonalVisitDto;
	}

	public CPubPlanHistoryGroupVisitDto getPubPlanHistoryGroupVisitDto() {
		return pubPlanHistoryGroupVisitDto;
	}

	public void setPubPlanHistoryGroupVisitDto(
			CPubPlanHistoryGroupVisitDto pubPlanHistoryGroupVisitDto) {
		this.pubPlanHistoryGroupVisitDto = pubPlanHistoryGroupVisitDto;
	}

}
