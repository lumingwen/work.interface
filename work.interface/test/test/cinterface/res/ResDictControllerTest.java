package test.cinterface.res;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.res.dto.ResDictExpandRequestDto;
import cn.com.ubing.res.dto.ResDictExpandResponseDto;
import cn.com.ubing.res.dto.ResDictRequestDto;
import cn.com.ubing.res.dto.ResDictResponseDto;

public class ResDictControllerTest extends BaseTest {
    @Test
    public void testResCouponList() {
        // 封装参数
        ResDictRequestDto param = new ResDictRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setType("16");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getDictByType.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResDictResponseDto resp = StringUtils.getObjectJson(ResDictResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testGetDictExpandByType() {
        // 封装参数
        ResDictExpandRequestDto param = new ResDictExpandRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setType("PERSONAL_VISIT_ADDED_SERVICE");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/GetDictExpandByType.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResDictExpandResponseDto resp = StringUtils.getObjectJson(ResDictExpandResponseDto.class, json);
        System.out.println(resp);
    }
}
