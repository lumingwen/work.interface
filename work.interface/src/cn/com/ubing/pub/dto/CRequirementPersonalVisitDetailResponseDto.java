package cn.com.ubing.pub.dto;

import java.util.Date;
import java.util.List;

/**
 * 自由行返回Dto
 * @author lumw
 *
 */
public class CRequirementPersonalVisitDetailResponseDto{
    private Long id;//需求id
    
    private Integer type;//需求类型
    
    private String username;// 需求提交人账号   
    
    private String title;//需求标题
    
    private Date createTime;//需求提交时间
    
    private String createTimeStr;//需求提交时间
    
    private Date departureTime;//出发时间 12(入住时间)34
    
    private String departureTimeStr;//出发时间 1234
    
    private Integer tripCount;//玩几天
    
    private Integer peopleCount;//出行人数
    
    private Date endTime;//结束时间
    
    private String endTimeStr;//结束时间
    
    private String detail;//详情补充说明1234
    
    private Long birthland;//出发地
    
    private String birthlandName;
	
	private Long destination;// 目的地 1234
	
	private String destinationName;// 目的地 1234
	
	private Integer planCount;// 方案数量1234
	
	private Integer grapCount;// 抢单人数1234
	
    private Integer childPeopleCount;//小孩数
    
    private Long theme;//旅游主题（关联res_dict_expand表）
    
    private String themName;//名称
    
    private String themIcon;//图标地址
    
    private String budget;// 人均预算
	
	private String contactsName;//联系人1234
	
	private String contactsTel;//联系人电话1234
	
	private String couponName;//优惠卷1234
	
	private Integer couponStatus;//优惠卷1234
	
	private Long transportation;//交通方式
	
	private String transportationStr;
	private String hotelLevelStr;//酒店
	
	private List<CPubPlanDto> pubPlanList;//方案列表1234

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getDepartureTimeStr() {
		return departureTimeStr;
	}

	public void setDepartureTimeStr(String departureTimeStr) {
		this.departureTimeStr = departureTimeStr;
	}

	public Integer getTripCount() {
		return tripCount;
	}

	public void setTripCount(Integer tripCount) {
		this.tripCount = tripCount;
	}

	public Integer getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Long getDestination() {
		return destination;
	}

	public void setDestination(Long destination) {
		this.destination = destination;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public Integer getPlanCount() {
		return planCount;
	}

	public void setPlanCount(Integer planCount) {
		this.planCount = planCount;
	}

	public Integer getGrapCount() {
		return grapCount;
	}

	public void setGrapCount(Integer grapCount) {
		this.grapCount = grapCount;
	}

	public Integer getChildPeopleCount() {
		return childPeopleCount;
	}

	public void setChildPeopleCount(Integer childPeopleCount) {
		this.childPeopleCount = childPeopleCount;
	}

	public Long getTheme() {
		return theme;
	}

	public void setTheme(Long theme) {
		this.theme = theme;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
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

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Integer getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(Integer couponStatus) {
		this.couponStatus = couponStatus;
	}

	public Long getTransportation() {
		return transportation;
	}

	public void setTransportation(Long transportation) {
		this.transportation = transportation;
	}

	public String getTransportationStr() {
		return transportationStr;
	}

	public void setTransportationStr(String transportationStr) {
		this.transportationStr = transportationStr;
	}

	public List<CPubPlanDto> getPubPlanList() {
		return pubPlanList;
	}

	public void setPubPlanList(List<CPubPlanDto> pubPlanList) {
		this.pubPlanList = pubPlanList;
	}

	public Long getBirthland() {
		return birthland;
	}

	public void setBirthland(Long birthland) {
		this.birthland = birthland;
	}

	public String getBirthlandName() {
		return birthlandName;
	}

	public void setBirthlandName(String birthlandName) {
		this.birthlandName = birthlandName;
	}

	public String getThemName() {
		return themName;
	}

	public void setThemName(String themName) {
		this.themName = themName;
	}

	public String getThemIcon() {
		return themIcon;
	}

	public void setThemIcon(String themIcon) {
		this.themIcon = themIcon;
	}

	public String getHotelLevelStr() {
		return hotelLevelStr;
	}

	public void setHotelLevelStr(String hotelLevelStr) {
		this.hotelLevelStr = hotelLevelStr;
	}


	
}
