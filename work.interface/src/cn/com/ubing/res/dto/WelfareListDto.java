package cn.com.ubing.res.dto;

public class WelfareListDto {
    private String welfareId;// 尾单id
    private String welfareType;// 活动类型，尾单1
    private String imageUrl;// 图片地址
    private String welfareTitle;// 活动标题
    private String welfareUrl;// 活动url

    public String getWelfareId() {
        return welfareId;
    }

    public void setWelfareId(String welfareId) {
        this.welfareId = welfareId;
    }

    public String getWelfareType() {
        return welfareType;
    }

    public void setWelfareType(String welfareType) {
        this.welfareType = welfareType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWelfareTitle() {
        return welfareTitle;
    }

    public void setWelfareTitle(String welfareTitle) {
        this.welfareTitle = welfareTitle;
    }

    public String getWelfareUrl() {
        return welfareUrl;
    }

    public void setWelfareUrl(String welfareUrl) {
        this.welfareUrl = welfareUrl;
    }

}
