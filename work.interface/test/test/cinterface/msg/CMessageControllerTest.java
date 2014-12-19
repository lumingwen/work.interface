/**
 * 
 */
package test.cinterface.msg;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.msg.dto.DeleteMessageRequestDto;
import cn.com.ubing.msg.dto.GroupMessageListRequestDto;
import cn.com.ubing.msg.dto.GroupMessageListResponseDto;
import cn.com.ubing.msg.dto.MessageListRequestDto;
import cn.com.ubing.msg.dto.MessageListResponseDto;
import cn.com.ubing.msg.dto.MessageRequestDto;
import cn.com.ubing.msg.dto.MessageResponseDto;
import cn.com.ubing.msg.dto.MessageSendRequestDto;


/**
 * C端消息测试
 * 
 * @author lumw
 * 
 * 
 */
public class CMessageControllerTest extends BaseTest {

    /**
     * 消息组
     */
    @Test
    public void testListMessageGroup() {

        // 封装参数
    	GroupMessageListRequestDto user = new GroupMessageListRequestDto();
        user.setUid("260");
        user.setLimit("10");
        user.setPageNow("1");
        
        user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/listMessageGroup.do", params);
        System.out.println("响应:" + json);

        // 解析
        GroupMessageListResponseDto resp = StringUtils.getObjectJson(GroupMessageListResponseDto.class, json);
        System.out.println(resp);

    }

    /**
     * 消息内容
     */
    @Test
    public void testViewMessageByGroup() {

        // 封装参数
        MessageRequestDto user = new MessageRequestDto();
        user.setUid("260");
        user.setGroupId("100");
        user.setType("2");
        user.setLimit("3");
        user.setPage("1");
        user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/viewMessageByGroup.do", params);
        System.out.println("响应:" + json);

        // 解析
        MessageResponseDto resp = StringUtils.getObjectJson(MessageResponseDto.class, json);
        System.out.println(resp);

    }

    /**
     * 发送消息
     */
    @Test
    public void testsendCMessage() {
        // 封装参数
        MessageSendRequestDto user = new MessageSendRequestDto();
        user.setUid("260");
        user.setGroupId("100");
        user.setType("2");
        user.setContent("啊时代发生发送爱上了发撒地方拉升");
        user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/sendCMessage.do", params);
        System.out.println("响应:" + json);

        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    
    /**
     * 删除消息
     */
    @Test
    public void testDeleteCMessage() {
        // 封装参数
    	DeleteMessageRequestDto deleteMessage = new DeleteMessageRequestDto();
    	deleteMessage.setUid("260");
    	//删除组消息
    	deleteMessage.setId("100");
    	deleteMessage.setType("1");
    	deleteMessage.setToken(StringUtils.getToken(deleteMessage));
    	//删除消息
//    	deleteMessage.setId("853");
//    	deleteMessage.setType("2");
        // 调用
        List<String[]> params = getParamterList("", deleteMessage);
        String json = postRequest("/deleteCMessage.do", params);
        System.out.println("响应:" + json);

        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }

}
