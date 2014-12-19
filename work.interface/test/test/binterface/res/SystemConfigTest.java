package test.binterface.res;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.msg.dto.MessageListResponseDto;

public class SystemConfigTest extends BaseTest {

    
    
    /**
     * 消息组
     */
    @Test
    public void testSystemConfig(){
    
    //封装参数
    RequestDto user = new RequestDto();
    user.setUos("ANDROID");
    

    //调用
    List<String[]> params = getParamterList("", user);
    String json = postRequest("/systemVersion.do",params);
    System.out.println("响应:"+json);
    
    
    //解析
    MessageListResponseDto resp = StringUtils.getObjectJson(MessageListResponseDto.class, json);
    System.out.println(resp);
    
    }
}
