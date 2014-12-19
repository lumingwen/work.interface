package cn.com.ubing.ask.dto;

import cn.com.ubing.common.dto.ResponseDto;


/**
 * 提问响应dto
 * @author zhangxujun
 * 
 *
 */
public class QuestionSubmitResponseDto extends ResponseDto {
    
    /**
     * 推送成功数量
     */
    private String pushCount;

    public String getPushCount() {
        return pushCount;
    }

    public void setPushCount(String pushCount) {
        this.pushCount = pushCount;
    }
    
    
    

}
