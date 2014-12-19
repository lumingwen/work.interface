package test.binterface.rms;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.rms.dto.BusinessCompanyCheckRequestDto;
import cn.com.ubing.rms.dto.BusinessUserInfoResponseDto;
import cn.com.ubing.rms.dto.BusinessUserSetPhotoRequestDto;
import cn.com.ubing.rms.dto.CompanyCheckInfoResponseDto;
import cn.com.ubing.rms.dto.RealNameCheckResponseDto;
import cn.com.ubing.rms.dto.UpdateNickNameRequestDto;

public class BBusinessUserControllerTest extends BaseTest{
    /**
     * 用户中心
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testUserCenter() {
        // 封装参数
        RequestDto param = new RequestDto();
        param.setUid("196");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/userCenter.do", params);
        System.out.println("响应:" + json);
        // 解析
        BusinessUserInfoResponseDto resp = StringUtils.getObjectJson(BusinessUserInfoResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 用户头像设置
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testBusinessSetPhoto() {
        // 封装参数
        BusinessUserSetPhotoRequestDto param = new BusinessUserSetPhotoRequestDto();
        param.setUid("2");
        param.setToken(StringUtils.getToken(param));
        param.setImageId("11");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/businessSetPhoto.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 用户昵称修改
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testUpdateNickName() {
        // 封装参数
        UpdateNickNameRequestDto param = new UpdateNickNameRequestDto();
        param.setUid("2");
        param.setToken(StringUtils.getToken(param));
        param.setNickname("附近的垃圾发电是放假啦");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/updateNickName.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 获取机构认证信息
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testCompanyCheckInfo() {
        // 封装参数
        RequestDto param = new RequestDto();
        param.setUid("196");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/companyCheckInfo.do", params);
        System.out.println("响应:" + json);
        // 解析
        CompanyCheckInfoResponseDto resp = StringUtils.getObjectJson(CompanyCheckInfoResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 获取实名认证信息
     * 
     * @author 邱全松 2014-6-27 上午9:41:14
     */
    @Test
    public void testRealNameCheckInfo() {
        // 封装参数
        RequestDto param = new RequestDto();
        param.setUid("229");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/realNameCheckInfo.do", params);
        System.out.println("响应:" + json);
        // 解析
        RealNameCheckResponseDto resp = StringUtils.getObjectJson(RealNameCheckResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 机构认证信息保存
     * 
     * @author 邱全松 2014-6-27 上午9:41:19
     */
    @Test
    public void testCompanyCheck() {
        // 封装参数
        BusinessCompanyCheckRequestDto param = new BusinessCompanyCheckRequestDto();
        param.setUid("9");
        param.setToken(StringUtils.getToken(param));
        param.setCompanyName("牛3逼公司");
        param.setPhotoId("224");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/saveOrUpdateCompanyCheck.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
}
