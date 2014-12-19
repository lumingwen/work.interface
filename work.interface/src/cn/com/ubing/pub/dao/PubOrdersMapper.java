package cn.com.ubing.pub.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.pub.dto.BPubOrdersListDto;
import cn.com.ubing.pub.dto.BPubOrdersListRequestDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailRequestDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailResponseDto;
import cn.com.ubing.pub.dto.PubOrdersListDto;
import cn.com.ubing.pub.dto.PubOrdersListRequestDto;
import cn.com.ubing.pub.model.PubOrders;

public interface PubOrdersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubOrders record);

    PubOrders selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubOrders record);
    /**
     * 查询订单列表
     * 
     * @author 邱全松 2014-11-18 下午3:50:59
     * @param param
     * @param pageBounds
     * @return
     */
    PageList<PubOrdersListDto> queryOrderList(PubOrdersListRequestDto param,PageBounds pageBounds);
    /**
     * 查询B端订单列表
     * 
     * @author 邱全松 2014-12-9 下午1:52:22
     * @param param
     * @param pageBounds
     * @return
     */
    PageList<BPubOrdersListDto> queryBOrderList(BPubOrdersListRequestDto param,PageBounds pageBounds);
    /**
     * 查询订单详情
     * 
     * @author 邱全松 2014-11-18 下午3:50:52
     * @param param
     * @return
     */
    CPubOrdersDetailResponseDto getOrderDetail(CPubOrdersDetailRequestDto param);
    
    int queryOrdersCount(RequestDto param);
}