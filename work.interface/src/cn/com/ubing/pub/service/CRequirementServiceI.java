package cn.com.ubing.pub.service;

import java.text.ParseException;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CRequirementGroupVisitDetailResponseDto;
import cn.com.ubing.pub.dto.CRequirementHotelDetailResponseDto;
import cn.com.ubing.pub.dto.CRequirementListRequestDto;
import cn.com.ubing.pub.dto.CRequirementListResponseDto;
import cn.com.ubing.pub.dto.CRequirementPersonalVisitDetailResponseDto;
import cn.com.ubing.pub.dto.CRequirementTicketDetailResponseDto;
import cn.com.ubing.pub.dto.PubPlanCountOutResponseDto;
import cn.com.ubing.pub.dto.SaveGroupRequirementRequestDto;
import cn.com.ubing.pub.dto.SaveHotelRequirementRequestDto;
import cn.com.ubing.pub.dto.SavePersonalRequirementRequestDto;
import cn.com.ubing.pub.dto.SaveTicketRequirementRequestDto;

public interface CRequirementServiceI {
    /**
     * 保存自由行需求
     * 
     * @author 邱全松 2014-10-30 下午3:23:37
     * @param param
     * @return
     */
    Integer SavePersonalRequirement(SavePersonalRequirementRequestDto param) throws ParseException;
    /**
     * 保存跟团行需求
     * 
     * @author 邱全松 2014-10-31 下午2:01:03
     * @param param
     * @return
     * @throws ParseException
     */
    Integer SaveGroupRequirement(SaveGroupRequirementRequestDto param) throws ParseException;
    /**
     * 保存机票需求
     * 
     * @author 邱全松 2014-11-4 下午3:19:51
     * @param param
     * @return
     * @throws ParseException
     */
    Integer SaveTicketRequirement(SaveTicketRequirementRequestDto param) throws ParseException;
    /**
     * 保存酒店需求
     * 
     * @author 邱全松 2014-11-4 下午3:20:05
     * @param param
     * @return
     * @throws ParseException
     */
    Integer SaveHotelRequirement(SaveHotelRequirementRequestDto param) throws ParseException;
    /**
     * 检查用户是否超出需求提交最大次数
     * 
     * @author 邱全松 2014-10-30 下午5:17:18
     * @param userId
     * @return 0:可以提交
     *         1:超出提交需求最大次数限制
     * 
     */
    Integer CheckSubmitRequirementStatus(Long userId);
    /**
     * 查询我的招标列表
     * 
     * @author 邱全松 2014-11-4 下午5:49:56
     * @param param
     * @param pageBounds
     * @return
     */
    CRequirementListResponseDto queryRequirementList(CRequirementListRequestDto param,PageBounds pageBounds);
    
    /**
     * 根据id查询需求详情(机票)
     * @param param
     * @param pageBounds
     * @return
     */
    
    CRequirementTicketDetailResponseDto queryRequirementTickDetailById(CRequirementDetailRequestDto param);
    
    /**
     * 根据id查询需求详情(酒店)
     * @param param
     * @param pageBounds
     * @return
     */
    
    CRequirementHotelDetailResponseDto queryRequirementHotelDetailById(CRequirementDetailRequestDto param);
    
    /**
     * 根据id查询需求详情(自由行)
     * @param param
     * @param pageBounds
     * @return
     */
    
    CRequirementPersonalVisitDetailResponseDto queryRequirementPersonalVisitDetailById(CRequirementDetailRequestDto param);
    
    /**
     * 根据id查询需求详情(更团行)
     * @param param
     * @param pageBounds
     * @return
     */
    
    CRequirementGroupVisitDetailResponseDto queryRequirementGroupVisiDetailById(CRequirementDetailRequestDto param);
    
	/**
	 * 查询招标总数
	 * @param param
	 * @param pageBounds
	 * @return
	 */
    public PubPlanCountOutResponseDto queryPubPlanCount(RequestDto param);
    
    
}
