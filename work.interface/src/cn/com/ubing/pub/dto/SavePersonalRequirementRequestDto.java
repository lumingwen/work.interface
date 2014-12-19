package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * c端用户提交自由行需求请求数据
 * 
 * @author 邱全松 2014-10-30 下午3:12:35
 */
public class SavePersonalRequirementRequestDto extends RequestDto {

    private String birthland;// 出发地                                                    必填
    private String destination;// 目的地                                             必填
    private String departureTime;// 出行时间                                 必填yyyy-MM-dd
    private String tripCount;// 玩几天
    private String peopleCount;// 出行人数（成人）
    private String detail;// 需求补充说明
    private String childPeopleCount;// 出行人数（小孩）
    private String theme;// 旅游主题（关联字典表）
    private String budget;// 人均预算
    private String coupon;// 优惠卷（关联优惠卷表）
    private String contactsName;// 联系人姓名
    private String contactsTel;// 联系人电话
    private String transportation;// 交通方式（关联字典表）
    private String hotelLevel;// 酒店星级id
    private String addeds;//增值服务ID串，多个以逗号隔开

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

    public String getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(String hotelLevel) {
        this.hotelLevel = hotelLevel;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getChildPeopleCount() {
        return childPeopleCount;
    }

    public void setChildPeopleCount(String childPeopleCount) {
        this.childPeopleCount = childPeopleCount;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
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

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getAddeds() {
        return addeds;
    }

    public void setAddeds(String addeds) {
        this.addeds = addeds;
    }
}
