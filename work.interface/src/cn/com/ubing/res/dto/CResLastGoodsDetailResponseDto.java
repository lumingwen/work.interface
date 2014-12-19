package cn.com.ubing.res.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;
/**
 * 尾单详情
 *  
 * @author 邱全松 2014-11-20 上午11:48:59
 */
public class CResLastGoodsDetailResponseDto extends ResponseDto{
    private String lastGoodId;//尾单id
    private List<String> imageList;//图片地址
    private String singlePrice;//最近单价
    private String marketPrice;//最近市场价
    private String title;//尾单标题
    private String departurePlace;//出发地
    private String quantity;//最近数量
    private List<String> departureTimes;//该尾单包含的出发日期
    private String popularReasons;//火爆理由
    private String feeDescription;//费用包含
    private String feeExclude;//费用不包含
    private List<ResLastGoodsTripDto> trips;//行程安排
    public String getLastGoodId() {
        return lastGoodId;
    }
    public void setLastGoodId(String lastGoodId) {
        this.lastGoodId = lastGoodId;
    }
    public List<String> getImageList() {
        return imageList;
    }
    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }
    public String getSinglePrice() {
        return singlePrice;
    }
    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }
    public String getMarketPrice() {
        return marketPrice;
    }
    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDeparturePlace() {
        return departurePlace;
    }
    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public List<String> getDepartureTimes() {
        return departureTimes;
    }
    public void setDepartureTimes(List<String> departureTimes) {
        this.departureTimes = departureTimes;
    }
    public String getPopularReasons() {
        return popularReasons;
    }
    public void setPopularReasons(String popularReasons) {
        this.popularReasons = popularReasons;
    }
    public String getFeeDescription() {
        return feeDescription;
    }
    public void setFeeDescription(String feeDescription) {
        this.feeDescription = feeDescription;
    }
    public String getFeeExclude() {
        return feeExclude;
    }
    public void setFeeExclude(String feeExclude) {
        this.feeExclude = feeExclude;
    }
    public List<ResLastGoodsTripDto> getTrips() {
        return trips;
    }
    public void setTrips(List<ResLastGoodsTripDto> trips) {
        this.trips = trips;
    }
}
