package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class SaveTicketRequirementRequestDto extends RequestDto{
    private String peopleCount;//出行人数
    private String birthland;//出发地id(关联字典表)
    private String destination;//目的地id(关联字典表)
    private String departureTime;//出发时间
    private String returnTime;//返程时间
    private String detail;//补充说明
    private String ticketType;//机票类型1单程2往返
    private String departureTimeDay;//出发时间（关联字典表）
    private String ticketSpace;//机票舱位(关联字典表)
    private String coupon;// 优惠卷（关联优惠卷表）
    private String contactsName;// 联系人姓名
    private String contactsTel;// 联系人电话
    public String getPeopleCount() {
        return peopleCount;
    }
    public void setPeopleCount(String peopleCount) {
        this.peopleCount = peopleCount;
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
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    public String getDepartureTimeDay() {
        return departureTimeDay;
    }
    public void setDepartureTimeDay(String departureTimeDay) {
        this.departureTimeDay = departureTimeDay;
    }
    public String getTicketSpace() {
        return ticketSpace;
    }
    public void setTicketSpace(String ticketSpace) {
        this.ticketSpace = ticketSpace;
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
