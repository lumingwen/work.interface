package cn.com.ubing.pub.service;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.pub.dto.BPubOrdersDetailsRequestDto;
import cn.com.ubing.pub.dto.BPubOrdersDetailsResponseDto;
import cn.com.ubing.pub.dto.BPubOrdersListDto;
import cn.com.ubing.pub.dto.BPubOrdersListRequestDto;
import cn.com.ubing.pub.dto.CAppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.CAppraisalDetailResponseDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailRequestDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailResponseDto;
import cn.com.ubing.pub.dto.CSaveAppraisalRequestDto;
import cn.com.ubing.pub.dto.PubOrdersListDto;
import cn.com.ubing.pub.dto.PubOrdersListRequestDto;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface PubOrdersServiceI {
    /**
     * 查询订单列表
     * 
     * @author 邱全松 2014-11-17 下午5:21:54
     * @param param
     * @param pageBounds
     * @return
     */
    PageList<PubOrdersListDto> queryOrderList(PubOrdersListRequestDto param,PageBounds pageBounds);
    /**
     * 查询订单详情
     * 
     * @author 邱全松 2014-11-18 下午1:25:27
     * @param param
     * @return
     */
    CPubOrdersDetailResponseDto getOrderDetail(CPubOrdersDetailRequestDto param);
    /**
     * 
     * 订单确认出行
     * @author 邱全松 2014-11-18 下午5:40:28
     * @param orderId订单id
     * @return 操作结果
     */
    String confirmTravel(Long orderId);
    /**
     * 保存评价信息
     * 
     * @author 邱全松 2014-11-19 下午2:13:44
     * @param param
     * @return
     */
    String cSaveAppraisal(CSaveAppraisalRequestDto param);
    /**
     * 评价信息详情
     * 
     * @author 邱全松 2014-11-27 下午1:55:47
     * @param param
     * @return
     */
    CAppraisalDetailResponseDto appraisalDetail(CAppraisalDetailRequestDto param);
    
    int queryOrdersCount(RequestDto param);
    /**
     * B端获取订单列表
     * 
     * @author 邱全松 2014-12-9 下午1:45:26
     * @param param
     * @param pageBounds
     * @return
     */
    PageList<BPubOrdersListDto> queryBOrderList(BPubOrdersListRequestDto param,PageBounds pageBounds);
    
    /**
     * 
     * B端订单详情
     */
    void getOrdersDetailsForB(BPubOrdersDetailsRequestDto req,BPubOrdersDetailsResponseDto resp);
}
