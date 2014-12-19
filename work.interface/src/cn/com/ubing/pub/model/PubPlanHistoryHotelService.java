package cn.com.ubing.pub.model;



import java.util.Date;
/**
 * 酒店方案提供服务
 * @author lumw
 *
 */
public class PubPlanHistoryHotelService {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private Long pubHistoryHotelId;

    private Long serviceId;

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

    public Long getPubHistoryHotelId() {
        return pubHistoryHotelId;
    }

    public void setPubHistoryHotelId(Long pubHistoryHotelId) {
        this.pubHistoryHotelId = pubHistoryHotelId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
}