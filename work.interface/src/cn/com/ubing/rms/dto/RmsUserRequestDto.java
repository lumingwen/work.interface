/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * (B端)菜单
 * 
 * @author lumingwen
 * 
 * 
 */
public class RmsUserRequestDto extends RequestDto {

	/**
	 * 用户id
	 */
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
