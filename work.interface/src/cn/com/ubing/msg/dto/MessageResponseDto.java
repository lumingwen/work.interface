/**
 * 
 */
package cn.com.ubing.msg.dto;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 消息详细响应dto
 * @author zhangxujun
 * 
 *
 */
public class MessageResponseDto extends ResponseDto {
    
    /**
     * 消息内容
     */
    private PageList<MessageDto> messageList;

    public PageList<MessageDto> getMessageList() {
        return messageList;
    }

    public void setMessageList(PageList<MessageDto> messageList) {
        this.messageList = messageList;
    }
    
}
