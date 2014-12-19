package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * B端方案库方案详情响应dto
 * 
 * @author 邱全松 2014-6-25 下午2:47:32
 */
public class LibraryPlanDetailResponseDto extends ResponseDto {
    private String requirementId;//需求id
    private String type;// 方案类型
    private PubPlanLibraryGroupVisitDto PubPlanLibraryGroupVisitDto;
    private PubPlanLibraryHotelDto PubPlanLibraryHotelDto;
    private PubPlanLibraryPersonalVisitDto PubPlanLibraryPersonalVisitDto;
    private PubPlanLibraryTicketDto PubPlanLibraryTicketDto;

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PubPlanLibraryGroupVisitDto getPubPlanLibraryGroupVisitDto() {
        return PubPlanLibraryGroupVisitDto;
    }

    public void setPubPlanLibraryGroupVisitDto(PubPlanLibraryGroupVisitDto pubPlanLibraryGroupVisitDto) {
        PubPlanLibraryGroupVisitDto = pubPlanLibraryGroupVisitDto;
    }

    public PubPlanLibraryHotelDto getPubPlanLibraryHotelDto() {
        return PubPlanLibraryHotelDto;
    }

    public void setPubPlanLibraryHotelDto(PubPlanLibraryHotelDto pubPlanLibraryHotelDto) {
        PubPlanLibraryHotelDto = pubPlanLibraryHotelDto;
    }

    public PubPlanLibraryPersonalVisitDto getPubPlanLibraryPersonalVisitDto() {
        return PubPlanLibraryPersonalVisitDto;
    }

    public void setPubPlanLibraryPersonalVisitDto(PubPlanLibraryPersonalVisitDto pubPlanLibraryPersonalVisitDto) {
        PubPlanLibraryPersonalVisitDto = pubPlanLibraryPersonalVisitDto;
    }

    public PubPlanLibraryTicketDto getPubPlanLibraryTicketDto() {
        return PubPlanLibraryTicketDto;
    }

    public void setPubPlanLibraryTicketDto(PubPlanLibraryTicketDto pubPlanLibraryTicketDto) {
        PubPlanLibraryTicketDto = pubPlanLibraryTicketDto;
    }

}
