package cn.com.ubing.pub.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.pub.dto.LibraryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.LibraryPlanListRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanListResponseDto;
import cn.com.ubing.pub.service.PlanServiceI;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hlvtech.ubing.common.constant.Constants;
/**
 * 方案库信息
 *  
 * @author 邱全松 2014-8-14 上午11:07:34
 */
@Controller
@RequestMapping("/")
public class LibraryPlanController extends BaseController {
    @Autowired
    private PlanServiceI planService;
    
    /**
     * 方案庫方案列表
     * 
     * @author 邱全松 2014-8-14 上午11:08:01
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/libraryPlanList")
    public void libraryPlanList(HttpServletRequest request, HttpServletResponse response, LibraryPlanListRequestDto param,PageBounds pageBounds){
      //构建返回参数对象
        LibraryPlanListResponseDto dto = buildResponse(LibraryPlanListResponseDto.class,param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            dto.setRequirementId(param.getRequirementId());
            dto.setPlanList(planService.queryLibraryPlanList(param,pageBounds));
            outputSuccessReponse(response, dto);
        }
    }
    /**
     * 方案庫方案詳情
     * 
     * @author 邱全松 2014-8-14 上午11:08:01
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/libraryPlanDetail")
    public void libraryPlanDetail(HttpServletRequest request, HttpServletResponse response, LibraryPlanDetailRequestDto param){
      //构建返回参数对象
        LibraryPlanDetailResponseDto dto = buildResponse(LibraryPlanDetailResponseDto.class,param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            dto.setRequirementId(param.getRequirementId());
            dto = planService.getLibraryPlanDetail(param);
            outputSuccessReponse(response, dto);
        }
    }
}
