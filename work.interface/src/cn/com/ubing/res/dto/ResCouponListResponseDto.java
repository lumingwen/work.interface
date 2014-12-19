package cn.com.ubing.res.dto;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.ResponseDto;

public class ResCouponListResponseDto extends ResponseDto{
    private String pageNow;// 当前页
    private String totalPages;// 总页数
    private String totalCount;// 总条数
    private PageList<ResCouponListDto> resCouponList;

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

    public PageList<ResCouponListDto> getResCouponList() {
        return resCouponList;
    }

    public void setResCouponList(PageList<ResCouponListDto> resCouponList) {
        this.resCouponList = resCouponList;
    }
    
}
