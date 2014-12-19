package cn.com.ubing.rms.controller.binterace;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.rms.dto.BusinessLinesRequestDto;
import cn.com.ubing.rms.dto.BusinessLinesResponseDto;
import cn.com.ubing.rms.dto.BusinessTypeAndLinesRequestDto;
import cn.com.ubing.rms.dto.BusinessTypeResponseDto;
import cn.com.ubing.rms.service.RmsUserBusinessTypeServiceI;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * 商家主营业务及相关经验线路设置
 * 
 * @author 邱全松 2014-7-15 上午10:55:45
 */
@Controller
@RequestMapping("/")
public class BRmsUserBusinessTypeController extends BaseController {

    /**
     * 经营类型 service
     */
    @Autowired
    private RmsUserBusinessTypeServiceI rmsUserBusinessTypeService;
    private final Logger log = Logger.getLogger(getClass());

    /**
     * 商家主营业务和经营线路信息保存
     * 
     * @author 邱全松 2014-7-15 上午10:56:08
     * @param request
     * @param response
     * @param param
     * @throws IOException
     */
    @RequestMapping("/saveBusinessTypeAndLines")
    public void saveBusinessTypeAndLines(HttpServletRequest request, HttpServletResponse response, BusinessTypeAndLinesRequestDto param) {
        try {
            // 响应response
            ResponseDto dto = buildResponse(ResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            rmsUserBusinessTypeService.saveOrUpdateBusinessTypeAndLines(param);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 获取用户主营业务类型信息
     * 
     * @author 邱全松 2014-7-15 下午1:29:11
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/getBusinessTypes")
    public void getBusinessTypes(HttpServletRequest request, HttpServletResponse response, RequestDto param) {
        try {
            // 响应response
            BusinessTypeResponseDto dto = buildResponse(BusinessTypeResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            dto.setTypes(rmsUserBusinessTypeService.getBusinessTypeByUser(CommonUtils.parseLong(param.getUid())));
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 获取用户运营线路信息
     * 
     * @author 邱全松 2014-7-15 下午1:29:39
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/getlines")
    public void getlines(HttpServletRequest request, HttpServletResponse response, BusinessLinesRequestDto param) {
        try {
            // 响应response
            BusinessLinesResponseDto dto = buildResponse(BusinessLinesResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            dto.setLineList(rmsUserBusinessTypeService.getLinesDtoByUser(CommonUtils.parseLong(param.getUid()), CommonUtils.parseInteger(param.getBusinessType())));
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
