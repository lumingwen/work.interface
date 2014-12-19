package cn.com.ubing.pub.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlvtech.ubing.common.constant.Constants;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.pub.dto.PubBroadcastRequestDto;
import cn.com.ubing.pub.dto.PubBroadcastResponseDto;
import cn.com.ubing.pub.service.BroadcastServiceI;
/**
 * 旅游播报信息
 *  
 * @author 邱全松 2014-7-11 上午10:51:39
 */
@Controller
@RequestMapping("/")
public class BBroadcastController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private BroadcastServiceI broadcaseService;
    @RequestMapping("/getBroadcast")
    public void getBroadcast(HttpServletRequest request, HttpServletResponse response, PubBroadcastRequestDto param) {
        try {
            // 构建返回参数对象
            PubBroadcastResponseDto dto = buildResponse(PubBroadcastResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户未登录！");
            } else {
                dto = broadcaseService.getBroadcast(param,dto);
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new PubBroadcastResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
