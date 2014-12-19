/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 个人中心响应包
 * 
 * @author lumingwen
 * 
 * 
 */
public class UserCenterResponseDto extends ResponseDto {
	
    /**
     * 用户名
     */
    private String nickname;
    
    private String email;
    
    private String expiredCoupons;
    
    private String returnMoney;
    
    private String bidNumber;
    
    private String photoUrl;
    
    private String orderNumber;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getExpiredCoupons() {
		return expiredCoupons;
	}

	public void setExpiredCoupons(String expiredCoupons) {
		this.expiredCoupons = expiredCoupons;
	}

	public String getReturnMoney() {
		return returnMoney;
	}

	public void setReturnMoney(String returnMoney) {
		this.returnMoney = returnMoney;
	}

	public String getBidNumber() {
		return bidNumber;
	}

	public void setBidNumber(String bidNumber) {
		this.bidNumber = bidNumber;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
