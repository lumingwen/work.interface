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
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.res.dto.CResBuyLastGoodsRequestDto;
import cn.com.ubing.res.dto.CResBuyLastGoodsResponseDto;
import cn.com.ubing.res.dto.CResLastGoodsDetailRequestDto;
import cn.com.ubing.res.dto.CResLastGoodsDetailResponseDto;
import cn.com.ubing.res.dto.ResCouponListResponseDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityInfoRequestDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityInfoResponseDto;
import cn.com.ubing.res.dto.WelfareListRequestDto;
import cn.com.ubing.res.dto.WelfareListResponseDto;
import cn.com.ubing.res.service.ResLastGoodsServiceI;
@Controller
public class ResLastGoodsController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private ResLastGoodsServiceI resLastGoodsService;
    /**
     * 尾单详情
     * 
     * @author 邱全松 2014-11-20 下午4:00:15
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/getLastGoodsDetail")
    public void getLastGoodsDetail(HttpServletRequest request, HttpServletResponse response, CResLastGoodsDetailRequestDto param) {
        try {
            // 构建返回参数对象
            CResLastGoodsDetailResponseDto dto = buildResponse(CResLastGoodsDetailResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // 查询及封装
            dto = resLastGoodsService.getLastGoodsDetail(param);
            setCommonProperties(param, dto);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 尾单日期价格信息
     * 
     * @author 邱全松 2014-11-20 下午4:00:25
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/queryLastGoodsPriceQuantity")
    public void queryLastGoodsPriceQuantity(HttpServletRequest request, HttpServletResponse response, ResLastGoodsPriceQuantityInfoRequestDto param) {
        try {
            // 构建返回参数对象
            ResLastGoodsPriceQuantityInfoResponseDto dto = buildResponse(ResLastGoodsPriceQuantityInfoResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // 查询及封装
            dto = resLastGoodsService.queryPriceQuantityInfo(param);
            setCommonProperties(param, dto);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 尾单购买
     * 
     * @author 邱全松 2014-11-20 下午4:00:25
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/buyLastGoods")
    public void buyLastGoods(HttpServletRequest request, HttpServletResponse response, CResBuyLastGoodsRequestDto param) {
        try {
            // 构建返回参数对象
            CResBuyLastGoodsResponseDto dto = buildResponse(CResBuyLastGoodsResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                // 查询及封装
                dto = resLastGoodsService.buyLastGoods(param);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 游福利列表
     * 
     * @author 邱全松 2014-11-28 下午3:06:56
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/welfareList")
    public void welfareList(HttpServletRequest request, HttpServletResponse response, WelfareListRequestDto param) {
        try {
            // 构建返回参数对象
            WelfareListResponseDto dto = buildResponse(WelfareListResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
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
            dto = resLastGoodsService.queryWelfareList(param, pageBounds);
            setCommonProperties(param, dto);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResCouponListResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }

}
