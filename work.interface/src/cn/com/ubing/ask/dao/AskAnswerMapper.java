package cn.com.ubing.ask.dao;

import cn.com.ubing.ask.dto.AnswerDetailRequestDto;
import cn.com.ubing.ask.dto.AnswerListRequestDto;
import cn.com.ubing.ask.dto.content.AnswerDetailContent;
import cn.com.ubing.ask.model.AskAnswer;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 问题回答
 * @author zhangxujun
 * 
 *
 */

public interface AskAnswerMapper {
    
    
    int deleteByPrimaryKey(Long id);

    int insert(AskAnswer record);

    AskAnswer selectByPrimaryKey(Long id);

    int updateByPrimaryKey(AskAnswer record);
    
    
    /**
     * 查询回答列表
     * 
     */
    PageList<AnswerDetailContent> listAnswerContent(AnswerListRequestDto param,PageBounds pageBounds);
    
    /**
     * 查询回答详情
     */
    AnswerDetailContent getAnswerContent(AnswerDetailRequestDto param);
}