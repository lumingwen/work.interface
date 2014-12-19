package cn.com.ubing.res.dao;

import cn.com.ubing.res.model.ResVaneHotCity;

/**
 * 风向标(热门城市排行)
 * @author zhangxujun
 * 
 *
 */
public interface ResVaneHotCityMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(ResVaneHotCity record);

    ResVaneHotCity selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ResVaneHotCity record);
}