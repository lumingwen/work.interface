package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 用户机构认证请求dto
 * 
 * @author 邱全松 2014-6-26 下午4:14:54
 */
public class BusinessCompanyCheckRequestDto extends RequestDto{
    private String checkId;//认证表ID
    private String companyName;// 公司名
    private String photoId;// 附件图片ID

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

}
