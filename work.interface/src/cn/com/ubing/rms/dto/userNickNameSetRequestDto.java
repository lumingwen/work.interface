package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 用户昵称设置请求头
 * @author shili
 *
 */
public class userNickNameSetRequestDto extends RequestDto{

	

	/**
	 * 呢称
	 */
	private String nickName;


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
	
}
