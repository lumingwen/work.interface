package cn.com.ubing.pub.service;

import java.util.List;

import cn.com.ubing.pub.dto.CHistoryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.CUpdatePubPlanRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.HistoryPlanListDto;
import cn.com.ubing.pub.dto.HistoryPlanListRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.LibraryPlanListDto;
import cn.com.ubing.pub.dto.LibraryPlanListRequestDto;
import cn.com.ubing.pub.dto.SavePlanRequestDto;
import cn.com.ubing.pub.dto.SavePlanResponseDto;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

/**
 * 方案信息处理
 * 
 * @author 邱全松 2014-6-25 下午6:22:00
 */
public interface PlanServiceI {
	/**
	 * (B端)获取历史方案详细信息
	 * 
	 * @author 邱全松 2014-6-25 下午6:26:24
	 * @param dto
	 * @return
	 */
	HistoryPlanDetailResponseDto getHistoryPlanDetail(
			HistoryPlanDetailRequestDto dto);

	/**
	 * (B端)获取方案库方案详细信息
	 * 
	 * @author 邱全松 2014-6-25 下午6:27:42
	 * @param dto
	 * @return
	 */
	LibraryPlanDetailResponseDto getLibraryPlanDetail(
			LibraryPlanDetailRequestDto dto);

	/**
	 * (B端)获取方案库方案列表信息
	 * 
	 * @author 邱全松 2014-6-25 下午8:28:54
	 * @param dto
	 * @return
	 */
	List<LibraryPlanListDto> queryLibraryPlanList(LibraryPlanListRequestDto dto,PageBounds pageBounds);

	/**
	 * (B端)获取历史方案列表信息
	 * 
	 * @author 邱全松 2014-6-25 下午8:28:58
	 * @param dto
	 * @return
	 */
	List<HistoryPlanListDto> queryHistoryPlanList(HistoryPlanListRequestDto dto,PageBounds pageBounds);
	/**
	 * (B端)保存方案
	 * 
	 * @author 邱全松 2014-8-14 下午8:36:14
	 * @param dto
	 * @return
	 */
	SavePlanResponseDto savePlan(SavePlanRequestDto dto);
	
	
	/**
	 * (B端)根据需求类型和需求id查询关联的优惠券字符串
	 * 
	 */
	String getCouponStr(Integer requirementType,Long requirementId);
	
		/**
		 * (c端)获取历史方案详细信息
		 * @param dto
		 * @return
		 */
	CHistoryPlanDetailResponseDto getHistoryCPlanDetail(
			HistoryPlanDetailRequestDto dto);
	
	
	public void updatePubPlanById(CUpdatePubPlanRequestDto dto);
}
