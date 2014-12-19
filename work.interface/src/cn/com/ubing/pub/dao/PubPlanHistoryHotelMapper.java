package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.dto.CPlanHistoryHotelDto;
import cn.com.ubing.pub.model.PubPlanHistoryHotel;

/**
 * 酒店方案
 * @author lumw
 *
 */
public interface PubPlanHistoryHotelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryHotel record);

    PubPlanHistoryHotel selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubPlanHistoryHotel record);
    
    CPlanHistoryHotelDto selectDetail(Long id);
}