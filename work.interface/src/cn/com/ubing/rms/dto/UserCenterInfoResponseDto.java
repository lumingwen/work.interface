/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.rms.model.RmsUser;

/**
 * 个人中心响应包
 * 
 * @author lumingwen
 * 
 * 
 */
public class UserCenterInfoResponseDto{

    
    private String id;
    private String email;
    private String nickname;
    private String photoUrl;

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	
}
