package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class CPubOrderOperationResponseDto extends ResponseDto {
    private String resultMessage;

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

}
