/**
 * 
 */
package cn.com.ubing.rms.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.MD5;
import cn.com.ubing.rms.dao.RUserCheckAttachmentMapper;
import cn.com.ubing.rms.dao.RmsUserCheckMapper;
import cn.com.ubing.rms.dao.RmsUserMapper;
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
import cn.com.ubing.rms.model.RUserCheckAttachment;
import cn.com.ubing.rms.model.RmsUser;
import cn.com.ubing.rms.model.RmsUserCheck;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * 用户
 * 
 * @author lumingwen
 * 
 * 
 */
@Service("rmsUserService")
public class RmsUserServiceImpl implements RmsUserServiceI {

	/**
	 * 用户dao
	 */
	@Autowired
	private RmsUserMapper rmsUserMapper;
	/**
	 * 用户认证信息
	 */
	@Autowired
	private RmsUserCheckMapper rmsUserCheckMapper;
	/**
	 * 用户认证附件关联信息
	 */
	@Autowired
	private RUserCheckAttachmentMapper rUserCheckAttachmentMapper;
	
	@Value(value = "${imageAttachmentHostAddr}")
	private String imageAttachmentHostAddr;

	@Override
	public RmsUser getByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 保存或更新用户
	 * 
	 * @param user
	 *            用户
	 */
	@Override
	public void saveOrUpdateRmsUser(RmsUser user) {
		if (user.getId() == null || user.getId() <= 0) {
			user.setCreateTime(new Date());
			user.setUpdateTime(user.getCreateTime());
			user.setDeleteFlag(0);
			user.setStatus(1);
			user.setPasswordKey(System.currentTimeMillis() + "");
			user.setPassword(MD5.getMD5String(user.getPassword()
					+ user.getPasswordKey()));
			rmsUserMapper.insert(user);
		} else {
			RmsUser temp = rmsUserMapper.selectByPrimaryKey(user.getId());
			if (temp != null) {
				user.setCreateTime(temp.getCreateTime());
				user.setDeleteFlag(temp.getDeleteFlag());
				user.setPasswordKey(temp.getPasswordKey());
				user.setPassword(temp.getPassword());
				user.setUpdateTime(new Date());
				rmsUserMapper.updateByPrimaryKey(user);
			}
		}

	}

	@Override
	public boolean checkPassword(RmsUser user) {
		// TODO Auto-generated method stub
		String password = null;
		if (user != null) {
			password = MD5.getMD5String(user.getPassword()
					+ user.getPasswordKey());
			if (password != null && user.getId() != null && user.getId() > 0) {
				RmsUser temp = rmsUserMapper.selectByPrimaryKey(user.getId());
				if (temp != null && temp.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void saveUserPassword(RmsUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public RmsUser checkTel(String tel) {
		return rmsUserMapper.selectByTel(tel);

	}
	
	@Override
    public RmsUser checkUser(String username) {
        return rmsUserMapper.selectByUsername(username);

    }

	@Override
	public int saveUser(RmsUser user) {
		return rmsUserMapper.insert(user);

	}

	@Override
	public int update(RmsUser user) {
		return rmsUserMapper.updateByPrimaryKey(user);
	}

	@Override
	public RmsUser getByOpenId(String wxOpenid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessUserInfoResponseDto getBusinessUserInfo(RequestDto dto) {
		// TODO Auto-generated method stub
		return rmsUserMapper.getBusinessUserInfo(dto);
	}

	@Override
	public int setBusinessPhoto(BusinessUserSetPhotoRequestDto dto) {
		// TODO Auto-generated method stub
		return rmsUserMapper.setbusinessPhoto(dto);
	}

	@Override
	public int saveOrUpdateBusinessCompanyCheck(
			BusinessCompanyCheckRequestDto dto) {
		// TODO Auto-generated method stub
		try {
			// 认证信息保存
			RmsUserCheck ruc = new RmsUserCheck();
			ruc.setId(CommonUtils.parseLong(dto.getCheckId()));
			ruc.setUpdateTime(new Date());
			ruc.setDeleteFlag(Constants.DEL_FLAG_NO);
			ruc.setUserId(CommonUtils.parseLong(dto.getUid()));
			ruc.setCheckType(Constants.BUSINESS_CHECK_COMPANY);
			ruc.setCheckStatus(Constants.BUSINESS_CHECK_ING);
			ruc.setCompanyName(dto.getCompanyName());
			if (ruc.getId() == null&&rmsUserCheckMapper.getCompanyCheckInfo(dto)==null) {
				ruc.setCreateTime(new Date());
			    rmsUserCheckMapper.insert(ruc);
			} else {
				rmsUserCheckMapper.updateByPrimaryKey(ruc);
			}
			// 认证关联附件信息保存
			RUserCheckAttachment rua = new RUserCheckAttachment();
			rua.setCreateTime(new Date());
			rua.setUpdateTime(new Date());
			rua.setDeleteFlag(Constants.DEL_FLAG_NO);
			rua.setUserCheckId(ruc.getId());
			rua.setAttachmentId(CommonUtils.parseLong(dto.getPhotoId()));
			rUserCheckAttachmentMapper.deleteHistoryRecord(ruc.getId());
			rUserCheckAttachmentMapper.insert(rua);
		} catch (Exception e) {
		    e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public CompanyCheckInfoResponseDto getCompanyCheckInfo(RequestDto dto) {
		// TODO Auto-generated method stub
		return rmsUserCheckMapper.getCompanyCheckInfo(dto);
	}

	@Override
	public RealNameCheckResponseDto getRealNameCheckInfo(RequestDto dto) {
		// TODO Auto-generated method stub
		return rmsUserCheckMapper.getRealNameCheckInfo(dto);
	}

    @Override
    public int updateNickName(UpdateNickNameRequestDto dto) {
        // TODO Auto-generated method stub
        RmsUser user = rmsUserMapper.selectByPrimaryKey(CommonUtils.parseLong(dto.getUid()));
        user.setNickname(dto.getNickname());
        return rmsUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public int saveOrUpdateBusinessRealNameCheck(RealNameCheckRequestDto dto) {
        try {
            // 认证信息保存
            RmsUserCheck ruc = new RmsUserCheck();
            ruc.setId(CommonUtils.parseLong(dto.getCheckId()));
            ruc.setUpdateTime(new Date());
            ruc.setDeleteFlag(Constants.DEL_FLAG_NO);
            ruc.setUserId(CommonUtils.parseLong(dto.getUid()));
            ruc.setCheckType(Constants.BUSINESS_CHECK_REALNAME);
            ruc.setCheckStatus(Constants.BUSINESS_CHECK_ING);
            ruc.setRealName(dto.getName());
            ruc.setIdNumber(dto.getIdNumber());
            if (ruc.getId() == null&&rmsUserCheckMapper.getRealNameCheckInfo(dto)==null) {
                ruc.setCreateTime(new Date());
                rmsUserCheckMapper.insert(ruc);
            } else {
                rmsUserCheckMapper.updateByPrimaryKey(ruc);
            }
            // 认证关联附件信息保存
            RUserCheckAttachment rua = new RUserCheckAttachment();
            rua.setCreateTime(new Date());
            rua.setUpdateTime(new Date());
            rua.setDeleteFlag(Constants.DEL_FLAG_NO);
            rua.setUserCheckId(ruc.getId());
            rua.setType(1);//正面照
            rua.setAttachmentId(CommonUtils.parseLong(dto.getPhotoId()));
            
            RUserCheckAttachment rua2 = new RUserCheckAttachment();
            rua2.setCreateTime(new Date());
            rua2.setUpdateTime(new Date());
            rua2.setDeleteFlag(Constants.DEL_FLAG_NO);
            rua2.setUserCheckId(ruc.getId());
            rua2.setType(2);//反面照
            rua2.setAttachmentId(CommonUtils.parseLong(dto.getAntiPhotoId()));
            
            rUserCheckAttachmentMapper.deleteHistoryRecord(ruc.getId());
            rUserCheckAttachmentMapper.insert(rua);
            rUserCheckAttachmentMapper.insert(rua2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public MainViewResponseDto getMainViewInfo(RequestDto dto) {
        // TODO Auto-generated method stub
        return rmsUserMapper.getMainViewInfo(dto);
    }

    
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
    @Override
    public RmsUser getById(Long id){
	    return id==null?null:rmsUserMapper.selectByPrimaryKey(id);
	}
	/**
	 * 检查c端用户
	 */
	@Override
	public RmsUser checkCUser(String username) {
		  return rmsUserMapper.selectByCUsername(username);
	}

	@Override
	public int setUserPhoto(UserSetPhotoRequestDto dto) {
		return rmsUserMapper.setUserPhoto(dto);
	}

	
	
	/**
	 * （c端）用户昵称和头像获取
	 * 
	 * @param dto
	 * @return
	 */
	
	@Override
	public UserCenterInfoResponseDto getUserImageAndNickNameInfo(RequestDto dto) {
		UserCenterInfoResponseDto userInfo=rmsUserMapper.getUserImageAndNickNameInfo(dto);
		userInfo.setPhotoUrl(imageAttachmentHostAddr+"//"+userInfo.getPhotoUrl());
		return rmsUserMapper.getUserImageAndNickNameInfo(dto);
	}
}
