package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

public class ResCouponListRequestDto extends RequestDto{
    private String limit;// 每页显示条数
    private String page;// 当前第几页
    private String useStatus;//0未使用 1已使用 2已过期
    private String requirementType;//用于选择优惠卷
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
    public String getUseStatus() {
        return useStatus;
    }
    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }
    public String getRequirementType() {
        return requirementType;
    }
    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }
    
}
