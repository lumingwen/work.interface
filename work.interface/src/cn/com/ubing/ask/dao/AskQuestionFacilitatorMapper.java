package cn.com.ubing.ask.dao;

import cn.com.ubing.ask.model.AskQuestionFacilitator;
/**
 * 问题推送
 * @author zhangxujun
 * 
 *
 */
public interface AskQuestionFacilitatorMapper {
   
    int deleteByPrimaryKey(Long id);

    int insert(AskQuestionFacilitator record);


    AskQuestionFacilitator selectByPrimaryKey(Long id);


    int updateByPrimaryKey(AskQuestionFacilitator record);
}