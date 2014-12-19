/**
 * 
 */
package cn.com.ubing.msg.controller.binterace;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.msg.dto.MessageListRequestDto;
import cn.com.ubing.msg.dto.MessageListResponseDto;
import cn.com.ubing.msg.dto.MessageRequestDto;
import cn.com.ubing.msg.dto.MessageResponseDto;
import cn.com.ubing.msg.dto.MessageSendRequestDto;
import cn.com.ubing.msg.dto.ModifySignatureRequestDto;
import cn.com.ubing.msg.model.MsgGroup;
import cn.com.ubing.msg.service.MessageServiceI;
import cn.com.ubing.rms.dto.UserLoginResponseDto;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * B端用户消息处理接口
 * 
 * @author zhangxujun
 * 
 * 
 */
@Controller
@RequestMapping("/")
public class BMessageController extends BaseController {

    /**
     * log日志
     */
    private final Logger log = Logger.getLogger(getClass());

    /**
     * 消息service
     */
    @Autowired
    private MessageServiceI messageService;

    /**
     * 消息列表接口
     * 
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/messageList")
    public void messageList(HttpServletRequest request, HttpServletResponse response, MessageListRequestDto param) {

        try {

            // 响应response
            MessageListResponseDto dto = buildResponse(MessageListResponseDto.class, param);

            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }

            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "用户id不能为空");
                return;
            }

            // 查询及封装
            PageBounds pageBounds = new PageBounds();
            pageBounds.setContainsTotalCount(true);
            pageBounds.setLimit(CommonUtils.parseInteger(param.getLimit()));
            pageBounds.setPage(CommonUtils.parseInteger(param.getPage()));
            pageBounds.getOrders().add(new Order("sendTime", Direction.DESC, ""));
            pageBounds.getOrders().add(new Order("unReadCount", Direction.DESC, ""));
            if (param.getLimit() == null || "".equals(param.getLimit())) {
                pageBounds.setLimit(10);
            }
            if (param.getPage() == null || "".equals(param.getPage())) {
                pageBounds.setPage(1);
            }
            MessageListResponseDto temp = messageService.getMessageListResponseDto(param, pageBounds);
            dto.setGroupFromUser(temp.getGroupFromUser());
            dto.setUserMessage(temp.getUserMessage());
            dto.setPageNow(temp.getPageNow());
            dto.setTotalCount(temp.getTotalCount());
            dto.setTotalPages(temp.getTotalPages());

            // 响应
            outputSuccessReponse(response, dto);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }

    /**
     * 消息组详细接口
     * 
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/message")
    public void message(HttpServletRequest request, HttpServletResponse response, MessageRequestDto param) {
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
            MessageResponseDto dto = buildResponse(MessageResponseDto.class, param);

            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }

            // uid、groupId、type校验
            if (!isLogin(param) || !CommonUtils.isLong(param.getType()) || !CommonUtils.isLong(param.getGroupId())) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "参数错误:uid、groupId、type必须是数字");
                return;
            }

            // 查询及封装
            MessageResponseDto temp = messageService.getMessageDetail(param,pageBounds);
            dto.setMessageList(temp.getMessageList());

            // 响应
            outputSuccessReponse(response, dto);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }

    /**
     * 发送消息接口
     * 
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/sendMessage")
    public void sendMessage(HttpServletRequest request, HttpServletResponse response, MessageSendRequestDto param) {
        try {
            // 响应response
            ResponseDto dto = buildResponse(ResponseDto.class, param);

            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }

            // uid、groupId、type校验
            if (!isLogin(param) || !CommonUtils.isLong(param.getType()) || !CommonUtils.isLong(param.getGroupId())) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "参数错误:uid、groupId、type必须是数字");
                return;
            }

            // 提问消息
            if ("9".equals(param.getType())) {
                Integer aacnt = messageService.queryAnswerCount(CommonUtils.parseLong(param.getGroupId()),
                        CommonUtils.parseLong(param.getUid()));
                if (aacnt != null && aacnt > 0) {
                    outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "问题只能回答一次");
                    return;
                }
                messageService.sendMessageForAsk(CommonUtils.parseLong(param.getGroupId()), CommonUtils.parseLong(param.getUid()),
                        param.getContent());
            }
            // 消息
            else {
                MsgGroup group = messageService.getMsgGroupById(CommonUtils.parseLong(param.getGroupId()));
                Long fromId = CommonUtils.parseLong(param.getUid());
                Long toId = fromId.equals(group.getFromId()) ? group.getToId() : group.getFromId();
                if (messageService.isInBlackList(fromId, toId)) {
                    outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "发送失败:黑名单");
                    return;
                }
                messageService.sendMessage(CommonUtils.parseInteger(param.getType()), fromId, toId, param.getContent());
            }

            // 响应
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }

    /**
     * 修改吆喝
     * 
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/modifySignature")
    public void modifySignature(HttpServletRequest request, HttpServletResponse response, ModifySignatureRequestDto param) {
        try {
            // 响应response
            ResponseDto dto = buildResponse(ResponseDto.class, param);

            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }

            // uid校验
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL, "参数错误:uid必须是数字");
                return;
            }

            // 修改
            messageService.updateUserSignature(CommonUtils.parseLong(param.getUid()), param.getSignature());

            // 响应
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new UserLoginResponseDto(), Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }

}
