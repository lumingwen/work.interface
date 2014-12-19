package cn.com.ubing.res.controller.cinterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsDetailRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsDetailResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsListRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsListResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsSaveRequestDto;
import cn.com.ubing.res.service.ResCommonContactsServiceI;

@Controller
@RequestMapping("/")
public class ResContactsController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private ResCommonContactsServiceI resCommonContactsService;

    @RequestMapping("/ResCommonContactsList")
    public void ResCommonContactsList(HttpServletRequest request, HttpServletResponse response, ResCommonContactsListRequestDto param) {
        try {
            // 构建返回参数对象
            ResCommonContactsListResponseDto dto = buildResponse(ResCommonContactsListResponseDto.class, param);
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
                pageBounds.getOrders().add(new Order("update_time", Direction.DESC, ""));
                pageBounds.setLimit(CommonUtils.parseInteger(param.getLimit()));
                pageBounds.setPage(CommonUtils.parseInteger(param.getPage()));
                if (param.getLimit() == null || "".equals(param.getLimit())) {
                    pageBounds.setLimit(10);
                }
                if (param.getPage() == null || "".equals(param.getPage())) {
                    pageBounds.setPage(1);
                }
                dto = resCommonContactsService.queryList(param, pageBounds);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResCommonContactsListResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    @RequestMapping("/ResCommonContactsDetail")
    public void ResCommonContactsDetail(HttpServletRequest request, HttpServletResponse response, ResCommonContactsDetailRequestDto param) {
        try {
            // 构建返回参数对象
            ResCommonContactsDetailResponseDto dto = buildResponse(ResCommonContactsDetailResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                dto = resCommonContactsService.getDetail(param);
                if(dto==null){
                    dto = new ResCommonContactsDetailResponseDto();
                }
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResCommonContactsDetailResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }

    @RequestMapping("/SaveResCommonContacts")
    public void SaveResCommonContacts(HttpServletRequest request, HttpServletResponse response, ResCommonContactsSaveRequestDto param) {
        try {
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
                if (resCommonContactsService.saveContacts(param)) {
                    dto.setResultInfo("保存成功");
                } else {
                    dto.setResultCode(Constants.RESULT_CODE_FAIL);
                    dto.setResultInfo("保存失败");
                }
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
