/**
 * 
 */
package cn.com.ubing.weixin.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.ubing.common.dto.WXResponseDto;
import cn.com.ubing.common.utils.DateHelper;
import cn.com.ubing.res.dao.ResSystemPropertiesMapper;
import cn.com.ubing.res.dao.ResWxAccessTokenMapper;
import cn.com.ubing.res.model.ResSystemProperties;
import cn.com.ubing.res.model.ResWxAccessToken;
import cn.com.ubing.weixin.bean.AccessToken;
import cn.com.ubing.weixin.bean.resBean.Article;
import cn.com.ubing.weixin.util.MyX509TrustManager;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.sms.SmsSendUtils;

/**
 * 微信接口调用service
 * 
 * @author zhangxujun
 * 
 * 
 */
@Service("wexinInterfaceCallService")
public class WexinInterfaceCallServiceImpl implements WexinInterfaceCallServiceI {
 // 获取access_token的接口地址（GET） 限200（次/天）
    private final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    @Autowired
    private ResWxAccessTokenMapper resWxAccessTokenMapper;
    @Autowired
    private ResSystemPropertiesMapper resSystemPropertiesMapper;
    
    /**
     * 微信参数
     */
    @Value(value = "${appSecret}")
    private String appSecret;
    
    /**
     * 微信参数
     */
    @Value(value = "${appId}")
    private String appId;
    
    /**
     * 发送文本消息
     * @throws IOException 
     * @throws NoSuchProviderException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     * 
     */
    @Override
    public WXResponseDto sendTextMessage(String openId, String message) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException{
	WXResponseDto dto = new WXResponseDto();
	
	    String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="
			+ getWxAccessToken();

		StringBuffer content = new StringBuffer();
		content.append("{\"touser\":\"");
		content.append(openId);
		content.append("\",\"msgtype\":\"text\",");
		content.append("\"text\":{\"content\":\"");
		content.append(getRealStr(message));
		content.append("\"}}");

		
		JSONObject jsonObject = httpRequest(url, "POST",
			content.toString());
		String errcode = String.valueOf(jsonObject.get("errcode"));
		if ("0".equals(errcode)){
		    dto.setSuccess(true);
		    dto.setMessage(String.valueOf(jsonObject.get("errmsg")));
		}else{
		    dto.setSuccess(false);
		    dto.setMessage(String.valueOf(jsonObject.get("errmsg")));
		}
	
	return dto;
    }
    
    
    
    
    @Override
    public WXResponseDto sendImageTextMessage(String openId, List<Article> list) {
        WXResponseDto dto = new WXResponseDto();
        try {
            String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + getWxAccessToken();

            StringBuffer content = new StringBuffer();
            content.append("{\"touser\":\"");
            content.append(openId);
            content.append("\",\"msgtype\":\"news\",");
            content.append("\"news\":{\"articles\":[");
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    Article at = list.get(i);
                    if (i > 0) {
                        content.append(",");
                    }
                    content.append("{\"title\":\"").append(getRealStr(at.getTitle())).append("\",");
                    content.append("\"description\":\"").append(getRealStr(at.getDescription())).append("\",");
                    content.append("\"url\":\"").append(getRealStr(at.getUrl())).append("\",");
                    content.append("\"picurl\":\"").append(getRealStr(at.getPicUrl())).append("\"}");
                }
            }
            content.append("]}}");

            JSONObject jsonObject = httpRequest(url, "POST", content.toString());
            String errcode = String.valueOf(jsonObject.get("errcode"));
            if ("0".equals(errcode)) {
                dto.setSuccess(true);
                dto.setMessage(String.valueOf(jsonObject.get("errmsg")));
            } else {
                dto.setSuccess(false);
                dto.setMessage(String.valueOf(jsonObject.get("errmsg")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            dto.setSuccess(false);
            dto.setMessage(e.getMessage());
        }
        return dto;
    }

    /**
     * 获得微信accessToken
     * 
     */
    @Override
    public String getWxAccessToken() {
        try {
            ResWxAccessToken resToken = resWxAccessTokenMapper.getByAppIdAndSecret(appId, appSecret, new Date());
            if (resToken == null) {
                AccessToken token = null;
                String requestUrl = access_token_url.replace("APPID", appId).replace("APPSECRET", appSecret);
                JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
                // 如果请求成功
                if (null != jsonObject) {
                    try {
                        token = new AccessToken();
                        token.setToken(jsonObject.getString("access_token"));
                        token.setExpiresIn(jsonObject.getInt("expires_in"));
                    } catch (JSONException e) {
                        token = null;
                        // 获取token失败
                        System.out
                                .println("获取token失败 errcode:{} errmsg:{}" + jsonObject.getInt("errcode") + jsonObject.getString("errmsg"));
                    }
                }
                if (token != null) {
                    resToken = new ResWxAccessToken();
                    resToken.setCreateTime(new Date());
                    resToken.setUpdateTime(new Date());
                    resToken.setDeleteFlag(Constants.DEL_FLAG_NO);
                    resToken.setAppId(appId);
                    resToken.setAppSecret(appSecret);
                    resToken.setAccessToken(token.getToken());
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date());
                    c.add(Calendar.SECOND, token.getExpiresIn());
                    resToken.setExpireTime(c.getTime());
                    resWxAccessTokenMapper.insert(resToken);
                } else {
                    List<ResSystemProperties> alertList = resSystemPropertiesMapper
                            .listByKey(Constants.SYSTEM_PRO_WEIXIN_INTERFACE_ALTER_MOBILE);
                    if (CollectionUtils.isNotEmpty(alertList)) {
                        for (ResSystemProperties pro : alertList) {
                            SmsSendUtils.sendSms(pro.getPropValue(), "现在时间:" + DateHelper.formatDateTime(new Date())
                                    + ",服务器异常,获取AccessToken失败");
                        }
                    }
                }
            }
            return resToken.getAccessToken();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 字符串处理
     * 
     * @param s
     * @return
     */
    private String getRealStr(String s) {
        if (s == null) {
            return "";
        }
        return s.trim().replaceAll("\"", "“");
    }

    private JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        System.setProperty("https.protocols", "SSLv3,SSLv2Hello");
        System.setProperty("jsse.enableSNIExtension", "false");
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            System.out.println("Weixin server connection timed out.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("https request error:{}");
        }
        return jsonObject;
    }

}
