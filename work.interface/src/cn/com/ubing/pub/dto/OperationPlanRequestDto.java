package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

public class OperationPlanRequestDto extends RequestDto{
    private String planId;
    private String operationParam;//0拒绝 1同意 2私信他
    public String getPlanId() {
        return planId;
    }
    public void setPlanId(String planId) {
        this.planId = planId;
    }
    public String getOperationParam() {
        return operationParam;
    }
    public void setOperationParam(String operationParam) {
        this.operationParam = operationParam;
    }
    
}
