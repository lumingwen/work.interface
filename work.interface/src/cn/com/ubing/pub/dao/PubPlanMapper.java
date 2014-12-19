package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.pub.dto.CPubPlanDto;
import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CUpdatePubPlanRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanListDto;
import cn.com.ubing.pub.dto.HistoryPlanListRequestDto;
import cn.com.ubing.pub.dto.PubPlanDto;
import cn.com.ubing.pub.model.PubPlan;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;



public interface PubPlanMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlan record);

    PubPlan selectByPrimaryKey(Long id);
    
    PubPlan selectCByPrimaryKey(Long id);

    int updateByPrimaryKey(PubPlan record);
    
    int updatePubPlanById(CUpdatePubPlanRequestDto pub);
    /**
     * 根据需求id用户id和需求类型查找方案
     * 
     * @author 邱全松 2014-8-13 下午6:06:39
     * @param record
     * @return
     */
    PubPlan getByRequirementIdAndType(PubPlan record);
    /**
     * 历史方案列表
     * 
     * @author 邱全松 2014-8-14 下午2:47:57
     * @param dto
     * @return
     */
    List<HistoryPlanListDto> HistoryPlanList(HistoryPlanListRequestDto dto,PageBounds pageBounds);
    
    
	/**
	 * 根据需求类型和需求id查询关联的优惠券字符串
	 * 
	 */
	String getCouponStr(Integer requirementType,Long requirementId);
	/**
	 * 同意一条方案
	 * 
	 * @author 邱全松 2014-11-5 上午10:59:38
	 * @param planId
	 * @return
	 */
	Integer agreePlan(Long planId);
	/**
     * 拒绝一条方案
     * 
     * @author 邱全松 2014-11-5 上午10:59:46
     * @param planId
     * @return
     */
    Integer rejectPlan(Long planId);
	/**
	 * 拒绝其他方案
	 * 
	 * @author 邱全松 2014-11-5 上午10:59:46
	 * @param planId
	 * @return
	 */
	Integer rejectOtherPlan(PubPlan param);
	
	
    /**
     * 根据需求id查询相关方案信息列表
     * 
     * @author Administrator 2014-6-9 上午10:56:24
     * @param requirementId
     * @param pageBounds
     * @return
     */
    List<PubPlanDto> listByPage(CRequirementDetailRequestDto record,PageBounds pageBounds);
    
    /**
     * 根据需求id查询相关方案信息列表
     * 
     * @author Administrator 2014-6-9 上午10:56:24
     * @param requirementId
     * @param pageBounds
     * @return
     */
    List<CPubPlanDto> listPubPlanByPage(CRequirementDetailRequestDto record,PageBounds pageBounds);
//    /**
//     * 查询用户未读方案
//     * 
//     * @author 邱全松 2014-9-5 下午12:24:22
//     * @param userId
//     * @param pageBounds
//     * @return
//     */
//    PageList<PubPlanDto> listUserByPage(Long userId,PageBounds pageBounds);
}