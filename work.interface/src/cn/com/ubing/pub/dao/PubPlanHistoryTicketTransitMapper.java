package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.model.PubPlanHistoryTicketTransit;

public interface PubPlanHistoryTicketTransitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryTicketTransit record);

    int insertSelective(PubPlanHistoryTicketTransit record);

    PubPlanHistoryTicketTransit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubPlanHistoryTicketTransit record);

    int updateByPrimaryKey(PubPlanHistoryTicketTransit record);
}