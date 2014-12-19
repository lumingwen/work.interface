package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CRequirementTicketDetailResponseDto;
import cn.com.ubing.pub.dto.PubRequirementTicketDto;
import cn.com.ubing.pub.model.PubRequirementTicket;

public interface PubRequirementTicketMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubRequirementTicket record);

    PubRequirementTicket selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubRequirementTicket record);
    
    PubRequirementTicketDto  queryRequirementTickById(Long id);
    
    CRequirementTicketDetailResponseDto queryRequirementTickDetailById(CRequirementDetailRequestDto param);
}