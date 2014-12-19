package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

public class ResCommonContactsDetailRequestDto extends RequestDto{
    private String contactId;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
