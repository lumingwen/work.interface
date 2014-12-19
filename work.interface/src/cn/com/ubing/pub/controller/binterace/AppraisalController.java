package cn.com.ubing.pub.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.hlvtech.ubing.common.constant.Constants;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.pub.dto.AppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.AppraisalDetailResponseDto;
import cn.com.ubing.pub.dto.AppraisalListRequestDto;
import cn.com.ubing.pub.dto.AppraisalListResponseDto;
import cn.com.ubing.pub.dto.AppraisalSaveRequestDto;
import cn.com.ubing.pub.service.AppraisalServiceI;
/**
 * 评价信息
 *  
 * @author 邱全松 2014-8-14 上午11:07:34
 */
@Controller
@RequestMapping("/")
public class AppraisalController extends BaseController {
    @Autowired
    private AppraisalServiceI appraisalService;
    
    /**
     * 评价信息列表
     * 
     * @author 邱全松 2014-8-14 上午11:08:01
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/appraisalList")
    public void appraisalList(HttpServletRequest request, HttpServletResponse response, AppraisalListRequestDto param,PageBounds pageBounds){
      //构建返回参数对象
        AppraisalListResponseDto dto = buildResponse(AppraisalListResponseDto.class,param);
        pageBounds.getOrders().add(new Order("requirement_time", Direction.DESC, ""));
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            dto.setAppraisalList(appraisalService.getAppraisalList(param,pageBounds));
            outputSuccessReponse(response, dto);
        }
    }
    /**
     * 评价信息详情
     * 
     * @author 邱全松 2014-8-14 上午11:08:01
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/appraisalDetail")
    public void appraisalDetail(HttpServletRequest request, HttpServletResponse response, AppraisalDetailRequestDto param){
      //构建返回参数对象
        AppraisalDetailResponseDto dto = buildResponse(AppraisalDetailResponseDto.class,param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }else{
            dto.setAppraisalDto(appraisalService.getAppraisalDetail(param));
            outputSuccessReponse(response, dto);
        }
    }
    /**
     * 保存评价信息
     * 
     * @author 邱全松 2014-8-14 上午11:08:01
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/saveAppraisal")
    public void saveAppraisal(HttpServletRequest request, HttpServletResponse response, AppraisalSaveRequestDto param){
      //构建返回参数对象
        ResponseDto dto = buildResponse(ResponseDto.class,param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(!isLogin(param)){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        }
        try{
            appraisalService.saveAppraisal(param);
            outputSuccessReponse(response, dto);
        }catch(Exception e){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "保存信息失败！");
        }
    }
}
