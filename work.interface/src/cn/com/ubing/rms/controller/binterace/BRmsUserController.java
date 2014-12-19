/**
 * 
 */
package cn.com.ubing.rms.controller.binterace;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.utils.MD5;
import cn.com.ubing.pub.service.PlanServiceI;
import cn.com.ubing.res.model.ResSmsEmail;
import cn.com.ubing.res.model.ResSystemProperties;
import cn.com.ubing.res.service.ResSmsEmailServiceI;
import cn.com.ubing.res.service.ResSystemPropertiesServiceI;
import cn.com.ubing.rms.dao.RmsUserMapper;
import cn.com.ubing.rms.dto.ForgetPasswordRequestDto;
import cn.com.ubing.rms.dto.ForgetPasswordResponseDto;
import cn.com.ubing.rms.dto.GetCodeRequestDto;
import cn.com.ubing.rms.dto.GetCodeResponseDto;
import cn.com.ubing.rms.dto.ScodeDto;
import cn.com.ubing.rms.dto.UserLoginRequestDto;
import cn.com.ubing.rms.dto.UserLoginResponseDto;
import cn.com.ubing.rms.dto.userNewRequestDto;
import cn.com.ubing.rms.dto.userNewResponseDto;
import cn.com.ubing.rms.model.RmsUser;
import cn.com.ubing.rms.service.RmsUserServiceI;
import cn.com.ubing.rms.utils.RmsUtils;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * B端用户controller
 * 
 * @author lumingwen
 * 
 * 
 */
@Controller
@RequestMapping("/")
public class BRmsUserController extends BaseController {

	private static Logger logger = Logger.getLogger(BRmsUserController.class);

	/**
	 * 用户service
	 */
	@Autowired
	private RmsUserServiceI rmsUserService;

	/**
	 * 短信service
	 */
	@Autowired
	private ResSmsEmailServiceI resSmsEmailService;

	/**
	 * menu菜单 service
	 */
	@Autowired
	private PlanServiceI planService;
	/**
	 * 系统配置service
	 */
	@Autowired
	private ResSystemPropertiesServiceI resSystemPropertiesService;
	@Autowired
	private RmsUserMapper rmsUserMapper;

	/**
	 * 登录
	 * 
	 */

	@RequestMapping("/userLogin")
	public void userLogin(HttpServletRequest request,
			HttpServletResponse response, UserLoginRequestDto param) {

		// 响应response
	UserLoginResponseDto dto = buildResponse(UserLoginResponseDto.class,
				param);

		// 参数校验
		if (!checkRequest(param)) {
			outputParamCheckError(response, dto);
			return;
		}

		// 后台校验
		boolean issuccess = true;
		String errorMessage = "";
		String successMessage = "";
		RmsUser loginUser;
		// 验证手机号和密码是否为空
		if (StringUtils.isBlank(param.getUserTel())
				|| StringUtils.isBlank(param.getUserPw())) {
			issuccess = false;
			errorMessage = "用户名或密码不能为空";
			outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
					errorMessage);
		} else {
			loginUser = rmsUserService.checkUser(param.getUserTel());
			if (loginUser == null) {
				issuccess = false;
				errorMessage = "用户不存在";
			} else {
				String loginPassword = MD5.getMD5String(param.getUserPw()
						+ loginUser.getPasswordKey());
				String persistPassword = loginUser.getPassword();
				if (!persistPassword.equalsIgnoreCase(loginPassword)) {
					issuccess = false;
					errorMessage = "密码不正确";
				} else {
					// 登录成功
					issuccess = true;
					successMessage = "登录成功";
				}
			}
			if (issuccess) {
			    if(param.getXingeToken()!=null){
    			    //更新用户token信息开始
    			    RmsUser updateUserInfo = new RmsUser();
    			    updateUserInfo.setId(loginUser.getId());
    			    updateUserInfo.setXingeToken(param.getXingeToken());
    			    updateUserInfo.setAppType(param.getUos());
    			    rmsUserMapper.updateUserInfoForXinge(updateUserInfo);
    			    //保存用户token信息结束
			    }
			    
				dto.setUid(loginUser.getId().toString());
				dto.setUserName(loginUser.getUsername());
				dto.setResultInfo(successMessage);
				outputReponse(response, dto);
			} else {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						errorMessage);
			}
		}
	}
	/**
	 * 获取手机验证码
	 * 
	 * @author 邱全松 2014-8-22 上午11:40:11
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/getScode")
    public void getScode(HttpServletRequest request,HttpServletResponse response, GetCodeRequestDto param){
	    // 构建返回参数对象
	    GetCodeResponseDto dto = buildResponse(GetCodeResponseDto.class, param);
        // 参数校验
        if (!checkRequest(param)) {
            outputParamCheckError(response, dto);
            return;
        }
        if(param.getType()==null||param.getUserTel()==null){
            outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "请求参数不完整！");
        }else{
    	    try{
    	        //读取系统配置
    	        String activeTime = null;//短信验证码有效时间（秒）
    	        String regetCount = null;//短信一天最大请求次数
    	        ResSystemProperties activeTimeObj = resSystemPropertiesService.selectByKey(Constants.SYSTEM_PRO_COMPOSITE_RULE_DUANXINYANJZHENGSHIJIAN);
                ResSystemProperties regetCountObj = resSystemPropertiesService.selectByKey(Constants.SYSTEM_PRO_COMPOSITE_RULE_DUANXINQINGQIUCISHU);
                if(activeTimeObj!=null){
                    activeTime = activeTimeObj.getPropValue();
                }
                if(regetCountObj!=null){
                    regetCount = regetCountObj.getPropValue();
                }
                
    	        //该设备获取验证码时间间隔校验
    	        Date oldDate = null;
    	        if (resSmsEmailService.getLastTime(param) != null) {
                    oldDate = resSmsEmailService.getLastTime(param).getOldSendTime();
                }
    	        if(oldDate!=null){
    	            if((new Date().getTime()-oldDate.getTime())/1000<=CommonUtils.parseLong(activeTime)){
    	                outputReponse(response, dto, Constants.RESULT_CODE_FAIL,"请间隔"+activeTime+"秒后再试！");
    	                return;
    	            }
    	        }
    	        
    	        //该设备最大获取验证码的次数校验
    	        int sendCount = resSmsEmailService.checkDeviceSendNumber(param.getDeviceID());
    	        if(sendCount>CommonUtils.parseInteger(regetCount)){
    	            outputReponse(response, dto, Constants.RESULT_CODE_FAIL,"同一设备，当天获取验证码次数已经超过"+regetCount+"次");
    	            return;
    	        }
    	        
    	        //保存短信验证码发送记录
                String scode = RmsUtils.createRandom(true, 6);
    	        ResSmsEmail r = new ResSmsEmail();
    	        r.setCreateTime(new Date());
                r.setUpdateTime(r.getCreateTime());
                r.setDeleteFlag(Constants.DEL_FLAG_NO);
                r.setType(Constants.EMAIL_AND_SMS_OF_SMS);
                r.setSmsMobileNumber(param.getUserTel());
                r.setMaxRetryCount(3);
                r.setRetryCount(0);
                r.setPriority(0);
                r.setStatus(0);
                r.setScode(scode);
                r.setDeviceId(param.getDeviceID());
                
                RmsUser rmsUser = rmsUserService.checkTel(param.getUserTel());
                if("1".equals(param.getType())){//注册
                    if (rmsUser != null) {
                    String erro_message="";
       				 if(rmsUser.getUserType()==Constants.USER_TYPE_CUSTOM){
       					   erro_message=Constants.LOGING_USER_REPEATE;
       					}
       				else if(rmsUser.getUserType()==Constants.USER_TYPE_BUSINESS)
       				    {
       					   erro_message=Constants.LOGING_BUSSINESS_REPEATE;
       					}
       				else if(rmsUser.getUserType()==Constants.USER_TYPE_ADMIN_NORMAL)
       					{
       						erro_message=Constants.LOGING_ADMIN_NORMAL_REPEATE;		
       					}
       				else
       					{
       					   erro_message=Constants.LOGING_ADMIN_REPEATE;
       					}
                        outputReponse(response, dto, Constants.RESULT_CODE_FAIL,erro_message);
                    }else{
                        r.setBusinessType(1);//业务类型,1:注册,2:找回密码,3:系统通知
                        r.setSmsContent("感谢你使用游必应手机认证功能，你的验证码是："+scode);
                        resSmsEmailService.sendSms(r);
                        dto.setResultInfo("短信发送成功");
                        dto.setScode(scode);
                        outputReponse(response, dto);
                    }
                }else if("2".equals(param.getType())){//找回密码
                    if (rmsUser == null) {
                        outputReponse(response, dto, Constants.RESULT_CODE_FAIL,"该手机号没注册");
                    }else{
                        r.setBusinessType(2);//业务类型,1:注册,2:找回密码,3:系统通知
                        r.setSmsContent("你正在使用游必应手机找回密码功能，你的验证码是："+scode);
                        resSmsEmailService.sendSms(r);
                        dto.setResultInfo("短信发送成功");
                        dto.setScode(scode);
                        outputReponse(response, dto);
                    }
                }
    	    }catch(Exception e){
    	        e.printStackTrace();
    	        outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "程序异常！");
    	    }
        }
	}

	/**
	 * 用户注册
	 * 
	 * @author Administrator 2014年6月24日 下午1:57:38
	 * @param request
	 * @param response
	 * @param param
	 * @throws IOException
	 */
	@RequestMapping("/userNew")
	public void userNew(HttpServletRequest request,
			HttpServletResponse response, userNewRequestDto param)
			throws IOException {
		// 响应response
	    userNewResponseDto dto = buildResponse(userNewResponseDto.class, param);

		// 参数校验
		if (!checkRequest(param)) {
			outputParamCheckError(response, dto);
			return;
		}
		String errorMessage = "";
		String successMessage = "";

		// 先判断输入的手机号码是否已经注册过
		RmsUser rmsUser = rmsUserService.checkTel(param.getUserTel());
		// 当前手机号，已经存在，则跳到新加用户页面
		if (rmsUser != null) {
			String erro_message="";
				 if(rmsUser.getUserType()==Constants.USER_TYPE_CUSTOM){
					   erro_message=Constants.LOGING_USER_REPEATE;
					}
				else if(rmsUser.getUserType()==Constants.USER_TYPE_BUSINESS)
				    {
					   erro_message=Constants.LOGING_BUSSINESS_REPEATE;
					}
				else if(rmsUser.getUserType()==Constants.USER_TYPE_ADMIN_NORMAL)
					{
						erro_message=Constants.LOGING_ADMIN_NORMAL_REPEATE;		
					}
				else
					{
					   erro_message=Constants.LOGING_ADMIN_REPEATE;
					}
			
			outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
					erro_message);
		} else {
			if (param.getUserTel() != null && param.getScode() != null
					&& param.getPassword() != null
					&& StringUtils.isNotBlank(param.getUserTel())
					&& StringUtils.isNotBlank(param.getScode())
					&& StringUtils.isNotBlank(param.getPassword())) {
				GetCodeRequestDto getCodeParam = new GetCodeRequestDto();
				getCodeParam.setDeviceID(param.getDeviceID());
				getCodeParam.setUserTel(param.getUserTel());

				// 当前时间
				Date date1 = new Date();

				// 取得短信验证码超时时间，短信重新请求时间
				ResSystemProperties resSystemRule = resSystemPropertiesService.selectByKey(Constants.SYSTEM_PRO_COMPOSITE_RULE_DUANXINYANJZHENGSHIJIAN);

				// 短信验证码有效时间
				Double smsActiveTime = CommonUtils.parseDouble(resSystemRule.getPropValue());

				ScodeDto sdto = resSmsEmailService.getLastTime(getCodeParam);
				// 发送最后获得短信时的时间
				Date oldDate = new Date();
				// 验证码的获取
				String scode = "";
				if (sdto != null) {
					oldDate = sdto.getOldSendTime();
					scode = sdto.getScode();
				}
				Calendar ca1 = Calendar.getInstance();
				Calendar ca2 = Calendar.getInstance();
				ca1.setTime(date1);
				ca2.setTime(oldDate);
				// 获得短信发送时间，和现在时间，判断是否过时
				long distanceMin = (ca1.getTimeInMillis() - ca2
						.getTimeInMillis()) / (1000 * 60);

				// 判断时间是否超时(如果时间大于一定时间，则超时)
				if (distanceMin < smsActiveTime) {
					if (scode.equals(param.getScode())) {
						if (param.getUserTel()
								.equals(sdto.getSmsMobileNumber())) {
							// 保存用户数据到数据库
							RmsUser user = new RmsUser();
							user.setTel(param.getUserTel());
							// 获得通过MD5加密的密码
							String password = MD5.getMD5String(param
									.getPassword() + Constants.PSSWORD_KEY);

							// 设置已绑定标志
							// user.setWeixinBoundFlag(Constants.WEIXIN_BOUND_FLAG);
							user.setUserType(Constants.USER_TYPE_BUSINESS);
							user.setUsername(param.getUserTel());//用户名为手机号码
							user.setNickname(param.getNickName());
							user.setPasswordKey(Constants.PSSWORD_KEY);
							user.setPassword(password);
							user.setCreateTime(new Date());
							user.setUpdateTime(new Date());
							user.setDeleteFlag(Constants.DEL_FLAG_NO);
							user.setScore(0D);
							user.setStatus(1);
							int flag = rmsUserService.saveUser(user);
							if (flag == 1) {
							    user.setStatus(1);
							    user.setNickname("商家"+user.getId());
							    rmsUserService.update(user);
								successMessage = "注册成功";
								dto.setResultInfo(successMessage);
								dto.setUid(user.getId().toString());
								outputReponse(response, dto);
							} else {
								errorMessage = "注册失败，请再次注册";
								outputReponse(response, dto,
										Constants.RESULT_CODE_FAIL,
										errorMessage);
							}
						} else {
							errorMessage = "号码不能改变";
							outputReponse(response, dto,
									Constants.RESULT_CODE_FAIL, errorMessage);
						}
					} else {
						errorMessage = "验证码输入不正确";
						outputReponse(response, dto,
								Constants.RESULT_CODE_FAIL, errorMessage);
					}
				} else {
					errorMessage = "验证码已经超时,请从新获取";
					outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
							errorMessage);
				}
			}

			else {
				errorMessage = "用户名或验证码或密码不能为空";
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						errorMessage);
			}
		}

	}

	/**
	 * 密码忘记，发送密码到手机
	 * 
	 * @author Administrator 2014年6月24日 下午1:57:38
	 * @param request
	 * @param response
	 * @param param
	 * @throws IOException
	 */
	@RequestMapping("/chagePassword")
	public void chagePassword(HttpServletRequest request,
			HttpServletResponse response, ForgetPasswordRequestDto param)
			throws IOException {
		// 响应response
		ForgetPasswordResponseDto dto = buildResponse(
				ForgetPasswordResponseDto.class, param);

		// 参数校验
		if (!checkRequest(param)) {
			outputParamCheckError(response, dto);
			return;
		}
		String errorMessage = "";
		String successMessage = "";

		// 先判断输入的手机号码是否已经注册过
		RmsUser rmsUser = rmsUserService.checkTel(param.getUserTel());
		// 当前手机号，手机号不存在，提示手机好不存在
		if (rmsUser == null) {
			errorMessage = "手机号不存在";
			outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
					errorMessage);
		} else {
			if (param.getUserTel() != null && param.getScode() != null
					&& StringUtils.isNotBlank(param.getUserTel())
					&& StringUtils.isNotBlank(param.getScode())) {
				GetCodeRequestDto getCodeParam = new GetCodeRequestDto();
				getCodeParam.setDeviceID(param.getDeviceID());
				getCodeParam.setUserTel(param.getUserTel());

				// 当前时间
				Date date1 = new Date();

				// 取得短信验证码超时时间，短信重新请求时间
				ResSystemProperties resSystemRule = resSystemPropertiesService.selectByKey(Constants.SYSTEM_PRO_COMPOSITE_RULE_DUANXINYANJZHENGSHIJIAN);

				// 短信验证码有效时间
				Double smsActiveTime = CommonUtils.parseDouble(resSystemRule.getPropValue());

				ScodeDto sdto = resSmsEmailService.getLastTime(getCodeParam);
				// 发送最后获得短信时的时间
				Date oldDate = null;

				// 验证码的获取
				String scode = "";
				long distanceMin = 0;
				if (sdto != null) {
					oldDate = sdto.getOldSendTime();
					scode = sdto.getScode();

					Calendar ca1 = Calendar.getInstance();
					Calendar ca2 = Calendar.getInstance();
					ca1.setTime(date1);
					ca2.setTime(oldDate);

					// 获得短信发送时间，和现在时间，判断是否过时
					distanceMin = (ca1.getTimeInMillis() - ca2
							.getTimeInMillis()) / (1000 * 60);
				}
				// 判断时间是否超时(如果时间大于一定时间，则超时)

				// 判断时间是否超时(如果时间大于一定时间，则超时)
				if (distanceMin > smsActiveTime || oldDate == null) {
					if (scode.equals(param.getScode())) {
						if (param.getUserTel()
								.equals(sdto.getSmsMobileNumber())) {
							if (param.getPassword().equals(
									param.getNextPassword())) {
								// 验证码输入正确，则发送10分钟有效密码到数据用户手机上
								// 保存用户数据到数据库
								// RmsUser user = new RmsUser();
								rmsUser.setTel(param.getUserTel());
								// 获得通过MD5加密的密码
								String password = MD5.getMD5String(param
										.getPassword() + Constants.PSSWORD_KEY);

								// 设置已绑定标志
								// user.setWeixinBoundFlag(Constants.WEIXIN_BOUND_FLAG);
								rmsUser.setUserType(Constants.USER_TYPE_BUSINESS);
								rmsUser.setPasswordKey(Constants.PSSWORD_KEY);
								rmsUser.setPassword(password);
								rmsUser.setCreateTime(new Date());
								rmsUser.setUpdateTime(new Date());
								rmsUser.setDeleteFlag(Constants.DEL_FLAG_NO);
								int flag = rmsUserService.update(rmsUser);
								if (flag == 1) {
									successMessage = "修改成功";
									dto.setResultInfo(successMessage);
									outputReponse(response, dto);
								} else {
									errorMessage = "修改失败，请再次修改";
									outputReponse(response, dto,
											Constants.RESULT_CODE_FAIL,
											errorMessage);
								}

							} else {
								errorMessage = "两次输入密码不一致";
								outputReponse(response, dto,
										Constants.RESULT_CODE_FAIL,
										errorMessage);
							}
						} else {
							errorMessage = "号码不能改变";
							outputReponse(response, dto,
									Constants.RESULT_CODE_FAIL, errorMessage);
						}
					} else {
						errorMessage = "验证码输入不正确";
						outputReponse(response, dto,
								Constants.RESULT_CODE_FAIL, errorMessage);
					}
				} else {
					errorMessage = "验证码已经超时,请从新获取";
					outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
							errorMessage);
				}
			}

			else {
				errorMessage = "用户名或验证码或密码不能为空";
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						errorMessage);
			}
		}

	}

	/**
	 * 密码忘记，发送密码到手机
	 * 
	 * @author Administrator 2014年6月24日 下午1:57:38
	 * @param request
	 * @param response
	 * @param param
	 * @throws IOException
	 */
	@RequestMapping("/forgetPassword")
	public void forgetPassword(HttpServletRequest request,
			HttpServletResponse response, ForgetPasswordRequestDto param)
			throws IOException {
		// 响应response
		ForgetPasswordResponseDto dto = buildResponse(
				ForgetPasswordResponseDto.class, param);

		// 参数校验
		if (!checkRequest(param)) {
			outputParamCheckError(response, dto);
			return;
		}
		String errorMessage = "";
		String successMessage = "";

		// 先判断输入的手机号码是否已经注册过
		RmsUser rmsUser = rmsUserService.checkTel(param.getUserTel());
		// 当前手机号，手机号不存在，提示手机好不存在
		if (rmsUser == null) {
			errorMessage = "手机号不存在";
			outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
					errorMessage);
		} else {
			if (param.getUserTel() != null && param.getScode() != null
					&& StringUtils.isNotBlank(param.getUserTel())
					&& StringUtils.isNotBlank(param.getScode())) {
				GetCodeRequestDto getCodeParam = new GetCodeRequestDto();
				getCodeParam.setDeviceID(param.getDeviceID());
				getCodeParam.setUserTel(param.getUserTel());

				// 当前时间
				Date date1 = new Date();

				//读取系统配置
                String smsActiveTime = null;//短信验证码有效时间（秒）
                ResSystemProperties activeTimeObj = resSystemPropertiesService.selectByKey(Constants.SYSTEM_PRO_COMPOSITE_RULE_DUANXINYANJZHENGSHIJIAN);
                if(activeTimeObj!=null){
                    smsActiveTime = activeTimeObj.getPropValue();
                }

				ScodeDto sdto = resSmsEmailService.getLastTime(getCodeParam);
				// 发送最后获得短信时的时间
				Date oldDate = null;

				// 验证码的获取
				String scode = "";
				long distanceMin = 0;
				if (sdto != null) {
					oldDate = sdto.getOldSendTime();
					scode = sdto.getScode();

					Calendar ca1 = Calendar.getInstance();
					Calendar ca2 = Calendar.getInstance();
					ca1.setTime(date1);
					ca2.setTime(oldDate);

					// 获得短信发送时间，和现在时间，判断是否过时
					distanceMin = (ca1.getTimeInMillis() - ca2
							.getTimeInMillis()) / 1000;
				}
				// 判断时间是否超时(如果时间大于一定时间，则超时)

				// 判断时间是否超时(如果时间大于一定时间，则超时)
				if (distanceMin < CommonUtils.parseLong(smsActiveTime) || oldDate != null) {
					if (scode.equals(param.getScode())) {
						if (param.getUserTel()
								.equals(sdto.getSmsMobileNumber())) {
							if (param.getPassword().equals(
									param.getNextPassword())) {
								// 验证码输入正确，则发送10分钟有效密码到数据用户手机上
								// 保存用户数据到数据库
								// RmsUser user = new RmsUser();
								rmsUser.setTel(param.getUserTel());
								// 获得通过MD5加密的密码
								String password = MD5.getMD5String(param
										.getPassword() + Constants.PSSWORD_KEY);

								// 设置已绑定标志
								// user.setWeixinBoundFlag(Constants.WEIXIN_BOUND_FLAG);
								rmsUser.setUserType(Constants.USER_TYPE_BUSINESS);
								rmsUser.setPasswordKey(Constants.PSSWORD_KEY);
								rmsUser.setPassword(password);
								rmsUser.setCreateTime(new Date());
								rmsUser.setUpdateTime(new Date());
								rmsUser.setDeleteFlag(Constants.DEL_FLAG_NO);
								int flag = rmsUserService.update(rmsUser);
								if (flag == 1) {
									successMessage = "修改成功";
									dto.setResultInfo(successMessage);
									outputReponse(response, dto);
								} else {
									errorMessage = "修改失败，请再次修改";
									outputReponse(response, dto,
											Constants.RESULT_CODE_FAIL,
											errorMessage);
								}

							} else {
								errorMessage = "两次输入密码不一致";
								outputReponse(response, dto,
										Constants.RESULT_CODE_FAIL,
										errorMessage);
							}
						} else {
							errorMessage = "号码不能改变";
							outputReponse(response, dto,
									Constants.RESULT_CODE_FAIL, errorMessage);
						}
					} else {
						errorMessage = "验证码输入不正确";
						outputReponse(response, dto,
								Constants.RESULT_CODE_FAIL, errorMessage);
					}
				} else {
					errorMessage = "验证码已经超时,请从新获取";
					outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
							errorMessage);
				}
			}

			else {
				errorMessage = "用户名或验证码或密码不能为空";
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						errorMessage);
			}
		}
	}
}
