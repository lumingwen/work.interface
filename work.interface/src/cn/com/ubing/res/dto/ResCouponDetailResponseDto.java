package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class ResCouponDetailResponseDto extends ResponseDto{
    private String couponId;
    private String type;
    private String name;
    private String endTime;
    private String money;
    private String destinationName;//目的地
    private String useStatus;//0未使用 1已使用2已过期
    private String remark;//说明
    
    
    public String getCouponId() {
        return couponId;
    }
    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public String getMoney() {
        return money;
    }
    public void setMoney(String money) {
        this.money = money;
    }
    public String getUseStatus() {
        return useStatus;
    }
    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }
    public String getDestinationName() {
        return destinationName;
    }
    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
