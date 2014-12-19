package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class CRequirementDetailResponseDto extends ResponseDto {
	private  CRequirementTicketDetailResponseDto tictktDetail;
	
	private  CRequirementHotelDetailResponseDto hotelDetail;
	
	private  CRequirementPersonalVisitDetailResponseDto personalVisitDetail;
	
	private  CRequirementGroupVisitDetailResponseDto groupVisitDetail;

	public CRequirementTicketDetailResponseDto getTictktDetail() {
		return tictktDetail;
	}

	public void setTictktDetail(CRequirementTicketDetailResponseDto tictktDetail) {
		this.tictktDetail = tictktDetail;
	}

	public CRequirementHotelDetailResponseDto getHotelDetail() {
		return hotelDetail;
	}

	public void setHotelDetail(CRequirementHotelDetailResponseDto hotelDetail) {
		this.hotelDetail = hotelDetail;
	}

	public CRequirementPersonalVisitDetailResponseDto getPersonalVisitDetail() {
		return personalVisitDetail;
	}

	public void setPersonalVisitDetail(
			CRequirementPersonalVisitDetailResponseDto personalVisitDetail) {
		this.personalVisitDetail = personalVisitDetail;
	}

	public CRequirementGroupVisitDetailResponseDto getGroupVisitDetail() {
		return groupVisitDetail;
	}

	public void setGroupVisitDetail(
			CRequirementGroupVisitDetailResponseDto groupVisitDetail) {
		this.groupVisitDetail = groupVisitDetail;
	}




}
