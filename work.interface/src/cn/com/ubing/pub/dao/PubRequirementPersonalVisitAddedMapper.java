package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.pub.dto.PubRequirementPersonVisitAddDto;
import cn.com.ubing.pub.model.PubRequirementPersonalVisitAdded;

public interface PubRequirementPersonalVisitAddedMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubRequirementPersonalVisitAdded record);

    PubRequirementPersonalVisitAdded selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubRequirementPersonalVisitAdded record);
    
    List<PubRequirementPersonVisitAddDto> findPersonVisitAddedByRequirementId(Long requirementId);
}