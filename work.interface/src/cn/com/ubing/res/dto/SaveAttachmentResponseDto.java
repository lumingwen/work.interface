package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 保存附件响应dto
 * 
 * @author 邱全松 2014-6-30 上午10:24:52
 */
public class SaveAttachmentResponseDto extends ResponseDto {
    private String attachmentId;// 附件ID
    private String oldName;// 附件原名
    private String savePath;// 附件保存地址

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

}
