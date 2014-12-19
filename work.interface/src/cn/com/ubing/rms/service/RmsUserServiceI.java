/**
 * 
 */
package cn.com.ubing.rms.service;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.rms.dto.BusinessCompanyCheckRequestDto;
import cn.com.ubing.rms.dto.BusinessUserInfoResponseDto;
import cn.com.ubing.rms.dto.BusinessUserSetPhotoRequestDto;
import cn.com.ubing.rms.dto.CompanyCheckInfoResponseDto;
import cn.com.ubing.rms.dto.MainViewResponseDto;
import cn.com.ubing.rms.dto.RealNameCheckRequestDto;
import cn.com.ubing.rms.dto.RealNameCheckResponseDto;
import cn.com.ubing.rms.dto.UpdateNickNameRequestDto;
import cn.com.ubing.rms.dto.UserCenterInfoResponseDto;
import cn.com.ubing.rms.dto.UserCenterResponseDto;
import cn.com.ubing.rms.dto.UserSetPhotoRequestDto;
import cn.com.ubing.rms.model.RmsUser;

/**
 * 用户
 * 
 * @author lumingwen
 * 
 * 
 */
public interface RmsUserServiceI {

	/**
	 * 根据用户名查询用户
	 * 
	 * @param username
	 * @return
	 */
	public RmsUser getByName(String username);

	/**
	 * 保存或更新用户
	 * 
	 * @param user
	 *            用户
	 */
	public void saveOrUpdateRmsUser(RmsUser user);

	/**
	 * 检查密码是否正确
	 * 
	 * @param user
	 * @return
	 */
	public boolean checkPassword(RmsUser user);

	/**
	 * 保存用户密码
	 * 
	 * @param user
	 */
	public void saveUserPassword(RmsUser user);

	/**
	 * 检查手机号是否已经注册过(存在)
	 * 
	 * @param user
	 * @return
	 */
	public RmsUser checkTel(String tel);

	/**
	 * 检查用户
	 * 
	 * @author 邱全松 2014-9-26 下午1:41:37
	 * @param tel
	 * @return
	 */
	public RmsUser checkUser(String username);

	/**
	 * 检查c端用户
	 * 
	 * @param username
	 * @return
	 */
	public RmsUser checkCUser(String username);

	/**
	 * 保存用户密码
	 * 
	 * @param user
	 */
	public int saveUser(RmsUser user);

	/**
	 * 更新用户信息
	 * 
	 * @param moaStaff
	 */
	public int update(RmsUser user);

	/**
	 * (B端app) 更改用户昵称
	 * 
	 * @author 邱全松 2014-7-9 下午5:54:31
	 * @param dto
	 * @return
	 */
	public int updateNickName(UpdateNickNameRequestDto dto);

	/**
	 * 根据微信openId查询
	 * 
	 * @param wxOpenid
	 * @return
	 */
	public RmsUser getByOpenId(String wxOpenid);

	/**
	 * （B端）查询商家个人中心首页信息
	 * 
	 * @author 邱全松 2014-6-26 下午2:07:21
	 * @param dto
	 * @return
	 */
	public BusinessUserInfoResponseDto getBusinessUserInfo(RequestDto dto);

	/**
	 * （B端）商家头像设置
	 * 
	 * @author 邱全松 2014-6-26 下午3:46:13
	 * @param dto
	 * @return
	 */
	public int setBusinessPhoto(BusinessUserSetPhotoRequestDto dto);

	/**
	 * （c端）用户头像设置
	 * 
	 * @param dto
	 * @return
	 */
	public int setUserPhoto(UserSetPhotoRequestDto dto);
	
	/**
	 * （c端）用户昵称和头像获取
	 * 
	 * @param dto
	 * @return
	 */
	
	public UserCenterInfoResponseDto getUserImageAndNickNameInfo(RequestDto dto);
	
	

	/**
	 * (B端) 商家机构认证信息保存
	 * 
	 * @author 邱全松 2014-6-26 下午4:18:22
	 * @param dto
	 * @return
	 */
	public int saveOrUpdateBusinessCompanyCheck(
			BusinessCompanyCheckRequestDto dto);

	/**
	 * (B端) 商家实名认证信息保存
	 * 
	 * @author 邱全松 2014-8-5 下午3:49:14
	 * @param dto
	 * @return
	 */
	public int saveOrUpdateBusinessRealNameCheck(RealNameCheckRequestDto dto);

	/**
	 * (B端)获取商家机构认证信息
	 * 
	 * @author 邱全松 2014-6-26 下午6:36:53
	 * @param dto
	 * @return
	 */
	public CompanyCheckInfoResponseDto getCompanyCheckInfo(RequestDto dto);

	/**
	 * (B端)获取商家实名认真信息
	 * 
	 * @author 邱全松 2014-6-26 下午6:37:18
	 * @param dto
	 * @return
	 */
	public RealNameCheckResponseDto getRealNameCheckInfo(RequestDto dto);

	/**
	 * 获取主页信息
	 * 
	 * @author 邱全松 2014-9-4 下午8:31:20
	 * @param dto
	 * @return
	 */
	public MainViewResponseDto getMainViewInfo(RequestDto dto);

	/**
	 * 根据id查询用户
	 * 
	 * @param id
	 * @return
	 */
	RmsUser getById(Long id);
}
