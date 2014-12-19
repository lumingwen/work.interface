package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.dto.ResPlanLibraryPersonalVisitDestinationDto;
import cn.com.ubing.res.model.ResPlanLibraryPersonalVisitDestination;

public interface ResPlanLibraryPersonalVisitDestinationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResPlanLibraryPersonalVisitDestination record);

    int insertSelective(ResPlanLibraryPersonalVisitDestination record);

    ResPlanLibraryPersonalVisitDestination selectByPrimaryKey(Long id);
    
    List<ResPlanLibraryPersonalVisitDestinationDto> selectDto(Long planId);

    int updateByPrimaryKeySelective(ResPlanLibraryPersonalVisitDestination record);

    int updateByPrimaryKey(ResPlanLibraryPersonalVisitDestination record);
}