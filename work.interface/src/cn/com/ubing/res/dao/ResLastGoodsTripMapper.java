package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.dto.ResLastGoodsTripDto;
import cn.com.ubing.res.model.ResLastGoodsTrip;

public interface ResLastGoodsTripMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResLastGoodsTrip record);

    ResLastGoodsTrip selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ResLastGoodsTrip record);
    /**
     * 查询一条尾单的行程安排
     * 
     * @author 邱全松 2014-11-20 下午1:35:34
     * @param id
     * @return
     */
    List<ResLastGoodsTripDto> selectByLastGoodsId(Long id);
}