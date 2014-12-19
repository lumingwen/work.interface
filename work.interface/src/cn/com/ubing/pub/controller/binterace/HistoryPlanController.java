package cn.com.ubing.pub.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.pub.dto.GetCouponStrRequestDto;
import cn.com.ubing.pub.dto.GetCouponStrResponseDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.HistoryPlanListRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanListResponseDto;
import cn.com.ubing.pub.dto.SavePlanRequestDto;
import cn.com.ubing.pub.dto.SavePlanResponseDto;
import cn.com.ubing.pub.service.PlanServiceI;
import cn.com.ubing.rms.dto.UserLoginResponseDto;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;
/**
 * 历史方案信息
 *  
 * @author 邱全松 2014-8-14 上午11:07:34
 */
@Controller
@RequestMapping("/")
public class HistoryPlanController extends BaseController {
    
    
    
    /**
     * log日志
     */
    private final Logger log = Logger.getLogger(getClass());
    
    @Autowired
    private PlanServiceI planService;
    
    /**
     * 历史方案列表
     * 
     * @author 邱全松 2014-8-14 上午11:08:01
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/historyPlanList")
    public void historyPlanList(HttpServletRequest request, HttpServletResponse response, HistoryPlanListRequestDto param,PageBounds pageBounds){
      //构建返回参数对象
        HistoryPlanListResponseDto dto = buildResponse(HistoryPlanListResponseDto.class,param);
        pageBounds.getOrders().add(new Order("submit_time", Direction.DESC, ""));
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            dto.setRequirementId(param.getRequirementId());
            dto.setPlanList(planService.queryHistoryPlanList(param,pageBounds));
            outputSuccessReponse(response, dto);
        }
    }
    /**
     * 历史方案详情
     * 
     * @author 邱全松 2014-8-14 上午11:08:01
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/historyPlanDetail")
    public void historyPlanDetail(HttpServletRequest request, HttpServletResponse response, HistoryPlanDetailRequestDto param){
      //构建返回参数对象
        HistoryPlanDetailResponseDto dto = buildResponse(HistoryPlanDetailResponseDto.class,param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            dto = planService.getHistoryPlanDetail(param);
            outputSuccessReponse(response, dto);
        }
    }
    /**
     * 方案保存
     * 
     * @author 邱全松 2014-8-14 上午11:08:01
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/savePlan")
    public void savePlan(HttpServletRequest request, HttpServletResponse response, SavePlanRequestDto param){
      //构建返回参数对象
        SavePlanResponseDto dto = buildResponse(SavePlanResponseDto.class,param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            planService.savePlan(param);
            outputSuccessReponse(response, dto);
        }
    }
    
    /**
     * 
     * 根据需求类型和需求id查询优惠券字符串
     */
    @RequestMapping("/getCouponStrBeforePubplan")
    public void getCouponStrBeforePubplan(HttpServletRequest request, HttpServletResponse response,GetCouponStrRequestDto param){
	try {
            // 响应response
	    GetCouponStrResponseDto dto = buildResponse(GetCouponStrResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户id不能为空");
                return;
            }
            //提交
            String couponstr = planService.getCouponStr(CommonUtils.parseInteger(param.getRequirementType()), CommonUtils.parseLong(param.getRequirementId()));
            dto.setCouponstr(couponstr);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
