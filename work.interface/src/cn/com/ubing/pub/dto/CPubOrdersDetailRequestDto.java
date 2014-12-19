package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class CPubOrdersDetailRequestDto extends RequestDto {
    private String orderId;// 订单id

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
