package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * B端方案库方案详情请求dto
 * 
 * @author 邱全松 2014-6-25 下午2:46:15
 */
public class LibraryPlanDetailRequestDto extends RequestDto {
    private String requirementId;//需求id 用于选择
    private String id;// 方案ID
    private String type;//方案类型

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
