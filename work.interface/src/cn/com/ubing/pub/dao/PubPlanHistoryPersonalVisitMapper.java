package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.dto.CPubPlanHistoryPersonalVisitDto;
import cn.com.ubing.pub.dto.PubPlanHistoryPersonalVisitDto;
import cn.com.ubing.pub.model.PubPlanHistoryPersonalVisit;

public interface PubPlanHistoryPersonalVisitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryPersonalVisit record);

    int insertSelective(PubPlanHistoryPersonalVisit record);

    PubPlanHistoryPersonalVisit selectByPrimaryKey(Long id);
    
    PubPlanHistoryPersonalVisitDto selectDetail(Long id);
    
    int updateByPrimaryKeySelective(PubPlanHistoryPersonalVisit record);

    int updateByPrimaryKey(PubPlanHistoryPersonalVisit record);
    
    CPubPlanHistoryPersonalVisitDto selectCPubPlanDetail(Long id);
}