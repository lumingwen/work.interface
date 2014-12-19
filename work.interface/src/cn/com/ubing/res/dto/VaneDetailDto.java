/**
 * 
 */
package cn.com.ubing.res.dto;

/**
 * 风向标详细信息dto(热门搜索/热门城市)
 * @author zhangxujun
 * 
 *
 */
public class VaneDetailDto {
    
    /**
     * 排名
     */
    private Integer rank;
    
    /**
     * 名称
     */
    private String name;

    
    /**
     * 总数
     */
    private Integer cnt;


    public Integer getRank() {
        return rank;
    }


    public void setRank(Integer rank) {
        this.rank = rank;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Integer getCnt() {
        return cnt;
    }


    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
    
}
