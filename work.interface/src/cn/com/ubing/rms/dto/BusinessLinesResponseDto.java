package cn.com.ubing.rms.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.res.dto.ResDictDto;

/**
 * 商家线路信息获取响应dto
 * 
 * @author 邱全松 2014-7-15 下午1:48:31
 */
public class BusinessLinesResponseDto extends ResponseDto {
    private List<ResDictDto> lineList;

    public List<ResDictDto> getLineList() {
        return lineList;
    }

    public void setLineList(List<ResDictDto> lineList) {
        this.lineList = lineList;
    }
}
