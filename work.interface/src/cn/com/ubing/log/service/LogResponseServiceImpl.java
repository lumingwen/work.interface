/**
 * 
 */
package cn.com.ubing.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.log.dao.LogResponseMapper;
import cn.com.ubing.log.model.LogResponse;

/**
 * 响应log
 * @author zhangxujun
 * 
 *
 */
@Service("logResponseService")
public class LogResponseServiceImpl implements LogResponseServiceI {
    
    /**
     * dao
     */
    @Autowired
    private LogResponseMapper logResponseMapper;
    
    /**
     * 
     * 插入
     */
    @Override
    public void insert(LogResponse log){
	logResponseMapper.insert(log);
    }

}
