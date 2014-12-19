package cn.com.ubing.pub.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PubPlanUtils {
    /**
     * 取得微信端查看需求详情的跳转地址
     * 
     */
    public static String getWeixinViewRequirementUrl(String appId, String weixinRedirectUrl, Integer requirementType, Long requirementId) {
        String url = "";
        try {
            url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId + "&redirect_uri="
                    + URLEncoder.encode(weixinRedirectUrl, "utf-8") + "&response_type=code&scope=snsapi_base&state=8A" + requirementType
                    + "B" + requirementId + "#wechat_redirect";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }
}
