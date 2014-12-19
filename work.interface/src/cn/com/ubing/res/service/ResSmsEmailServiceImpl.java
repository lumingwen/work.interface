/**
 * 
 */
package cn.com.ubing.res.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.res.dao.ResSmsEmailMapper;
import cn.com.ubing.res.model.ResSmsEmail;
import cn.com.ubing.rms.dto.GetCodeRequestDto;
import cn.com.ubing.rms.dto.ScodeDto;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.sms.SmsSendStatus;
import com.hlvtech.ubing.common.sms.SmsSendUtils;

/**
 * 邮件/短信
 * 
 * @author lumingwen
 * 
 * 
 */
@Service("resSmsEmailService")
public class ResSmsEmailServiceImpl implements ResSmsEmailServiceI {

	/**
	 * dao
	 */
	@Autowired
	private ResSmsEmailMapper resSmsEmailMapper;

	/**
	 * 发送短信
	 * 
	 * @author Administrator 2014年6月24日 上午11:35:07
	 * @param rs
	 */
	public void sendSms(ResSmsEmail rs) {
	    SmsSendStatus s = SmsSendUtils.sendSms(rs.getSmsMobileNumber(), rs.getSmsContent());
	    if(s.isSuccess()){
	        rs.setStatus(2);
	        resSmsEmailMapper.insert(rs);
	    }else{
	        System.out.println(s.getMessage());
	    }
	};

	// @Override
	// public void sendSms(Integer businessType, String mobileNumber,
	// String content) {
	// ResSmsEmail r = new ResSmsEmail();
	// r.setCreateTime(new Date());
	// r.setUpdateTime(r.getCreateTime());
	// r.setDeleteFlag(Constants.DEL_FLAG_NO);
	// r.setType(Constants.EMAIL_AND_SMS_OF_SMS);
	// r.setBusinessType(businessType);
	// r.setSmsMobileNumber(mobileNumber);
	// r.setSmsContent(content);
	// r.setMaxRetryCount(3);
	// r.setRetryCount(0);
	// r.setPriority(0);
	// r.setStatus(0);
	// resSmsEmailMapper.insert(r);
	// }

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
	@Override
	public void sendEmail(Integer businessType, String email, String title,
			String content) {
		ResSmsEmail r = new ResSmsEmail();
		r.setCreateTime(new Date());
		r.setUpdateTime(r.getCreateTime());
		r.setDeleteFlag(Constants.DEL_FLAG_NO);
		r.setType(Constants.EMAIL_AND_SMS_OF_EMAIL);
		r.setBusinessType(businessType);
		r.setEmailTitle(email);
		r.setEmailTitle(title);
		r.setEmailContent(content);
		r.setMaxRetryCount(3);
		r.setRetryCount(0);
		r.setPriority(0);
		r.setStatus(0);
		resSmsEmailMapper.insert(r);
	}

	/**
	 * 同一手机号码，当天短信最大发送量
	 * 
	 * @param tel
	 *            手号码
	 */
	@Override
	public int checkSendNumber(String tel) {
		return resSmsEmailMapper.checkSendNumber(tel);
	}

	/**
	 * 同一设备，当天短信最大发送量
	 * 
	 * @param deviceId
	 *            设备号
	 */
	@Override
	public int checkDeviceSendNumber(String deviceId) {
		return resSmsEmailMapper.checkDeviceSendNumber(deviceId);
	}

	/**
	 * 获取当前手机号，上次发送验证码的时间
	 * 
	 * @author Administrator 2014年6月24日 下午1:11:22
	 * @param tel
	 *            手号码
	 * @param deviceid
	 *            设备号
	 * @return
	 */
	public ScodeDto getLastTime(GetCodeRequestDto param) {
		return resSmsEmailMapper.getLastTime(param);

	};

}
