package cn.com.ubing.res.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.res.dto.CheckDictReponseDto;
import cn.com.ubing.res.dto.CheckDictRequestDto;
import cn.com.ubing.res.dto.ResDictRequestDto;
import cn.com.ubing.res.dto.ResDictResponseDto;
import cn.com.ubing.res.model.ResSystemProperties;
import cn.com.ubing.res.service.ResDictServiceI;
import cn.com.ubing.res.service.ResSystemPropertiesServiceI;

import com.hlvtech.ubing.common.constant.Constants;

@Controller
@RequestMapping("/")
public class getDictController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private ResDictServiceI resDictService;
    @Autowired
    private ResSystemPropertiesServiceI resSystemPropertiesService;
    @RequestMapping("/getResDict")
    public void getResDict(HttpServletRequest request, HttpServletResponse response, ResDictRequestDto param){
        try {
            // 构建返回参数对象
            ResDictResponseDto dto = buildResponse(ResDictResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            dto.setDictList(resDictService.listAllDictDtoByType(param.getType()));
            setCommonProperties(param, dto);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResDictResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    @RequestMapping("/checkDict")
    public void checkDict(HttpServletRequest request, HttpServletResponse response, CheckDictRequestDto param){
        try {
            // 构建返回参数对象
            CheckDictReponseDto dto = buildResponse(CheckDictReponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
                ResSystemProperties sysp = resSystemPropertiesService.selectByKey("SYSTEM_PRO_COMPOSITE_RES_DICT_VESION");
                if(sysp!=null&&sysp.getPropValue()!=null){
                    dto.setVersion(sysp.getPropValue());
                }else{
                    dto.setVersion("2");
                }                
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResDictResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
