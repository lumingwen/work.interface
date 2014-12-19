package cn.com.ubing.res.dao;

import cn.com.ubing.pub.dto.PubPlanLibraryGroupVisitDto;
import cn.com.ubing.res.model.ResPlanLibraryGroupVisit;

public interface ResPlanLibraryGroupVisitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResPlanLibraryGroupVisit record);

    int insertSelective(ResPlanLibraryGroupVisit record);

    ResPlanLibraryGroupVisit selectByPrimaryKey(Long id);
    
    PubPlanLibraryGroupVisitDto selectDetail(Long id);

    int updateByPrimaryKeySelective(ResPlanLibraryGroupVisit record);

    int updateByPrimaryKey(ResPlanLibraryGroupVisit record);
}