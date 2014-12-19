package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class SystemVersion extends ResponseDto{
    private String type;//类型(1:android,2:ios)
    private String version;//版本名
    private String versionCode;//版本号
    private String forceUpdateFlag;//强制升级(1:是,0:否)
    private String defaultFlag;//是否默认版本(1:是,0:否)
    private String url;//新版本下载地址
    private String appUrl;//IOS新版本下载地址
    
    public String getAppUrl() {
        return appUrl;
    }
    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public String getVersionCode() {
        return versionCode;
    }
    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getForceUpdateFlag() {
        return forceUpdateFlag;
    }
    public void setForceUpdateFlag(String forceUpdateFlag) {
        this.forceUpdateFlag = forceUpdateFlag;
    }
    public String getDefaultFlag() {
        return defaultFlag;
    }
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
}
