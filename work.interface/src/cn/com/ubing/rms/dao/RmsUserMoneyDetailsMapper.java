package cn.com.ubing.rms.dao;

import cn.com.ubing.rms.model.RmsUserMoneyDetails;

public interface RmsUserMoneyDetailsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RmsUserMoneyDetails record);

    RmsUserMoneyDetails selectByPrimaryKey(Long id);

    int updateByPrimaryKey(RmsUserMoneyDetails record);
}