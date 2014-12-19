package cn.com.ubing.res.dto;
/**
 * 尾单行程说明
 *  
 * @author 邱全松 2014-11-20 上午11:19:32
 */
public class ResLastGoodsTripDto {
    private String dayOfTrip;//第几天
    private String title;//标题
    private String description;//说明
    public String getDayOfTrip() {
        return dayOfTrip;
    }
    public void setDayOfTrip(String dayOfTrip) {
        this.dayOfTrip = dayOfTrip;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
