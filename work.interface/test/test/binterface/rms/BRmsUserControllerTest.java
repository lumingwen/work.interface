/**
 * 
 */
package test.binterface.rms;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.rms.dto.ForgetPasswordRequestDto;
import cn.com.ubing.rms.dto.ForgetPasswordResponseDto;
import cn.com.ubing.rms.dto.GetCodeRequestDto;
import cn.com.ubing.rms.dto.GetCodeResponseDto;
import cn.com.ubing.rms.dto.MainViewResponseDto;
import cn.com.ubing.rms.dto.UserLoginRequestDto;
import cn.com.ubing.rms.dto.UserLoginResponseDto;

/**
 * 
 * 测试B端
 * 
 * @author zhangxujun
 * 
 * 
 */
public class BRmsUserControllerTest extends BaseTest {

	/**
	 * 测试登录
	 */
	@Test
	public void testUserLogin() {

		// 封装参数
		UserLoginRequestDto user = new UserLoginRequestDto();
		user.setDeviceID("145");
		user.setUserTel("13888888888");
		user.setUserPw("111111");
		user.setToken(StringUtils.getToken(user));

		// 调用
		List<String[]> params = getParamterList("", user);
		String json = postRequest("/userLogin.do", params);
		System.out.println("响应:" + json);

		// 解析
		UserLoginResponseDto resp = StringUtils.getObjectJson(
				UserLoginResponseDto.class, json);
		System.out.println(resp);

	}
	/**
     * 测试登录
     */
    @Test
    public void testMainView() {

        // 封装参数
        RequestDto user = new RequestDto();
        user.setDeviceID("145");
        user.setUid("196");
        user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/mainView.do", params);
        System.out.println("响应:" + json);

        // 解析
        MainViewResponseDto resp = StringUtils.getObjectJson(
                MainViewResponseDto.class, json);
        System.out.println(resp);

    }
	/**
     * 测试获取验证码
     */
    @Test
    public void testGetScode() {

        // 封装参数
        GetCodeRequestDto user = new GetCodeRequestDto();
        user.setUid("");
        user.setDeviceID("5");
        user.setUserTel("13888888888");
        user.setType("2");
        user.setToken(StringUtils.getToken(user));

        // 调用
        List<String[]> params = getParamterList("", user);
        String json = postRequest("/getScode.do", params);
        System.out.println("响应:" + json);

        // 解析
        GetCodeResponseDto resp = StringUtils.getObjectJson(
                GetCodeResponseDto.class, json);
        System.out.println(resp);

    }
	/**
	 * 测试忘记密码
	 */
	@Test
	public void testForgetPassword() {

		// 封装参数
		ForgetPasswordRequestDto user = new ForgetPasswordRequestDto();
		user.setDeviceID("145");
		user.setUserTel("15984885552");
		user.setScode("23");
		user.setPassword("12");
		user.setNextPassword("12");
		user.setToken(StringUtils.getToken(user));

		// 调用
		List<String[]> params = getParamterList("", user);
		String json = postRequest("/forgetPassword.do", params);
		System.out.println("响应:" + json);

		// 解析
		ForgetPasswordResponseDto resp = StringUtils.getObjectJson(
				ForgetPasswordResponseDto.class, json);
		System.out.println(resp);

	}

}
