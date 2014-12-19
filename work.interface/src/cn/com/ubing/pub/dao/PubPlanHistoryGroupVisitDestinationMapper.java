package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.pub.dto.PubPlanHistoryGroupVisitDestinationDto;
import cn.com.ubing.pub.model.PubPlanHistoryGroupVisitDestination;

public interface PubPlanHistoryGroupVisitDestinationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryGroupVisitDestination record);

    int insertSelective(PubPlanHistoryGroupVisitDestination record);

    PubPlanHistoryGroupVisitDestination selectByPrimaryKey(Long id);
    
    List<PubPlanHistoryGroupVisitDestinationDto> selectDto(Long planId);

    int updateByPrimaryKeySelective(PubPlanHistoryGroupVisitDestination record);

    int updateByPrimaryKey(PubPlanHistoryGroupVisitDestination record);
}