/**
 * 
 */
package cn.com.ubing.msg.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 消息详细请求dto
 * @author zhangxujun
 * 
 *
 */
public class MessageRequestDto extends RequestDto {

    /**
     * 消息组id
     */
    private String groupId;
    
    /**
     * 消息类型
     */
    private String type;
    private String limit;
    private String page;

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
