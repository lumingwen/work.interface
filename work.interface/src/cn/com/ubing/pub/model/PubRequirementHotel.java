package cn.com.ubing.pub.model;

import java.util.Date;

public class PubRequirementHotel {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long userId;

    private Long destination;

    private String title;

    private Date departureTime;

    private Integer tripCount;

    private Integer hotelRooms;

    private Long hotelPrice;

    private Long hotelLevel;

    private String detail;

    private String serialNumber;

    private Integer fromSys;

    private Integer manualStatus;

    private Integer sendStatus;

    private Date endTime;

    private Integer status;

    private String point;

    private Long contacts;

    private Long coupon;

    private String a1;

    private String a2;

    private String a3;

    private String a4;

    private String a5;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDestination() {
        return destination;
    }

    public void setDestination(Long destination) {
        this.destination = destination;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getTripCount() {
        return tripCount;
    }

    public void setTripCount(Integer tripCount) {
        this.tripCount = tripCount;
    }

    public Integer getHotelRooms() {
        return hotelRooms;
    }

    public void setHotelRooms(Integer hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    public Long getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(Long hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    public Long getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Long hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public Integer getFromSys() {
        return fromSys;
    }

    public void setFromSys(Integer fromSys) {
        this.fromSys = fromSys;
    }

    public Integer getManualStatus() {
        return manualStatus;
    }

    public void setManualStatus(Integer manualStatus) {
        this.manualStatus = manualStatus;
    }

    public Integer getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

    public Long getContacts() {
        return contacts;
    }

    public void setContacts(Long contacts) {
        this.contacts = contacts;
    }

    public Long getCoupon() {
        return coupon;
    }

    public void setCoupon(Long coupon) {
        this.coupon = coupon;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1 == null ? null : a1.trim();
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2 == null ? null : a2.trim();
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3 == null ? null : a3.trim();
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4 == null ? null : a4.trim();
    }

    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5 == null ? null : a5.trim();
    }
}