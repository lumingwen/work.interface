package cn.com.ubing.pub.controller.cinterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.pub.dto.CAppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.CAppraisalDetailResponseDto;
import cn.com.ubing.pub.dto.CPubOrderOperationRequestDto;
import cn.com.ubing.pub.dto.CPubOrderOperationResponseDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailRequestDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailResponseDto;
import cn.com.ubing.pub.dto.CSaveAppraisalRequestDto;
import cn.com.ubing.pub.dto.PubOrdersListDto;
import cn.com.ubing.pub.dto.PubOrdersListRequestDto;
import cn.com.ubing.pub.dto.PubOrdersListResponseDto;
import cn.com.ubing.pub.service.PubOrdersServiceI;

@Controller
public class PubOrdersController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private PubOrdersServiceI pubOrdersService;
    /**
     * 订单列表
     * 
     * @author 邱全松 2014-10-30 下午3:20:52
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/getOrdersList")
    public void getOrdersList(HttpServletRequest request,HttpServletResponse response,PubOrdersListRequestDto param) {
        try {
            // 构建返回参数对象
            PubOrdersListResponseDto dto = buildResponse(PubOrdersListResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
                        "用户未登录！");
            } else {
                // 查询及封装
                PageBounds pageBounds = new PageBounds();
                pageBounds.setContainsTotalCount(true);
                pageBounds.getOrders().add(new Order("last_pay_time", Direction.DESC, ""));
                pageBounds.setLimit(CommonUtils.parseInteger(param.getLimit()));
                pageBounds.setPage(CommonUtils.parseInteger(param.getPage()));
                if (param.getLimit() == null || "".equals(param.getLimit())) {
                    pageBounds.setLimit(10);
                }
                if (param.getPage() == null || "".equals(param.getPage())) {
                    pageBounds.setPage(1);
                }
                PageList<PubOrdersListDto> list = pubOrdersService.queryOrderList(param, pageBounds);
                if(list!=null&&list.size()!=0){
                    dto.setOrdersList(list);
                    dto.setPageNow(list.getPaginator().getPage()+"");
                    dto.setTotalCount(list.getPaginator().getTotalCount()+"");
                    dto.setTotalPages(list.getPaginator().getTotalPages()+"");
                }
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(),
                    Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 订单详情
     * 
     * @author 邱全松 2014-11-18 下午1:28:35
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/getOrdersDetail")
    public void getOrdersDetail(HttpServletRequest request,HttpServletResponse response,CPubOrdersDetailRequestDto param) {
        try {
            // 构建返回参数对象
            CPubOrdersDetailResponseDto dto = buildResponse(CPubOrdersDetailResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
                        "用户未登录！");
            } else {
                // 查询及封装
                dto = pubOrdersService.getOrderDetail(param);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(),
                    Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 确认出行
     * 
     * @author 邱全松 2014-11-18 下午1:28:35
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/confirmTravel")
    public void confirmTravel(HttpServletRequest request,HttpServletResponse response,CPubOrderOperationRequestDto param) {
        try {
            // 构建返回参数对象
            CPubOrderOperationResponseDto dto = buildResponse(CPubOrderOperationResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
                        "用户未登录！");
            } else {
                // 查询及封装
                dto.setResultMessage(pubOrdersService.confirmTravel(CommonUtils.parseLong(param.getOrderId())));
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(),
                    Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 保存评价信息
     * 
     * @author 邱全松 2014-11-18 下午1:28:35
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/cSaveAppraisal")
    public void saveAppraisal(HttpServletRequest request,HttpServletResponse response,CSaveAppraisalRequestDto param) {
        try {
            // 构建返回参数对象
            CPubOrderOperationResponseDto dto = buildResponse(CPubOrderOperationResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
                        "用户未登录！");
            } else {
                // 查询及封装
                dto.setResultMessage(pubOrdersService.cSaveAppraisal(param));
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(),
                    Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 评价详情
     * 
     * @author 邱全松 2014-11-27 下午1:54:39
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/cAppraisalDetail")
    public void appraisalDetail(HttpServletRequest request,HttpServletResponse response,CAppraisalDetailRequestDto param) {
        try {
            // 构建返回参数对象
            CAppraisalDetailResponseDto dto = buildResponse(CAppraisalDetailResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
                        "用户未登录！");
            } else {
                // 查询及封装
                dto = pubOrdersService.appraisalDetail(param);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(),
                    Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
