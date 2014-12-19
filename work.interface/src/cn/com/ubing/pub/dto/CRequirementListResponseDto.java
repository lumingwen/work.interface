package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

public class CRequirementListResponseDto extends ResponseDto{
    private String pageNow;// 当前页
    private String totalPages;// 总页数
    private String totalCount;// 总条数
    private String status;
    private List<CRequirementListDto> requirementList;//需求信息列表
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
    public List<CRequirementListDto> getRequirementList() {
        return requirementList;
    }
    public void setRequirementList(List<CRequirementListDto> requirementList) {
        this.requirementList = requirementList;
    }
}
