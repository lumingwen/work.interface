package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class SaveGroupRequirementRequestDto extends RequestDto{
    private String birthland;//出发地ID 必填
    private String destination;//目的地ID 必填
    private String departureTime;//出行时间串yyyy-MM-dd  必填
    private String tripCount;//玩几天
    private String peopleCount;//成人数量
    private String childPeopleCount;//儿童数量
    private String detail;//补充说明
    private String budget;//人均预算
    private String coupon;//优惠卷id
    private String contactsName;//联系人姓名
    private String contactsTel;//联系人电话
    private String hotelLevel;//酒店星级id
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
    public String getPeopleCount() {
        return peopleCount;
    }
    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
    }
    public String getChildPeopleCount() {
        return childPeopleCount;
    }
    public void setChildPeopleCount(String childPeopleCount) {
        this.childPeopleCount = childPeopleCount;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getBudget() {
        return budget;
    }
    public void setBudget(String budget) {
        this.budget = budget;
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
    public String getHotelLevel() {
        return hotelLevel;
    }
    public void setHotelLevel(String hotelLevel) {
        this.hotelLevel = hotelLevel;
    }
    
}
