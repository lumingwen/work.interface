package cn.com.ubing.pub.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.pub.dao.GiveUpRequirementRequestDto;
import cn.com.ubing.pub.dto.GetRequirementInfoRequest;
import cn.com.ubing.pub.dto.GetRequirementInfoResponse;
import cn.com.ubing.pub.dto.GrabRequirementRequestDto;
import cn.com.ubing.pub.dto.GrabRequirementResponseDto;
import cn.com.ubing.pub.dto.RequirementDetailRequestDto;
import cn.com.ubing.pub.dto.RequirementDetailResponseDto;
import cn.com.ubing.pub.dto.RequirementListRequest;
import cn.com.ubing.pub.dto.RequirementResponseDto;
import cn.com.ubing.pub.service.RequirementServiceI;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.hlvtech.ubing.common.constant.Constants;

/**
 * 需求相关逻辑处理
 * 
 * @author 邱全松 2014-6-23 下午2:10:36
 */
@Controller
@RequestMapping("/")
public class RequirementController extends BaseController {
    @Autowired
    private RequirementServiceI requirementService;

    /**
     * 历史订单列表
     * 
     * @author 邱全松 2014-8-13 下午4:31:58
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/requirementList")
    public void requirementList(HttpServletRequest request, HttpServletResponse response, RequirementListRequest param, PageBounds pageBounds) {
        // 构建返回参数对象
        RequirementResponseDto dto = buildResponse(RequirementResponseDto.class, param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if (!isLogin(param)) {
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        } else {
            pageBounds.getOrders().add(new Order("create_time", Direction.DESC, ""));
            dto.setRequirementList(requirementService.queryRequirementList(param,pageBounds));
            outputSuccessReponse(response, dto);
        }
    }

    /**
     * 需求详情
     * 
     * @author 邱全松 2014-8-13 下午5:20:06
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/requirementDetail")
    public void requirement(HttpServletRequest request, HttpServletResponse response, RequirementDetailRequestDto param) {
        // 构建返回参数对象
        RequirementDetailResponseDto dto = buildResponse(RequirementDetailResponseDto.class, param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if (!isLogin(param)) {
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        } else {
            try {
                dto = requirementService.getRequirementDetail(param);
                if (dto == null) {
                    dto = buildResponse(RequirementDetailResponseDto.class, param);
                    outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "未查询到数据！");
                } else {
                    setCommonProperties(param, dto);
                    outputSuccessReponse(response, dto);
                }
            } catch (Exception e) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "查询信息错误");
            }
        }
    }
    /**
     * 抢单
     * 
     * @author 邱全松 2014-9-3 下午6:42:49
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/grabRequirement")
    public void grabRequirement(HttpServletRequest request, HttpServletResponse response, GrabRequirementRequestDto param) {
        // 构建返回参数对象
        GrabRequirementResponseDto dto = buildResponse(GrabRequirementResponseDto.class, param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if (!isLogin(param)) {
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        } else {
            try {
                dto = requirementService.grapRequirement(param);
                if (dto == null) {
                    dto = buildResponse(GrabRequirementResponseDto.class, param);
                    outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "抢单程序异常！");
                } else {
                    setCommonProperties(param, dto);
                    outputSuccessReponse(response, dto);
                }
            } catch (Exception e) {
                e.printStackTrace();
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "查询信息错误");
            }
        }
    }
    /**
     * 放弃抢单
     * 
     * @author 邱全松 2014-9-3 下午6:42:49
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/giveUpRequirement")
    public void giveUpRequirement(HttpServletRequest request, HttpServletResponse response, GiveUpRequirementRequestDto param) {
        // 构建返回参数对象
        ResponseDto dto = buildResponse(ResponseDto.class, param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if (!isLogin(param)) {
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        } else {
            try {
                requirementService.giveUpRequirement(param);
                outputSuccessReponse(response, dto);
            } catch (Exception e) {
                e.printStackTrace();
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "查询信息错误");
            }
        }
    }
    /**
     * 获取需求信息IOS专用
     * 
     * @author 邱全松 2014-9-3 下午6:42:49
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/getRequirementInfo")
    public void getRequirementInfo(HttpServletRequest request, HttpServletResponse response, GetRequirementInfoRequest param) {
        // 构建返回参数对象
        GetRequirementInfoResponse dto = buildResponse(GetRequirementInfoResponse.class, param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if (!isLogin(param)) {
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
        } else {
            try {
                dto = requirementService.getRequirementInfo(param);
                dto.setEndTimeLong(dto.getEndTime().getTime()+"");
                dto.setEndTime(null);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            } catch (Exception e) {
                e.printStackTrace();
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "查询信息错误");
            }
        }
    }
}
