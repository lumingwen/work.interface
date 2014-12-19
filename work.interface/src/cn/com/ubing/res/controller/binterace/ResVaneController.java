package cn.com.ubing.res.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.res.service.ResVaneServiceI;

import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * 风向标相关逻辑处理
 * 
 * @author 邱全松 2014-6-23 下午2:10:36
 */
@Controller
@RequestMapping("/")
public class ResVaneController extends BaseController {
    
    
    @Autowired
    private ResVaneServiceI resVaneService;
    
    
    /**
     * 获得风向标信息
     * @author 邱全松 2014-6-24 下午5:16:04
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/vane")
    public void vane(HttpServletRequest request, HttpServletResponse response, RequestDto param) {
	String str = resVaneService.generateFristLineAnalysisString(CommonUtils.parseLong(param.getUid()));
	System.out.println(str);
	outputSuccessReponse(response, new ResponseDto());
    }
}
