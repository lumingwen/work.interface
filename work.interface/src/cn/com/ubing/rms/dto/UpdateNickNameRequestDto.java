package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 修改用户昵称请求dto
 *  
 * @author 邱全松 2014-7-9 下午5:36:25
 */
public class UpdateNickNameRequestDto extends RequestDto{
    private String nickname;//新用户昵称

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
}
