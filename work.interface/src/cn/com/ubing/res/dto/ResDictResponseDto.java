package cn.com.ubing.res.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 线路信息获取相应dto
 *  
 * @author 邱全松 2014-6-30 下午4:32:56
 */
public class ResDictResponseDto extends ResponseDto{
    private List<ResDictDto> DictList;//线路信息列表

    public List<ResDictDto> getDictList() {
        return DictList;
    }

    public void setDictList(List<ResDictDto> dictList) {
        DictList = dictList;
    }

    
}
