/**
 * 
 */
package cn.com.ubing.pub.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.res.dao.ResSystemPropertiesMapper;
import cn.com.ubing.res.model.ResSystemProperties;
import cn.com.ubing.rms.dao.RmsUserMapper;
import cn.com.ubing.rms.model.RmsUser;
import cn.com.ubing.weixin.service.WexinInterfaceCallServiceI;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;


/**
 * 需求提醒
 * @author zhangxujun
 * 
 *
 */
@Service("pubRequirementNoticeService")
public class PubRequirementNoticeServiceImpl implements
	PubRequirementNoticeServiceI {
    
    private final Logger log = Logger.getLogger(getClass());

    
    /**
	 * 系统属性dao
	 */
	@Autowired
	private ResSystemPropertiesMapper resSystemPropertiesMapper;
	
	/**
	 * 用户dao
	 */
	@Autowired
	private RmsUserMapper rmsUserMapper;
	
	/**
	 * 微信发送接口
	 */
	@Autowired
	private WexinInterfaceCallServiceI wexinInterfaceCallService;

	
	
	/**
	 * 延迟执行线程池
	 */
	private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);  
	
	/**
	 * 自定义发送消息的线程
	 * 
	 */
	class SendWxMessageThread extends Thread{
	    private WexinInterfaceCallServiceI wexinInterfaceCallService;
	    private RmsUser user;
	    private String notice;
	    private SendWxMessageThread(WexinInterfaceCallServiceI wexinInterfaceCallService,RmsUser user,String notice){
		this.wexinInterfaceCallService = wexinInterfaceCallService;
		this.user = user;
		this.notice = notice;
	    }
	    @Override
	    public void run() {
		try{
			if (user!=null && StringUtils.isNotBlank(user.getWeixinOpenId())){
			    //发送消息
			    wexinInterfaceCallService.sendTextMessage(user.getWeixinOpenId(), notice);
			}
		}catch(Exception e){
		    log.error(e.getMessage(), e);
		}
	    }
	    
	}
    
    
    /**
     * 查询有需求时需要告警的人员信息
     * 
     */
    @Override
    public List<RmsUser> listPubRequirementNoticeUser(){
	List<RmsUser> list = new ArrayList<RmsUser>();
	List<ResSystemProperties> propList = resSystemPropertiesMapper.listByKey(Constants.SYSTEM_PRO_NEW_REQUIREMENT_WEIXIN_NOTICE_USER_ID);
	if (CollectionUtils.isNotEmpty(propList)){
	    for (ResSystemProperties prop:propList){
		Long userId = CommonUtils.parseLong(prop.getPropValue());
		if (userId != null){
		    RmsUser user = rmsUserMapper.selectByPrimaryKey(userId);
		    if (user != null){
			list.add(user);
		    }
		}
	    }
	}
	return list;
    }
    
    
    
    /**
     * 发送微信提醒
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     * 
     */
    @Override
    public void sendWxNotice(RmsUser user,String notice) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException{
	if (user!=null && StringUtils.isNotBlank(user.getWeixinOpenId())){
        	wexinInterfaceCallService.getWxAccessToken();
        	SendWxMessageThread st = new SendWxMessageThread(wexinInterfaceCallService, user, notice);
        	executor.schedule(st, 1000+new Random().nextInt(500), TimeUnit.MILLISECONDS);
	}
    }

}
