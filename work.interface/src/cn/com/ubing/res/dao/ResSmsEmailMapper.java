package cn.com.ubing.res.dao;

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
public interface ResSmsEmailMapper {
	int deleteByPrimaryKey(Long id);

	int insert(ResSmsEmail record);

	ResSmsEmail selectByPrimaryKey(Long id);

	int updateByPrimaryKey(ResSmsEmail record);

	/**
	 * 判断用户当天同一手机号最大发送量
	 * 
	 * @author Administrator 2014年6月24日 上午10:41:32
	 * @param tel
	 * @return
	 */
	int checkSendNumber(String tel);

	/**
	 * 同一设备，当天短信最大发送量
	 * 
	 * @author Administrator 2014年6月24日 上午10:55:09
	 * @param deviceId
	 * @return
	 */
	int checkDeviceSendNumber(String deviceId);

	/**
	 * 获取当前手机号，上次发送验证码的时间
	 * 
	 * @author Administrator 2014年6月24日 上午11:21:08
	 * @param tel
	 * @return
	 */
	ScodeDto getLastTime(GetCodeRequestDto param);

}