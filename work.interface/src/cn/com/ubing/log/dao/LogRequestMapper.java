package cn.com.ubing.log.dao;

import cn.com.ubing.log.model.LogRequest;

public interface LogRequestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogRequest record);

    LogRequest selectByPrimaryKey(Long id);

    int updateByPrimaryKey(LogRequest record);
}