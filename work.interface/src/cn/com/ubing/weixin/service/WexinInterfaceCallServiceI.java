/**
 * 
 */
package cn.com.ubing.weixin.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

import cn.com.ubing.common.dto.WXResponseDto;
import cn.com.ubing.weixin.bean.resBean.Article;


/**
 * 
 * 微信接口调用service
 * @author zhangxujun
 * 
 *
 */
public interface WexinInterfaceCallServiceI {
    
    String getWxAccessToken();
    
  
    
    /**
     * 发送文本消息
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     * 
     */
    public WXResponseDto sendTextMessage(String openId, String message) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException;
   
    
    /**
     * 发送图文消息
     * 
     */
    public WXResponseDto sendImageTextMessage(String openId, List<Article> list);
    
}
