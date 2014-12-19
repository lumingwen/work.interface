package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class PubPlanCountOutResponseDto extends ResponseDto{
    private String PubPlanCount;//招标中的总数

	public String getPubPlanCount() {
		return PubPlanCount;
	}

	public void setPubPlanCount(String pubPlanCount) {
		PubPlanCount = pubPlanCount;
	}


}
