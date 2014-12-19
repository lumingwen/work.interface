package cn.com.ubing.res.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dto.ResCouponDetailRequestDto;
import cn.com.ubing.res.dto.ResCouponDetailResponseDto;
import cn.com.ubing.res.dto.ResCouponListDto;
import cn.com.ubing.res.dto.ResCouponListRequestDto;
import cn.com.ubing.res.model.ResCoupon;

public interface ResCouponMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResCoupon record);

    ResCoupon selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ResCoupon record);
    
    PageList<ResCouponListDto> queryList(ResCouponListRequestDto param,PageBounds pageBounds);
    
    ResCouponDetailResponseDto selectDetail(ResCouponDetailRequestDto param);
    
    int selectCountTimeOut(RequestDto param);
}