/**
 * 
 */
package cn.com.ubing.ask.dto;

import java.util.List;

import cn.com.ubing.ask.dto.content.QuestionDetailContent;
import cn.com.ubing.common.dto.ResponseDto;

/**
 * 
 * 提问列表响应dto
 * @author zhangxujun
 * 
 *
 */
public class QuestionListResponseDto extends ResponseDto {
    
    
    /**
     * 提问列表
     */
    private List<QuestionDetailContent> questionList;
    
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

    public List<QuestionDetailContent> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionDetailContent> questionList) {
        this.questionList = questionList;
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
