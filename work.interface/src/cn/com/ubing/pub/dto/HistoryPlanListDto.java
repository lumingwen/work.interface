package cn.com.ubing.pub.dto;
/**
 * 历史方案列表
 *  
 * @author 邱全松 2014-8-14 下午2:39:26
 */
public class HistoryPlanListDto {
    private String planId;
    private String submitTime;
    private String price;
    private String childPrice;
    private String planTitle;
    private String planContent;
    private String planRelationId;
    private String planRelationTitle;
    private String planType;

    public String getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(String childPrice) {
        this.childPrice = childPrice;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
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

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }
    
}
