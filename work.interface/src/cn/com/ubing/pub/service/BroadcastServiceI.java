package cn.com.ubing.pub.service;


import cn.com.ubing.pub.dto.PubBroadcastRequestDto;
import cn.com.ubing.pub.dto.PubBroadcastResponseDto;

/**
 * 旅游播报信息
 * 
 * @author 邱全松 2014-7-11 上午11:46:31
 */
public interface BroadcastServiceI {
    /**
     * (B端APP)获取旅游播报信息
     * 
     * @author 邱全松 2014-7-11 上午11:47:13
     * @param dto
     * @return
     */
    PubBroadcastResponseDto getBroadcast(PubBroadcastRequestDto dto,PubBroadcastResponseDto res);
}
