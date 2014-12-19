package cn.com.ubing.res.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dto.SaveAttachmentResponseDto;
import cn.com.ubing.res.model.ResAttachment;

public interface ResAttachmentServiceI {
    /**
     * （B端）保存附件
     * 
     * @author 邱全松 2014-6-30 上午10:50:49
     * @param param
     * @return
     */
//    public SaveAttachmentResponseDto saveAttachment(SaveAttachmentRequestDto param,HttpServletRequest request);
    public SaveAttachmentResponseDto saveAttachment(RequestDto param,HttpServletRequest request, MultipartFile file);
    
    
	/**
	 * (c端)查询图片
	 * 根据关联关系获得附件信息 关联关系：关联类型，关联ID
	 * 
	 * @param resAttachment
	 * @return
	 */
	public List<ResAttachment> getByRel(ResAttachment resAttachment);
	
	/**
	 * 查询附件完整的http路径
	 * @param id 附件id
	 * 
	 */
	String getFullHttpUrl(Long id);
	
	/**
	 * 查询附件完整的http路径
	 * @param savePath 附件相对路径
	 * 
	 */
	String getFullHttpUrl(String savePath);
}
