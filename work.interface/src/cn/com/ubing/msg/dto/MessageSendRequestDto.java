/**
 * 
 */
package cn.com.ubing.msg.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 消息发送请求dto
 * @author zhangxujun
 * 
 *
 */
public class MessageSendRequestDto extends RequestDto {
    
    /**
     * 类型
     */
    private String type;
    
    /**
     * 消息组id
     */
    private String groupId;
    
    /**
     * 消息内容
     */
    private String content;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    

}
