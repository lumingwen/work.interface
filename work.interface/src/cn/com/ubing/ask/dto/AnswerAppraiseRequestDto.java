/**
 * 
 */
package cn.com.ubing.ask.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 回答评价
 * @author zhangxujun
 * 
 *
 */
public class AnswerAppraiseRequestDto extends RequestDto {

    /**
     * 回答id
     */
    private String id;
    
    
    /**
     * 评价(1:最佳,2:有用,3:无用)
     */
    private String appraise;


    


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getAppraise() {
        return appraise;
    }


    public void setAppraise(String appraise) {
        this.appraise = appraise;
    }
    
    
    
    
}
