package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 评价详情响应Dto
 * 
 * @author 邱全松 2014-6-27 上午11:35:34
 */
public class AppraisalDetailResponseDto extends ResponseDto {
    private AppraisalDto appraisalDto;

    public AppraisalDto getAppraisalDto() {
        return appraisalDto;
    }

    public void setAppraisalDto(AppraisalDto appraisalDto) {
        this.appraisalDto = appraisalDto;
    }
}
