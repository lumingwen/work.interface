package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 用户邮箱设置请求头
 * @author shili
 *
 */
public class userEmailSetRequestDto extends RequestDto{

	

	/**
	 * 邮箱
	 */
	private String email;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
}
