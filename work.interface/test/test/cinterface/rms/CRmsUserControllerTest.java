/**
 * 
 */
package test.cinterface.rms;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.rms.dto.CMainViewResponseDto;
import cn.com.ubing.rms.dto.ForgetPasswordRequestDto;
import cn.com.ubing.rms.dto.ForgetPasswordResponseDto;
import cn.com.ubing.rms.dto.GetCodeRequestDto;
import cn.com.ubing.rms.dto.GetCodeResponseDto;
import cn.com.ubing.rms.dto.MainViewResponseDto;
import cn.com.ubing.rms.dto.UserCenterResponseDto;
import cn.com.ubing.rms.dto.UserLoginRequestDto;
import cn.com.ubing.rms.dto.UserLoginResponseDto;
import cn.com.ubing.rms.dto.UserSetPhotoRequestDto;
import cn.com.ubing.rms.dto.UserSetPhotoResponseDto;
import cn.com.ubing.rms.dto.userEmailResponseDto;
import cn.com.ubing.rms.dto.userEmailSetRequestDto;
import cn.com.ubing.rms.dto.userNickNameResponseDto;
import cn.com.ubing.rms.dto.userNickNameSetRequestDto;

/**
 * 
 * 测试C端
 * 
 * @author lumw
 * 
 * 
 */
public class CRmsUserControllerTest extends BaseTest {

	/**
	 * 测试登录
	 */
	@Test
	public void testUserLogin() {

		// 封装参数
		UserLoginRequestDto user = new UserLoginRequestDto();
		user.setDeviceID("145");
		user.setUserTel("13880745410");
		user.setUserPw("111111");
		user.setToken(StringUtils.getToken(user));

		// 调用
		List<String[]> params = getParamterList("", user);
		String json = postRequest("/c/userLogin.do", params);
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

	/**
	 * 测试修改昵称
	 */
	@Test
	public void testUserNickNameSet() {
		// 封装参数
		userNickNameSetRequestDto user = new userNickNameSetRequestDto();
		user.setDeviceID("145");
		user.setUid("312");
		user.setNickName("xiaolu");
		user.setToken(StringUtils.getToken(user));
		// 调用
		List<String[]> params = getParamterList("", user);
		String json = postRequest("/c/userNickNameSet.do", params);
		System.out.println("响应:" + json);

		// 解析
		userNickNameResponseDto resp = StringUtils.getObjectJson(
				userNickNameResponseDto.class, json);
		System.out.println(resp);

	}	
	/**
	 * 测试登录
	 */
	@Test
	public void testuserEmailSet() {
		// 封装参数
		userEmailSetRequestDto user = new userEmailSetRequestDto();
		user.setDeviceID("145");
		user.setUid("312");
		user.setEmail("337859518@qq.com");
		user.setToken(StringUtils.getToken(user));
		// 调用
		List<String[]> params = getParamterList("", user);
		String json = postRequest("userEmailSet.do", params);
		System.out.println("响应:" + json);

		// 解析
		userEmailResponseDto resp = StringUtils.getObjectJson(
				userEmailResponseDto.class, json);
		System.out.println(resp);

	}	
	
	
	/**
	 * 测试登录
	 */
	@Test
	public void testuserPhotoSet() {
		// 封装参数
		UserSetPhotoRequestDto user = new UserSetPhotoRequestDto();
		user.setDeviceID("145");
		user.setUid("312");
		user.setImageId("12");
		user.setToken(StringUtils.getToken(user));
		// 调用
		List<String[]> params = getParamterList("", user);
		String json = postRequest("cUserSetPhoto.do", params);
		System.out.println("响应:" + json);

		// 解析
		UserSetPhotoResponseDto resp = StringUtils.getObjectJson(
				UserSetPhotoResponseDto.class, json);
		System.out.println(resp);

	}	
	
	
	/**
	 * 测试个人中心
	 */
	@Test
	public void testuserCenter() {
	    // 封装参数
        RequestDto param = new RequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/cUserCenter.do", params);
        System.out.println("响应:" + json);
        // 解析
        UserCenterResponseDto resp = StringUtils.getObjectJson(UserCenterResponseDto.class, json);
        System.out.println(resp);
	}
	
	/**
     * 测试主页
     */
    @Test
    public void testGetMainView() {
        // 封装参数
        RequestDto param = new RequestDto();
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getMainViewInfo.do", params);
        System.out.println("响应:" + json);
        // 解析
        CMainViewResponseDto resp = StringUtils.getObjectJson(CMainViewResponseDto.class, json);
        System.out.println(resp);
    }
}
