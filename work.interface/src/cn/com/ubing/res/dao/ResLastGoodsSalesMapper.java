package cn.com.ubing.res.dao;

import cn.com.ubing.res.model.ResLastGoodsSales;

public interface ResLastGoodsSalesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResLastGoodsSales record);

    ResLastGoodsSales selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ResLastGoodsSales record);
}