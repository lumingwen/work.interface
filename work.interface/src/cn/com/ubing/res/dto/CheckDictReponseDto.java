package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.ResponseDto;
/**
 * 字典当前版本号查询响应dto
 *  
 * @author 邱全松 2014-8-6 下午4:14:01
 */
public class CheckDictReponseDto extends ResponseDto{
    private String version;//字典当前版本号

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
}
