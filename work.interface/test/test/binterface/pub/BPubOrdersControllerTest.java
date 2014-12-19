/**
 * 
 */
package test.binterface.pub;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.BPubOrdersDetailsRequestDto;
import cn.com.ubing.pub.dto.BPubOrdersDetailsResponseDto;

/**
 * 订单
 * @author jokiye
 *
 */
public class BPubOrdersControllerTest extends BaseTest {
	
	/**
	 * 订单详情
	 */
	@Test
	public void testGetOrdersDetailsForB(){
	    // 封装参数
		BPubOrdersDetailsRequestDto param = new BPubOrdersDetailsRequestDto();
        param.setUid("360");
        param.setOrderId("1");
        param.setToken(StringUtils.getToken(param));
        //param.setId("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getOrdersDetailsForB.do", params);
        System.out.println("响应:" + json);
        // 解析
        BPubOrdersDetailsResponseDto resp = StringUtils.getObjectJson(BPubOrdersDetailsResponseDto.class, json);
        System.out.println(resp);
	}

}
