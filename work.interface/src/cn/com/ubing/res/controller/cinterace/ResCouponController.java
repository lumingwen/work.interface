package cn.com.ubing.res.controller.cinterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dto.ResCouponCountTimeOutResponseDto;
import cn.com.ubing.res.dto.ResCouponDetailRequestDto;
import cn.com.ubing.res.dto.ResCouponDetailResponseDto;
import cn.com.ubing.res.dto.ResCouponListRequestDto;
import cn.com.ubing.res.dto.ResCouponListResponseDto;
import cn.com.ubing.res.dto.ResDictResponseDto;
import cn.com.ubing.res.service.ResCouponServiceI;

@Controller
@RequestMapping("/")
public class ResCouponController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private ResCouponServiceI resCouponService;

    @RequestMapping("/ResCouponList")
    public void ResCouponList(HttpServletRequest request, HttpServletResponse response, ResCouponListRequestDto param) {
        try {
            // 构建返回参数对象
            ResCouponListResponseDto dto = buildResponse(ResCouponListResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                // 查询及封装
                PageBounds pageBounds = new PageBounds();
                pageBounds.setContainsTotalCount(true);
                pageBounds.setLimit(CommonUtils.parseInteger(param.getLimit()));
                pageBounds.setPage(CommonUtils.parseInteger(param.getPage()));
                if (param.getLimit() == null || "".equals(param.getLimit())) {
                    pageBounds.setLimit(10);
                }
                if (param.getPage() == null || "".equals(param.getPage())) {
                    pageBounds.setPage(1);
                }
                dto = resCouponService.queryList(param,pageBounds);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResCouponListResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    @RequestMapping("/ResCouponDetail")
    public void ResCouponDetail(HttpServletRequest request, HttpServletResponse response, ResCouponDetailRequestDto param) {
        try {
            // 构建返回参数对象
            ResCouponDetailResponseDto dto = buildResponse(ResCouponDetailResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                dto = resCouponService.ResCouponDetail(param);
                if(dto==null){
                    dto = new ResCouponDetailResponseDto();
                }
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResCouponDetailResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    @RequestMapping("/ResCouponCount")
    public void ResCouponCount(HttpServletRequest request, HttpServletResponse response, RequestDto param) {
        try {
            // 构建返回参数对象
            ResCouponCountTimeOutResponseDto dto = buildResponse(ResCouponCountTimeOutResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                dto = resCouponService.getCouponCountTimeOut(param);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResCouponCountTimeOutResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
