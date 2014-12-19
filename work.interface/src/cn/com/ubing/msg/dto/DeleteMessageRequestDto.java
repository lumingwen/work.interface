package cn.com.ubing.msg.dto;

import cn.com.ubing.common.dto.RequestDto;

public class DeleteMessageRequestDto extends RequestDto {
private String id;//id组id 或则消息id
private String type;//类型 1表示删除组消息 2表示删除一条消息
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
}
