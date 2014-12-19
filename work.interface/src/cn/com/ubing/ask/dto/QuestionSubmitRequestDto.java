/**
 * 
 */
package cn.com.ubing.ask.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 提问提交dto
 * @author zhangxujun
 * 
 *
 */
public class QuestionSubmitRequestDto extends RequestDto{
    
    
    /**
     * 目的地id
     */
    private String targetRegionId;
    
    /**
     * 问题说明
     */
    private String content;

    

    public String getTargetRegionId() {
        return targetRegionId;
    }

    public void setTargetRegionId(String targetRegionId) {
        this.targetRegionId = targetRegionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
