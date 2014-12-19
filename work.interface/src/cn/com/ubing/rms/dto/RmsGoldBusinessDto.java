package cn.com.ubing.rms.dto;

import cn.com.ubing.rms.model.RmsUserTitle;
/*
 * 金牌商家Dto
 */
public class RmsGoldBusinessDto extends RmsUserTitle{
    
	//商家id
	private int goldId;

	//金牌商家名字
	private String goldName;
	
	//金牌商家电话
	private String goldTel;
	
	//金牌商家邮件
	private String goldEmail;
	
	//金牌商家头像
	private String goldRloeId;
	

	public String getGoldName() {
		return goldName;
	}

	public void setGoldName(String goldName) {
		this.goldName = goldName;
	}

	public String getGoldTel() {
		return goldTel;
	}

	public void setGoldTel(String goldTel) {
		this.goldTel = goldTel;
	}

	public String getGoldEmail() {
		return goldEmail;
	}

	public void setGoldEmail(String goldEmail) {
		this.goldEmail = goldEmail;
	}

	public String getGoldRloeId() {
		return goldRloeId;
	}

	public void setGoldRloeId(String goldRloeId) {
		this.goldRloeId = goldRloeId;
	}
	
	public int getGoldId() {
		return goldId;
	}

	public void setGoldId(int goldId) {
		this.goldId = goldId;
	}

	
}
