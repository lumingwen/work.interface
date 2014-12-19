package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class PubOrdersListRequestDto extends RequestDto{
    private String status;//订单状态0:未支付,1:已支付
    private String limit;
    private String page;

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
    
}
