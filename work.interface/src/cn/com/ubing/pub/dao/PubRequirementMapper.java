package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.pub.dto.HomePageInfoDto;
import cn.com.ubing.pub.dto.RequirementDetailRequestDto;
import cn.com.ubing.pub.dto.RequirementDetailResponseDto;
import cn.com.ubing.pub.dto.RequirementDto;
import cn.com.ubing.pub.dto.RequirementRequestDto;
import cn.com.ubing.pub.model.PubRequirement;
import cn.com.ubing.rms.dto.RmsUserRequestDto;

public interface PubRequirementMapper {
	int deleteByPrimaryKey(Long id);

	int insert(PubRequirement record);

	int insertSelective(PubRequirement record);

	PubRequirement selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(PubRequirement record);

	int updateByPrimaryKey(PubRequirement record);

	/**
	 * 根据用户id查询主页信息
	 * 
	 * @author 邱全松 2014-6-24 下午1:49:22
	 * @param userId
	 * @return
	 */
	HomePageInfoDto getHomePageInfoDto(Long userId);

	/**
	 * 查询订单列表
	 * 
	 * @author 邱全松 2014-6-25 下午1:37:45
	 * @param dto
	 * @return
	 */
	List<RequirementDto> queryRequirementList(RequirementRequestDto dto);

	/**
	 * 查询订单详细信息
	 * 
	 * @author 邱全松 2014-6-25 下午3:09:21
	 * @param dto
	 * @return
	 */
	RequirementDetailResponseDto getRequirementDetail(
			RequirementDetailRequestDto dto);

	/**
	 * (B端) 菜单 历史订单总数
	 * 
	 * @author lumingwen 2014-6-25 下午8:28:58
	 * @param dto
	 * @return
	 */
	int countRequirement(RmsUserRequestDto dto);
	
	/**
	 * 
	 * 查询需求来源
	 */
	Integer getRequirementSouce(Integer requirementType,Long requirementId);
}