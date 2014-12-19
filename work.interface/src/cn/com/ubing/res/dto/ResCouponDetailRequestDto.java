package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

public class ResCouponDetailRequestDto extends RequestDto {
    private String couponId;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

}
