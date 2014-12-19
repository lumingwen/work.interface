/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 获取验证码请求头
 * 
 * @author lumingwen
 * 
 * 
 */
public class GetCodeRequestDto extends RequestDto {

	/**
	 * 手机号码
	 */
	private String userTel;

	/**
	 * 业务类型,1:注册,2:找回密码,3:系统通知
	 */
	private String type;

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

}
