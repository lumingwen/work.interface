package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * c端头像设置请求dto
 *
 */
public class UserSetPhotoRequestDto extends RequestDto {
    private String imageId;//附件表ID

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
    
}
