package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;
/**
 * 旅游播报信息获取相应dto
 *  
 * @author 邱全松 2014-7-11 上午10:55:04
 */
public class PubBroadcastResponseDto extends ResponseDto {
    private List<BroadcastDto> broadcastList;
    private String pageNow;// 当前页
    private String totalPages;// 总页数
    private String totalCount;// 总条数

    public List<BroadcastDto> getBroadcastList() {
        return broadcastList;
    }

    public void setBroadcastList(List<BroadcastDto> broadcastList) {
        this.broadcastList = broadcastList;
    }

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
    
    
}
