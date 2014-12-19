package test.cinterface.res;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.res.dto.ResCommonContactsDetailRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsDetailResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsListRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsListResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsSaveRequestDto;

public class ResCommonContactsControllerTest  extends BaseTest {
    @Test
    public void testResContactsList() {
        // 封装参数
        ResCommonContactsListRequestDto param = new ResCommonContactsListRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setLimit("10");
        param.setPage("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/ResCommonContactsList.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResCommonContactsListResponseDto resp = StringUtils.getObjectJson(ResCommonContactsListResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testResCommonContactsDetail() {
        // 封装参数
        ResCommonContactsDetailRequestDto param = new ResCommonContactsDetailRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setContactId("4");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/ResCommonContactsDetail.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResCommonContactsDetailResponseDto resp = StringUtils.getObjectJson(ResCommonContactsDetailResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testSaveResCommonContacts() {
        // 封装参数
        ResCommonContactsSaveRequestDto param = new ResCommonContactsSaveRequestDto();
        param.setUid("313");
        param.setToken(StringUtils.getToken(param));
        param.setName("老小宗宇");
        param.setTel("22");
        param.setCertificateTypeId("13198");
        param.setCertificateCode("fadfsds");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/SaveResCommonContacts.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
}
