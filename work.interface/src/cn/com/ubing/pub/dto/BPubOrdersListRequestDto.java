package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class BPubOrdersListRequestDto extends RequestDto {
    private String status;// 订单状态
    private String limit;
    private String page;
    private Long orderId;//订单id
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
    
}