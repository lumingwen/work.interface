package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.dto.ResDictDto;
import cn.com.ubing.res.dto.ResDictRequestDto;
import cn.com.ubing.res.model.ResDict;



/**
 * 字典dao
 * 
 * @author zhangxujun
 * 
 * 
 */
public interface ResDictMapper {

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(ResDict record);

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */
	ResDict selectByPrimaryKey(Long id);

	/**
	 * 更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(ResDict record);

	/**
	 * 字典查询
	 * 
	 * 
	 * @return 字典
	 */
	List<ResDict> listAllDict(ResDict param);
	/**
     * 字典查询
     * 
     * 
     * @return 字典
     */
    List<ResDictDto> listAllDictDto(ResDict param);
    /**
     * c端查询字典信息
     * 
     * @author 邱全松 2014-10-31 下午2:46:11
     * @param param
     * @return
     */
    List<ResDictDto> getDictByType(ResDictRequestDto param);
}