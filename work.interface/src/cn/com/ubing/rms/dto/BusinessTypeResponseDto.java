package cn.com.ubing.rms.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 商家业务类型信息dto
 * 
 * @author 邱全松 2014-7-15 下午1:39:49
 */
public class BusinessTypeResponseDto extends ResponseDto {
    
    private List<RmsUserBusinessTypeDto> types;// 商家业务类型

    public List<RmsUserBusinessTypeDto> getTypes() {
        return types;
    }

    public void setTypes(List<RmsUserBusinessTypeDto> types) {
        this.types = types;
    }
    

}
