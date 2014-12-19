package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class CRequirementListRequestDto extends RequestDto{
    private String limit;// 每页显示条数
    private String page;// 当前第几页
    private String status;//1招标中 2已采纳 3已结束
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
