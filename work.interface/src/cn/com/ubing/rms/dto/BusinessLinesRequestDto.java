package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 商家经营线路获取请求dto
 * 
 * @author 邱全松 2014-7-15 下午1:48:59
 */
public class BusinessLinesRequestDto extends RequestDto {
    private String businessType;// 业务类型

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}
