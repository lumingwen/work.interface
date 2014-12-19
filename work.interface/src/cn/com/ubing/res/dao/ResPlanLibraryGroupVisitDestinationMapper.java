package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.dto.ResPlanLibraryGroupVisitDestinationDto;
import cn.com.ubing.res.model.ResPlanLibraryGroupVisitDestination;

public interface ResPlanLibraryGroupVisitDestinationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResPlanLibraryGroupVisitDestination record);

    int insertSelective(ResPlanLibraryGroupVisitDestination record);

    ResPlanLibraryGroupVisitDestination selectByPrimaryKey(Long id);
    
    List<ResPlanLibraryGroupVisitDestinationDto> selectDto(Long planId);

    int updateByPrimaryKeySelective(ResPlanLibraryGroupVisitDestination record);

    int updateByPrimaryKey(ResPlanLibraryGroupVisitDestination record);
}