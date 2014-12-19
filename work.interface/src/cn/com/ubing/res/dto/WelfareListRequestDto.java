package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

public class WelfareListRequestDto extends RequestDto{
    private String limit;// 每页显示条数
    private String page;// 当前第几页
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
