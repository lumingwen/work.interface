package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * B端订单详情响应dto
 * 
 * @author 邱全松 2014-6-25 下午2:35:53
 */
public class RequirementDetailResponseDto extends ResponseDto {
	private String requirementTitle;
	private String requirementStatus;
	private String grapStatus;
	private String readStatus;
	private String requirementById;
	private String requirementByName;
	private String requirementByUrl;
	private String birthlandName;
	private String destinationName;
	private String departureTime;
	private String hotelRooms;
	private String tripCount;
	private String hotelPrice;
	private String hotelLevel;
	private String returnTime;
	private String remark;
	private String planId;
	private String planTitle;
	private String planPrice;
	private String planStartTime;
	private String planEndTime;
	private String planRemark;
	private String planRelationId;
	private String planRelationTitle;
	private String appraisalName;
	private String appraisalTime;
	private String appraisalDescription;
	private String appraisalService;
	private String appraisalResult;
	private String appraisalContent;
	private String appraisalResponseTime;
	private String appraisalResponseContent;
	private String appraisalRejectContent;
	private String appraisalRejectTime;
	private String appraisalRejectBy;
	private String days;
	private String buchong;
	private String groupId;

	/**
     * 2.0新增字段
     */
	private String strDepartureTimeDay;// 起飞时间 1

	private String ticketSpace;// 机票舱位 1

	private String contactsName;// 联系人

	private String contactsTel;// 联系人电话

	private String couponName;// 优惠卷

	private Integer couponStatus;// 优惠卷

	private String point;// 关键字 2

	private String themName;// 名称 3

	private String themIcon;// 图标地址3

	private String budget;// 人均预算3

	private String transportationStr;// 3

	private Integer childPeopleCount;// 小孩数 3
	private Integer peopleCount;// 出行人数3
	
	private List<PubRequirementPersonVisitAddDto> addServiceList;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getBuchong() {
		return buchong;
	}

	public void setBuchong(String buchong) {
		this.buchong = buchong;
	}

	public String getRequirementTitle() {
		return requirementTitle;
	}

	public void setRequirementTitle(String requirementTitle) {
		this.requirementTitle = requirementTitle;
	}

	public String getRequirementByUrl() {
		return requirementByUrl;
	}

	public void setRequirementByUrl(String requirementByUrl) {
		this.requirementByUrl = requirementByUrl;
	}

	public String getRequirementStatus() {
		return requirementStatus;
	}

	public void setRequirementStatus(String requirementStatus) {
		this.requirementStatus = requirementStatus;
	}

	public String getGrapStatus() {
		return grapStatus;
	}

	public void setGrapStatus(String grapStatus) {
		this.grapStatus = grapStatus;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	public String getRequirementById() {
		return requirementById;
	}

	public void setRequirementById(String requirementById) {
		this.requirementById = requirementById;
	}

	public String getRequirementByName() {
		return requirementByName;
	}

	public void setRequirementByName(String requirementByName) {
		this.requirementByName = requirementByName;
	}

	public String getBirthlandName() {
		return birthlandName;
	}

	public void setBirthlandName(String birthlandName) {
		this.birthlandName = birthlandName;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(String hotelRooms) {
		this.hotelRooms = hotelRooms;
	}

	public String getTripCount() {
		return tripCount;
	}

	public void setTripCount(String tripCount) {
		this.tripCount = tripCount;
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

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public String getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(String planPrice) {
		this.planPrice = planPrice;
	}

	public String getPlanStartTime() {
		return planStartTime;
	}

	public void setPlanStartTime(String planStartTime) {
		this.planStartTime = planStartTime;
	}

	public String getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
	}

	public String getPlanRemark() {
		return planRemark;
	}

	public void setPlanRemark(String planRemark) {
		this.planRemark = planRemark;
	}

	public String getPlanRelationId() {
		return planRelationId;
	}

	public void setPlanRelationId(String planRelationId) {
		this.planRelationId = planRelationId;
	}

	public String getPlanRelationTitle() {
		return planRelationTitle;
	}

	public void setPlanRelationTitle(String planRelationTitle) {
		this.planRelationTitle = planRelationTitle;
	}

	public String getAppraisalName() {
		return appraisalName;
	}

	public void setAppraisalName(String appraisalName) {
		this.appraisalName = appraisalName;
	}

	public String getAppraisalTime() {
		return appraisalTime;
	}

	public void setAppraisalTime(String appraisalTime) {
		this.appraisalTime = appraisalTime;
	}

	public String getAppraisalDescription() {
		return appraisalDescription;
	}

	public void setAppraisalDescription(String appraisalDescription) {
		this.appraisalDescription = appraisalDescription;
	}

	public String getAppraisalService() {
		return appraisalService;
	}

	public void setAppraisalService(String appraisalService) {
		this.appraisalService = appraisalService;
	}

	public String getAppraisalResult() {
		return appraisalResult;
	}

	public void setAppraisalResult(String appraisalResult) {
		this.appraisalResult = appraisalResult;
	}

	public String getAppraisalContent() {
		return appraisalContent;
	}

	public void setAppraisalContent(String appraisalContent) {
		this.appraisalContent = appraisalContent;
	}

	public String getAppraisalResponseTime() {
		return appraisalResponseTime;
	}

	public void setAppraisalResponseTime(String appraisalResponseTime) {
		this.appraisalResponseTime = appraisalResponseTime;
	}

	public String getAppraisalResponseContent() {
		return appraisalResponseContent;
	}

	public void setAppraisalResponseContent(String appraisalResponseContent) {
		this.appraisalResponseContent = appraisalResponseContent;
	}

	public String getAppraisalRejectContent() {
		return appraisalRejectContent;
	}

	public void setAppraisalRejectContent(String appraisalRejectContent) {
		this.appraisalRejectContent = appraisalRejectContent;
	}

	public String getAppraisalRejectTime() {
		return appraisalRejectTime;
	}

	public void setAppraisalRejectTime(String appraisalRejectTime) {
		this.appraisalRejectTime = appraisalRejectTime;
	}

	public String getAppraisalRejectBy() {
		return appraisalRejectBy;
	}

	public void setAppraisalRejectBy(String appraisalRejectBy) {
		this.appraisalRejectBy = appraisalRejectBy;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
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

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
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

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getTransportationStr() {
		return transportationStr;
	}

	public void setTransportationStr(String transportationStr) {
		this.transportationStr = transportationStr;
	}

	public Integer getChildPeopleCount() {
		return childPeopleCount;
	}

	public void setChildPeopleCount(Integer childPeopleCount) {
		this.childPeopleCount = childPeopleCount;
	}

	public Integer getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public List<PubRequirementPersonVisitAddDto> getAddServiceList() {
		return addServiceList;
	}

	public void setAddServiceList(
		List<PubRequirementPersonVisitAddDto> addServiceList) {
		this.addServiceList = addServiceList;
	}
	

}
