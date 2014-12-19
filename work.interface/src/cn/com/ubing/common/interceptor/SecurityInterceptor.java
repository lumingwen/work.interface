package cn.com.ubing.common.interceptor;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.rms.model.RmsUser;
import cn.com.ubing.rms.service.RmsUserServiceI;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;


/**
 * 
 * springmvc拦截器
 * 
 * @author zhangxujun
 * 
 *
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter{
    
    
    /**
     * log
     */
    private static final Logger log = Logger.getLogger(SecurityInterceptor.class);
    
   

    /**
     * 用户service
     */
    @Autowired
    private RmsUserServiceI rmsUserService;
    
    
    
    @Override
    public void afterCompletion(HttpServletRequest arg0,
	    HttpServletResponse arg1, Object arg2, Exception arg3)
	    throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
	    Object arg2, ModelAndView arg3) throws Exception {
    }

    
    /**
     * 方法调用前拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp,
	    Object object) throws Exception {


	try {
	    //封装参数
	    RequestDto bean = new RequestDto();
		ServletRequestDataBinder binder = new ServletRequestDataBinder(
			bean);
		binder.bind(req);
		//如果有uid则根据uid校验用户
	    if (StringUtils.isNotBlank(bean.getUid())) {
		String message = "";
		RmsUser user = rmsUserService.getById(CommonUtils
			.parseLong(bean.getUid()));
		if (user == null) {
		    message = "用户不存在";
		} else if (!Constants.USER_STATUS.equals(user.getStatus())) {
		    message = "用户已停用";
		}
		// 输出校验结果
		if (StringUtils.isNotBlank(message)) {
		    ResponseDto dto = new ResponseDto();
		    dto.setResultCode(Constants.RESULT_CODE_FAIL);
		    dto.setResultInfo(message);
		    String json = cn.com.ubing.common.utils.StringUtils
			    .toJson(dto);
		    resp.setContentType("application/json;charset=utf-8");
		    PrintWriter pw = resp.getWriter();
		    pw.print(json);
		    pw.flush();
		    return false;
		}
	    }
	}catch(Exception e){
	    log.error(e.getMessage(), e);
	}
	
	//参数校验
	log.debug("安全校验!");
	return true;

    }

    
   
}
