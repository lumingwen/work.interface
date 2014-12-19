package cn.com.ubing.res.dao;

import cn.com.ubing.res.model.ResVaneLineAnalysis;
/**
 * 风向标(经营线路分析)
 * @author zhangxujun
 * 
 *
 */
public interface ResVaneLineAnalysisMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(ResVaneLineAnalysis record);

    ResVaneLineAnalysis selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ResVaneLineAnalysis record);
    
    /**
     * 根据线路id查询风向标
     * @param lineId
     * @return
     */
    ResVaneLineAnalysis getResVaneLineAnalysisByLineId(Long lineId);
    
}