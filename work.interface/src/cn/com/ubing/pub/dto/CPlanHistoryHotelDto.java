package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.res.model.ResAttachment;

public class CPlanHistoryHotelDto {
	
    private String id;//产品id
	
	private String address;//酒店地址
	
	private String roomType;//房型
	
	private String bedType;//床型(关联字典表)
	
	private String imageId;//酒店主图(关联附件表id)
	
	private List<ResAttachment> attachmentList;
	
    private List<PubPlanHistoryHotelServiceDto> serviceList;// 服务列表

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public List<PubPlanHistoryHotelServiceDto> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<PubPlanHistoryHotelServiceDto> serviceList) {
		this.serviceList = serviceList;
	}

	public List<ResAttachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<ResAttachment> attachmentList) {
		this.attachmentList = attachmentList;
	}
	
}
