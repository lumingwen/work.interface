package cn.com.ubing.rms.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.rms.dto.BusinessCompanyCheckRequestDto;
import cn.com.ubing.rms.dto.BusinessUserInfoResponseDto;
import cn.com.ubing.rms.dto.BusinessUserSetPhotoRequestDto;
import cn.com.ubing.rms.dto.CompanyCheckInfoResponseDto;
import cn.com.ubing.rms.dto.MainViewResponseDto;
import cn.com.ubing.rms.dto.RealNameCheckRequestDto;
import cn.com.ubing.rms.dto.RealNameCheckResponseDto;
import cn.com.ubing.rms.dto.UpdateNickNameRequestDto;
import cn.com.ubing.rms.service.RmsUserServiceI;

import com.hlvtech.ubing.common.constant.Constants;

/**
 * 商家个人信息维护
 *  
 * @author 邱全松 2014-6-26 下午2:12:19
 */
@Controller
@RequestMapping("/")
public class BBusinessUserController extends BaseController{
    @Autowired
    private RmsUserServiceI rmsUserService;
    private final Logger log = Logger.getLogger(getClass());
    /**
     * 主页面信息获取
     * 
     * @author 邱全松 2014-9-4 下午9:09:04
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/mainView")
    public void mainView(HttpServletRequest request, HttpServletResponse response, RequestDto param) {
        try {
            // 构建返回参数对象
            MainViewResponseDto dto = buildResponse(MainViewResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                dto = rmsUserService.getMainViewInfo(param);
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 商家个人中心首页信息获取
     * 
     * @author 邱全松 2014-6-25 下午8:04:12
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/userCenter")
    public void userCenter(HttpServletRequest request, HttpServletResponse response, RequestDto param) {
        try {
            // 构建返回参数对象
            BusinessUserInfoResponseDto dto = buildResponse(BusinessUserInfoResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                if(rmsUserService.getBusinessUserInfo(param)!=null){
                    dto = rmsUserService.getBusinessUserInfo(param);
                }
                setCommonProperties(param, dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 设置头像
     * 
     * @author 邱全松 2014-6-25 下午8:04:12
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/businessSetPhoto")
    public void businessSetPhoto(HttpServletRequest request, HttpServletResponse response, BusinessUserSetPhotoRequestDto param) {
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
                rmsUserService.setBusinessPhoto(param);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 商家机构认证信息保存
     * 
     * @author 邱全松 2014-6-25 下午8:04:12
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/saveOrUpdateCompanyCheck")
    public void saveOrUpdateCompanyCheck(HttpServletRequest request, HttpServletResponse response, BusinessCompanyCheckRequestDto param) {
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
                rmsUserService.saveOrUpdateBusinessCompanyCheck(param);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 实名认证信息保存
     * 
     * @author 邱全松 2014-8-5 下午3:47:50
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/businessCheck")
    public void businessCheck(HttpServletRequest request, HttpServletResponse response, RealNameCheckRequestDto param) {
        try {
            // 构建返回参数对象
            ResponseDto dto = buildResponse(ResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return ;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                rmsUserService.saveOrUpdateBusinessRealNameCheck(param);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }    
    /**
     * 获取商家实名认证信息
     * 
     * @author 邱全松 2014-6-25 下午8:04:12
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/realNameCheckInfo")
    public void realNameCheckInfo(HttpServletRequest request, HttpServletResponse response, RequestDto param) {
        try {
            // 构建返回参数对象
            RealNameCheckResponseDto dto = buildResponse(RealNameCheckResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                dto = rmsUserService.getRealNameCheckInfo(param);
                if(dto==null){
                    outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "无数据!");
                }else{
                    setCommonProperties(param, dto);
                    outputSuccessReponse(response, dto);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * 获取商家机构认证信息
     * 
     * @author 邱全松 2014-6-25 下午8:04:12
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/companyCheckInfo")
    public void companyCheckInfo(HttpServletRequest request, HttpServletResponse response, RequestDto param) {
        try {
            // 构建返回参数对象
            CompanyCheckInfoResponseDto dto = buildResponse(CompanyCheckInfoResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {                
                if(rmsUserService.getCompanyCheckInfo(param)!=null){
                    dto = rmsUserService.getCompanyCheckInfo(param);
                    setCommonProperties(param, dto);
                }
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    /**
     * （B端app）修改商家昵称
     * 
     * @author 邱全松 2014-7-9 下午5:32:14
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/updateNickName")
    public void updateNickName(HttpServletRequest request, HttpServletResponse response, UpdateNickNameRequestDto param){
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
                rmsUserService.updateNickName(param);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
