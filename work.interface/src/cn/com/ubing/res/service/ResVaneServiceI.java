package cn.com.ubing.res.service;

import java.util.List;

import cn.com.ubing.res.dto.VaneDetailDto;
import cn.com.ubing.res.dto.VaneLineAnalysisDto;

/**
 * 风向标service
 * @author zhangxujun
 * 
 *
 */
public interface ResVaneServiceI {
    
    
    /**
     * 查询用户经营线路风向标字符串(第一个经营线路)
     * @param userId 用户id
     * @return 字符串
     */
    String generateFristLineAnalysisString(Long userId);
    
    
    /**
     * 查询经营线路风向标
     * @param userId 用户id
     * @return 集合
     */
    List<VaneLineAnalysisDto> generateLineAnalysisVane(Long userId);
    
    
    /**
     * 查询热门城市风向标
     * @param userId 用户id
     * @return 集合
     */
    List<VaneDetailDto> generateHotCityVane(Long userId);
    
    /**
     * 查询搜索关键字风向标(第一个经营线路)
     * @param userId 用户id
     * @return 集合
     */
    List<VaneDetailDto> generateKeywordsVane(Long userId);
}
