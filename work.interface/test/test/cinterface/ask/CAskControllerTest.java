/**
 * 
 */
package test.cinterface.ask;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
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
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;

/**
 * 旅行问答测试类
 * @author zhangxujun
 * 
 *
 */
public class CAskControllerTest extends BaseTest {
    
    @Test
    public void testSubmitQuestion() {
	QuestionSubmitRequestDto param = new QuestionSubmitRequestDto();
	// 封装参数
	param.setUid("351");
	param.setContent("提wen......");
	param.setTargetRegionId("123");
	param.setToken(StringUtils.getToken(param));
	// 调用
	List<String[]> params = getParamterList("", param);
	String json = postRequest("/submitQuestion.do", params);
	System.out.println("响应:" + json);
	// 解析
	ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
	System.out.println(resp);
    }
    
    
    @Test
    public void testListQuestion() {
        // 封装参数
	QuestionListRequestDto param = new QuestionListRequestDto();
        param.setUid("351");
        param.setType("3");
        param.setPage("1");
        param.setLimit("2");
        param.setTargetRegionName("成都");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/listQuestion.do", params);
        System.out.println("响应:\n" + json+"\n");
        // 解析
        QuestionListResponseDto resp = StringUtils.getObjectJson(QuestionListResponseDto.class, json);
        System.out.println(resp);
    }

    
    @Test
    public void testQuestionDetail() {
        // 封装参数
	QuestionDetailRequestDto param = new QuestionDetailRequestDto();
        param.setUid("351");
        param.setId("94");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/questionDetail.do", params);
        System.out.println("响应:\n" + json+"\n");
        // 解析
        QuestionDetailResponseDto resp = StringUtils.getObjectJson(QuestionDetailResponseDto.class, json);
        System.out.println(resp);
    }
    
    
    
    @Test
    public void testAnswerList() {
        // 封装参数
	AnswerListRequestDto param = new AnswerListRequestDto();
        param.setUid("351");
        param.setQuestionId("40");
        param.setPage("1");
        param.setLimit("2");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/answerList.do", params);
        System.out.println("响应:\n" + json+"\n");
        // 解析
        AnswerListResponseDto resp = StringUtils.getObjectJson(AnswerListResponseDto.class, json);
        System.out.println(resp);
    }
    
    
    
    @Test
    public void testAnswerDetail() {
        // 封装参数
	AnswerDetailRequestDto param = new AnswerDetailRequestDto();
        param.setUid("351");
        param.setId("35");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/answerDetail.do", params);
        System.out.println("响应:\n" + json+"\n");
        // 解析
        AnswerDetailResponseDto resp = StringUtils.getObjectJson(AnswerDetailResponseDto.class, json);
        System.out.println(resp);
    }
    
    
    @Test
    public void testAnswerAppraise() {
        // 封装参数
	AnswerAppraiseRequestDto param = new AnswerAppraiseRequestDto();
        param.setUid("351");
        param.setId("35");
        param.setAppraise("1");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/answerAppraise.do", params);
        System.out.println("响应:\n" + json+"\n");
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
}
