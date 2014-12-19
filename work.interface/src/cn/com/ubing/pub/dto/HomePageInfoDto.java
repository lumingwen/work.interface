package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 主页信息
 *  
 * @author 邱全松 2014-6-24 下午1:43:45
 */
public class HomePageInfoDto extends ResponseDto {
    private Integer flightTicketRange;// 机票订单距离 仅包含数字（null代表非经营）
    private Integer hotelRange;// 酒店订单距离 仅包含数字（null代表非经营）
    private Integer freeTravelRange;// 自由行订单距离 仅包含数字（null代表非经营）
    private Integer groupTravelRange;// 跟团行订单距离 仅包含数字（null代表非经营）
    private Integer flightTicketStatus;// 机票订单是否可抢单 非空 仅包含数字（1是，0否，2非经营）
    private Integer hotelStatus;// 酒店订单是否可抢单 非空 仅包含数字（1是，0否，2非经营）
    private Integer freeTravelStatus;// 自由行订单是否可抢 非空 仅包含数字（1是，0否，2非经营）
    private Integer groupTravelStatus;// 跟团行订单是否可抢 非空 仅包含数字（1是，0否，2非经营）
    private String vaneName;// 风向标名字 非空 主营线路第一个
    private Integer needDeliverCount;// 需投递 非空 仅包含数字
    private Integer needAppraisalCount;// 需评价 非空 仅包含数字
    private Integer needRegiment;// 需出团 非空 仅包含数字
    private Integer messageCount;// 未读信 非空 仅包含数字
    private Integer askCount;// 提问 非空 仅包含数字
    public Integer getFlightTicketRange() {
        return flightTicketRange;
    }
    public void setFlightTicketRange(Integer flightTicketRange) {
        this.flightTicketRange = flightTicketRange;
    }
    public Integer getHotelRange() {
        return hotelRange;
    }
    public void setHotelRange(Integer hotelRange) {
        this.hotelRange = hotelRange;
    }
    public Integer getFreeTravelRange() {
        return freeTravelRange;
    }
    public void setFreeTravelRange(Integer freeTravelRange) {
        this.freeTravelRange = freeTravelRange;
    }
    public Integer getGroupTravelRange() {
        return groupTravelRange;
    }
    public void setGroupTravelRange(Integer groupTravelRange) {
        this.groupTravelRange = groupTravelRange;
    }
    public Integer getFlightTicketStatus() {
        return flightTicketStatus;
    }
    public void setFlightTicketStatus(Integer flightTicketStatus) {
        this.flightTicketStatus = flightTicketStatus;
    }
    public Integer getHotelStatus() {
        return hotelStatus;
    }
    public void setHotelStatus(Integer hotelStatus) {
        this.hotelStatus = hotelStatus;
    }
    public Integer getFreeTravelStatus() {
        return freeTravelStatus;
    }
    public void setFreeTravelStatus(Integer freeTravelStatus) {
        this.freeTravelStatus = freeTravelStatus;
    }
    public Integer getGroupTravelStatus() {
        return groupTravelStatus;
    }
    public void setGroupTravelStatus(Integer groupTravelStatus) {
        this.groupTravelStatus = groupTravelStatus;
    }
    public String getVaneName() {
        return vaneName;
    }
    public void setVaneName(String vaneName) {
        this.vaneName = vaneName;
    }
    public Integer getNeedDeliverCount() {
        return needDeliverCount;
    }
    public void setNeedDeliverCount(Integer needDeliverCount) {
        this.needDeliverCount = needDeliverCount;
    }
    public Integer getNeedAppraisalCount() {
        return needAppraisalCount;
    }
    public void setNeedAppraisalCount(Integer needAppraisalCount) {
        this.needAppraisalCount = needAppraisalCount;
    }
    public Integer getNeedRegiment() {
        return needRegiment;
    }
    public void setNeedRegiment(Integer needRegiment) {
        this.needRegiment = needRegiment;
    }
    public Integer getMessageCount() {
        return messageCount;
    }
    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }
    public Integer getAskCount() {
        return askCount;
    }
    public void setAskCount(Integer askCount) {
        this.askCount = askCount;
    }
}
