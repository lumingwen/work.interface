package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.model.ResSystemProperties;

public interface ResSystemPropertiesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResSystemProperties record);

    ResSystemProperties selectByPrimaryKey(Long id);
    /**
     * 根据key查询value
     * @param key
     * @return
     */
    List<ResSystemProperties> listByKey(String key);
    /**
     * 根据key获得配置信息
     * 
     * @author 邱全松 2014-8-22 下午2:02:22
     * @param id
     * @return
     */
    ResSystemProperties selectByKey(String key);

    int updateByPrimaryKey(ResSystemProperties record);
}