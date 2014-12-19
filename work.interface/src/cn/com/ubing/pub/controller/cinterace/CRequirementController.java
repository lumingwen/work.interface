package cn.com.ubing.pub.controller.cinterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CRequirementDetailResponseDto;
import cn.com.ubing.pub.dto.CRequirementListRequestDto;
import cn.com.ubing.pub.dto.CRequirementListResponseDto;
import cn.com.ubing.pub.dto.SaveGroupRequirementRequestDto;
import cn.com.ubing.pub.dto.SaveHotelRequirementRequestDto;
import cn.com.ubing.pub.dto.SavePersonalRequirementRequestDto;
import cn.com.ubing.pub.dto.SaveTicketRequirementRequestDto;
import cn.com.ubing.pub.service.CRequirementServiceI;
import cn.com.ubing.pub.service.PubPlanServiceI;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

@Controller
public class CRequirementController extends BaseController {
	private final Logger log = Logger.getLogger(getClass());
	@Autowired
	private CRequirementServiceI cRequirementService;

	@Autowired
	private PubPlanServiceI pubPlanService;

	/**
	 * 自由行需求保存
	 * 
	 * @author 邱全松 2014-10-30 下午3:20:52
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/SavePersonalRequirement")
	public void SavePersonalRequirement(HttpServletRequest request,
			HttpServletResponse response,
			SavePersonalRequirementRequestDto param) {
		try {
			// 构建返回参数对象
			ResponseDto dto = buildResponse(ResponseDto.class, param);
			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}
			if (!isLogin(param)) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
			} else {
				Integer status = cRequirementService
						.CheckSubmitRequirementStatus(CommonUtils
								.parseLong(param.getUid()));
				if (status == 0) {
					Integer flag = cRequirementService
							.SavePersonalRequirement(param);
					if (flag == null || flag != 1) {
						dto.setResultCode(Constants.RESULT_CODE_FAIL);
						dto.setResultInfo("保存失败");
					}
					outputSuccessReponse(response, dto);
				} else if (status == 1) {
					dto.setResultCode(Constants.RESULT_CODE_FAIL);
					dto.setResultInfo("超出最大提交需求次数");
					outputReponse(response, dto);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new ResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}

	/**
	 * 跟团行需求保存
	 * 
	 * @author 邱全松 2014-10-30 下午3:20:52
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/SaveGroupRequirement")
	public void SaveGroupRequirement(HttpServletRequest request,
			HttpServletResponse response, SaveGroupRequirementRequestDto param) {
		try {
			// 构建返回参数对象
			ResponseDto dto = buildResponse(ResponseDto.class, param);
			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}
			if (!isLogin(param)) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
			} else {
				Integer status = cRequirementService
						.CheckSubmitRequirementStatus(CommonUtils
								.parseLong(param.getUid()));
				if (status == 0) {
					Integer flag = cRequirementService
							.SaveGroupRequirement(param);
					if (flag == null || flag != 1) {
						dto.setResultCode(Constants.RESULT_CODE_FAIL);
						dto.setResultInfo("保存失败");
					}
					outputSuccessReponse(response, dto);
				} else if (status == 1) {
					dto.setResultCode(Constants.RESULT_CODE_FAIL);
					dto.setResultInfo("超出最大提交需求次数");
					outputReponse(response, dto);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new ResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}

	/**
	 * 保存机票需求信息
	 * 
	 * @author 邱全松 2014-11-4 下午3:54:03
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/SaveTicketRequirement")
	public void SaveTicketRequirement(HttpServletRequest request,
			HttpServletResponse response, SaveTicketRequirementRequestDto param) {
		try {
			// 构建返回参数对象
			ResponseDto dto = buildResponse(ResponseDto.class, param);
			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}
			if (!isLogin(param)) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
			} else {
				Integer status = cRequirementService
						.CheckSubmitRequirementStatus(CommonUtils
								.parseLong(param.getUid()));
				if (status == 0) {
					Integer flag = cRequirementService
							.SaveTicketRequirement(param);
					if (flag == null || flag != 1) {
						dto.setResultCode(Constants.RESULT_CODE_FAIL);
						dto.setResultInfo("保存失败");
					}
					outputSuccessReponse(response, dto);
				} else if (status == 1) {
					dto.setResultCode(Constants.RESULT_CODE_FAIL);
					dto.setResultInfo("超出最大提交需求次数");
					outputReponse(response, dto);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new ResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}

	/**
	 * 保存酒店需求信息
	 * 
	 * @author 邱全松 2014-11-4 下午3:53:26
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/SaveHotelRequirement")
	public void SaveHotelRequirement(HttpServletRequest request,
			HttpServletResponse response, SaveHotelRequirementRequestDto param) {
		try {
			// 构建返回参数对象
			ResponseDto dto = buildResponse(ResponseDto.class, param);
			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}
			if (!isLogin(param)) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
			} else {
				Integer status = cRequirementService
						.CheckSubmitRequirementStatus(CommonUtils
								.parseLong(param.getUid()));
				if (status == 0) {
					Integer flag = cRequirementService
							.SaveHotelRequirement(param);
					if (flag == null || flag != 1) {
						dto.setResultCode(Constants.RESULT_CODE_FAIL);
						dto.setResultInfo("保存失败");
					}
					outputSuccessReponse(response, dto);
				} else if (status == 1) {
					dto.setResultCode(Constants.RESULT_CODE_FAIL);
					dto.setResultInfo("超出最大提交需求次数");
					outputReponse(response, dto);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new ResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}

	@RequestMapping("/queryRequirementList")
	public void queryRequirementList(HttpServletRequest request,
			HttpServletResponse response, CRequirementListRequestDto param) {
		try {
			// 构建返回参数对象
			CRequirementListResponseDto dto = buildResponse(
					CRequirementListResponseDto.class, param);
			PageBounds pageBounds = new PageBounds();
			pageBounds.setLimit(CommonUtils.parseInteger(param.getLimit()));
			pageBounds.setPage(CommonUtils.parseInteger(param.getPage()));
			pageBounds.getOrders().add(
					new Order("create_time", Direction.DESC, ""));
			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}
			if (!isLogin(param)) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
			} else {
				dto = cRequirementService.queryRequirementList(param,
						pageBounds);
				dto.setStatus(param.getStatus());
				setCommonProperties(param, dto);
				outputSuccessReponse(response, dto);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new ResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}

	/**
	 * 根据需求id查询需求详细
	 * 
	 * @param request
	 * @param response
	 * @param param
	 * @author lumw
	 */
	@RequestMapping("/queryRequirementDetailById")
	public void queryRequirementDetailById(HttpServletRequest request,
			HttpServletResponse response, CRequirementDetailRequestDto param) {
		try {
			// 构建返回参数对象
			// 查询机票详细
			CRequirementDetailResponseDto dto = buildResponse(
					CRequirementDetailResponseDto.class, param);

			PageBounds pageBounds = new PageBounds();
			pageBounds.getOrders().add(
					new Order("create_time", Direction.DESC, ""));
			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}
			if (!isLogin(param)) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
			} else {
				if (param.getRequirementType().equals(
						Constants.REQUIREMENT_TYPE_TICKET.toString())) {
					dto.setTictktDetail(cRequirementService
							.queryRequirementTickDetailById(param));
					// 查询方案列表
					dto.getTictktDetail().setPubPlanList(
							pubPlanService.listPubPlanByPage(param, pageBounds));
				} else if (param.getRequirementType().equals(
						Constants.REQUIREMENT_TYPE_HOTEL.toString())) {
					dto.setHotelDetail(cRequirementService
							.queryRequirementHotelDetailById(param));
					dto.getHotelDetail().setPubPlanList(pubPlanService.listPubPlanByPage(param, pageBounds));
				} else if (param.getRequirementType().equals(
						Constants.REQUIREMENT_TYPE_PERSONAL_VISIT.toString())) {
					dto.setPersonalVisitDetail(cRequirementService
							.queryRequirementPersonalVisitDetailById(param));
					dto.getPersonalVisitDetail().setPubPlanList(pubPlanService.listPubPlanByPage(param, pageBounds));
				} else {
					dto.setGroupVisitDetail(cRequirementService
							.queryRequirementGroupVisiDetailById(param));
					dto.getGroupVisitDetail().setPubPlanList(pubPlanService.listPubPlanByPage(param, pageBounds));
				}
				setCommonProperties(param, dto);
				outputSuccessReponse(response, dto);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new ResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}

}
