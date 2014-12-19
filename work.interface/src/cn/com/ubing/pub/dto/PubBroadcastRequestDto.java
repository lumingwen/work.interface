package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 播报请求
 *  
 * @author 邱全松 2014-10-16 上午11:21:20
 */
public class PubBroadcastRequestDto extends RequestDto{
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
