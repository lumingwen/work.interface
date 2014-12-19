package cn.com.ubing.res.dao;

import cn.com.ubing.res.dto.SystemVersion;
import cn.com.ubing.res.model.ResAppSoftware;

public interface ResAppSoftwareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResAppSoftware record);

    ResAppSoftware selectByPrimaryKey(Long id);
    /**
     * 根据系统类型，查询对应版本号
     * 
     * @author 邱全松 2014-9-22 上午11:34:13
     * @param type
     * @return
     */
    SystemVersion selectSystemVersion(Integer type);

    int updateByPrimaryKey(ResAppSoftware record);
}