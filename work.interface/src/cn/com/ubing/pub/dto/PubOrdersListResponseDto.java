package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

public class PubOrdersListResponseDto extends ResponseDto {
    private String pageNow;// 当前页
    private String totalPages;// 总页数
    private String totalCount;// 总条数
    private List<PubOrdersListDto> ordersList;
    public String getPageNow() {
        return pageNow;
    }
    public void setPageNow(String pageNow) {
        this.pageNow = pageNow;
    }
    public String getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }
    public String getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
    public List<PubOrdersListDto> getOrdersList() {
        return ordersList;
    }
    public void setOrdersList(List<PubOrdersListDto> ordersList) {
        this.ordersList = ordersList;
    }
}
