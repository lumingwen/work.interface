/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 头像中心响应包
 * 
 * @author lumingwen
 * 
 * 
 */
public class UserSetPhotoResponseDto extends ResponseDto {
	
    
    private String photoUrl;

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}
