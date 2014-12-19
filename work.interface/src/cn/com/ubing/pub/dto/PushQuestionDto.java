/**
 * 
 */
package cn.com.ubing.pub.dto;

/**
 * 问题推送dto
 * @author zhangxujun
 * 
 *
 */
public class PushQuestionDto {
  
    
    /**
     * 提问id
     */
    private Long questionId;
    
    /**
     * 推送用户id,多个以逗号分隔
     */
    private String result;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    

}
