package cn.com.ubing.res.dao;

import cn.com.ubing.res.model.ResVaneLineKeywords;
/**
 * 风向标(线路热门搜索词)
 * @author zhangxujun
 * 
 *
 */
public interface ResVaneLineKeywordsMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(ResVaneLineKeywords record);

    ResVaneLineKeywords selectByPrimaryKey(Long id);

   
    int updateByPrimaryKey(ResVaneLineKeywords record);
}