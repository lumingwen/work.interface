package cn.com.ubing.res.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dto.ResCouponCountTimeOutResponseDto;
import cn.com.ubing.res.dto.ResCouponDetailRequestDto;
import cn.com.ubing.res.dto.ResCouponDetailResponseDto;
import cn.com.ubing.res.dto.ResCouponListRequestDto;
import cn.com.ubing.res.dto.ResCouponListResponseDto;

public interface ResCouponServiceI {
    /**
     * 查询优惠卷列表
     * 
     * @author 邱全松 2014-10-21 下午1:54:29
     * @param param
     * @return
     */
    public ResCouponListResponseDto queryList(ResCouponListRequestDto param,PageBounds pageBounds);
    /**
     * 查询优惠卷详细信息
     * 
     * @author 邱全松 2014-10-21 下午3:27:37
     * @param param
     * @param pageBounds
     * @return
     */
    public ResCouponDetailResponseDto ResCouponDetail(ResCouponDetailRequestDto param);
    /**
     * 查询激将过期的优惠卷数量
     * 
     * @author 邱全松 2014-10-21 下午4:01:38
     * @param param
     * @return
     */
    public ResCouponCountTimeOutResponseDto getCouponCountTimeOut(RequestDto param);
}
