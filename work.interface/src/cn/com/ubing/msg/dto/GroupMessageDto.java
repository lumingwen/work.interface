/**
 * 
 */
package cn.com.ubing.msg.dto;

/**
 * 消息组dto
 * @author lumw
 * 
 *
 */
public class GroupMessageDto {
    
    /**
     * 发送人id
     */
    private String partakeUserId;
    
    /**
     * 头像地址
     */
    private String imageAttahcment;
    
    /**
     * 发送人姓名
     */
    private String fromUserName;

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
    


	public String getPartakeUserId() {
		return partakeUserId;
	}

	public void setPartakeUserId(String partakeUserId) {
		this.partakeUserId = partakeUserId;
	}

	public String getImageAttahcment() {
		return imageAttahcment;
	}

	public void setImageAttahcment(String imageAttahcment) {
		this.imageAttahcment = imageAttahcment;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
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
