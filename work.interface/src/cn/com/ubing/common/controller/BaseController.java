/**
 * 
 */
package cn.com.ubing.common.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.log.model.LogRequest;
import cn.com.ubing.log.model.LogResponse;
import cn.com.ubing.log.service.LogRequestServiceI;
import cn.com.ubing.log.service.LogResponseServiceI;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.JsonUtils;

/**
 * 
 * 基类Controller
 * 
 * @author zhangxujun
 * 
 * 
 */
public abstract class BaseController {

	/**
	 * log
	 */
	private final Logger log = Logger.getLogger(getClass());
	
	/**
	 * 请求log
	 */
	@Autowired
	private LogRequestServiceI logRequestService;
	
	/**
	 * 响应log
	 */
	@Autowired
	private LogResponseServiceI logResponseService;

	
	/**
	 * 判断用户是否登陆:true登陆,false未登陆
	 * @param req
	 * @return
	 */
	protected boolean isLogin(RequestDto req){
	    return req!=null && StringUtils.isNotBlank(req.getUid());
	}
	
	/**
	 * 
	 * @param type
	 * @param req
	 * @return
	 */
    protected <T> T buildResponse(Class<T> type, RequestDto req) {
	try {
	    T resp = type.newInstance();
	    if (resp instanceof ResponseDto) {
		ResponseDto temp = (ResponseDto) resp;
		temp.setResultCode(Constants.RESULT_CODE_SUCCESS);
		temp.setResultInfo("操作成功");
		temp.setDeviceID(req.getDeviceID());
		temp.setUid(req.getUid());
	    }
	    writeRequestLog(req);
	    return resp;
	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	}
	return null;
    }
	
	
	/**
	 * 设置响应头公共参数
	 * @param req
	 * @param resp
	 */
	protected void setCommonProperties(RequestDto req,ResponseDto resp){
	    resp.setDeviceID(req.getDeviceID());
	    resp.setUid(req.getUid());
	}

	/**
	 * 输入参数校验失败响应
	 * 
	 * @param response
	 * @param dto
	 */
	protected void outputParamCheckError(HttpServletResponse response,
			ResponseDto dto) {
		dto.setResultCode(Constants.RESULT_CODE_FAIL);
		dto.setResultInfo("参数校验失败");
		String json = StringUtils.toJson(dto);
		writeJsonToResponse(response, json);
		writeReponseLog(dto);
	}

	/**
	 * 输出操作成功响应
	 * 
	 * @param response
	 * @param dto
	 */
	protected void outputSuccessReponse(HttpServletResponse response,
			ResponseDto dto) {
		dto.setResultCode(Constants.RESULT_CODE_SUCCESS);
		dto.setResultInfo("操作成功");
		String json = StringUtils.toJson(dto);
		writeJsonToResponse(response, json);
		writeReponseLog(dto);
	}

	/**
	 * 输出响应
	 * 
	 * @param response
	 * @param dto
	 * @param resultCode
	 * @param resultInfo
	 */
	protected void outputReponse(HttpServletResponse response, ResponseDto dto,
			String resultCode, String resultInfo) {
		dto.setResultCode(resultCode);
		dto.setResultInfo(resultInfo);
		String json = StringUtils.toJson(dto);
		writeJsonToResponse(response, json);
		writeReponseLog(dto);
	}

	/**
	 * 输出响应
	 * 
	 * @param response
	 * @param dto
	 */
	protected void outputReponse(HttpServletResponse response, ResponseDto dto) {
		String json = StringUtils.toJson(dto);
		writeJsonToResponse(response, json);
		writeReponseLog(dto);
	}

	/**
	 * 检查数据格式是否正确并处理
	 * 
	 * @param param
	 *            参数
	 * @return false不正确
	 */
	protected boolean checkRequest(RequestDto param) {
//		boolean flag = false;
//		if (param != null) {
//			String token = StringUtils.getToken(param);
//			flag = token.equalsIgnoreCase(param.getToken());
//		}
//
//		return flag;
	    return true;

	}

	/**
	 * 将json格式的字符串返回到客户端
	 * 
	 * @param response
	 *            响应
	 * @param json
	 *            字符串
	 */
	private void writeJsonToResponse(HttpServletResponse response, String json) {
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.print(json);
			pw.flush();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	
	
	/**
	 * 
	 * 记录请求日志
	 */
    private void writeRequestLog(RequestDto dto) {
	try {
	    ServletRequestAttributes sa = (ServletRequestAttributes) RequestContextHolder
		    .getRequestAttributes();
	    HttpServletRequest request = sa == null ? null : sa.getRequest();
	    LogRequest log = new LogRequest();
	    log.setCreateTime(new Date());
	    log.setUpdateTime(log.getCreateTime());
	    log.setDeleteFlag(Constants.DEL_FLAG_NO);
	    if (request != null) {
		String serailNumber = UUID.randomUUID().toString();
		request.setAttribute("logserailNumber", serailNumber);
		log.setSerialNumber(serailNumber);
		log.setIp(request.getRemoteAddr());
		log.setUri(request.getRequestURI());
	    }
	    if (dto != null) {
		log.setDeviceId(dto.getDeviceID());
		log.setUos(dto.getUos());
		log.setVersion(dto.getVersion());
		log.setInterfaceVersion(dto.getInterfaceVersion());
		log.setUid(dto.getUid());
		log.setScreen(dto.getScreen());
		log.setSource(dto.getSource());
		log.setUserAgent(dto.getUserAgent());
		log.setMapType(dto.getMapType());
		log.setMapVersion(dto.getMapVersion());
		log.setToken(dto.getToken());
		log.setTime(dto.getTime());
		log.setFullContent(JsonUtils.toJson(dto));
	    }
	    logRequestService.insert(log);
	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	}
    }
	
	/**
	 * 
	 * 记录响应日志
	 */
	private void writeReponseLog(ResponseDto dto){
	    try {
		    ServletRequestAttributes sa = (ServletRequestAttributes) RequestContextHolder
			    .getRequestAttributes();
		    HttpServletRequest request = sa == null ? null : sa.getRequest();
		    LogResponse log = new LogResponse();
		    log.setCreateTime(new Date());
		    log.setUpdateTime(log.getCreateTime());
		    log.setDeleteFlag(Constants.DEL_FLAG_NO);
		    if (request != null) {
			log.setSerialNumber((String)request.getAttribute("logserailNumber"));
		    }
		    if (dto != null) {
			log.setDeviceId(dto.getDeviceID());
			log.setUid(dto.getUid());
			log.setToken(dto.getToken());
			log.setResultCode(dto.getResultCode());
			log.setResultInfo(dto.getResultInfo());
			log.setFullContent(JsonUtils.toJson(dto));
		    }
		    logResponseService.insert(log);
		} catch (Exception e) {
		    log.error(e.getMessage(), e);
		}
	}

}
