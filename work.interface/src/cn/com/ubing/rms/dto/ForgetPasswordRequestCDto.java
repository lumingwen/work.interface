/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 忘记密码请求包头(c端)
 * 
 * @author lumingwen
 * 
 * 
 */
public class ForgetPasswordRequestCDto extends RequestDto {

	/**
	 * 手机号码
	 */
	private String userTel;

	/**
	 * 验证码
	 */
	private String scode;


	/**
	 * 密码
	 */
	private String password;


	public String getUserTel() {
		return userTel;
	}


	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}


	public String getScode() {
		return scode;
	}


	public void setScode(String scode) {
		this.scode = scode;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


}
