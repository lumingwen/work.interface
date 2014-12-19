package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.pub.dto.PubPlanHistoryPersonalVisitServiceDto;
import cn.com.ubing.pub.model.PubPlanHistoryPersonalVisitService;

public interface PubPlanHistoryPersonalVisitServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryPersonalVisitService record);

    int insertSelective(PubPlanHistoryPersonalVisitService record);

    PubPlanHistoryPersonalVisitService selectByPrimaryKey(Long id);

    List<PubPlanHistoryPersonalVisitServiceDto> selectDto(Long planId);

    int updateByPrimaryKeySelective(PubPlanHistoryPersonalVisitService record);

    int updateByPrimaryKey(PubPlanHistoryPersonalVisitService record);
}