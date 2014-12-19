package test.binterface.res;

import java.util.List;

import org.junit.Test;

import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.res.dto.CheckDictReponseDto;
import cn.com.ubing.res.dto.CheckDictRequestDto;
import cn.com.ubing.res.dto.ResDictRequestDto;
import cn.com.ubing.res.dto.ResDictResponseDto;
import test.base.BaseTest;

public class ResDictControllerTest extends BaseTest  {
    @Test
    public void testGetResDict() {
        // 封装参数
        ResDictRequestDto param = new ResDictRequestDto();
        param.setUid("2");
        param.setToken(StringUtils.getToken(param));
        param.setType("JLXL");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getResDict.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResDictResponseDto resp = StringUtils.getObjectJson(ResDictResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testCheckResDict() {
        // 封装参数
        CheckDictRequestDto param = new CheckDictRequestDto();
        param.setUid("313");
        param.setToken(StringUtils.getToken(param));
        param.setType("JLXL");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/checkDict.do", params);
        System.out.println("响应:" + json);
        // 解析
        CheckDictReponseDto resp = StringUtils.getObjectJson(CheckDictReponseDto.class, json);
        System.out.println(resp);
    }
}
