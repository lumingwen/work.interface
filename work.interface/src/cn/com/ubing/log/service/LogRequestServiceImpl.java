/**
 * 
 */
package cn.com.ubing.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.log.dao.LogRequestMapper;
import cn.com.ubing.log.model.LogRequest;

/**
 * 请求log
 * @author zhangxujun
 * 
 *
 */
@Service("logRequestService")
public class LogRequestServiceImpl implements LogRequestServiceI {
    
    
    /**
     * dao
     */
    @Autowired
    private LogRequestMapper logRequestMapper;
    
    
    /**
     * 
     * 插入
     */
    @Override
    public void insert(LogRequest log){
	logRequestMapper.insert(log);
    }

}
