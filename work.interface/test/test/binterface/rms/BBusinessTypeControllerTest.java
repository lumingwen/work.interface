package test.binterface.rms;

import java.util.List;

import org.junit.Test;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.rms.dto.BusinessLinesRequestDto;
import cn.com.ubing.rms.dto.BusinessLinesResponseDto;
import cn.com.ubing.rms.dto.BusinessTypeAndLinesRequestDto;
import cn.com.ubing.rms.dto.BusinessTypeResponseDto;
import test.base.BaseTest;

public class BBusinessTypeControllerTest extends BaseTest{
    /**
     * 保存信息
     * 
     * @author 邱全松 2014-7-15 下午1:59:30
     */
    @Test
    public void testSaveBusinessTypeAndLines() {
        // 封装参数
        BusinessTypeAndLinesRequestDto param = new BusinessTypeAndLinesRequestDto();
        param.setUid("196");
        param.setToken(StringUtils.getToken(param));
        param.setBusinessType("2");
        param.setLineIds("1870,1871,1872,1873,1874");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/saveBusinessTypeAndLines.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 获取商家主营业务类型
     * 
     * @author 邱全松 2014-7-15 下午1:59:38
     */
    @Test
    public void testGetBusinessTypes() {
        // 封装参数
        RequestDto param = new RequestDto();
        param.setUid("226");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getBusinessTypes.do", params);
        System.out.println("响应:" + json);
        // 解析
        BusinessTypeResponseDto resp = StringUtils.getObjectJson(BusinessTypeResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 获取商家经营线路
     * 
     * @author 邱全松 2014-7-15 下午1:59:54
     */
    @Test
    public void testGetlines() {
        // 封装参数
        BusinessLinesRequestDto param = new BusinessLinesRequestDto();
        param.setUid("229");
        param.setToken(StringUtils.getToken(param));
        param.setBusinessType("4");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getlines.do", params);
        System.out.println("响应:" + json);
        // 解析
        BusinessLinesResponseDto resp = StringUtils.getObjectJson(BusinessLinesResponseDto.class, json);
        System.out.println(resp);
    }
}
