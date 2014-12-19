package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.RequestDto;
/**
 * 商家头像设置请求dto
 * @author 邱全松 2014-6-26 下午3:42:43
 */
public class BusinessUserSetPhotoRequestDto extends RequestDto {
    private String imageId;//附件表ID

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
    
}
