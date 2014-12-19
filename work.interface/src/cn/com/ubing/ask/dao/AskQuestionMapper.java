package cn.com.ubing.ask.dao;

import cn.com.ubing.ask.dto.QuestionListRequestDto;
import cn.com.ubing.ask.dto.content.QuestionDetailContent;
import cn.com.ubing.ask.model.AskQuestion;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * 提问
 * @author zhangxujun
 * 
 *
 */
public interface AskQuestionMapper {
   
    int deleteByPrimaryKey(Long id);

    int insert(AskQuestion record);


    AskQuestion selectByPrimaryKey(Long id);


    int updateByPrimaryKey(AskQuestion record);
    
    
    /**
     * 查询需求列表
     * 
     */
    PageList<QuestionDetailContent> listQuestionContent(QuestionListRequestDto param,PageBounds pageBounds);
    
    /**
     * 查看需求详情
     * 
     */
    QuestionDetailContent getQuestionContent(Long id);
}