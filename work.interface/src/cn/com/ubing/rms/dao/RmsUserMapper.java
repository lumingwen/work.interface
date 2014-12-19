package cn.com.ubing.rms.dao;

import java.util.List;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.rms.dto.BusinessCompanyCheckRequestDto;
import cn.com.ubing.rms.dto.BusinessUserInfoResponseDto;
import cn.com.ubing.rms.dto.BusinessUserSetPhotoRequestDto;
import cn.com.ubing.rms.dto.MainViewResponseDto;
import cn.com.ubing.rms.dto.UserCenterInfoResponseDto;
import cn.com.ubing.rms.dto.UserCenterResponseDto;
import cn.com.ubing.rms.dto.UserSetPhotoRequestDto;
import cn.com.ubing.rms.model.RmsUser;

/**
 * 用户dao
 * 
 * @author lumingwen
 * 
 * 
 */
public interface RmsUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RmsUser record);

    RmsUser selectByPrimaryKey(Long id);
    /**
     * 更新用户登录信息
     * 
     * @author 邱全松 2014-9-4 下午4:46:24
     * @param record
     * @return
     */
    
    int updateUserInfoForXinge(RmsUser record);
    
    int updateByPrimaryKey(RmsUser record);

    /**
     * 判断用户是否存在
     * 
     * @author lumingwen 2014-6-12 下午13:56:30
     * @param tel
     * @return
     */
    RmsUser selectByTel(String tel);
    /**
     * 判断用户名
     * 
     * @author 邱全松 2014-9-26 下午1:42:46
     * @param tel
     * @return
     */
    RmsUser selectByUsername(String username);
    
	/**
	 * 判断c端用户名
	 * @param username
	 * @return
	 */
    RmsUser selectByCUsername(String username);

    /**
     * 增加竞争力(必传参数:id,score)
     * 
     * @param user
     *            参数
     */
    void addScore(RmsUser user);

    /**
     * 增加进度(必传参数:id,grabValue)
     * 
     * @param user
     *            参数
     */
    void addGrabValue(RmsUser user);

    /**
     * 查询商家经营线路
     * 
     * @param userId
     *            用户id
     * @return 所有线路id集合
     */
    List<Long> listBusinessUserLine(Long userId);

    /**
     * (B端)获取用户个人中心首页信息
     * 
     * @author 邱全松 2014-6-26 下午2:08:53
     * @param dto
     * @return
     */
    BusinessUserInfoResponseDto getBusinessUserInfo(RequestDto dto);
    /**
     * （B端）商家头像设置
     * 
     * @author 邱全松 2014-6-26 下午3:46:13
     * @param dto
     * @return
     */
    int setbusinessPhoto(BusinessUserSetPhotoRequestDto dto);
    
    /**
     * （c端）用户头像设置
     */
    int setUserPhoto(UserSetPhotoRequestDto dto);
    /**
     * 获取主页信息数据
     * 
     * @author 邱全松 2014-9-5 上午10:09:34
     * @param dto
     * @return
     */
    MainViewResponseDto getMainViewInfo(RequestDto dto);
    
    
    UserCenterInfoResponseDto getUserImageAndNickNameInfo(RequestDto dto);
}