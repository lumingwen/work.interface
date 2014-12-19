/**
 * 
 */
package cn.com.ubing.res.service;

import cn.com.ubing.res.model.ResSmsEmail;
import cn.com.ubing.rms.dto.GetCodeRequestDto;
import cn.com.ubing.rms.dto.ScodeDto;

/**
 * 邮件/短信
 * 
 * @author lumingwen
 * 
 * 
 */
public interface ResSmsEmailServiceI {

	/**
	 * 发送短信
	 * 
	 * @author Administrator 2014年6月24日 上午11:35:07
	 * @param rs
	 */
	void sendSms(ResSmsEmail rs);

	/**
	 * 发送邮件
	 * 
	 * @param businessType
	 *            业务类型,参考常量类Constants
	 * @param email
	 *            邮件地址
	 * @param title
	 *            邮件标题
	 * @param content
	 *            邮件内容
	 */
	void sendEmail(Integer businessType, String email, String title,
			String content);

	/**
	 * 同一手机号码，当天短信最大发送量
	 * 
	 * @param tel
	 *            手号码
	 */
	int checkSendNumber(String tel);

	/**
	 * 同一设备，当天短信最大发送量
	 * 
	 * @param deviceId
	 *            设备号
	 */
	int checkDeviceSendNumber(String deviceId);

	/**
	 * 获取当前手机号，上次发送验证码的时间
	 * 
	 * @author Administrator 2014年6月24日 下午1:11:22
	 * @param tel
	 * @param deviceid
	 * @return
	 */
	ScodeDto getLastTime(GetCodeRequestDto param);
}
