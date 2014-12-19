/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 用户登录请求头
 * @author zhangxujun
 * 
 *
 */
public class UserLoginRequestDto extends RequestDto {
    
    /**
     * 手机号码
     */
    private String userTel;
    
    /**
     * 密码
     */
    private String userPw;
    /**
     * 信鸽token，用户推送用户信息
     */
    private String xingeToken;

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getXingeToken() {
        return xingeToken;
    }

    public void setXingeToken(String xingeToken) {
        this.xingeToken = xingeToken;
    }

    
    
}
