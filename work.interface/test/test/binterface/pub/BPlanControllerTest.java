package test.binterface.pub;

import java.util.List;

import org.junit.Test;

import test.base.BaseTest;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.GetCouponStrRequestDto;
import cn.com.ubing.pub.dto.GetCouponStrResponseDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.HistoryPlanListRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanListResponseDto;
import cn.com.ubing.pub.dto.LibraryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.LibraryPlanListRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanListResponseDto;
import cn.com.ubing.pub.dto.SavaLibraryPlanRequestDto;
import cn.com.ubing.pub.dto.SavePlanRequestDto;
import cn.com.ubing.pub.dto.SavePlanResponseDto;
import cn.com.ubing.pub.dto.SubmitPlanRequestDto;

public class BPlanControllerTest extends BaseTest {
    /**
     * 历史方案详情查看
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testHistoryPlan() {
        // 封装参数
        HistoryPlanDetailRequestDto param = new HistoryPlanDetailRequestDto();
        param.setUid("2");
        param.setToken(StringUtils.getToken(param));
        //param.setId("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/historyPlan.do", params);
        System.out.println("响应:" + json);
        // 解析
        HistoryPlanDetailResponseDto resp = StringUtils.getObjectJson(HistoryPlanDetailResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 方案库方案详情查看
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testLibraryPlan() {
        // 封装参数
        LibraryPlanDetailRequestDto param = new LibraryPlanDetailRequestDto();
        param.setUid("2");
        param.setToken(StringUtils.getToken(param));
        param.setId("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/libraryPlan.do", params);
        System.out.println("响应:" + json);
        // 解析
        LibraryPlanDetailResponseDto resp = StringUtils.getObjectJson(LibraryPlanDetailResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 方案库方案列表查看
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testLibraryPlanList() {
        // 封装参数
        LibraryPlanListRequestDto param = new LibraryPlanListRequestDto();
        param.setUid("1");
        param.setToken(StringUtils.getToken(param));
        param.setRequirementId("1");
        //param.setType("2");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/libraryPlanList.do", params);
        System.out.println("响应:" + json);
        // 解析
        LibraryPlanListResponseDto resp = StringUtils.getObjectJson(LibraryPlanListResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 历史方案列表查看
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testHistoryPlanList() {
        // 封装参数
        HistoryPlanListRequestDto param = new HistoryPlanListRequestDto();
        param.setUid("302");
        param.setPlanType("3");
        param.setToken(StringUtils.getToken(param));
        param.setRequirementId("1");
        //param.setType("1");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/historyPlanList.do", params);
        System.out.println("响应:" + json);
        // 解析
        HistoryPlanListResponseDto resp = StringUtils.getObjectJson(HistoryPlanListResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 方案库方案保存
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testSaveLibraryPlan() {
        // 封装参数
        SavaLibraryPlanRequestDto param = new SavaLibraryPlanRequestDto();
        param.setUid("2");
        param.setToken(StringUtils.getToken(param));
        param.setType("1");
        param.setTravelRemark("飞机打飞机打浪费大家撒分居两地伺服电机来说");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/saveLibraryPlan.do", params);
        System.out.println("响应:" + json);
        // 解析
        HistoryPlanListResponseDto resp = StringUtils.getObjectJson(HistoryPlanListResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 方案提交
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testSubmitPlan() {
        // 封装参数
        SubmitPlanRequestDto param = new SubmitPlanRequestDto();
        param.setUid("2");
        param.setToken(StringUtils.getToken(param));
        param.setRequirementId("1");
        param.setType("1");
        param.setTravelRemark("方大夫觉得撒发来的撒放假了地方撒就是地方");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/submitPlan.do", params);
        System.out.println("响应:" + json);
        // 解析
        HistoryPlanListResponseDto resp = StringUtils.getObjectJson(HistoryPlanListResponseDto.class, json);
        System.out.println(resp);
    }
    
    
    /**
     * 根据需求类型和需求id查询优惠券字符串
     * 
     */
    @Test
    public void testGetCouponStrBeforePubplan() {
        // 封装参数
	GetCouponStrRequestDto param = new GetCouponStrRequestDto();
        param.setUid("1");
        param.setRequirementType("1");
        param.setRequirementId("1");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/getCouponStrBeforePubplan.do", params);
        System.out.println("响应:" + json);
        // 解析
        GetCouponStrResponseDto resp = StringUtils.getObjectJson(GetCouponStrResponseDto.class, json);
        System.out.println(resp);
    }
    
    
    /**
     * 方案保存
     * 
     * @author 邱全松 2014-6-25 下午1:57:14
     */
    @Test
    public void testSavePlan() {
        // 封装参数
    	SavePlanRequestDto param = new SavePlanRequestDto();
        param.setUid("1");
        param.setToken(StringUtils.getToken(param));
        param.setRequirementId("1");
        param.setPlanType("2");
        param.setRequirementId("205");
        param.setRequirementType("3");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/savePlan.do", params);
        System.out.println("响应:" + json);
        // 解析
        SavePlanResponseDto resp = StringUtils.getObjectJson(SavePlanResponseDto.class, json);
        System.out.println(resp);
    }
}
