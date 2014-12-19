package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class BusinessUserInfoResponseDto extends ResponseDto {
    private String realNameCheckStatus;// 实名认证状态
    private String nickname;// 昵称/姓名
    private String rankPercentage;// 积分排名百分比
    private String score;// 积分/竞争力
    private String endScore;// 升级需要的分数
    private String scoreLevel;// 竞争力等级
    private String presetTime;// 增加的抢单时间
    private String companyCheckStatus;// 机构认证状态
    private String businessTypeStatus;// 主营业务是否设置
    private String photoUrl;// 头像地址
    private String companyName;// 公司名称
    private String businessTypes;// 经营类型

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(String businessTypes) {
        this.businessTypes = businessTypes;
    }

    public String getRealNameCheckStatus() {
        return realNameCheckStatus;
    }

    public void setRealNameCheckStatus(String realNameCheckStatus) {
        this.realNameCheckStatus = realNameCheckStatus;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRankPercentage() {
        return rankPercentage;
    }

    public void setRankPercentage(String rankPercentage) {
        this.rankPercentage = rankPercentage;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getEndScore() {
        return endScore;
    }

    public void setEndScore(String endScore) {
        this.endScore = endScore;
    }

    public String getScoreLevel() {
        return scoreLevel;
    }

    public void setScoreLevel(String scoreLevel) {
        this.scoreLevel = scoreLevel;
    }

    public String getPresetTime() {
        return presetTime;
    }

    public void setPresetTime(String presetTime) {
        this.presetTime = presetTime;
    }

    public String getCompanyCheckStatus() {
        return companyCheckStatus;
    }

    public void setCompanyCheckStatus(String companyCheckStatus) {
        this.companyCheckStatus = companyCheckStatus;
    }

    public String getBusinessTypeStatus() {
        return businessTypeStatus;
    }

    public void setBusinessTypeStatus(String businessTypeStatus) {
        this.businessTypeStatus = businessTypeStatus;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
