package cn.com.ubing.pub.model;

import java.util.Date;

public class PubPlanHistoryTicketTransit {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long ticketId;

    private Integer type;

    private String companyName;

    private String airplaneType;

    private String airplaneNumber;

    private Long airplaneSeat;

    private Long leaveLocation;

    private Long leaveAirport;

    private String leaveTimeHour;

    private String leaveTimeMinute;

    private Long reachLocation;

    private Long reachAirport;

    private String reachTimeHour;

    private String reachTimeMinute;

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

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType == null ? null : airplaneType.trim();
    }

    public String getAirplaneNumber() {
        return airplaneNumber;
    }

    public void setAirplaneNumber(String airplaneNumber) {
        this.airplaneNumber = airplaneNumber == null ? null : airplaneNumber.trim();
    }

    public Long getAirplaneSeat() {
        return airplaneSeat;
    }

    public void setAirplaneSeat(Long airplaneSeat) {
        this.airplaneSeat = airplaneSeat;
    }

    public Long getLeaveLocation() {
        return leaveLocation;
    }

    public void setLeaveLocation(Long leaveLocation) {
        this.leaveLocation = leaveLocation;
    }

    public Long getLeaveAirport() {
        return leaveAirport;
    }

    public void setLeaveAirport(Long leaveAirport) {
        this.leaveAirport = leaveAirport;
    }

    public String getLeaveTimeHour() {
        return leaveTimeHour;
    }

    public void setLeaveTimeHour(String leaveTimeHour) {
        this.leaveTimeHour = leaveTimeHour == null ? null : leaveTimeHour.trim();
    }

    public String getLeaveTimeMinute() {
        return leaveTimeMinute;
    }

    public void setLeaveTimeMinute(String leaveTimeMinute) {
        this.leaveTimeMinute = leaveTimeMinute == null ? null : leaveTimeMinute.trim();
    }

    public Long getReachLocation() {
        return reachLocation;
    }

    public void setReachLocation(Long reachLocation) {
        this.reachLocation = reachLocation;
    }

    public Long getReachAirport() {
        return reachAirport;
    }

    public void setReachAirport(Long reachAirport) {
        this.reachAirport = reachAirport;
    }

    public String getReachTimeHour() {
        return reachTimeHour;
    }

    public void setReachTimeHour(String reachTimeHour) {
        this.reachTimeHour = reachTimeHour == null ? null : reachTimeHour.trim();
    }

    public String getReachTimeMinute() {
        return reachTimeMinute;
    }

    public void setReachTimeMinute(String reachTimeMinute) {
        this.reachTimeMinute = reachTimeMinute == null ? null : reachTimeMinute.trim();
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