package cn.com.ubing.ask.dto;

import cn.com.ubing.common.dto.RequestDto;


/**
 * 
 * 提问列表请求dto
 * @author zhangxujun
 * 
 *
 */

public class QuestionListRequestDto extends RequestDto {
    
    /**
     * 每页显示条数
     */
    private String limit;
    
    /**
     * 当前第几页
     */
    private String page; 
    
    /**
     * 列表类型,1:待解决,2:已解决,3:网友在问
     */
    private String type;
    
    
    /**
     * 目的地名称
     */
    private String targetRegionName;


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getTargetRegionName() {
        return targetRegionName;
    }


    public void setTargetRegionName(String targetRegionName) {
        this.targetRegionName = targetRegionName;
    }


    public String getLimit() {
        return limit;
    }


    public void setLimit(String limit) {
        this.limit = limit;
    }


    public String getPage() {
        return page;
    }


    public void setPage(String page) {
        this.page = page;
    }
    
    
    

}
