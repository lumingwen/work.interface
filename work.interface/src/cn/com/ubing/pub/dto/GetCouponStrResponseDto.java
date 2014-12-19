/**
 * 
 */
package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * @author zhangxujun
 * 
 *
 */
public class GetCouponStrResponseDto extends ResponseDto {
    
    /**
     * 优惠券字符串
     */
    private String couponstr;

    public String getCouponstr() {
        return couponstr;
    }

    public void setCouponstr(String couponstr) {
        this.couponstr = couponstr;
    }
    
    

}
