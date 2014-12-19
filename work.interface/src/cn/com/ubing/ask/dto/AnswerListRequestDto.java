/**
 * 
 */
package cn.com.ubing.ask.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 问题回答列表
 * @author zhangxujun
 * 
 *
 */
public class AnswerListRequestDto extends RequestDto {
    
    /**
     * 提问id
     */
    private String questionId;
    
    /**
     * 每页显示条数
     */
    private String limit;
    
    /**
     * 当前第几页
     */
    private String page;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
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
