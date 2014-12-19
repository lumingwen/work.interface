package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 主页信息返回dto
 * 
 * @author 邱全松 2014-9-4 下午8:29:10
 */
public class MainViewResponseDto extends ResponseDto {
    private String appraisal;// 评价
    private String requirement;// 订单
    private String message;// 消息
    private String broadcast;// 旅游播报
    private String plan;//方案
    private String phoUrl;//头像地址
    private String level;//等级
    private String name;//姓名
    private String ticketValue;//机票等待百分比
    private String hotelValue;//酒店等待百分比
    private String personalValue;//自由行等待百分比
    private String groupValue;//跟团行等待百分比
    private String ticketStatus;//机票经营状态0非经营1经营
    private String hotelStatus;//酒店经营状态0非经营1经营
    private String personalStatus;//自由行经营状态0非经营1经营
    private String groupStatus;//跟团行经营状态0非经营1经营

    public String getTicketValue() {
        return ticketValue;
    }
    public void setTicketValue(String ticketValue) {
        this.ticketValue = ticketValue;
    }
    public String getHotelValue() {
        return hotelValue;
    }
    public void setHotelValue(String hotelValue) {
        this.hotelValue = hotelValue;
    }
    public String getPersonalValue() {
        return personalValue;
    }
    public void setPersonalValue(String personalValue) {
        this.personalValue = personalValue;
    }
    public String getGroupValue() {
        return groupValue;
    }
    public void setGroupValue(String groupValue) {
        this.groupValue = groupValue;
    }
    public String getTicketStatus() {
        return ticketStatus;
    }
    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
    public String getHotelStatus() {
        return hotelStatus;
    }
    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }
    public String getPersonalStatus() {
        return personalStatus;
    }
    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }
    public String getGroupStatus() {
        return groupStatus;
    }
    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }
    public String getPhoUrl() {
        return phoUrl;
    }
    public void setPhoUrl(String phoUrl) {
        this.phoUrl = phoUrl;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAppraisal() {
        return appraisal;
    }
    public void setAppraisal(String appraisal) {
        this.appraisal = appraisal;
    }
    public String getRequirement() {
        return requirement;
    }
    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getBroadcast() {
        return broadcast;
    }
    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }
    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
    
}
