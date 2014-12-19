/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 用户注册请求头
 * 
 * @author lumingwen
 * 
 * 
 */
public class userNewRequestDto extends RequestDto {

	/**
	 * 手机号码
	 */
	private String userTel;

	/**
	 * 验证码
	 */
	private String scode;

	/**
	 * 呢称
	 */
	private String nickName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 经营类型
	 */
	private String businessTypes;

	/**
	 * 主营线路id
	 */
	private String lineIds;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 身份证号码
	 */

	private String idNumber;

	/**
	 * 照片上传id
	 */
	private String photoId;

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBusinessTypes() {
		return businessTypes;
	}

	public void setBusinessTypes(String businessTypes) {
		this.businessTypes = businessTypes;
	}

	public String getLineIds() {
		return lineIds;
	}

	public void setLineIds(String lineIds) {
		this.lineIds = lineIds;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

}
