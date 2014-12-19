package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.dto.ResGoodsIdAndDateQueryDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityDto;
import cn.com.ubing.res.model.ResLastGoodsPriceQuantity;

public interface ResLastGoodsPriceQuantityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResLastGoodsPriceQuantity record);

    ResLastGoodsPriceQuantity selectByPrimaryKey(Long id);
    
    int updateByPrimaryKey(ResLastGoodsPriceQuantity record);
    /**
     * 根据主表id查询最近的一条记录
     * 
     * @author 邱全松 2014-11-17 下午1:53:46
     * @param id
     * @return
     */
    ResLastGoodsPriceQuantity selectFirstById(Long id);
    /**
     * 根据主表id查询所有价格信息
     * 
     * @author 邱全松 2014-11-20 下午1:29:51
     * @param id
     * @return
     */
    List<ResLastGoodsPriceQuantity> selectByLastGoodsId(Long id);
    /**
     * 根据主表id查询所有价格信息
     * 
     * @author 邱全松 2014-11-20 下午3:06:20
     * @param id
     * @return
     */
    List<ResLastGoodsPriceQuantityDto> selectDtoByLastGoodsId(Long id);
    /**
     * 根据日期和主表id查询价格信息，其中数量为剩余数量
     * 
     * @author 邱全松 2014-11-20 下午5:27:09
     * @param param
     * @return
     */
    ResLastGoodsPriceQuantity selectByLastGoodsIdAndDate(ResGoodsIdAndDateQueryDto param);
}