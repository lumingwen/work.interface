package cn.com.ubing.res.model;

import java.util.Date;

/**
 * 邮件/短信
 * 
 * @author lumingwen
 * 
 * 
 */
public class ResSmsEmail {
	private Long id;

	/*
	 * 创建时间
	 */
	private Date createTime;

	/*
	 * 更新时间
	 */
	private Date updateTime;

	/*
	 * 删除标记
	 */

	private Integer deleteFlag;

	/*
	 * 类型,1:短信,2:邮件
	 */

	private Integer type;

	/*
	 * 业务类型,1:注册,2:找回密码,3:系统通知
	 */

	private Integer businessType;
	/*
	 * 短信手机号码
	 */
	private String smsMobileNumber;

	/*
	 * 短信内容
	 */

	private String smsContent;

	/*
	 * 邮件地址
	 */

	private String emailAddress;

	/*
	 * 邮件标题
	 */

	private String emailTitle;

	/*
	 * 邮件内容
	 */

	private String emailContent;

	/*
	 * 状态,1:未处理,2:成功,3:失败
	 */

	private Integer status;

	/*
	 * 已重试次数
	 */

	private Integer retryCount;

	/*
	 * 最大重试次数
	 */

	private Integer maxRetryCount;

	/*
	 * 优先级,数字越大越高
	 */

	private Integer priority;

	/*
	 * 备注
	 */

	private String remark;

	/*
	 * 终端设备号(设备唯一编号)
	 */

	private String deviceId;

	/*
	 * 验证码
	 */

	private String scode;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getScode() {
		return scode;
	}

	public void setScode(String scode) {
		this.scode = scode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSmsMobileNumber() {
		return smsMobileNumber;
	}

	public void setSmsMobileNumber(String smsMobileNumber) {
		this.smsMobileNumber = smsMobileNumber == null ? null : smsMobileNumber
				.trim();
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent == null ? null : smsContent.trim();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress == null ? null : emailAddress.trim();
	}

	public String getEmailTitle() {
		return emailTitle;
	}

	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle == null ? null : emailTitle.trim();
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent == null ? null : emailContent.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}

	public Integer getMaxRetryCount() {
		return maxRetryCount;
	}

	public void setMaxRetryCount(Integer maxRetryCount) {
		this.maxRetryCount = maxRetryCount;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getBusinessType() {
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

}