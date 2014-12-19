/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 获取验证码乡应头
 * 
 * @author lumingwen
 * 
 * 
 */
public class GetCodeResponseDto extends ResponseDto {

	/**
	 * 验证码
	 */
	private String scode;

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

}
