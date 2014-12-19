package cn.com.ubing.res.controller.cinterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlvtech.ubing.common.constant.Constants;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.res.dto.ResDictExpandRequestDto;
import cn.com.ubing.res.dto.ResDictExpandResponseDto;
import cn.com.ubing.res.dto.ResDictRequestDto;
import cn.com.ubing.res.dto.ResDictResponseDto;
import cn.com.ubing.res.service.ResDictServiceI;
@Controller
@RequestMapping("/")
public class ResDictController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private ResDictServiceI resDictService;
    @RequestMapping("/getDictByType")
    public void GetDictByType(HttpServletRequest request, HttpServletResponse response, ResDictRequestDto param) {
        try {
            // 构建返回参数对象
            ResDictResponseDto dto = buildResponse(ResDictResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            dto = resDictService.GetDictByType(param);
            setCommonProperties(param, dto);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResDictResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    @RequestMapping("/GetDictExpandByType")
    public void GetDictExpandByType(HttpServletRequest request, HttpServletResponse response, ResDictExpandRequestDto param) {
        try {
            // 构建返回参数对象
            ResDictExpandResponseDto dto = buildResponse(ResDictExpandResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            dto.setDictList(resDictService.queryDictExpandDtoList(param));
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResDictResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
