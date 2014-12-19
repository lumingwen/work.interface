package test.binterface.pub;

import java.util.List;

import org.junit.Test;

import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.pub.dto.AppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.AppraisalDetailResponseDto;
import cn.com.ubing.pub.dto.AppraisalListRequestDto;
import cn.com.ubing.pub.dto.AppraisalListResponseDto;
import cn.com.ubing.pub.dto.AppraisalSaveRequestDto;
import test.base.BaseTest;

public class BAppraisalControllerTest extends BaseTest{
    /**
     * 评价信息列表
     * 
     * @author 邱全松 2014-6-27 下午2:22:11
     */
    @Test
    public void testAppraisalList() {
        // 封装参数
        AppraisalListRequestDto param = new AppraisalListRequestDto();
        param.setUid("196");
        param.setToken(StringUtils.getToken(param));
        param.setPlanStatus("1");//方案评价状态：1:需评价,2:已评价,3:拒绝
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/appraisalList.do", params);
        System.out.println("响应:" + json);
        // 解析
        AppraisalListResponseDto resp = StringUtils.getObjectJson(AppraisalListResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 评价信息详情
     * 
     * @author 邱全松 2014-6-27 下午2:22:11
     */
    @Test
    public void testAppraisalInfo() {
        // 封装参数
        AppraisalDetailRequestDto param = new AppraisalDetailRequestDto();
        param.setUid("2");
        param.setRequirementId("1");
        param.setRequirementType("1");
        param.setToken(StringUtils.getToken(param));
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/appraisalDetail.do", params);
        System.out.println("响应:" + json);
        // 解析
        AppraisalDetailResponseDto resp = StringUtils.getObjectJson(AppraisalDetailResponseDto.class, json);
        System.out.println(resp);
    }
    /**
     * 保存评价信息
     * 
     * @author 邱全松 2014-6-27 下午2:22:11
     */
    @Test
    public void testSaveAppraisal() {
        // 封装参数
        AppraisalSaveRequestDto param = new AppraisalSaveRequestDto();
        param.setUid("196");
        param.setToken(StringUtils.getToken(param));
        param.setPlanId("1");
        param.setAppraisalResponseContent("aaaaaaaaa");
        param.setRequirementUserId("180");
        // 调用
        List<String[]> params = getParamterList("", param);
        String json = postRequest("/saveAppraisal.do", params);
        System.out.println("响应:" + json);
        // 解析
        ResponseDto resp = StringUtils.getObjectJson(ResponseDto.class, json);
        System.out.println(resp);
    }
}
