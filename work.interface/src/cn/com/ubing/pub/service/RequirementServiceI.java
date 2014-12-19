package cn.com.ubing.pub.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.pub.dao.GiveUpRequirementRequestDto;
import cn.com.ubing.pub.dto.GetRequirementInfoRequest;
import cn.com.ubing.pub.dto.GetRequirementInfoResponse;
import cn.com.ubing.pub.dto.GrabRequirementRequestDto;
import cn.com.ubing.pub.dto.GrabRequirementResponseDto;
import cn.com.ubing.pub.dto.HomePageInfoDto;
import cn.com.ubing.pub.dto.RequirementDetailRequestDto;
import cn.com.ubing.pub.dto.RequirementDetailResponseDto;
import cn.com.ubing.pub.dto.RequirementDto;
import cn.com.ubing.pub.dto.RequirementListRequest;
import cn.com.ubing.rms.dto.RmsUserRequestDto;

/**
 * 抢单相关信息
 * 
 * @author 邱全松 2014-6-24 下午1:46:54
 */
public interface RequirementServiceI {
    /**
     * (B端)查询历史需求列表
     * 
     * @author 邱全松 2014-6-25 上午10:29:05
     * @return
     */
    List<RequirementDto> queryRequirementList(RequirementListRequest dto,PageBounds pageBounds);
    
	/**
	 * (B端)等待抢单主页信息获取
	 * 
	 * @author 邱全松 2014-6-24 下午2:50:07
	 * @param dto
	 * @param resDto
	 * @return
	 */
	HomePageInfoDto getHomePageInfoDto(RequestDto resDto);


	/**
	 * (B端)根据需求ID查询需求详细信息
	 * 
	 * @author 邱全松 2014-6-25 下午2:54:39
	 * @param dto
	 * @return
	 */
	RequirementDetailResponseDto getRequirementDetail(
			RequirementDetailRequestDto reqDto);

	/**
	 * 
	 * (B端)历史订单
	 * 
	 * @author lumingwen 2014年7月1日 下午1:31:30
	 * @param dto
	 * @return
	 */
	int countRequirement(RmsUserRequestDto dto);
	
	/**
     * 
     * (B端)抢单
     * 
     * @author lumingwen 2014年7月1日 下午1:31:30
     * @param dto
     * @return
     */
	GrabRequirementResponseDto grapRequirement(GrabRequirementRequestDto dto);
	/**
	 * 放弃抢单
	 * 
	 * @author 邱全松 2014-9-3 下午7:20:20
	 * @param dto
	 * @return
	 */
	int giveUpRequirement(GiveUpRequirementRequestDto dto);
	/**
	 * 获取需求信息
	 * 
	 * @author 邱全松 2014-9-13 下午2:11:34
	 * @param dto
	 * @return
	 */
	GetRequirementInfoResponse getRequirementInfo(GetRequirementInfoRequest dto);
}
