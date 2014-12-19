/**
 * 
 */
package cn.com.ubing.ask.dto;

import cn.com.ubing.ask.dto.content.AnswerDetailContent;
import cn.com.ubing.common.dto.ResponseDto;

/**
 * 回答详情
 * @author zhangxujun
 * 
 *
 */
public class AnswerDetailResponseDto extends ResponseDto {
    

    /**
     * 回答详情
     */
    private AnswerDetailContent answer;

    public AnswerDetailContent getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerDetailContent answer) {
        this.answer = answer;
    }
    
    
}
