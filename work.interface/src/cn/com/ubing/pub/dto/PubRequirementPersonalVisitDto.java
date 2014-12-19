package cn.com.ubing.pub.dto;


import cn.com.ubing.pub.model.PubRequirementPersonalVisit;

/**
 * 自由行需求dto
 *  
 */
public class PubRequirementPersonalVisitDto extends PubRequirementPersonalVisit{
	
	private String contactsName;//联系人
	
	private String contactsTel;//联系人电话
	
	private String couponName;//优惠卷
	
	private String couponPrice;//优惠卷价格
	
	private Integer couponStatus;
	
	
    private String themName;//名称
	     
	private String themIcon;//图标地址
	    
	private String transportationStr;
	private String hotelLevelStr;


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

	public String getThemName() {
		return themName;
	}

	public void setThemName(String themName) {
		this.themName = themName;
	}

	public String getThemIcon() {
		return themIcon;
	}

	public void setThemIcon(String themIcon) {
		this.themIcon = themIcon;
	}


	public String getTransportationStr() {
		return transportationStr;
	}

	public void setTransportationStr(String transportationStr) {
		this.transportationStr = transportationStr;
	}

	public String getHotelLevelStr() {
		return hotelLevelStr;
	}

	public void setHotelLevelStr(String hotelLevelStr) {
		this.hotelLevelStr = hotelLevelStr;
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
