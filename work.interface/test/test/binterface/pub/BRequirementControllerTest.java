package test.binterface.pub;

import java.util.List;

import org.junit.Test;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.HomePageInfoDto;
import cn.com.ubing.pub.dto.RequirementDetailRequestDto;
import cn.com.ubing.pub.dto.RequirementDetailResponseDto;
import cn.com.ubing.pub.dto.RequirementListRequest;
import cn.com.ubing.pub.dto.RequirementResponseDto;
import test.base.BaseTest;

public class BRequirementControllerTest extends BaseTest {
    /**
     * 主页数据获取
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testGrabReady() {
        // 封装参数
        RequestDto user = new RequestDto();
        user.setUid("2");
        user.setToken(StringUtils.getToken(user));
        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/grabReady.do", params);
        System.out.println("响应:" + json);
        // 解析
        HomePageInfoDto resp = StringUtils.getObjectJson(HomePageInfoDto.class, json);
        System.out.println(resp);
    }
    /**
     * 主页数据获取2
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testRequirementList() {
        // 封装参数
        RequirementListRequest user = new RequirementListRequest();
        user.setUid("307");
        user.setStatus("8");
        user.setToken(StringUtils.getToken(user));
        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/requirementList.do", params);
        System.out.println("响应:" + json);
        // 解析
        RequirementResponseDto resp = StringUtils.getObjectJson(RequirementResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 需求详情
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testRequirement() {
        // 封装参数
        RequirementDetailRequestDto user = new RequirementDetailRequestDto();
        user.setUid("196");
        user.setRequirementId("1");
        user.setRequirementType("3");
        user.setToken(StringUtils.getToken(user));
        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/requirementDetail.do", params);
        System.out.println("响应:" + json);
        // 解析
        RequirementDetailResponseDto resp = StringUtils.getObjectJson(RequirementDetailResponseDto.class, json);
        System.out.println(resp);
    }
}
