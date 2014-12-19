/**
 * 
 */
package cn.com.ubing.msg.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.msg.dto.GroupMessageListResponseDto;
import cn.com.ubing.msg.dto.MessageListResponseDto;
import cn.com.ubing.msg.dto.MessageRequestDto;
import cn.com.ubing.msg.dto.MessageResponseDto;
import cn.com.ubing.msg.model.MsgGroup;

/**
 * 消息service
 * @author lumw
 * 
 *
 */
public interface MessageServiceI {

    /**
     * (B端)查询消息组
     * @param param
     * @return
     */
    public MessageListResponseDto getMessageListResponseDto(RequestDto param, PageBounds pageBounds);
    
    /**
     * (B端)根据消息组查询消息内容
     * @param param
     * @return
     */
    public MessageResponseDto getMessageDetail(MessageRequestDto param, PageBounds pageBounds);
    
    /**
     * (B端)是否在黑名单中
     * @param fromId 发送者id
     * @param toId 接收者id
     * @return true在,false不在
     */
    public boolean isInBlackList(Long fromId,Long toId);
    
    /**
     * (B端)根据消息组id查询消息组
     * @param groupId
     * @return
     */
    public MsgGroup getMsgGroupById(Long groupId);
    /**
     * 根据用户id查询其消息组，如果不存在则创建
     * 
     * @author 邱全松 2014-9-26 下午4:05:39
     * @param fromId
     * @param toId
     * @return
     */
    public MsgGroup getMsgGroupByUser(Long oneUserId,Long twoUserId);
    
    
    /**
     * (B端)发送信息
     * @param type
     * @param fromId
     * @param toId
     * @param content
     */
    public void sendMessage(Integer type,Long fromId,Long toId,String content);
    
    
    /**
     * (c端)发送信息
     * @param type
     * @param fromId
     * @param toId
     * @param content
     */
    public void sendCMessage(Integer type,Long fromId,Long toId,String content);
    
    
    /**
     * (B端)发送提问消息
     * @param questionId
     * @param userId
     * @param content
     */
    public void sendMessageForAsk(Long questionId,Long userId,String content);
    
    
    /**
     * (B端)修改个性签名
     * @param userId
     * @param signature
     */
    public void updateUserSignature(Long userId,String signature);
    
    /**
     * 查询问题回答总数
     * @param questionId
     * @param userId
     * @return
     */
    public Integer queryAnswerCount(Long questionId,Long userId);
    
    
    /**
     * (c端)查询消息组
     * @param param
     * @return
     */
    public GroupMessageListResponseDto getGroupMessageListResponseDto(RequestDto param, PageBounds pageBounds);
    
    
    /**
     * (c端)发送信息
     * @param type
     * @param fromId
     * @param toId
     * @param content
     */
    public void sendUserMessage(Integer type,Long fromId,Long toId,String content);
    
	/**
	 * (c端）删除消息组信息
	 * @param groupId
	 * @return
	 */
    public int deleteGroupMessageById(Long groupId);
    
	/**
	 * (c端）删除消息信息
	 * @param id
	 * @return
	 */
    public int deleteMessageById(Long id);
}
