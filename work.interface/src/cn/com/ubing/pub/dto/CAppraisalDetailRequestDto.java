package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class CAppraisalDetailRequestDto extends RequestDto {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
