/**
 * 
 */
package cn.com.ubing.msg.dto;

/**
 * 消息详细dto
 * @author zhangxujun
 * 
 *
 */
public class MessageDto {
    
    /**
     * 发送者id
     */
    private String fromId;
    
    /**
     * 发送者姓名
     */
    private String fromUserName;
    
    /**
     * 发送者头像相对路径
     */
    private String fromImageAttahcment;
    
    /**
     * 接收者id
     */
    private String toId;
    
    /**
     * 接收者姓名
     */
    private String toUserName;
    
    /**
     * 接收者头像相对路径
     */
    private String toImageAttahcment;
    
    /**
     * 发送内容
     */
    private String content;
    
    /**
     * 发送时间
     */
    private String sendTime;

    /**
     * 消息类型
     */
    private String type;

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }



    public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getFromImageAttahcment() {
        return fromImageAttahcment;
    }

    public void setFromImageAttahcment(String fromImageAttahcment) {
        this.fromImageAttahcment = fromImageAttahcment;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getToImageAttahcment() {
        return toImageAttahcment;
    }

    public void setToImageAttahcment(String toImageAttahcment) {
        this.toImageAttahcment = toImageAttahcment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
