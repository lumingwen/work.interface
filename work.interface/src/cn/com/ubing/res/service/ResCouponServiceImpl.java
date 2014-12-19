package cn.com.ubing.res.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dao.ResCouponMapper;
import cn.com.ubing.res.dto.ResCouponCountTimeOutResponseDto;
import cn.com.ubing.res.dto.ResCouponDetailRequestDto;
import cn.com.ubing.res.dto.ResCouponDetailResponseDto;
import cn.com.ubing.res.dto.ResCouponListDto;
import cn.com.ubing.res.dto.ResCouponListRequestDto;
import cn.com.ubing.res.dto.ResCouponListResponseDto;

@Service("resCouponService")
public class ResCouponServiceImpl implements ResCouponServiceI {
    @Autowired
    private ResCouponMapper resCouponMapper;
    @Override
    public ResCouponListResponseDto queryList(ResCouponListRequestDto param, PageBounds pageBounds) {
        ResCouponListResponseDto res  = new ResCouponListResponseDto();
        PageList<ResCouponListDto> pageList = resCouponMapper.queryList(param, pageBounds);
        res.setPageNow(pageList.getPaginator().getPage()+"");
        res.setTotalPages(pageList.getPaginator().getTotalPages()+"");
        res.setTotalCount(pageList.getPaginator().getTotalCount()+"");
        res.setResCouponList(pageList);
        return res;
    }
    @Override
    public ResCouponDetailResponseDto ResCouponDetail(ResCouponDetailRequestDto param) {
        return resCouponMapper.selectDetail(param);
    }
    @Override
    public ResCouponCountTimeOutResponseDto getCouponCountTimeOut(RequestDto param) {
        ResCouponCountTimeOutResponseDto res = new ResCouponCountTimeOutResponseDto();
        res.setResCouponCount(resCouponMapper.selectCountTimeOut(param)+"");
        return res;
    }
}
