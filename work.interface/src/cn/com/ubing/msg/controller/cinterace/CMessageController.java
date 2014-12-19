/**
 * 
 */
package cn.com.ubing.msg.controller.cinterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.msg.dto.DeleteMessageRequestDto;
import cn.com.ubing.msg.dto.GroupMessageListRequestDto;
import cn.com.ubing.msg.dto.GroupMessageListResponseDto;
import cn.com.ubing.msg.dto.MessageRequestDto;
import cn.com.ubing.msg.dto.MessageResponseDto;
import cn.com.ubing.msg.dto.MessageSendRequestDto;
import cn.com.ubing.msg.model.MsgGroup;
import cn.com.ubing.msg.service.MessageServiceI;
import cn.com.ubing.rms.dto.UserLoginResponseDto;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * C端用户消息处理接口
 * 
 * @author lumw
 * 
 * 
 */
@Controller
@RequestMapping("/")
public class CMessageController extends BaseController {

	/**
	 * log日志
	 */
	private final Logger log = Logger.getLogger(getClass());

	/**
	 * 消息service
	 */
	@Autowired
	private MessageServiceI messageService;
	
	
	@Value("#{settings['imageAttachmentHostAddr']}")
	private String imageAttachmentHostAddr;

	/**
	 * 消息列表接口(消息组列表）
	 * 
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/listMessageGroup")
	public void listMessageGroup(HttpServletRequest request,
			HttpServletResponse response, GroupMessageListRequestDto param) {
		try {
			// 构建返回参数对象
			GroupMessageListResponseDto dto = buildResponse(
					GroupMessageListResponseDto.class, param);

			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}
			if (param.getUid() == null) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
				return;
			}

			// 查询及封装
			PageBounds pageBounds = new PageBounds();
			pageBounds.setContainsTotalCount(true);
			pageBounds.setLimit(CommonUtils.parseInteger(param.getLimit()));
			pageBounds.setPage(CommonUtils.parseInteger(param.getPageNow()));
			pageBounds.getOrders().add(
					new Order("sendTime", Direction.DESC, ""));
			pageBounds.getOrders().add(
					new Order("unReadCount", Direction.DESC, ""));
			if (param.getLimit() == null || "".equals(param.getLimit())) {
				pageBounds.setLimit(10);
			}
			if (param.getPageNow() == null || "".equals(param.getPageNow())) {
				pageBounds.setPage(1);
			}
			GroupMessageListResponseDto temp = messageService
					.getGroupMessageListResponseDto(param, pageBounds);
			dto.setGroupMessageList(temp.getGroupMessageList());
			
			for(int i=0;i<dto.getGroupMessageList().size();i++)
			{
				dto.getGroupMessageList().get(i).setImageAttahcment(imageAttachmentHostAddr+"/"+dto.getGroupMessageList().get(i).getImageAttahcment());
			}
			
			dto.setPageNow(temp.getPageNow());
			
			  
			dto.setTotalCount(temp.getTotalCount());
			dto.setTotalPages(temp.getTotalPages());

			// 响应
			outputSuccessReponse(response, dto);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new UserLoginResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}

	/**
	 * 消息组详细接口
	 * 
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/viewMessageByGroup")
	public void viewMessageByGroup(HttpServletRequest request,
			HttpServletResponse response, MessageRequestDto param) {
		PageBounds pageBounds = new PageBounds();
		pageBounds.setContainsTotalCount(true);
		pageBounds.setLimit(CommonUtils.parseInteger(param.getLimit()));
		pageBounds.setPage(CommonUtils.parseInteger(param.getPage()));
		if (param.getLimit() == null || "".equals(param.getLimit())) {
			pageBounds.setLimit(10);
		}
		if (param.getPage() == null || "".equals(param.getPage())) {
			pageBounds.setPage(1);
		}
		try {
			// 响应response
			MessageResponseDto dto = buildResponse(MessageResponseDto.class,
					param);

			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}

			// uid、groupId、type校验
			if (param.getUid() == null) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
				return;
			}

			// 查询及封装
			MessageResponseDto temp = messageService.getMessageDetail(param,
					pageBounds);
			for(int i=0;i<temp.getMessageList().size();i++)
			{
				temp.getMessageList().get(i).setFromImageAttahcment(imageAttachmentHostAddr+"/"+temp.getMessageList().get(i).getFromImageAttahcment());
				temp.getMessageList().get(i).setToImageAttahcment(imageAttachmentHostAddr+"/"+temp.getMessageList().get(i).getToImageAttahcment());
			}
			dto.setMessageList(temp.getMessageList());

			// 响应
			outputSuccessReponse(response, dto);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new UserLoginResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}

	/**
	 * 发送消息接口
	 * 
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/cSendMessage")
	public void sendMessage(HttpServletRequest request,
			HttpServletResponse response, MessageSendRequestDto param) {
		try {
			// 响应response
			ResponseDto dto = buildResponse(ResponseDto.class, param);

			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}

			// uid、groupId、type校验
			if (!isLogin(param) || !CommonUtils.isLong(param.getType())
					|| !CommonUtils.isLong(param.getGroupId())) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"参数错误:uid、groupId、type必须是数字");
				return;
			}

			// 提问消息
			if ("9".equals(param.getType())) {
				Integer aacnt = messageService.queryAnswerCount(
						CommonUtils.parseLong(param.getGroupId()),
						CommonUtils.parseLong(param.getUid()));
				if (aacnt != null && aacnt > 0) {
					outputReponse(response, new UserLoginResponseDto(),
							Constants.RESULT_CODE_FAIL, "问题只能回答一次");
					return;
				}
				messageService.sendMessageForAsk(
						CommonUtils.parseLong(param.getGroupId()),
						CommonUtils.parseLong(param.getUid()),
						param.getContent());
			}
			// 消息
			else {
				MsgGroup group = messageService.getMsgGroupById(CommonUtils
						.parseLong(param.getGroupId()));
				Long fromId = CommonUtils.parseLong(param.getUid());
				Long toId = fromId.equals(group.getFromId()) ? group.getToId()
						: group.getFromId();
				if (messageService.isInBlackList(fromId, toId)) {
					outputReponse(response, new UserLoginResponseDto(),
							Constants.RESULT_CODE_FAIL, "发送失败:黑名单");
					return;
				}
				messageService.sendCMessage(
						CommonUtils.parseInteger(param.getType()), fromId,
						toId, param.getContent());
			}

			// 响应
			outputSuccessReponse(response, dto);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new UserLoginResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}
	
	/**
	 * 消息删除接口(消息删除列表）
	 * 
	 * @param request
	 * @param response
	 * @param param
	 */
	@RequestMapping("/cDeleteMessage")
	public void deleteMessage(HttpServletRequest request,
			HttpServletResponse response, DeleteMessageRequestDto param) {
		try {
			// 构建返回参数对象
			ResponseDto dto = buildResponse(
					ResponseDto.class, param);

			// 参数校验
			if (!checkRequest(param)) {
				outputParamCheckError(response, dto);
				return;
			}
			if (param.getUid() == null) {
				outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
						"用户未登录！");
				return;
			}
            if(param.getType().equals("1"))//删除消息组
            {
            	
            	if(messageService.deleteGroupMessageById(Long.parseLong(param.getId()))!=-1)
            	{
                dto.setResultInfo("删除成功");
            	}else{
            		dto.setResultInfo("删除失败");
            	}
            }else{
            	if(messageService.deleteMessageById(Long.parseLong(param.getId()))!=-1)
            	{
                    dto.setResultInfo("删除成功");
                	}else{
                		dto.setResultInfo("删除失败");
                	}	
            }
			// 响应
			outputSuccessReponse(response, dto);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			outputReponse(response, new UserLoginResponseDto(),
					Constants.RESULT_CODE_FAIL, "未知错误!");
		}
	}


}
