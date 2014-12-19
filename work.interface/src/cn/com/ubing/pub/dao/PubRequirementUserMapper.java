package cn.com.ubing.pub.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.pub.dto.CRequirementListDto;
import cn.com.ubing.pub.dto.CRequirementListRequestDto;
import cn.com.ubing.pub.dto.GetRequirementInfoRequest;
import cn.com.ubing.pub.dto.GetRequirementInfoResponse;
import cn.com.ubing.pub.dto.GrabRequirementRequestDto;
import cn.com.ubing.pub.dto.RequirementDto;
import cn.com.ubing.pub.dto.RequirementListRequest;
import cn.com.ubing.pub.model.PubRequirementUser;

public interface PubRequirementUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubRequirementUser record);

    int insertSelective(PubRequirementUser record);

    PubRequirementUser selectByPrimaryKey(Long id);
    
    List<RequirementDto> queryRequirementList(RequirementListRequest param,PageBounds pageBounds);

    int updateByPrimaryKeySelective(PubRequirementUser record);

    int updateByPrimaryKey(PubRequirementUser record);
    /**
     * 根据需求id和类型和用户id查询
     * 
     * @author 邱全松 2014-9-3 下午6:46:36
     * @param record
     * @return
     */
    PubRequirementUser selectByIdAndTypeAndUser(PubRequirementUser record);
    /**
     * 获取机票订单信息
     * 
     * @author 邱全松 2014-9-13 下午2:14:53
     * @param dto
     * @return
     */
    GetRequirementInfoResponse getTicketRequirementInfo(GetRequirementInfoRequest dto);
    /**
     * 获取酒店订单信息
     * 
     * @author 邱全松 2014-10-21 上午10:00:23
     * @param dto
     * @return
     */
    GetRequirementInfoResponse getHotelRequirementInfo(GetRequirementInfoRequest dto);
    /**
     * 获取自由行订单信息
     * 
     * @author 邱全松 2014-10-21 上午10:00:33
     * @param dto
     * @return
     */
    GetRequirementInfoResponse getPersonalRequirementInfo(GetRequirementInfoRequest dto); 
    /**
     * 获取跟团行订单信息
     * 
     * @author 邱全松 2014-10-21 上午10:00:48
     * @param dto
     * @return
     */
    GetRequirementInfoResponse getGroupRequirementInfo(GetRequirementInfoRequest dto);
    /**
     * 检查已抢单人数是否已经超过限制
     * 
     * @author 邱全松 2014-9-18 上午9:58:10
     * @param dto
     * @return 0已经超过限制，1未超过限制
     */
    Integer checkGrapRequirement(GrabRequirementRequestDto dto);
    /**
     * c端查询我的招标列表
     * 
     * @author 邱全松 2014-11-4 下午7:06:53
     * @param param
     * @param pageBounds
     * @return
     */
    PageList<CRequirementListDto> queryCRequirementList(CRequirementListRequestDto param, PageBounds pageBounds);
    
    int queryPubPlanCount(RequestDto param);
}