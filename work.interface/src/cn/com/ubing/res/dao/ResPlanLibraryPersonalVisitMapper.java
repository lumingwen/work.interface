package cn.com.ubing.res.dao;

import cn.com.ubing.pub.dto.PubPlanLibraryPersonalVisitDto;
import cn.com.ubing.res.model.ResPlanLibraryPersonalVisit;

public interface ResPlanLibraryPersonalVisitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResPlanLibraryPersonalVisit record);

    int insertSelective(ResPlanLibraryPersonalVisit record);

    ResPlanLibraryPersonalVisit selectByPrimaryKey(Long id);
    
    PubPlanLibraryPersonalVisitDto selectDetail(Long id);

    int updateByPrimaryKeySelective(ResPlanLibraryPersonalVisit record);

    int updateByPrimaryKey(ResPlanLibraryPersonalVisit record);
}