package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * I 字典版本号检查请求dto
 * 
 * @author 邱全松 2014-8-6 下午3:53:56
 */
public class CheckDictRequestDto extends RequestDto {
    private String type;// 字典类型：1境外，2境内

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
