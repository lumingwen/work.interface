package cn.com.ubing.rms.dao;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.rms.dto.CompanyCheckInfoResponseDto;
import cn.com.ubing.rms.dto.RealNameCheckResponseDto;
import cn.com.ubing.rms.model.RmsUserCheck;

public interface RmsUserCheckMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RmsUserCheck record);

    int insertSelective(RmsUserCheck record);

    RmsUserCheck selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RmsUserCheck record);

    int updateByPrimaryKey(RmsUserCheck record);
    /**
     * 机构认证信息获取
     * 
     * @author 邱全松 2014-6-27 上午9:48:51
     * @param dto
     * @return
     */
    CompanyCheckInfoResponseDto getCompanyCheckInfo(RequestDto dto);
    /**
     * 实名认证信息获取
     * 
     * @author 邱全松 2014-6-27 上午9:49:06
     * @param dto
     * @return
     */
    RealNameCheckResponseDto getRealNameCheckInfo(RequestDto dto);
}