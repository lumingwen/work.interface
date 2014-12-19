/**
 * 
 */
package cn.com.ubing.pub.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import cn.com.ubing.rms.model.RmsUser;



/**
 * 需求提醒
 * @author zhangxujun
 * 
 *
 */
public interface PubRequirementNoticeServiceI {

    
    
    /**
     * 查询有需求时需要告警的人员信息
     * 
     */
    List<RmsUser> listPubRequirementNoticeUser();
    
    /**
     * 发送微信提醒
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     * 
     */
    void sendWxNotice(RmsUser user,String notice) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException;
}
