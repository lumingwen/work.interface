package cn.com.ubing.rms.dto;

public class CMainFocusDto {
    private String type;//1尾单 2活动
    private String url;//图片链接
    private String lastGoodsId;//是尾单时，尾单ID
    private String skipUrl;//是活动时跳转的页面

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLastGoodsId() {
        return lastGoodsId;
    }

    public void setLastGoodsId(String lastGoodsId) {
        this.lastGoodsId = lastGoodsId;
    }

    public String getSkipUrl() {
        return skipUrl;
    }

    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

}
