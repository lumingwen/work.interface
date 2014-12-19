package cn.com.ubing.pub.model;
import java.util.Date;
/**
 * 机票方案
 * @author jokiye
 *
 */
public class PubPlanHistoryTicket {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteFlag;

    private String leaveLocation;

    private String reachLocation;

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

    public String getLeaveLocation() {
        return leaveLocation;
    }

    public void setLeaveLocation(String leaveLocation) {
        this.leaveLocation = leaveLocation == null ? null : leaveLocation.trim();
    }

    public String getReachLocation() {
        return reachLocation;
    }

    public void setReachLocation(String reachLocation) {
        this.reachLocation = reachLocation == null ? null : reachLocation.trim();
    }
}