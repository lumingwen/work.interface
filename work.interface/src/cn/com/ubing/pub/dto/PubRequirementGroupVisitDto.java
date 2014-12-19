package cn.com.ubing.pub.dto;

import cn.com.ubing.pub.model.PubRequirementGroupVisit;

/**
 * 更团型需求dto
 *  
 */
public class PubRequirementGroupVisitDto extends PubRequirementGroupVisit{
	
	private String contactsName;//联系人
	
	private String contactsTel;//联系人电话
	
	private String couponName;//优惠卷
	
	private Integer couponStatus;
	
	private String couponPrice;//优惠卷价格

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
