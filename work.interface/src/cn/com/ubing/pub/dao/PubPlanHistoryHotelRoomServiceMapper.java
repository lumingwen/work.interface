package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.model.PubPlanHistoryHotelRoomService;

public interface PubPlanHistoryHotelRoomServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryHotelRoomService record);

    int insertSelective(PubPlanHistoryHotelRoomService record);

    PubPlanHistoryHotelRoomService selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubPlanHistoryHotelRoomService record);

    int updateByPrimaryKey(PubPlanHistoryHotelRoomService record);
}