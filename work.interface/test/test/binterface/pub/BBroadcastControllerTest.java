package test.binterface.pub;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.PubBroadcastRequestDto;
import cn.com.ubing.pub.dto.PubBroadcastResponseDto;

public class BBroadcastControllerTest extends BaseTest {
    /**
     * 历史方案详情查看
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testGetBroadcast() {
        // 封装参数
        PubBroadcastRequestDto param = new PubBroadcastRequestDto();
        param.setUid("313");
        param.setPage("3");
        param.setToken(StringUtils.getToken(param));
        
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getBroadcast.do", params);
        System.out.println("响应:" + json);
        // 解析
        PubBroadcastResponseDto resp = StringUtils.getObjectJson(PubBroadcastResponseDto.class, json);
        System.out.println(resp);
    }
}
