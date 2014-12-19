package cn.com.ubing.res.dto;

import org.springframework.web.multipart.MultipartFile;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 文件保存请求dto
 * 
 * @author 邱全松 2014-6-30 上午11:49:35
 */
public class SaveAttachmentRequestDto extends RequestDto {
//    private String attachment;// 附件二进制字符串
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
//
//    public String getAttachment() {
//        return attachment;
//    }
//
//    public void setAttachment(String attachment) {
//        this.attachment = attachment;
//    }

}
