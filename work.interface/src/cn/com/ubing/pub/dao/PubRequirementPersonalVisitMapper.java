package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CRequirementPersonalVisitDetailResponseDto;
import cn.com.ubing.pub.dto.PubRequirementPersonalVisitDto;
import cn.com.ubing.pub.model.PubRequirementPersonalVisit;

public interface PubRequirementPersonalVisitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubRequirementPersonalVisit record);

    PubRequirementPersonalVisit selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubRequirementPersonalVisit record);
    
    PubRequirementPersonalVisitDto  queryRequirementPersonalVisitById(Long id);
    
    int selectRequirementCountByUser(Long userId);
    
    CRequirementPersonalVisitDetailResponseDto queryRequirementPersonalVisitDetailById(
			CRequirementDetailRequestDto param);
}