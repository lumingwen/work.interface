package cn.com.ubing.res.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hlvtech.ubing.common.constant.Constants;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.FileUpload;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.res.dao.ResAttachmentMapper;
import cn.com.ubing.res.dto.SaveAttachmentResponseDto;
import cn.com.ubing.res.model.ResAttachment;
@Service("resAttachmentService")
public class ResAttachmentServiceImpl implements ResAttachmentServiceI {
    @Value(value = "${fileSavePath}")
    private String fileSavePath;
    @Autowired
    private ResAttachmentMapper resAttachmentMapper;
    
    @Value(value = "${imageAttachmentHostAddr}")
	private String imageAttachmentHostAddr;
    
    @Override
    public SaveAttachmentResponseDto saveAttachment(RequestDto param, HttpServletRequest request, MultipartFile file) {
        //保存附件信息至服务器，并在数据库中记录信息
        String savePath = FileUpload.upload(request, file, fileSavePath);
        ResAttachment  resAttachment = new ResAttachment();
        resAttachment.setCreateTime(new Date());
        resAttachment.setUpdateTime(new Date());
        resAttachment.setDeleteFlag(Constants.DEL_FLAG_NO);
        resAttachment.setOldName(file.getOriginalFilename());
        resAttachment.setSavePath(savePath);
        resAttachmentMapper.insert(resAttachment);
        //构造返回对象
        SaveAttachmentResponseDto res = new SaveAttachmentResponseDto();
        res.setAttachmentId(resAttachment.getId()+"");
        res.setOldName(resAttachment.getOldName());
        res.setSavePath(savePath);
        return res;
    }
	@Override
	public List<ResAttachment> getByRel(ResAttachment resAttachment) {
		return resAttachmentMapper.selectByRel(resAttachment);
	} 
	
	
	/**
	 * 查询附件完整的http路径
	 * @param id 附件id
	 * 
	 */
	public String getFullHttpUrl(Long id){
		if (id!=null){
			ResAttachment at = resAttachmentMapper.selectByPrimaryKey(id);
			if (at != null){
				String ext = imageAttachmentHostAddr.endsWith("/")?"":"/";
				return imageAttachmentHostAddr+ext+at.getSavePath();
			}
		}
		return "";
	}
	
	/**
	 * 查询附件完整的http路径
	 * @param savePath 附件相对路径
	 * 
	 */
	public String getFullHttpUrl(String savePath){
		if (StringUtils.isNotBlank(savePath)){
			String ext = imageAttachmentHostAddr.endsWith("/")?"":"/";
			return imageAttachmentHostAddr+ext+savePath;
		}
		return "";
	}
	
}
