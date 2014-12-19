package cn.com.ubing.pub.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.pub.model.PubBroadcastSend;

public interface PubBroadcastSendMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubBroadcastSend record);

    int insertSelective(PubBroadcastSend record);

    PubBroadcastSend selectByPrimaryKey(Long id);
    
    PageList<PubBroadcastSend> listBroadcastSendInfo(Long userId,PageBounds pageBounds);

    int updateByPrimaryKeySelective(PubBroadcastSend record);

    int updateByPrimaryKey(PubBroadcastSend record);
}