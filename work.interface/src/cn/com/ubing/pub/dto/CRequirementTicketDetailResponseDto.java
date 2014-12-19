package cn.com.ubing.pub.dto;

import java.util.Date;
import java.util.List;
/**
 * 机票返回Dto
 * @author lumw
 *
 */
public class CRequirementTicketDetailResponseDto{
    private Long id;//需求id
    
    private Integer type;//需求类型
    
    private String username;// 需求提交人账号   
    
    private String title;//需求标题
    
    private Date createTime;//需求提交时间
    
    private String createTimeStr;//需求提交时间
    
    private Date departureTime;//出发时间 1234
    
    private String departureTimeStr;//出发时间 1234
    
    private String returnTimeStr;//返程时间 1
    
    private Date returnTime;//返程时间 1
    
    private Date endTime;//结束时间
    
    private String endTimeStr;//结束时间
    
    private Integer ticketType;//机票类型 1
    
    private String peopleCount;//机票人数
    
    private String detail;//详情补充说明1234
    
	private Long birthland;// 出发地 134
	
	private String birthlandName;// 出发地 134
	
	private Long destination;// 目的地 1234
	
	private String destinationName;// 目的地 1234
	
	private Integer planCount;// 方案数量1234
	
	private Integer grapCount;// 抢单人数1234
	
	private String strDepartureTimeDay;//起飞时间
	
	private String ticketSpace;//机票舱位
	
	private String contactsName;//联系人
	
	private String contactsTel;//联系人电话
	
	private String couponName;//优惠卷
	
	private Integer couponStatus;//优惠卷
	
	private List<CPubPlanDto> pubPlanList;//方案列表
	

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

	public String getReturnTimeStr() {
		return returnTimeStr;
	}

	public void setReturnTimeStr(String returnTimeStr) {
		this.returnTimeStr = returnTimeStr;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getTicketType() {
		return ticketType;
	}

	public void setTicketType(Integer ticketType) {
		this.ticketType = ticketType;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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
	public String getStrDepartureTimeDay() {
		return strDepartureTimeDay;
	}

	public void setStrDepartureTimeDay(String strDepartureTimeDay) {
		this.strDepartureTimeDay = strDepartureTimeDay;
	}

	public String getTicketSpace() {
		return ticketSpace;
	}

	public void setTicketSpace(String ticketSpace) {
		this.ticketSpace = ticketSpace;
	}

	public String getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(String peopleCount) {
		this.peopleCount = peopleCount;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
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

	public List<CPubPlanDto> getPubPlanList() {
		return pubPlanList;
	}

	public void setPubPlanList(List<CPubPlanDto> pubPlanList) {
		this.pubPlanList = pubPlanList;
	}
	
}
