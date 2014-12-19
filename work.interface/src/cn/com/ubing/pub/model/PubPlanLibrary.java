package cn.com.ubing.pub.model;

import java.util.Date;

public class PubPlanLibrary {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Integer type;

    private Long userId;

    private String title;

    private Long lineId;

    private Long birthland;

    private Long destination;

    private String tripCount;

    private String hotelName;

    private String airLine;

    private String hotelAddress;

    private String hotelRoom;

    private Integer ticketType;

    private Date departureTime;

    private Date returnTime;

    private String leaveAirPlace;

    private String reachAirPlace;

    private Long airBerth;

    private String flightNumber;

    private String travelRemark;

    private String feeRemark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Long getBirthland() {
        return birthland;
    }

    public void setBirthland(Long birthland) {
        this.birthland = birthland;
    }

    public Long getDestination() {
        return destination;
    }

    public void setDestination(Long destination) {
        this.destination = destination;
    }

    public String getTripCount() {
        return tripCount;
    }

    public void setTripCount(String tripCount) {
        this.tripCount = tripCount == null ? null : tripCount.trim();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getAirLine() {
        return airLine;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine == null ? null : airLine.trim();
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress == null ? null : hotelAddress.trim();
    }

    public String getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(String hotelRoom) {
        this.hotelRoom = hotelRoom == null ? null : hotelRoom.trim();
    }

    public Integer getTicketType() {
        return ticketType;
    }

    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getLeaveAirPlace() {
        return leaveAirPlace;
    }

    public void setLeaveAirPlace(String leaveAirPlace) {
        this.leaveAirPlace = leaveAirPlace == null ? null : leaveAirPlace.trim();
    }

    public String getReachAirPlace() {
        return reachAirPlace;
    }

    public void setReachAirPlace(String reachAirPlace) {
        this.reachAirPlace = reachAirPlace == null ? null : reachAirPlace.trim();
    }

    public Long getAirBerth() {
        return airBerth;
    }

    public void setAirBerth(Long airBerth) {
        this.airBerth = airBerth;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber == null ? null : flightNumber.trim();
    }

    public String getTravelRemark() {
        return travelRemark;
    }

    public void setTravelRemark(String travelRemark) {
        this.travelRemark = travelRemark == null ? null : travelRemark.trim();
    }

    public String getFeeRemark() {
        return feeRemark;
    }

    public void setFeeRemark(String feeRemark) {
        this.feeRemark = feeRemark == null ? null : feeRemark.trim();
    }
}