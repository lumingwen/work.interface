package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 商家实名认证响应Dto
 * 
 * @author 邱全松 2014-6-26 下午6:15:13
 */
public class RealNameCheckResponseDto extends ResponseDto {
    private String checkId;// 认证ID
    private String checkStatus;// 认证状态 0未通过，1待审核，2已认证
    private String name;// 用户姓名
    private String idNumber;// 身份证号码
    private String photoUrl;// 正面图片地址
    private String antiPhotoUrl;// 反面图片地址

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAntiPhotoUrl() {
        return antiPhotoUrl;
    }

    public void setAntiPhotoUrl(String antiPhotoUrl) {
        this.antiPhotoUrl = antiPhotoUrl;
    }

}
