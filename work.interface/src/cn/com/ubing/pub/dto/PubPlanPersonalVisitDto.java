package cn.com.ubing.pub.dto;

import java.util.List;

/**
 * 自由行方案Dto
 *  
 * @author 邱全松 2014-9-2 上午9:54:08
 */
public class PubPlanPersonalVisitDto {
    private String id;//产品id
    private String name;// 产品名称
    private String days;// 行程天数
    private String nights;// 入住晚数
    private String leaveLocationId;// 出发地,关联字典表
    private String leaveLocationName;// 出发地
    private String type;// 1:国内游,2:境外游,3:港澳台
    private String typeName;// 1:国内游,2:境外游,3:港澳台
    private String trafficLeaveId;// 去交通方式,关联字典表
    private String trafficLeaveName;// 去交通方式
    private String trafficReachId;// 返回交通方式,关联字典表
    private String trafficReachName;// 返回交通方式
    private String feeRemark;// 费用说明
    private String imageId;// 主图ID
    private String imageUrl;// 主图ID
    private String introduction;// 行程简介
    private String remark;// 其他说明
    private List<PubPlanServiceDto> serviceList;// 服务列表
    private List<PubPlanDestinationDto> destinationList;// 目的地列表
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDays() {
        return days;
    }
    public void setDays(String days) {
        this.days = days;
    }
    public String getNights() {
        return nights;
    }
    public void setNights(String nights) {
        this.nights = nights;
    }
    public String getLeaveLocationId() {
        return leaveLocationId;
    }
    public void setLeaveLocationId(String leaveLocationId) {
        this.leaveLocationId = leaveLocationId;
    }
    public String getLeaveLocationName() {
        return leaveLocationName;
    }
    public void setLeaveLocationName(String leaveLocationName) {
        this.leaveLocationName = leaveLocationName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public String getTrafficLeaveId() {
        return trafficLeaveId;
    }
    public void setTrafficLeaveId(String trafficLeaveId) {
        this.trafficLeaveId = trafficLeaveId;
    }
    public String getTrafficLeaveName() {
        return trafficLeaveName;
    }
    public void setTrafficLeaveName(String trafficLeaveName) {
        this.trafficLeaveName = trafficLeaveName;
    }
    public String getTrafficReachId() {
        return trafficReachId;
    }
    public void setTrafficReachId(String trafficReachId) {
        this.trafficReachId = trafficReachId;
    }
    public String getTrafficReachName() {
        return trafficReachName;
    }
    public void setTrafficReachName(String trafficReachName) {
        this.trafficReachName = trafficReachName;
    }
    public String getFeeRemark() {
        return feeRemark;
    }
    public void setFeeRemark(String feeRemark) {
        this.feeRemark = feeRemark;
    }
    public String getImageId() {
        return imageId;
    }
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public List<PubPlanServiceDto> getServiceList() {
        return serviceList;
    }
    public void setServiceList(List<PubPlanServiceDto> serviceList) {
        this.serviceList = serviceList;
    }
    public List<PubPlanDestinationDto> getDestinationList() {
        return destinationList;
    }
    public void setDestinationList(List<PubPlanDestinationDto> destinationList) {
        this.destinationList = destinationList;
    }
}
