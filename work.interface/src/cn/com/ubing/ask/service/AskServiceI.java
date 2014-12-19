/**
 * 
 */
package cn.com.ubing.ask.service;

import cn.com.ubing.ask.dto.AnswerAppraiseRequestDto;
import cn.com.ubing.ask.dto.AnswerDetailRequestDto;
import cn.com.ubing.ask.dto.AnswerListRequestDto;
import cn.com.ubing.ask.dto.QuestionListRequestDto;
import cn.com.ubing.ask.dto.QuestionSubmitRequestDto;
import cn.com.ubing.ask.dto.content.AnswerDetailContent;
import cn.com.ubing.ask.dto.content.QuestionDetailContent;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 旅行问答service
 * @author zhangxujun
 * 
 *
 */
public interface AskServiceI {
    
    
    
    /**
     * 查询提问列表
     * 
     */
    PageList<QuestionDetailContent> listQuestionContent(QuestionListRequestDto param);

    
    /**
     * 提交提问,返回问题推送数量
     * 
     */
    Integer submitQuestion(QuestionSubmitRequestDto param);
    
    
    /**
     * 查看需求详情
     * 
     */
    QuestionDetailContent getQuestionContent(Long id);
    
    
    
    /**
     * 查询回答列表
     * 
     */
    PageList<AnswerDetailContent> listAnswerContent(AnswerListRequestDto param);
    
    /**
     * 查询回答详情
     */
    AnswerDetailContent getAnswerContent(AnswerDetailRequestDto param);
    
    
    /**
     * 评价回答
     */
    void answerAppraise(AnswerAppraiseRequestDto param);
}
