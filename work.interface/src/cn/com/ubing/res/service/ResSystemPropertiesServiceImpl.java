package cn.com.ubing.res.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.res.dao.ResSystemPropertiesMapper;
import cn.com.ubing.res.model.ResSystemProperties;

@Service("resSystemPropertiesService")
public class ResSystemPropertiesServiceImpl implements ResSystemPropertiesServiceI {
    @Autowired
    private ResSystemPropertiesMapper resSystemPropertiesMapper;

    @Override
    public ResSystemProperties selectByKey(String key) {
        // TODO Auto-generated method stub
        return resSystemPropertiesMapper.selectByKey(key);
    }

}
