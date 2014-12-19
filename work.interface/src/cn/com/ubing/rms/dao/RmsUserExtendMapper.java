package cn.com.ubing.rms.dao;

import cn.com.ubing.rms.model.RmsUserExtend;

public interface RmsUserExtendMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RmsUserExtend record);

    RmsUserExtend selectByPrimaryKey(Long id);

    int updateByPrimaryKey(RmsUserExtend record);
}