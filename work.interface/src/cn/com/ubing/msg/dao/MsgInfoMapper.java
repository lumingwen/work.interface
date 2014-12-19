package cn.com.ubing.msg.dao;

import cn.com.ubing.msg.dto.MessageRequestDto;
import cn.com.ubing.msg.model.MsgInfo;
/**
 * 消息内容
 * @author zhangxujun
 * 
 *
 */
public interface MsgInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgInfo record);

    MsgInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKey(MsgInfo record);
    
    int updateToRead(MessageRequestDto record);
    
    int deleteMessageByGroupId(Long id);
}