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
public class ChagePasswordRequestCDto extends RequestDto {

	/**
	 * 手机号码
	 */
	private String tel;

	/**
	 * 旧密码
	 */
	private String oldPassword;

	/**
	 * 密码
	 */
	private String newPaword;

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPaword() {
		return newPaword;
	}

	public void setNewPaword(String newPaword) {
		this.newPaword = newPaword;
	}

	
}
