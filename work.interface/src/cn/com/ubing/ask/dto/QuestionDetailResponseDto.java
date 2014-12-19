/**
 * 
 */
package cn.com.ubing.ask.dto;

import cn.com.ubing.ask.dto.content.QuestionDetailContent;
import cn.com.ubing.common.dto.ResponseDto;

/**
 * 提问详情
 * @author zhangxujun
 * 
 *
 */
public class QuestionDetailResponseDto extends ResponseDto {
   
    
    /**
     * 问题详情
     */
    private QuestionDetailContent question;

    public QuestionDetailContent getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDetailContent question) {
        this.question = question;
    }
    
    

}
