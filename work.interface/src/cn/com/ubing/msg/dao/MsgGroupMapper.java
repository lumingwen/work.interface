package cn.com.ubing.msg.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.msg.dto.GroupMessageDto;
import cn.com.ubing.msg.dto.MessageDto;
import cn.com.ubing.msg.dto.MessageGroupDto;
import cn.com.ubing.msg.dto.MessageRequestDto;
import cn.com.ubing.msg.model.MsgGroup;

/**
 * 消息组
 * @author zhangxujun
 * 
 *
 */
public interface MsgGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MsgGroup record);

    MsgGroup selectByPrimaryKey(Long id);
    /**
     * 根据fromId和toId获取消息组id
     * 
     * @author 邱全松 2014-11-5 下午2:18:28
     * @param record
     * @return
     */
    MsgGroup selectGroupId(MsgGroup record);
    /**
     * 根据用户id查询消息组
     * 
     * @author 邱全松 2014-9-26 下午4:10:21
     * @param id
     * @return
     */
    MsgGroup selectByUserId(MsgGroup record);

    int updateByPrimaryKey(MsgGroup record);
    
    /**
     * 查询消息组
     * @param param
     * @return
     */
    public PageList<MessageGroupDto> listMessageGroupDto(RequestDto param, PageBounds pageBounds);
    
    
    
    /**
     * 根据消息组查询消息内容
     * @param param
     * @return
     */
    public PageList<MessageDto> listMessageDetail(MessageRequestDto param, PageBounds pageBounds);
    
    
    /**
     * 根据提问id获得提问及解答内容
     * @param param
     * @return
     */
    public PageList<MessageDto> listMessageDetailForAsk(MessageRequestDto param, PageBounds pageBounds);
    
    /**
     * 查询问题回答总数
     * @param questionId
     * @param userId
     * @return
     */
    public Integer queryAnswerCount(Long questionId,Long userId);
    
    
    /**
     * 查询消息组
     * @param record
     * @return
     */
    List<MsgGroup> listMsgGroup(MsgGroup record);
    
    
    
    /**
     * c(端)查询消息组
     * @param param
     * @return
     */
    public PageList<GroupMessageDto> listGroupMessageDto(RequestDto param, PageBounds pageBounds);
}