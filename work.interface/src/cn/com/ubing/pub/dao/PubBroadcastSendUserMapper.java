package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.model.PubBroadcastSendUser;

public interface PubBroadcastSendUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubBroadcastSendUser record);

    int insertSelective(PubBroadcastSendUser record);

    PubBroadcastSendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubBroadcastSendUser record);

    int updateByPrimaryKey(PubBroadcastSendUser record);
}