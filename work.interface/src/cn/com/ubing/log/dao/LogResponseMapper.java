package cn.com.ubing.log.dao;

import cn.com.ubing.log.model.LogResponse;

public interface LogResponseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LogResponse record);

    LogResponse selectByPrimaryKey(Long id);

    int updateByPrimaryKey(LogResponse record);
}