package cn.com.ubing.pub.dto;
/**
 * 方案库方案列表信息
 *  
 * @author 邱全松 2014-8-14 下午6:17:35
 */
public class LibraryPlanListDto {
    private String planId;//方案ID
    private String planType;//方案类型
    private String name;//标题
    private String days;//行程天数
    private String nights;//入住晚数
    private String introduction;//行程简介
    
    public String getPlanType() {
        return planType;
    }
    public void setPlanType(String planType) {
        this.planType = planType;
    }
    public String getPlanId() {
        return planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
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
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
