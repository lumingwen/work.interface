package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.dto.ResPlanLibraryPersonalVisitServiceDto;
import cn.com.ubing.res.model.ResPlanLibraryPersonalVisitService;

public interface ResPlanLibraryPersonalVisitServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResPlanLibraryPersonalVisitService record);

    int insertSelective(ResPlanLibraryPersonalVisitService record);

    ResPlanLibraryPersonalVisitService selectByPrimaryKey(Long id);
    
    List<ResPlanLibraryPersonalVisitServiceDto> selectDto(Long planId);

    int updateByPrimaryKeySelective(ResPlanLibraryPersonalVisitService record);

    int updateByPrimaryKey(ResPlanLibraryPersonalVisitService record);
}