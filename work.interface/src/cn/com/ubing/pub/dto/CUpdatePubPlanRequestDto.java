package cn.com.ubing.pub.dto;

import java.util.Date;

import cn.com.ubing.common.dto.RequestDto;




/**
 * 方案详细
 * @author Administrator
 *
 */
public class CUpdatePubPlanRequestDto extends RequestDto {
  private String id;
  private String status;
  private Date updateTime;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(Date updateTime) {
	this.updateTime = updateTime;
}
  
}
