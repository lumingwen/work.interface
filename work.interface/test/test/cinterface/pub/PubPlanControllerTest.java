package test.cinterface.pub;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.CHistoryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.CUpdatePubPlanRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.OperationPlanRequestDto;

public class PubPlanControllerTest extends BaseTest {
    @Test
    public void testOperationPlan() {//保存自由行需求
        // 封装参数
        OperationPlanRequestDto param = new OperationPlanRequestDto();
        param.setUid("313");
        param.setToken(StringUtils.getToken(param));
        param.setPlanId("378");
        param.setOperationParam("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/operationPlan.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    
    @Test
    public void testViewPlanDetail() {//查看方案详细
        // 封装参数
    	HistoryPlanDetailRequestDto param = new HistoryPlanDetailRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setPlanId("498");
        param.setRequirementId("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/viewPlanDetail.do", params);
        System.out.println("响应:" + json);
        // 解析
        CHistoryPlanDetailResponseDto resp = StringUtils.getObjectJson(CHistoryPlanDetailResponseDto.class, json);
        System.out.println(resp);
    }
    
    @Test
    public void testUpdatePubPlanById() {//查看方案详细
        // 封装参数
    	CUpdatePubPlanRequestDto param = new CUpdatePubPlanRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setId("374");
        param.setStatus("3");
        param.setUpdateTime(new Date());
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/updatePubPlanById.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
}
