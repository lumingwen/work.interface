package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.dto.CPubPlanHistoryGroupVisitDto;
import cn.com.ubing.pub.dto.PubPlanHistoryGroupVisitDto;
import cn.com.ubing.pub.model.PubPlanHistoryGroupVisit;

public interface PubPlanHistoryGroupVisitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryGroupVisit record);

    int insertSelective(PubPlanHistoryGroupVisit record);

    PubPlanHistoryGroupVisit selectByPrimaryKey(Long id);
    
    PubPlanHistoryGroupVisitDto selectDetail(Long id);

    int updateByPrimaryKeySelective(PubPlanHistoryGroupVisit record);

    int updateByPrimaryKey(PubPlanHistoryGroupVisit record);
    
    CPubPlanHistoryGroupVisitDto selectCPubPlanDetail(Long id);
}