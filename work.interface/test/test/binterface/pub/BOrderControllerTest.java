package test.binterface.pub;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.BPubOrdersListRequestDto;
import cn.com.ubing.pub.dto.BPubOrdersListResponseDto;

public class BOrderControllerTest extends BaseTest {
    /**
     * b端订单列表
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testOrderList() {
        // 封装参数
        BPubOrdersListRequestDto param = new BPubOrdersListRequestDto();
        param.setUid("360");
        param.setPage("1");
        param.setLimit("10");
        param.setStatus("3");
        param.setToken(StringUtils.getToken(param));
        //param.setId("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getOrdersListForB.do", params);
        System.out.println("响应:" + json);
        // 解析
        BPubOrdersListResponseDto resp = StringUtils.getObjectJson(BPubOrdersListResponseDto.class, json);
        System.out.println(resp);
    }
}
