package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 商家业务类型及线路设置请求dto
 *  
 * @author 邱全松 2014-7-15 上午10:54:31
 */
public class BusinessTypeAndLinesRequestDto extends RequestDto{
    private String lineIds;//线路id串
    private String businessType;//经营业务类型
    public String getLineIds() {
        return lineIds;
    }
    public void setLineIds(String lineIds) {
        this.lineIds = lineIds;
    }
    public String getBusinessType() {
        return businessType;
    }
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    
}
