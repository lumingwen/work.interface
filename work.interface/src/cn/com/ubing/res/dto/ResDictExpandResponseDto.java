package cn.com.ubing.res.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

public class ResDictExpandResponseDto extends ResponseDto{
    private List<ResDictExpandDto> dictList;

    public List<ResDictExpandDto> getDictList() {
        return dictList;
    }

    public void setDictList(List<ResDictExpandDto> dictList) {
        this.dictList = dictList;
    }
}
