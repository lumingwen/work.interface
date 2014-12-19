/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 用户登录响应包
 * @author zhangxujun
 * 
 *
 */
public class UserLoginResponseDto extends ResponseDto {
    
    /**
     * 用户名
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    
}
