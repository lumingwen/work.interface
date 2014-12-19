package cn.com.ubing.pub.dto;
/**
 * 历史方案查看头部
 *  
 * @author 邱全松 2014-8-14 下午5:34:28
 */
public class PubPlanHistoryDto {
    private String title;// 标题
    private String price;// 报价
    private String childPrice;// 报价
    private String remark;// 特殊说明
    private String point;// 方案亮点
    private String startTime;//开始时间
    private String endTime;//结束时间
    
    private String crateTime;//方案创建时间
    
    private String userName;//用户名

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(String childPrice) {
        this.childPrice = childPrice;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public String getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(String crateTime) {
		this.crateTime = crateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
