package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CRequirementHotelDetailResponseDto;
import cn.com.ubing.pub.dto.PubRequirementHotelDto;
import cn.com.ubing.pub.model.PubRequirementHotel;

public interface PubRequirementHotelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubRequirementHotel record);

    PubRequirementHotel selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubRequirementHotel record);
    
    PubRequirementHotelDto  queryRequirementHotelById(Long id);
    
    CRequirementHotelDetailResponseDto queryRequirementHotelDetailById(
			CRequirementDetailRequestDto param);
}