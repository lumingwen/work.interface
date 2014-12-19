/**
 * 
 */
package cn.com.ubing.ask.dto;

import java.util.List;

import cn.com.ubing.ask.dto.content.AnswerDetailContent;
import cn.com.ubing.common.dto.ResponseDto;

/**
 * 问题回答列表
 * @author zhangxujun
 * 
 *
 */
public class AnswerListResponseDto extends ResponseDto {
    
    /**
     * 回答列表
     */
    private List<AnswerDetailContent> answerList;
    
    /**
     * 当前页
     */
    private String pageNow;
    
    /**
     * 总页数
     */
    private String totalPages;
    
    /**
     * 总条数
     */
    private String totalCount;

    public List<AnswerDetailContent> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<AnswerDetailContent> answerList) {
        this.answerList = answerList;
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
