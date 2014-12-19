package cn.com.ubing.rms.controller.cinterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlvtech.ubing.common.constant.Constants;
import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dto.ResCommonContactsListResponseDto;
import cn.com.ubing.rms.dto.CMainViewResponseDto;
import cn.com.ubing.rms.service.CMainViewServiceI;

@Controller
@RequestMapping("/")
public class CMainViewController extends BaseController {
    private static Logger log = Logger.getLogger(CMainViewController.class);
    @Autowired
    private CMainViewServiceI cMainViewService;

    @RequestMapping("/getMainViewInfo")
    public void getMainViewInfo(HttpServletRequest request, HttpServletResponse response, RequestDto param) {
        try {
            // 构建返回参数对象
            CMainViewResponseDto dto = buildResponse(CMainViewResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // 查询及封装
            dto = cMainViewService.getMainViewDto(param);
            setCommonProperties(param, dto);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResCommonContactsListResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
