package cn.com.ubing.pub.controller.cinterace;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlvtech.ubing.common.constant.Constants;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.pub.dto.CHistoryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.CUpdatePubPlanRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.OperationPlanRequestDto;
import cn.com.ubing.pub.dto.OperationPlanResponseDto;
import cn.com.ubing.pub.service.CPlanServiceI;
import cn.com.ubing.pub.service.PlanServiceI;

@Controller
public class PlanController extends BaseController{
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private CPlanServiceI cPlanService;
    
    @Autowired
    private PlanServiceI planService;
    
    @RequestMapping("/operationPlan")
    public void operationPlan(HttpServletRequest request, HttpServletResponse response, OperationPlanRequestDto param){
        try {
            // 构建返回参数对象
            OperationPlanResponseDto dto = buildResponse(OperationPlanResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                dto = cPlanService.operationPlan(param);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new OperationPlanResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 方案详细
     * @param request
     * @param response
     * @param param
     */

    @RequestMapping("/viewPlanDetail")
    public void viewPlanDetail(HttpServletRequest request, HttpServletResponse response, HistoryPlanDetailRequestDto param){
      //构建返回参数对象
    	CHistoryPlanDetailResponseDto dto = buildResponse(CHistoryPlanDetailResponseDto.class,param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            dto = planService.getHistoryCPlanDetail(param);
            outputSuccessReponse(response, dto);
        }
    }
    
    
    /**
     * 方案更新
     * @param request
     * @param response
     * @param param
     */

    @RequestMapping("/updatePubPlanById")
    public void updatePubPlanById(HttpServletRequest request, HttpServletResponse response, CUpdatePubPlanRequestDto param){
      //构建返回参数对象
		// 响应response
		ResponseDto dto = buildResponse(ResponseDto.class, param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            planService.updatePubPlanById(param);
            outputSuccessReponse(response, dto);
        }
    }
}
