package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 公司认证信息查询响应dto
 * 
 * @author 邱全松 2014-6-26 下午6:14:54
 */
public class CompanyCheckInfoResponseDto extends ResponseDto {
    private String checkId;// 认证ID
    private String checkStatus;// 认证状态
    private String companyName;// 公司名
    private String photoUrl;// 图片地址

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

}
