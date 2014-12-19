package cn.com.ubing.res.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.ubing.res.dto.ResDictDto;
import cn.com.ubing.res.model.RUserBusinessLine;

public interface RUserBusinessLineMapper {
	int deleteByPrimaryKey(Long id);

	int insert(RUserBusinessLine record);

	int insertSelective(RUserBusinessLine record);

	RUserBusinessLine selectByPrimaryKey(Long id);

	/**
	 * 根据商家id查询商家主营线路列表信息
	 * 
	 * @param userId
	 * @return
	 */
	List<RUserBusinessLine> getByUserId(Long userId);
	/**
	 * 根据用户id及业务类型查询对应经营线路信息
	 * 
	 * @author 邱全松 2014-7-15 上午11:14:32
	 * @param userId
	 * @param businessType
	 * @return
	 */
	List<RUserBusinessLine> getLinesByUser(@Param("userId")Long userId,@Param("businessType")Integer businessType);
	/**
	 * 根据用户id及业务类型查询对应经营线路信息
	 * 
	 * @author 邱全松 2014-8-6 下午4:51:04
	 * @param userId
	 * @param businessType
	 * @return
	 */
	List<ResDictDto> getLinesDtoByUser(@Param("userId")Long userId,@Param("businessType")Integer businessType);
	/**
	 * 删除用户id和业务类型删除线路信息
	 * 
	 * @author 邱全松 2014-7-15 下午12:00:06
	 * @param userId
	 * @param lineIds
	 * @return
	 */
	int deleteByUserIdAndType(@Param("userId")Long userId,@Param("businessType")Integer businessType);

	int updateByPrimaryKeySelective(RUserBusinessLine record);

	int updateByPrimaryKey(RUserBusinessLine record);
}