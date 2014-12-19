/**
 * 
 */
package cn.com.ubing.log.service;

import cn.com.ubing.log.model.LogRequest;

/**
 * 请求log
 * @author zhangxujun
 * 
 *
 */
public interface LogRequestServiceI {
    
    /**
     * 
     * 插入
     */
    void insert(LogRequest log);

}
