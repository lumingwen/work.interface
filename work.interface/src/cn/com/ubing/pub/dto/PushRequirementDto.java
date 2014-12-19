/**
 * 
 */
package cn.com.ubing.pub.dto;

/**
 * 需求推送dto
 * @author zhangxujun
 * 
 *
 */
public class PushRequirementDto {
    
    /**
     * 需求类型
     */
    private Integer requirementType;
    
    /**
     * 需求id
     */
    private Long requirementId;
    
    /**
     * 推送用户id,多个以逗号分隔
     */
    private String result;

    public Integer getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(Integer requirementType) {
        this.requirementType = requirementType;
    }

    public Long getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Long requirementId) {
        this.requirementId = requirementId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
