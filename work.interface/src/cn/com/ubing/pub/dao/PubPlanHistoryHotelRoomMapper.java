package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.model.PubPlanHistoryHotelRoom;

public interface PubPlanHistoryHotelRoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryHotelRoom record);

    int insertSelective(PubPlanHistoryHotelRoom record);

    PubPlanHistoryHotelRoom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubPlanHistoryHotelRoom record);

    int updateByPrimaryKey(PubPlanHistoryHotelRoom record);
}