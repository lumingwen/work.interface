package cn.com.ubing.pub.dto;

import cn.com.ubing.pub.model.PubRequirementTicket;

/**
 * 机票需求dto
 *  
 */
public class PubRequirementTicketDto extends PubRequirementTicket{
	private String strDepartureTimeDay;//起飞时间
	
	private String strTicketSpace;//机票舱位
	
	private String contactsName;//联系人
	
	private String contactsTel;//联系人电话
	
	private String couponName;//优惠卷
	
	private Integer couponStatus;
	
	private String couponPrice;//优惠卷价格

	public String getStrDepartureTimeDay() {
		return strDepartureTimeDay;
	}

	public void setStrDepartureTimeDay(String strDepartureTimeDay) {
		this.strDepartureTimeDay = strDepartureTimeDay;
	}

	public String getStrTicketSpace() {
		return strTicketSpace;
	}

	public void setStrTicketSpace(String strTicketSpace) {
		this.strTicketSpace = strTicketSpace;
	}

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsTel() {
		return contactsTel;
	}

	public void setContactsTel(String contactsTel) {
		this.contactsTel = contactsTel;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Integer getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(Integer couponStatus) {
		this.couponStatus = couponStatus;
	}

	public String getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(String couponPrice) {
		this.couponPrice = couponPrice;
	}
	
}
