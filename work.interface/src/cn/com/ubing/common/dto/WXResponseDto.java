package cn.com.ubing.common.dto;

public class WXResponseDto {
    /**
     * 是否成功
     */
    private boolean success;
    
    
    /**
     * 提示信息
     */
    private String message;

    
    /**
     * 数据
     */
    private String data;


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }


    public String getData() {
        return data;
    }


    public void setData(String data) {
        this.data = data;
    }
}
