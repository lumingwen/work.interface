package cn.com.ubing.rms.dao;

import java.util.List;

import cn.com.ubing.rms.dto.RmsGoldBusinessDto;
import cn.com.ubing.rms.model.RmsUserTitle;


public interface RmsUserTitleMapper {
	int deleteByPrimaryKey(Long id);

	int insert(RmsUserTitle record);

	int insertSelective(RmsUserTitle record);

	RmsUserTitle selectByPrimaryKey(Long id);

	List<RmsUserTitle> getTitleListByUserId(Long userId);
	
	RmsUserTitle getByUserIdAndType(RmsUserTitle record);

	int updateByPrimaryKeySelective(RmsUserTitle record);

	int updateByPrimaryKey(RmsUserTitle record);
	
	List<RmsGoldBusinessDto> getGoldBusiness(Long requirement_id);
}