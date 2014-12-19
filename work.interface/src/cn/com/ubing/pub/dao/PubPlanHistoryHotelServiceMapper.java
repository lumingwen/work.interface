package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.pub.dto.PubPlanHistoryHotelServiceDto;
import cn.com.ubing.pub.model.PubPlanHistoryHotelService;


/**
 * 酒店方案提供服务
 * @author lumw
 *
 */
public interface PubPlanHistoryHotelServiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanHistoryHotelService record);

    PubPlanHistoryHotelService selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubPlanHistoryHotelService record);
     
    List<PubPlanHistoryHotelServiceDto> listServiceInfoByHistoryId(Long pubHistoryId);
}