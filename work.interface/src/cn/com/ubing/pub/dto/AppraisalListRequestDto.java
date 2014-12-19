package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 评价信息列表查看请求dto
 *  
 * @author 邱全松 2014-6-27 下午1:47:05
 */
public class AppraisalListRequestDto extends RequestDto {
    private String planStatus;// 方案状态

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

}
