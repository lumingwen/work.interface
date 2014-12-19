/**
 * 
 */
package cn.com.ubing.msg.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 修改吆喝请求dto
 * @author zhangxujun
 * 
 *
 */
public class ModifySignatureRequestDto extends RequestDto {

    /**
     * 吆喝
     */
    private String signature;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    
    
    
}
