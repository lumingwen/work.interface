/**
 * 
 */
package cn.com.ubing.res.service;

import java.util.List;

import cn.com.ubing.res.dto.ResDictDto;
import cn.com.ubing.res.dto.ResDictExpandDto;
import cn.com.ubing.res.dto.ResDictExpandRequestDto;
import cn.com.ubing.res.dto.ResDictRequestDto;
import cn.com.ubing.res.dto.ResDictResponseDto;
import cn.com.ubing.res.model.ResDict;


/**
 * 字典service
 * 
 * @author zhangxujun
 * 
 * 
 */
public interface ResDictServiceI {

	/**
	 * 根据类型查询所有字典
	 * 
	 * @param type
	 * @return
	 */
	public List<ResDictDto> listAllDictDtoByType(String type);
	/**
	 * 根据类型查询所有字典
	 * 
	 * @author 邱全松 2014-8-6 下午4:18:13
	 * @param type
	 * @return
	 */
	public List<ResDict> listAllDictByType(String type);

	/**
	 * 插入字典
	 * 
	 * @param dict
	 */
	public void insertDict(ResDict dict);

	/**
	 * 级联删除字典
	 * 
	 * @param id
	 */
	public void removeDict(Long id);

	/**
	 * 修改字典
	 * 
	 * @param dict
	 */
	public void updateDict(ResDict dict);

	/**
	 * 根据类型和名称查询字典
	 * 
	 * @param type
	 * @param name
	 * @return
	 */
	public List<ResDict> listDictByTypeAndName(String type, String name);

	/**
	 * 根据类型和父id查询字典
	 * 
	 * @param type
	 * @param pid
	 * @return
	 * @author lumingwen
	 */
	public List<ResDict> listDictByTypeAndPid(String type, Long pid);

	/**
	 * 根据类型和父id查询字典
	 * 
	 * @param type
	 * @param pid
	 * @return
	 * @author lumingwen
	 */
	public List<ResDict> listParentDict(Long pid);
	
	/**
     * c端获取线路信息
     * 
     * @author 邱全松 2014-10-31 下午2:38:11
     * @param param
     * @return
     */
    public ResDictResponseDto GetDictByType(ResDictRequestDto param);
    /**
     * 查询扩展字典表
     * 
     * @author 邱全松 2014-11-4 下午2:00:57
     * @param param
     * @return
     */
    public List<ResDictExpandDto> queryDictExpandDtoList(ResDictExpandRequestDto param);
}
