package cn.com.ubing.res.service;

import java.text.ParseException;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import cn.com.ubing.res.dto.CResBuyLastGoodsRequestDto;
import cn.com.ubing.res.dto.CResBuyLastGoodsResponseDto;
import cn.com.ubing.res.dto.CResLastGoodsDetailRequestDto;
import cn.com.ubing.res.dto.CResLastGoodsDetailResponseDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityInfoRequestDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityInfoResponseDto;
import cn.com.ubing.res.dto.WelfareListRequestDto;
import cn.com.ubing.res.dto.WelfareListResponseDto;

/**
 * 尾单逻辑处理
 *  
 * @author 邱全松 2014-11-20 上午11:40:07
 */
public interface ResLastGoodsServiceI {
    /**
     * 获取尾单详细信息
     * 
     * @author 邱全松 2014-11-20 上午11:43:20
     * @param param
     * @return
     */
    CResLastGoodsDetailResponseDto getLastGoodsDetail(CResLastGoodsDetailRequestDto param);
    /**
     * 查询尾单日期和价格信息
     * 
     * @author 邱全松 2014-11-20 下午3:04:42
     * @param param 尾单id
     * @return
     */
    ResLastGoodsPriceQuantityInfoResponseDto queryPriceQuantityInfo(ResLastGoodsPriceQuantityInfoRequestDto param);
    /**
     * 购买尾单
     * 
     * @author 邱全松 2014-11-20 下午4:44:56
     * @param param
     * @return
     */
    CResBuyLastGoodsResponseDto buyLastGoods(CResBuyLastGoodsRequestDto param) throws ParseException;
    /**
     * 查询游福利活动列表
     * 
     * @author 邱全松 2014-11-28 下午3:14:03
     * @param param
     * @return
     */
    WelfareListResponseDto queryWelfareList(WelfareListRequestDto param,PageBounds pageBounds);
}
