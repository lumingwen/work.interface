package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 方案库方案保存请求dto
 * 
 * @author 邱全松 2014-6-26 上午9:12:36
 */
public class SavaLibraryPlanRequestDto extends RequestDto {
    private String id;// 方案id
    private String type;// 方案类型 非空 仅数字（1机票，2酒店，3自由行，4跟团行）
    private String title;// 方案标题 非空
    private String lineId;// 线路 仅数字，仅自由行、跟团行有效
    private String birthland;// 出发地 仅数字，仅机票、自由行、跟团行有效
    private String destination;// 目的地 仅数字
    private String tripCount;// 行程天数 仅数字，仅自由行、跟团行、酒店有效
    private String hotelName;// 酒店名称 仅自由行、跟团行、酒店有效
    private String airLine;// 航空公司 仅机票、自由行、跟团行有效
    private String hotelAddress;// 酒店地址 仅酒店有效
    private String hotelRoom;// 酒店房型 仅酒店有效
    private String ticketType;// 机票类型 仅数字，仅机票有效（1单程，2往返）
    private String departureTime;// 出发时间 格式:yyyy-MM-dd hh:MM:ss
    private String returnTime;// 返程时间 格式:yyyy-MM-dd hh:MM:ss，仅机票有效
    private String leaveAirPlace;// 出发机场 仅机票有效
    private String reachAirPlace;// 到达机场 仅机票有效
    private String airBerth;// 舱位 仅数字，仅机票有效
    private String flightNumber;// 航班号 仅机票有效
    private String travelRemark;// 行程简介
    private String feeRemark;// 费用说明

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getBirthland() {
        return birthland;
    }

    public void setBirthland(String birthland) {
        this.birthland = birthland;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTripCount() {
        return tripCount;
    }

    public void setTripCount(String tripCount) {
        this.tripCount = tripCount;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAirLine() {
        return airLine;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(String hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getLeaveAirPlace() {
        return leaveAirPlace;
    }

    public void setLeaveAirPlace(String leaveAirPlace) {
        this.leaveAirPlace = leaveAirPlace;
    }

    public String getReachAirPlace() {
        return reachAirPlace;
    }

    public void setReachAirPlace(String reachAirPlace) {
        this.reachAirPlace = reachAirPlace;
    }

    public String getAirBerth() {
        return airBerth;
    }

    public void setAirBerth(String airBerth) {
        this.airBerth = airBerth;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getTravelRemark() {
        return travelRemark;
    }

    public void setTravelRemark(String travelRemark) {
        this.travelRemark = travelRemark;
    }

    public String getFeeRemark() {
        return feeRemark;
    }

    public void setFeeRemark(String feeRemark) {
        this.feeRemark = feeRemark;
    }

}
