package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

public class RealNameCheckRequestDto extends RequestDto {
    private String checkId;// 认证表ID
    private String name;// 姓名
    private String idNumber;// 身份证号码
    private String photoId;// 正面照片
    private String antiPhotoId;// 反面照片

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
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

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getAntiPhotoId() {
        return antiPhotoId;
    }

    public void setAntiPhotoId(String antiPhotoId) {
        this.antiPhotoId = antiPhotoId;
    }

}
