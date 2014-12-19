package cn.com.ubing.res.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dao.ResAppSoftwareMapper;
import cn.com.ubing.res.dto.SystemVersion;

import com.hlvtech.ubing.common.constant.Constants;

@Controller
@RequestMapping("/")
public class SystemConfig  extends BaseController{
    @Autowired
    private ResAppSoftwareMapper resAppSoftwareMapper;
    private final Logger log = Logger.getLogger(getClass());
    @RequestMapping("/systemVersion")
    public void getResDict(HttpServletRequest request,HttpServletResponse response, RequestDto param){
        try {
            // 构建返回参数对象
            SystemVersion dto = buildResponse(SystemVersion.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if("ANDROID".equals(param.getUos())){
                dto = resAppSoftwareMapper.selectSystemVersion(1);
            }else if("IPHONE".equals(param.getUos())){
                dto = resAppSoftwareMapper.selectSystemVersion(2);
            }
            setCommonProperties(param, dto);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new SystemVersion(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
