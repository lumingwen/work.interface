package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.pub.dto.PubPlanHistoryPersonalVisitDestinationDto;
import cn.com.ubing.pub.model.PubPlanHistoryPersonalVisitDestination;

public interface PubPlanHistoryPersonalVisitDestinationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryPersonalVisitDestination record);

    int insertSelective(PubPlanHistoryPersonalVisitDestination record);

    PubPlanHistoryPersonalVisitDestination selectByPrimaryKey(Long id);

    List<PubPlanHistoryPersonalVisitDestinationDto> selectDto(Long planId);

    int updateByPrimaryKeySelective(PubPlanHistoryPersonalVisitDestination record);

    int updateByPrimaryKey(PubPlanHistoryPersonalVisitDestination record);
}