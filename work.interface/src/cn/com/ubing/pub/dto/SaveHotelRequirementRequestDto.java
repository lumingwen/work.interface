package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class SaveHotelRequirementRequestDto extends RequestDto{
    private String destination;//目的地ID
    private String departureTime;//出行时间yyyy-MM-dd
    private String tripCount;//住几晚
    private String hotelRooms;//住几间房
    private String hotelPrice;//酒店价格（关联字典表）
    private String hotelLevel;//酒店星级（关联字典表）
    private String detail;//详细说明
    private String point;//关键字
    private String coupon;// 优惠卷（关联优惠卷表）
    private String contactsName;// 联系人姓名
    private String contactsTel;// 联系人电话
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getTripCount() {
        return tripCount;
    }
    public void setTripCount(String tripCount) {
        this.tripCount = tripCount;
    }
    public String getHotelRooms() {
        return hotelRooms;
    }
    public void setHotelRooms(String hotelRooms) {
        this.hotelRooms = hotelRooms;
    }
    public String getHotelPrice() {
        return hotelPrice;
    }
    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice;
    }
    public String getHotelLevel() {
        return hotelLevel;
    }
    public void setHotelLevel(String hotelLevel) {
        this.hotelLevel = hotelLevel;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getPoint() {
        return point;
    }
    public void setPoint(String point) {
        this.point = point;
    }
    public String getCoupon() {
        return coupon;
    }
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
    public String getContactsName() {
        return contactsName;
    }
    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }
    public String getContactsTel() {
        return contactsTel;
    }
    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
    }
}
