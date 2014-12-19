/**
 * 
 */
package cn.com.ubing.res.dto;


/**
 * 风向标详细信息dto(经营线路分析)
 * @author zhangxujun
 * 
 *
 */
public class VaneLineAnalysisDto {
    
    /**
     * 排名
     */
    private Integer rank;

    /**
     * 线路名称
     */
    private String lineName;

    /**
     * 上月同期总数
     */
    private Integer lastMonthCount;

    /**
     * 当月同期总数
     */
    private Integer currentMonthCount;
    
    /**
     * 增长百分比
     */
    private String addPercent;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Integer getLastMonthCount() {
        return lastMonthCount;
    }

    public void setLastMonthCount(Integer lastMonthCount) {
        this.lastMonthCount = lastMonthCount;
    }

    public Integer getCurrentMonthCount() {
        return currentMonthCount;
    }

    public void setCurrentMonthCount(Integer currentMonthCount) {
        this.currentMonthCount = currentMonthCount;
    }

    public String getAddPercent() {
        return addPercent;
    }

    public void setAddPercent(String addPercent) {
        this.addPercent = addPercent;
    }
    
    
    

}
