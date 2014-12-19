package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class ResCouponCountTimeOutResponseDto extends ResponseDto{
    private String ResCouponCount;//即将过期的优惠卷数量

    public String getResCouponCount() {
        return ResCouponCount;
    }

    public void setResCouponCount(String resCouponCount) {
        ResCouponCount = resCouponCount;
    }
    
}
