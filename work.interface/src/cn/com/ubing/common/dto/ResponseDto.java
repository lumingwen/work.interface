/**
 * 
 */
package cn.com.ubing.common.dto;

import com.hlvtech.ubing.common.constant.Constants;



/**
 * 公共响应头
 * @author zhangxujun
 * 
 *
 */
public  class ResponseDto {

    
    /**
     * 设备号
     */
    private String deviceID;
    
    /**
     * 用户ID
     */
    private String uid;
    
    
    /**
     * 加密字符串
     */
    private String token;
    
    
    /**
     * 返回码
     */
    private String resultCode = Constants.RESULT_CODE_SUCCESS;
    
    /**
     * 如果出错，返回错误信息
     */
    private String resultInfo = "操作成功";
    

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }
    
    
    
}
