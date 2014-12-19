package cn.com.ubing.rms.dto;

import java.util.Date;

import cn.com.ubing.res.model.ResSmsEmail;

/**
 * 最新时间和验证码获得Dto
 * 
 * @author lumingwen
 * 
 * 
 */
public class ScodeDto extends ResSmsEmail {
	/**
	 * 上一次同一手机号或者同一设备发送的时间
	 */
	private Date oldSendTime;

	public Date getOldSendTime() {
		return oldSendTime;
	}

	public void setOldSendTime(Date oldSendTime) {
		this.oldSendTime = oldSendTime;
	}

}
