package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class OperationPlanResponseDto extends ResponseDto{
    private String messageGroupId;//用于私信他
    private String fromUserName;//用于私信他

    public String getMessageGroupId() {
        return messageGroupId;
    }

    public void setMessageGroupId(String messageGroupId) {
        this.messageGroupId = messageGroupId;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
    
}
