/**
 * 
 */
package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * B端APP订单详情
 * @author jokiye
 *
 */
public class BPubOrdersDetailsResponseDto extends ResponseDto {
	
	/**
	 * 订单id
	 */
	private String orderId;
	
	/**
	 * 订单标题
	 */
	private String orderTitle;
	
	
	/**
	 * 订单状态(1等待付款    2付款超时    3已付款    4已出行    5已评价    6已完成)
	 */
	private String orderStatus;
	
	/**
	 * 需求类型
	 */
	 private String requirementType;
	 	
	 /**
	  * 需求id
	  */
	private String requirementId;

	/**
	 * 购买者id
	 */
	private String buyUserId;
		
	
	/**
	 * 购买者昵称
	 */
	private String buyUsername;
	
	
	/**
	 * 购买者电话
	 */
	private String buyUserTel;
	
	/**
	 * 购买者头像路径(完整路径,如:http://xxxxxxx)
	 */
	private String buyUserIconUrl;
	
	/**
	 * 消息组id
	 */
	private String chatGroupId;
	
	/**
	 * 需求来源
	 */
	private String source;
	
	/**
	 * 方案id
	 */
	private String planId;
	
	/**
	 * 成人人数
	 */
	private String peopleCount;
	
	/**
	 * 成人价格
	 */
	private String peoplePrice;
	/**
	 * 儿童人数
	 */
	private String childCount;
	/**
	 * 儿童价格
	 */
	private String childPrice;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderTitle() {
		return orderTitle;
	}

	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getBuyUserId() {
		return buyUserId;
	}

	public void setBuyUserId(String buyUserId) {
		this.buyUserId = buyUserId;
	}

	public String getBuyUsername() {
		return buyUsername;
	}

	public void setBuyUsername(String buyUsername) {
		this.buyUsername = buyUsername;
	}

	public String getBuyUserTel() {
		return buyUserTel;
	}

	public void setBuyUserTel(String buyUserTel) {
		this.buyUserTel = buyUserTel;
	}

	public String getBuyUserIconUrl() {
		return buyUserIconUrl;
	}

	public void setBuyUserIconUrl(String buyUserIconUrl) {
		this.buyUserIconUrl = buyUserIconUrl;
	}

	public String getRequirementType() {
		return requirementType;
	}

	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}

	public String getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}

	public String getChatGroupId() {
		return chatGroupId;
	}

	public void setChatGroupId(String chatGroupId) {
		this.chatGroupId = chatGroupId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(String peopleCount) {
		this.peopleCount = peopleCount;
	}

	public String getPeoplePrice() {
		return peoplePrice;
	}

	public void setPeoplePrice(String peoplePrice) {
		this.peoplePrice = peoplePrice;
	}

	public String getChildCount() {
		return childCount;
	}

	public void setChildCount(String childCount) {
		this.childCount = childCount;
	}

	public String getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(String childPrice) {
		this.childPrice = childPrice;
	}

	
	
	
}
