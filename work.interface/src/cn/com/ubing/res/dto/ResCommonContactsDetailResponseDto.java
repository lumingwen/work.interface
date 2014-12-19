package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.ResponseDto;

public class ResCommonContactsDetailResponseDto extends ResponseDto {
    private String contactId;
    private String name;
    private String certificateTypeId;
    private String certificateTypeName;
    private String certificateCode;
    private String tel;
    public String getContactId() {
        return contactId;
    }
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCertificateTypeId() {
        return certificateTypeId;
    }
    public void setCertificateTypeId(String certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }
    public String getCertificateTypeName() {
        return certificateTypeName;
    }
    public void setCertificateTypeName(String certificateTypeName) {
        this.certificateTypeName = certificateTypeName;
    }
    public String getCertificateCode() {
        return certificateCode;
    }
    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
}
