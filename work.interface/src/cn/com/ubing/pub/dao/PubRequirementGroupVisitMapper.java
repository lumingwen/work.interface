package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CRequirementGroupVisitDetailResponseDto;
import cn.com.ubing.pub.dto.PubRequirementGroupVisitDto;
import cn.com.ubing.pub.model.PubRequirementGroupVisit;

public interface PubRequirementGroupVisitMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubRequirementGroupVisit record);

    PubRequirementGroupVisit selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubRequirementGroupVisit record);
    
    
    PubRequirementGroupVisitDto queryRequirementGroupVisitById(Long id);
    
    CRequirementGroupVisitDetailResponseDto queryRequirementGroupVisiDetailById(
			CRequirementDetailRequestDto param);
}