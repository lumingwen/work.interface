package cn.com.ubing.rms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.ubing.rms.dto.RmsUserBusinessTypeDto;
import cn.com.ubing.rms.model.RmsUserBusinessType;

public interface RmsUserBusinessTypeMapper {
	int deleteByPrimaryKey(Long id);
	/**
	 * 根据用户id和业务类型删除对应记录
	 * 
	 * @author 邱全松 2014-7-15 下午1:08:35
	 * @param id
	 * @return
	 */
	int deleteByUserIdAndType(@Param("userId")Long userId,@Param("businessType")Integer businessType);

	int insert(RmsUserBusinessType record);

	RmsUserBusinessType selectByPrimaryKey(Long id);
	/**
	 * 根据商家id查询对应的经营类型信息
	 * 
	 * @author 邱全松 2014-7-15 上午11:18:08
	 * @param userId
	 * @param businessType
	 * @return
	 */
	List<RmsUserBusinessTypeDto> getBusinessTypeByUser(Long userId);

	int updateByPrimaryKey(RmsUserBusinessType record);

	/**
	 * 根据用户查出相应的线路
	 * 
	 */
	List<RmsUserBusinessType> selectByUserId(Long userid);
}