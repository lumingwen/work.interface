/**
 * 
 */
package test.binterface.msg;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.msg.dto.MessageListRequestDto;
import cn.com.ubing.msg.dto.MessageListResponseDto;
import cn.com.ubing.msg.dto.MessageRequestDto;
import cn.com.ubing.msg.dto.MessageResponseDto;
import cn.com.ubing.msg.dto.MessageSendRequestDto;
import cn.com.ubing.msg.dto.ModifySignatureRequestDto;

/**
 * B端消息测试
 * 
 * @author zhangxujun
 * 
 * 
 */
public class BMessageControllerTest extends BaseTest {

    /**
     * 消息组
     */
    @Test
    public void testMessageList() {

        // 封装参数
        MessageListRequestDto user = new MessageListRequestDto();
        user.setUid("281");
        user.setLimit("10");
        user.setPage("1");
        
        user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/messageList.do", params);
        System.out.println("响应:" + json);

        // 解析
        MessageListResponseDto resp = StringUtils.getObjectJson(MessageListResponseDto.class, json);
        System.out.println(resp);

    }

    /**
     * 消息内容
     */
    @Test
    public void testMessage() {

        // 封装参数
        MessageRequestDto user = new MessageRequestDto();
        user.setUid("281");
        user.setGroupId("80");
        user.setType("2");
        user.setLimit("3");
        user.setPage("1");
        user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/message.do", params);
        System.out.println("响应:" + json);

        // 解析
        MessageResponseDto resp = StringUtils.getObjectJson(MessageResponseDto.class, json);
        System.out.println(resp);

    }

    /**
     * 发送消息
     */
    @Test
    public void testSendMessage() {
        // 封装参数
        MessageSendRequestDto user = new MessageSendRequestDto();
        user.setUid("330");
        user.setGroupId("191");
        user.setType("2");
        user.setContent("啊时代发生发送爱上了发撒地方拉升");
        //user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/sendMessage.do", params);
        System.out.println("响应:" + json);

        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    
    /**
     * 发送消息 c端
     */
    @Test
    public void testCSendMessage() {
        // 封装参数
        MessageSendRequestDto user = new MessageSendRequestDto();
        user.setUid("351");
        user.setGroupId("191");
        user.setType("2");
        user.setContent("啊时代发生发送爱上了发撒地方拉升");
        //user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/cSendMessage.do", params);
        System.out.println("响应:" + json);

        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }

    /**
     * 修改签名
     */
    @Test
    public void testModifySignature() {

        // 封装参数
        ModifySignatureRequestDto user = new ModifySignatureRequestDto();
        user.setUid("1");
        user.setSignature("签名" + System.currentTimeMillis());
        user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/modifySignature.do", params);
        System.out.println("响应:" + json);

        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
}
