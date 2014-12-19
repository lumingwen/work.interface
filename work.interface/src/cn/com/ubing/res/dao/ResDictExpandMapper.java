package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.dto.ResDictExpandDto;
import cn.com.ubing.res.dto.ResDictExpandRequestDto;
import cn.com.ubing.res.model.ResDictExpand;

public interface ResDictExpandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResDictExpand record);

    ResDictExpand selectByPrimaryKey(Long id);
    
    List<ResDictExpandDto> queryDtoList(ResDictExpandRequestDto param);

    int updateByPrimaryKey(ResDictExpand record);
}