package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 购买尾单
 *  
 * @author 邱全松 2014-11-20 下午4:40:56
 */
public class CResBuyLastGoodsRequestDto extends RequestDto{
     private String lastGoodsId;//尾单id
     private String travelTime;//时间
     private String peopleCount;//数量
    public String getLastGoodsId() {
        return lastGoodsId;
    }
    public void setLastGoodsId(String lastGoodsId) {
        this.lastGoodsId = lastGoodsId;
    }
    public String getTravelTime() {
        return travelTime;
    }
    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }
    public String getPeopleCount() {
        return peopleCount;
    }
    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
    }
}
