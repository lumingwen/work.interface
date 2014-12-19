/**
 * 
 */
package cn.com.ubing.msg.dto;

/**
 * 消息组dto
 * @author zhangxujun
 * 
 *
 */
public class MessageGroupDto {
    
    /**
     * 发送人id
     */
    private String fromId;
    
    /**
     * 头像地址
     */
    private String imageAttahcment;
    
    /**
     * 发送人姓名
     */
    private String fromName;
    
    /**
     * 最新消息内容
     */
    private String content;
    
    /**
     * 未读消息总数
     */
    private String unReadCount;
    
    /**
     * 消息组id
     */
    private String groupId;
    
    /**
     * 类型
     */
    private String type;
    
    /**
     * 发送时间
     */
    private String sendTime;

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getImageAttahcment() {
        return imageAttahcment;
    }

    public void setImageAttahcment(String imageAttahcment) {
        this.imageAttahcment = imageAttahcment;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUnReadCount() {
        return unReadCount;
    }

    public void setUnReadCount(String unReadCount) {
        this.unReadCount = unReadCount;
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

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
    

}
