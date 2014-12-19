package cn.com.ubing.res.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hlvtech.ubing.common.constant.Constants;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dto.SaveAttachmentResponseDto;
import cn.com.ubing.res.service.ResAttachmentServiceI;

@Controller
@RequestMapping("/")
public class UploadAttachmentController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());

    @Autowired
    private ResAttachmentServiceI resAttachmentService;

    @RequestMapping("/uploadAttachment")
    public void saveAttachment(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response,
            RequestDto param) {
        try {
            // 构建返回参数对象
            SaveAttachmentResponseDto dto = buildResponse(SaveAttachmentResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                dto = resAttachmentService.saveAttachment(param, request,file);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new SaveAttachmentResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
