package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 评价列表查看响应dto
 * 
 * @author 邱全松 2014-6-27 下午1:47:20
 */
public class AppraisalListResponseDto extends ResponseDto {
    private List<PubAppraisalListDto> appraisalList;// 评价信息列表

    public List<PubAppraisalListDto> getAppraisalList() {
        return appraisalList;
    }

    public void setAppraisalList(List<PubAppraisalListDto> appraisalList) {
        this.appraisalList = appraisalList;
    }

}
