package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class RequirementListRequest extends RequestDto{
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
