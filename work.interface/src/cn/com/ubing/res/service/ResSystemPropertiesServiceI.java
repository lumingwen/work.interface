package cn.com.ubing.res.service;

import cn.com.ubing.res.model.ResSystemProperties;

public interface ResSystemPropertiesServiceI {
    /**
     * 根据key获取对应配置信息
     * 
     * @author 邱全松 2014-8-22 下午2:04:32
     * @param id
     * @return
     */
    public ResSystemProperties selectByKey(String id);
}
