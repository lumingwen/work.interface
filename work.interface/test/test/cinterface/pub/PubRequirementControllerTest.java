package test.cinterface.pub;

import java.util.List;

import org.junit.Test;

import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CRequirementListRequestDto;
import cn.com.ubing.pub.dto.CRequirementListResponseDto;
import cn.com.ubing.pub.dto.SaveGroupRequirementRequestDto;
import cn.com.ubing.pub.dto.SaveHotelRequirementRequestDto;
import cn.com.ubing.pub.dto.SavePersonalRequirementRequestDto;
import cn.com.ubing.pub.dto.SaveTicketRequirementRequestDto;
import test.base.BaseTest;

public class PubRequirementControllerTest extends BaseTest {
    @Test
    public void testSavePersonalRequirement() {//保存自由行需求
        // 封装参数
        SavePersonalRequirementRequestDto param = new SavePersonalRequirementRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setBirthland("1844");
        param.setDestination("36");
        param.setDepartureTime("2014-11-11");
        param.setTripCount("1");
        param.setPeopleCount("2");
        param.setDetail("补充说明。。。。");
        param.setChildPeopleCount("1");
        param.setTheme("2");
        param.setBudget("你大爷");
        param.setCoupon("2");
        param.setContactsName("联系人姓名");
        param.setContactsTel("1352124221");
        param.setTransportation("2");
        param.setAddeds("1,2,3");
        param.setHotelLevel("21");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/SavePersonalRequirement.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testSaveGroupRequirement() {//保存跟团行需求
        // 封装参数
        SaveGroupRequirementRequestDto param = new SaveGroupRequirementRequestDto();
        param.setUid("351");
        param.setToken(StringUtils.getToken(param));
        param.setBirthland("1844");
        param.setDestination("36");
        param.setDepartureTime("2014-11-11");
        param.setTripCount("1");
        param.setPeopleCount("2");
        param.setDetail("补充说明2。。。。");
        param.setChildPeopleCount("1");
        param.setBudget("你大爷");
        param.setCoupon("2");
        param.setContactsName("联系人姓名");
        param.setContactsTel("1352124221");
        param.setHotelLevel("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/SaveGroupRequirement.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testSaveTicketRequirement() {//保存机票需求
        // 封装参数
        SaveTicketRequirementRequestDto param = new SaveTicketRequirementRequestDto();
        param.setUid("351");
        param.setPeopleCount("2");//出行人数
        param.setBirthland("3");//出发地id(关联字典表)
        param.setDestination("21");//目的地id(关联字典表)
        param.setDepartureTime("2014-12-26");//出发时间
        param.setReturnTime("2014-12-27");//返程时间
        param.setDetail("我要坐灰机咯");//补充说明
        param.setTicketType("2");//机票类型1单程2往返
        param.setDepartureTimeDay("1");//出发时间（关联字典表）
        param.setTicketSpace("2");//机票舱位(关联字典表)
        param.setCoupon("2");// 优惠卷（关联优惠卷表）
        param.setContactsName("飞飞");// 联系人姓名
        param.setContactsTel("110");// 联系人电话
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/SaveTicketRequirement.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testSaveHotelRequirement() {//保存酒店需求
        // 封装参数
        SaveHotelRequirementRequestDto param = new SaveHotelRequirementRequestDto();
        param.setUid("351");
        param.setDestination("33");//目的地ID
        param.setDepartureTime("2014-12-12");//出行时间yyyy-MM-dd
        param.setTripCount("1");//住几晚
        param.setHotelRooms("2");//住几间房
        param.setHotelPrice("3");//酒店价格（关联字典表）
        param.setHotelLevel("4");//酒店星级（关联字典表）
        param.setDetail("fdafdsafdasfd");//详细说明
        param.setPoint("fdsafdsa");//关键字
        param.setCoupon("3");// 优惠卷（关联优惠卷表）
        param.setContactsName("tom");// 联系人姓名
        param.setContactsTel("112");// 联系人电话
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/SaveHotelRequirement.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
    @Test
    public void testQueryRequirementList() {//查询我的招标列表
        // 封装参数
        CRequirementListRequestDto param = new CRequirementListRequestDto();
        param.setUid("273");
        param.setLimit("3");
        param.setPage("1");
        param.setStatus("2");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/queryRequirementList.do", params);
        System.out.println("响应:" + json);
        // 解析
        CRequirementListResponseDto resp = StringUtils.getObjectJson(CRequirementListResponseDto.class, json);
        System.out.println(resp);
    }
    
    //需求详细查看(lumw)
    @Test
    public void testQueryRequirementDetailById() {
        // 封装参数
    	CRequirementDetailRequestDto param = new CRequirementDetailRequestDto();
        param.setUid("273");
        //自由行
//        param.setRequirementId("203");
//        param.setRequirementType("3");
        //更团行
//        param.setRequirementId("148");
//        param.setRequirementType("4");
        //酒店
//        param.setRequirementId("10");
//        param.setRequirementType("2");
////      //机票
//         param.setRequirementId("30");
//         param.setRequirementType("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/queryRequirementDetailById.do", params);
        System.out.println("响应:" + json);
        // 解析
//        CRequirementTicketDetailResponseDto resp = StringUtils.getObjectJson(CRequirementTicketDetailResponseDto.class, json);
//        System.out.println(resp);
    }
    
    
}
