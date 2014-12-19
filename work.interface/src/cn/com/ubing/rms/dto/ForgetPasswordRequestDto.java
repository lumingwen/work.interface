/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 忘记密码请求包头
 * 
 * @author lumingwen
 * 
 * 
 */
public class ForgetPasswordRequestDto extends RequestDto {

	/**
	 * 手机号码
	 */
	private String userTel;

	/**
	 * 验证码
	 */
	private String scode;

	/**
	 * 类型
	 */
	private String type;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 密码
	 */
	private String nextPassword;

	public String getNextPassword() {
		return nextPassword;
	}

	public void setNextPassword(String nextPassword) {
		this.nextPassword = nextPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

}
