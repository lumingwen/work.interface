/**
 * 
 */
package cn.com.ubing.ask.controller.cinterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.ask.dto.AnswerAppraiseRequestDto;
import cn.com.ubing.ask.dto.AnswerDetailRequestDto;
import cn.com.ubing.ask.dto.AnswerDetailResponseDto;
import cn.com.ubing.ask.dto.AnswerListRequestDto;
import cn.com.ubing.ask.dto.AnswerListResponseDto;
import cn.com.ubing.ask.dto.QuestionDetailRequestDto;
import cn.com.ubing.ask.dto.QuestionDetailResponseDto;
import cn.com.ubing.ask.dto.QuestionListRequestDto;
import cn.com.ubing.ask.dto.QuestionListResponseDto;
import cn.com.ubing.ask.dto.QuestionSubmitRequestDto;
import cn.com.ubing.ask.dto.QuestionSubmitResponseDto;
import cn.com.ubing.ask.dto.content.AnswerDetailContent;
import cn.com.ubing.ask.dto.content.QuestionDetailContent;
import cn.com.ubing.ask.service.AskServiceI;
import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.rms.dto.UserLoginResponseDto;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Paginator;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * c端旅行问答
 * @author zhangxujun
 * 
 *
 */
@Controller
@RequestMapping("/")
public class CAskController extends BaseController {
    
    
    /**
     * log日志
     */
    private final Logger log = Logger.getLogger(getClass());
    
    
    /**
     * 旅行问答service
     */
    @Autowired
    private AskServiceI askService;
    
    
    
    
    /**
     * 
     * 提问
     */
    @RequestMapping("/submitQuestion")
    public void submitQuestion(HttpServletRequest request, HttpServletResponse response,QuestionSubmitRequestDto param){
	try {
            // 响应response
	    QuestionSubmitResponseDto dto = buildResponse(QuestionSubmitResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户id不能为空");
                return;
            }
            //提交
            Integer pushCount = askService.submitQuestion(param);
            dto.setPushCount(String.valueOf(pushCount));
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }

    
    /**
     * 提问列表
     */
    @RequestMapping("/listQuestion")
    public void listQuestion(HttpServletRequest request, HttpServletResponse response,QuestionListRequestDto param){
	try {
            // 响应response
	    QuestionListResponseDto dto = buildResponse(QuestionListResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户id不能为空");
                return;
            }
            //查询数据
            PageList<QuestionDetailContent> contentList = askService.listQuestionContent(param);
            dto.setQuestionList(contentList);
            Paginator paginator = contentList.getPaginator();
            if (paginator != null){
        	dto.setPageNow(String.valueOf(paginator.getPage()));
        	dto.setTotalPages(String.valueOf(paginator.getTotalPages()));
        	dto.setTotalCount(String.valueOf(paginator.getTotalCount()));
            }
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    
    
    /**
     * 问题详情
     */
    @RequestMapping("/questionDetail")
    public void questionDetail(HttpServletRequest request, HttpServletResponse response,QuestionDetailRequestDto param){
	try {
            // 响应response
	    QuestionDetailResponseDto dto = buildResponse(QuestionDetailResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户id不能为空");
                return;
            }
            //查询数据
            QuestionDetailContent content = askService.getQuestionContent(CommonUtils.parseLong(param.getId()));
            dto.setQuestion(content);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    
    
    /**
     * 回答列表
     */
    @RequestMapping("/answerList")
    public void answerList(HttpServletRequest request, HttpServletResponse response,AnswerListRequestDto param){
	try {
            // 响应response
	    AnswerListResponseDto dto = buildResponse(AnswerListResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户id不能为空");
                return;
            }
            //查询数据
            PageList<AnswerDetailContent> list = askService.listAnswerContent(param);
            dto.setAnswerList(list);
            Paginator paginator = list.getPaginator();
            if (paginator != null){
        	dto.setPageNow(String.valueOf(paginator.getPage()));
        	dto.setTotalPages(String.valueOf(paginator.getTotalPages()));
        	dto.setTotalCount(String.valueOf(paginator.getTotalCount()));
            }
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    
    /**
     * 回答详情
     */
    @RequestMapping("/answerDetail")
    public void answerDetail(HttpServletRequest request, HttpServletResponse response,AnswerDetailRequestDto param){
	try {
            // 响应response
	    AnswerDetailResponseDto dto = buildResponse(AnswerDetailResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户id不能为空");
                return;
            }
            //查询数据
            AnswerDetailContent content = askService.getAnswerContent(param);
            dto.setAnswer(content);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    
    
    /**
     * 回答评价
     */
    @RequestMapping("/answerAppraise")
    public void answerAppraise(HttpServletRequest request, HttpServletResponse response,AnswerAppraiseRequestDto param){
	try {
            // 响应response
	    ResponseDto dto = buildResponse(ResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户id不能为空");
                return;
            }
            //查询数据
            askService.answerAppraise(param);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
}
