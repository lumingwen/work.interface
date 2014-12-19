package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.pub.dto.BroadcastDto;
import cn.com.ubing.pub.model.PubBroadcastSendDetail;

public interface PubBroadcastSendDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubBroadcastSendDetail record);

    int insertSelective(PubBroadcastSendDetail record);

    PubBroadcastSendDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubBroadcastSendDetail record);

    int updateByPrimaryKey(PubBroadcastSendDetail record);
    /**
     * 根据商家ID获取最新旅游播报
     * 
     * @author 邱全松 2014-7-11 下午1:53:08
     * @param dto
     * @return
     */
    List<BroadcastDto> getBroadcastListBySendId(Long sendID);
    /**
     * 获取播报信息后，更改状态
     * 
     * @author 邱全松 2014-7-11 下午1:53:30
     * @param dto
     * @return
     */
    int updateSendStatusByUser(RequestDto dto);
}