package test.cinterface.pub;

import java.util.List;

import org.junit.Test;

import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.CAppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.CAppraisalDetailResponseDto;
import cn.com.ubing.pub.dto.CPubOrderOperationRequestDto;
import cn.com.ubing.pub.dto.CPubOrderOperationResponseDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailRequestDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailResponseDto;
import cn.com.ubing.pub.dto.CSaveAppraisalRequestDto;
import cn.com.ubing.pub.dto.PubOrdersListRequestDto;
import cn.com.ubing.pub.dto.PubOrdersListResponseDto;
import test.base.BaseTest;

public class PubOrdersControllerTest extends BaseTest {
    @Test
    public void testgetOrdersList() {//订单列表
        // 封装参数
        PubOrdersListRequestDto param = new PubOrdersListRequestDto();
        param.setUid("360");
        param.setToken(StringUtils.getToken(param));
        param.setStatus("1");
        param.setLimit("10");
        param.setPage("0");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getOrdersList.do", params);
        System.out.println("响应:" + json);
        // 解析
        PubOrdersListResponseDto resp = StringUtils.getObjectJson(PubOrdersListResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testgetOrdersDetail() {//订单详情
        // 封装参数
        CPubOrdersDetailRequestDto param = new CPubOrdersDetailRequestDto();
        param.setUid("308");
        param.setToken(StringUtils.getToken(param));
        param.setOrderId("2");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getOrdersDetail.do", params);
        System.out.println("响应:" + json);
        // 解析
        CPubOrdersDetailResponseDto resp = StringUtils.getObjectJson(CPubOrdersDetailResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testConfirmTravel() {//确认出行
        // 封装参数
        CPubOrderOperationRequestDto param = new CPubOrderOperationRequestDto();
        param.setUid("308");
        param.setToken(StringUtils.getToken(param));
        param.setOrderId("2");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/confirmTravel.do", params);
        System.out.println("响应:" + json);
        // 解析
        CPubOrderOperationResponseDto resp = StringUtils.getObjectJson(CPubOrderOperationResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testSaveAppraisal() {//保存评价
        // 封装参数
        CSaveAppraisalRequestDto param = new CSaveAppraisalRequestDto();
        param.setUid("308");
        param.setToken(StringUtils.getToken(param));
        param.setFromId("313");
        param.setToId("303");
        param.setContent("评价测试评价内容");
        param.setDoneServiceLabelId("3");
        param.setDoneDescriptionLabelId("4");
        param.setAppraisalResult("1");
        param.setPlanId("378");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/cSaveAppraisal.do", params);
        System.out.println("响应:" + json);
        // 解析
        CPubOrderOperationResponseDto resp = StringUtils.getObjectJson(CPubOrderOperationResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testAppraisal() {//确认出行
        // 封装参数
        CAppraisalDetailRequestDto param = new CAppraisalDetailRequestDto();
        param.setUid("308");
        param.setToken(StringUtils.getToken(param));
        param.setOrderId("2");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/cAppraisalDetail.do", params);
        System.out.println("响应:" + json);
        // 解析
        CAppraisalDetailResponseDto resp = StringUtils.getObjectJson(CAppraisalDetailResponseDto.class, json);
        System.out.println(resp);
    }
}
