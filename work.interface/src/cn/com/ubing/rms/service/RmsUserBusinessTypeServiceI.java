package cn.com.ubing.rms.service;

import java.util.List;

import cn.com.ubing.res.dto.ResDictDto;
import cn.com.ubing.res.model.RUserBusinessLine;
import cn.com.ubing.rms.dto.BusinessTypeAndLinesRequestDto;
import cn.com.ubing.rms.dto.RmsUserBusinessTypeDto;
import cn.com.ubing.rms.model.RmsUserBusinessType;

/**
 * 经营类型
 * 
 * @author lumingwen
 * 
 * 
 */
public interface RmsUserBusinessTypeServiceI {

	/**
	 * 保存或修改经营类型
	 * 
	 * @param user
	 *            经营类型
	 */
	public boolean saveOrUpdateRmsUserBusinessType(
			List<RmsUserBusinessType> rmsUserBusinessType, String[] btypeArray);

	/**
	 * 保存或更新经营类型
	 * 
	 * @param user
	 *            经营类型
	 */
	public boolean saveRmsUserBusinessType(String[] btypeArray, String userId);

	/**
	 * 根据用户查出相应的线路信息
	 * 
	 * @author Administrator 2014年6月25日 下午2:00:43
	 * @param userid
	 * @return
	 */
	public List<RmsUserBusinessType> selectByUserId(Long userid);

	/**
	 * 保存或更新主营线路
	 * 
	 * @param user
	 *            主营线路
	 */
	public boolean saveRmsUserBusinessLine(String[] lineArray, String userId);
	/**
	 * 根据用户id及经营类型获取对应的线路信息
	 * 
	 * @author 邱全松 2014-7-15 上午11:08:53
	 * @param userId
	 * @return
	 */
	public List<RUserBusinessLine> getLinesByUser(Long userId,Integer businessType);
	/**
	 * 根据用户id及经营类型获取对应的线路信息
	 * 
	 * @author 邱全松 2014-8-6 下午4:50:17
	 * @param userId
	 * @param businessType
	 * @return
	 */
	public List<ResDictDto> getLinesDtoByUser(Long userId,Integer businessType);
	/**
	 * 根据用户id获取对应的经营类型
	 * 
	 * @author 邱全松 2014-7-15 上午11:10:35
	 * @param userId
	 * @return
	 */
	public List<RmsUserBusinessTypeDto> getBusinessTypeByUser(Long userId);
	/**
	 * 保存或更新用户经营类型和线路信息
	 * 
	 * @author 邱全松 2014-7-15 上午11:35:06
	 * @param dto
	 */
	public boolean saveOrUpdateBusinessTypeAndLines(BusinessTypeAndLinesRequestDto dto);
}
