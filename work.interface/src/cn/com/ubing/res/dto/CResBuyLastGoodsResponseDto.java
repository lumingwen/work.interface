package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class CResBuyLastGoodsResponseDto extends ResponseDto{
    private String resultMessage;//返回提示信息
    private String orderId;//订单id

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
}
