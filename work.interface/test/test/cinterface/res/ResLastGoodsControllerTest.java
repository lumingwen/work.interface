package test.cinterface.res;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.res.dto.CResBuyLastGoodsRequestDto;
import cn.com.ubing.res.dto.CResBuyLastGoodsResponseDto;
import cn.com.ubing.res.dto.CResLastGoodsDetailRequestDto;
import cn.com.ubing.res.dto.CResLastGoodsDetailResponseDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityInfoRequestDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityInfoResponseDto;
import cn.com.ubing.res.dto.WelfareListRequestDto;
import cn.com.ubing.res.dto.WelfareListResponseDto;

public class ResLastGoodsControllerTest extends BaseTest {
    @Test
    public void testGetLastGoodsDetail() {
        // 封装参数
        CResLastGoodsDetailRequestDto param = new CResLastGoodsDetailRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setLastGoodId("4");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getLastGoodsDetail.do", params);
        System.out.println("响应:" + json);
        // 解析
        CResLastGoodsDetailResponseDto resp = StringUtils.getObjectJson(CResLastGoodsDetailResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testQueryLastGoodsPriceQuantity() {
        // 封装参数
        ResLastGoodsPriceQuantityInfoRequestDto param = new ResLastGoodsPriceQuantityInfoRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setLastGoodsId("4");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/queryLastGoodsPriceQuantity.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResLastGoodsPriceQuantityInfoResponseDto resp = StringUtils.getObjectJson(ResLastGoodsPriceQuantityInfoResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testBuyLastGoods() {
        // 封装参数
        CResBuyLastGoodsRequestDto param = new CResBuyLastGoodsRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setLastGoodsId("4");
        param.setTime("2014-11-18");
        param.setPeopleCount("2");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/buyLastGoods.do", params);
        System.out.println("响应:" + json);
        // 解析
        CResBuyLastGoodsResponseDto resp = StringUtils.getObjectJson(CResBuyLastGoodsResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testWelfareList() {
        // 封装参数
        WelfareListRequestDto param = new WelfareListRequestDto();
        param.setDeviceID("aaa");
        param.setUid("351");
        param.setLimit("10");
        param.setPage("1");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/welfareList.do", params);
        System.out.println("响应:" + json);
        // 解析
        WelfareListResponseDto resp = StringUtils.getObjectJson(WelfareListResponseDto.class, json);
        System.out.println(resp);
    }
}
