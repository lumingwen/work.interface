/**
 * 
 */
package cn.com.ubing.common.dto;

/**
 * 公共请求头
 * @author zhangxujun
 * 
 *
 */
public  class RequestDto {

    
    /**
     * 设备号
     */
    private String deviceID;
    
    /**
     * 终端类型
     */
    private String uos;
    
    /**
     * 客户端版本号
     */
    private String version;
    
    /**
     * 接口版本
     */
    private String interfaceVersion;
    
    /**
     * 用户ID
     */
    private String uid;
    
    /**
     * 分辨率
     */
    private String screen;
    
    /**
     * 渠道编号
     */
    private String source;
    
    /**
     * 手机型号
     */
    private String userAgent;
    
    /**
     * 地图类型
     */
    private String mapType;
    
    /**
     * 地图版本号
     */
    private String mapVersion;
    
    /**
     * 加密字符串
     */
    private String token;
    
    /**
     * 时间戳
     */
    private String time;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getUos() {
        return uos;
    }

    public void setUos(String uos) {
        this.uos = uos;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getMapType() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType = mapType;
    }

    public String getMapVersion() {
        return mapVersion;
    }

    public void setMapVersion(String mapVersion) {
        this.mapVersion = mapVersion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    
}
