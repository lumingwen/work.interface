package test.cinterface.res;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.res.dto.ResCouponCountTimeOutResponseDto;
import cn.com.ubing.res.dto.ResCouponDetailRequestDto;
import cn.com.ubing.res.dto.ResCouponDetailResponseDto;
import cn.com.ubing.res.dto.ResCouponListRequestDto;
import cn.com.ubing.res.dto.ResCouponListResponseDto;

public class ResCouponControllerTest extends BaseTest {
    @Test
    public void testResCouponList() {
        // 封装参数
        ResCouponListRequestDto param = new ResCouponListRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setLimit("10");
        param.setPage("1");
        param.setUseStatus("0");
        param.setRequirementType("3");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/ResCouponList.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResCouponListResponseDto resp = StringUtils.getObjectJson(ResCouponListResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testResCouponDetail() {
        // 封装参数
        ResCouponDetailRequestDto param = new ResCouponDetailRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setCouponId("3");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/ResCouponDetail.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResCouponDetailResponseDto resp = StringUtils.getObjectJson(ResCouponDetailResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testResCouponCount() {
        // 封装参数
        RequestDto param = new RequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/ResCouponCount.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResCouponCountTimeOutResponseDto resp = StringUtils.getObjectJson(ResCouponCountTimeOutResponseDto.class, json);
        System.out.println(resp);
    }
}
