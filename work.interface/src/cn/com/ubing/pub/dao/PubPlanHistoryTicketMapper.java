package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.dto.CPubPlanHistoryTicketDto;
import cn.com.ubing.pub.model.PubPlanHistoryTicket;


/**
 * 机票方案
 * @author lumw
 *
 */
public interface PubPlanHistoryTicketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryTicket record);

    PubPlanHistoryTicket selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubPlanHistoryTicket record);
    
    CPubPlanHistoryTicketDto selectDetail(Long id);
}