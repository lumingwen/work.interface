/**
 * 
 */
package cn.com.ubing.msg.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.ubing.ask.dao.AskAnswerMapper;
import cn.com.ubing.ask.model.AskAnswer;
import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.msg.dao.MsgBlacklistMapper;
import cn.com.ubing.msg.dao.MsgGroupMapper;
import cn.com.ubing.msg.dao.MsgInfoMapper;
import cn.com.ubing.msg.dto.GroupMessageDto;
import cn.com.ubing.msg.dto.GroupMessageListResponseDto;
import cn.com.ubing.msg.dto.MessageGroupDto;
import cn.com.ubing.msg.dto.MessageListResponseDto;
import cn.com.ubing.msg.dto.MessageRequestDto;
import cn.com.ubing.msg.dto.MessageResponseDto;
import cn.com.ubing.msg.model.MsgBlacklist;
import cn.com.ubing.msg.model.MsgGroup;
import cn.com.ubing.msg.model.MsgInfo;
import cn.com.ubing.msg.utils.SendXinGeMsg;
import cn.com.ubing.res.service.ResSystemPropertiesServiceI;
import cn.com.ubing.rms.dao.RmsUserMapper;
import cn.com.ubing.rms.model.RmsUser;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;
import com.tencent.xinge.MessageIOS;
import com.tencent.xinge.TimeInterval;
import com.tencent.xinge.XingeApp;

/**
 * 消息service
 * 
 * @author lumw
 * 
 * 
 */
@Service("messageService")
public class MessageServiceImpl implements MessageServiceI {

	/**
	 * 消息组dao
	 */
	@Autowired
	private MsgGroupMapper msgGroupMapper;

	/**
	 * 消息内容dao
	 */
	@Autowired
	private MsgInfoMapper msgInfoMapper;

	/**
	 * 用户dao
	 */
	@Autowired
	private RmsUserMapper rmsUserMapper;

	/**
	 * 问题回答dao
	 */
	@Autowired
	private AskAnswerMapper askAnswerMapper;

	/**
	 * 黑名单dao
	 */
	@Autowired
	private MsgBlacklistMapper msgBlacklistMapper;

	@Autowired
	private ResSystemPropertiesServiceI resSystemPropertiesService;

	/**
	 * (B端)查询消息组
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public MessageListResponseDto getMessageListResponseDto(RequestDto param,
			PageBounds pageBounds) {
		MessageListResponseDto dto = new MessageListResponseDto();
		RmsUser user = rmsUserMapper.selectByPrimaryKey(CommonUtils
				.parseLong(param.getUid()));
		if (user != null) {
			dto.setUserNickname(user.getNickname());
			dto.setUserMessage(user.getSignature());
			PageList<MessageGroupDto> pageList = msgGroupMapper
					.listMessageGroupDto(param, pageBounds);
			dto.setPageNow(pageList.getPaginator().getPage() + "");
			dto.setTotalPages(pageList.getPaginator().getTotalPages() + "");
			dto.setTotalCount(pageList.getPaginator().getTotalCount() + "");
			dto.setGroupFromUser(pageList);
		}
		return dto;
	}

	/**
	 * (B端)根据消息组查询消息内容
	 * 
	 * @param param
	 * @return
	 */
	@Override
	public MessageResponseDto getMessageDetail(MessageRequestDto param,
			PageBounds pageBounds) {
		MessageResponseDto dto = new MessageResponseDto();

		if ("9".equals(param.getType())) {
			// 提问
			dto.setMessageList(msgGroupMapper.listMessageDetailForAsk(param,
					pageBounds));
		} else {
			// 消息
			dto.setMessageList(msgGroupMapper.listMessageDetail(param,
					pageBounds));
			msgInfoMapper.updateToRead(param);
		}
		return dto;
	}

	/**
	 * (B端)是否在黑名单中
	 * 
	 * @param fromId
	 *            发送者id
	 * @param toId
	 *            接收者id
	 * @return true在,false不在
	 */
	@Override
	public boolean isInBlackList(Long fromId, Long toId) {
		MsgBlacklist param = new MsgBlacklist();
		param.setFromId(fromId);
		param.setToId(toId);
		List<MsgBlacklist> list = msgBlacklistMapper.listMsgBlacklist(param);
		return CollectionUtils.isNotEmpty(list);
	}

	/**
	 * (B端)根据消息组id查询消息组
	 * 
	 * @param groupId
	 * @return
	 */
	@Override
	public MsgGroup getMsgGroupById(Long groupId) {
		return msgGroupMapper.selectByPrimaryKey(groupId);
	}

	/**
	 * (B端)发送信息
	 * 
	 * @param type
	 * @param fromId
	 * @param toId
	 * @param content
	 */
	@Override
	public void sendMessage(Integer type, Long fromId, Long toId, String content) {
		// 消息组
		MsgGroup group = new MsgGroup();
		group.setType(type);
		group.setFromId(fromId);
		group.setToId(toId);
		List<MsgGroup> groupList = msgGroupMapper.listMsgGroup(group);
		if (CollectionUtils.isEmpty(groupList)) {
			group.setCreateTime(new Date());
			group.setUpdateTime(new Date());
			group.setDeleteFlag(Constants.DEL_FLAG_NO);
			msgGroupMapper.insert(group);
		} else {
			group = groupList.get(0);
			group.setUpdateTime(new Date());
			msgGroupMapper.updateByPrimaryKey(group);
		}
		// 消息内容
		MsgInfo info = new MsgInfo();
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		info.setDeleteFlag(Constants.DEL_FLAG_NO);
		info.setGroupId(group.getId());
		info.setContent(content);
		info.setSendTime(new Date());
		info.setStatus(Constants.MESSAGE_STAUTS_UN_READ);
		info.setDisplay(Constants.MESSAGE_DISPLAY_STAUTS_DISPLAY);
		info.setFromId(fromId);
		info.setToId(toId);
		msgInfoMapper.insert(info);
		if(type==4)
		{
		 sendPriceXGMsg(info,group,4);
		}else{
		 sendXGMsg(info,group, 2);
		}
	}
	

	/**
	 * (c端)发送信息
	 * 
	 * @param type
	 * @param fromId
	 * @param toId
	 * @param content
	 */
	@Override
	public void sendCMessage(Integer type, Long fromId, Long toId, String content) {
		// 消息组
		MsgGroup group = new MsgGroup();
		group.setType(type);
		group.setFromId(fromId);
		group.setToId(toId);
		List<MsgGroup> groupList = msgGroupMapper.listMsgGroup(group);
		if (CollectionUtils.isEmpty(groupList)) {
			group.setCreateTime(new Date());
			group.setUpdateTime(new Date());
			group.setDeleteFlag(Constants.DEL_FLAG_NO);
			msgGroupMapper.insert(group);
		} else {
			group = groupList.get(0);
			group.setUpdateTime(new Date());
			msgGroupMapper.updateByPrimaryKey(group);
		}
	
		// 消息内容
		MsgInfo info = new MsgInfo();
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		info.setDeleteFlag(Constants.DEL_FLAG_NO);
		info.setGroupId(group.getId());
		info.setContent(content);
		info.setSendTime(new Date());
		info.setStatus(Constants.MESSAGE_STAUTS_UN_READ);
		info.setDisplay(Constants.MESSAGE_DISPLAY_STAUTS_DISPLAY);
		info.setFromId(fromId);
		info.setToId(toId);
		msgInfoMapper.insert(info);
		//发送信鸽消息
		sendBXGMsg(info,group, 2);
	}
	

	/**
	 * (B端)发送提问消息
	 * 
	 * @param questionId
	 * @param userId
	 * @param content
	 */
	@Override
	public void sendMessageForAsk(Long questionId, Long userId, String content) {
		// 回答问题
		AskAnswer aa = new AskAnswer();
		aa.setContent(content);
		aa.setCreateTime(new Date());
		aa.setDeleteFlag(Constants.DEL_FLAG_NO);
		aa.setFromId(userId);
		aa.setQuestionId(questionId);
		aa.setStatus(Constants.ANSWER_STATUS_UN_EVALUATE);
		aa.setUpdateTime(aa.getCreateTime());
		askAnswerMapper.insert(aa);
		// 增加竞争力
		// ResSystemProperties rr =
		// resSystemPropertiesService.selectByKey("ask_score");
		// if (rr!=null && rr.getValue()!=null){
		// RmsUser ru = new RmsUser();
		// ru.setId(userId);
		// // ru.setGrabValue(rr.getAskScore().intValue());
		// //ru.setGrabValue(rr.getAskScore().intValue());
		// rmsUserMapper.addGrabValue(ru);
		// }
	}

	/**
	 * (B端)修改个性签名
	 * 
	 * @param userId
	 * @param signature
	 */
	@Override
	public void updateUserSignature(Long userId, String signature) {
		RmsUser user = rmsUserMapper.selectByPrimaryKey(userId);
		user.setSignature(signature);
		user.setUpdateTime(new Date());
		rmsUserMapper.updateByPrimaryKey(user);
	}

	/**
	 * 查询问题回答总数
	 * 
	 * @param questionId
	 * @param userId
	 * @return
	 */
	@Override
	public Integer queryAnswerCount(Long questionId, Long userId) {
		return msgGroupMapper.queryAnswerCount(questionId, userId);
	}

	@Override
	public MsgGroup getMsgGroupByUser(Long oneUserId, Long twoUserId) {
		// TODO Auto-generated method stub
		MsgGroup param = new MsgGroup();
		param.setFromId(oneUserId);
		param.setToId(twoUserId);
		MsgGroup group = msgGroupMapper.selectByUserId(param);
		if (group == null) {
			group = new MsgGroup();
			group.setCreateTime(new Date());
			group.setUpdateTime(new Date());
			group.setDeleteFlag(Constants.DEL_FLAG_NO);
			group.setType(Constants.MESSAGE_TYPE_USER);
			group.setFromId(oneUserId);
			group.setToId(twoUserId);
			msgGroupMapper.insert(group);
		}
		return group;
	}

	@Override
	public GroupMessageListResponseDto getGroupMessageListResponseDto(
			RequestDto param, PageBounds pageBounds) {
		GroupMessageListResponseDto dto = new GroupMessageListResponseDto();
		RmsUser user = rmsUserMapper.selectByPrimaryKey(CommonUtils
				.parseLong(param.getUid()));
		if (user != null) {
			PageList<GroupMessageDto> groupMessageList = msgGroupMapper
					.listGroupMessageDto(param, pageBounds);
			dto.setPageNow(groupMessageList.getPaginator().getPage() + "");
			dto.setTotalPages(groupMessageList.getPaginator().getTotalPages()
					+ "");
			dto.setTotalCount(groupMessageList.getPaginator().getTotalCount()
					+ "");
			dto.setGroupMessageList(groupMessageList);
		}
		return dto;
	}

	@Override
	public void sendUserMessage(Integer type, Long fromId, Long toId,
			String content) {
		// 消息组
		MsgGroup group = new MsgGroup();
		group.setType(type);
		group.setFromId(fromId);
		group.setToId(toId);
		List<MsgGroup> groupList = msgGroupMapper.listMsgGroup(group);
		if (CollectionUtils.isEmpty(groupList)) {
			group.setCreateTime(new Date());
			group.setUpdateTime(new Date());
			group.setDeleteFlag(Constants.DEL_FLAG_NO);
			msgGroupMapper.insert(group);
		} else {
			group = groupList.get(0);
			group.setUpdateTime(new Date());
			msgGroupMapper.updateByPrimaryKey(group);
		}
		// 消息内容
		MsgInfo info = new MsgInfo();
		info.setCreateTime(new Date());
		info.setUpdateTime(new Date());
		info.setDeleteFlag(Constants.DEL_FLAG_NO);
		info.setGroupId(group.getId());
		info.setContent(content);
		info.setSendTime(new Date());
		info.setStatus(Constants.MESSAGE_STAUTS_UN_READ);
		info.setDisplay(Constants.MESSAGE_DISPLAY_STAUTS_DISPLAY);
		info.setFromId(fromId);
		info.setToId(toId);
		msgInfoMapper.insert(info);
		sendXGMsg(info, group, 2);

	}

	/**
	 * * 发送信鸽推送信息
	 * 
	 * @author lumw
	 * @param info
	 * @param group
	 * @param flag
	 */
	public void sendXGMsg(MsgInfo info, MsgGroup group, Integer flag) {
		RmsUser user = rmsUserMapper.selectByPrimaryKey(info.getToId());
		RmsUser user1 = rmsUserMapper.selectByPrimaryKey(info.getFromId());
		Map<String, Object> custom = new HashMap<String, Object>();
		custom.put("type", flag + "");// 类型：判断是推送的消息类型（1订单消息，2聊天消息,中标消息）
		custom.put("fromName", user.getUsername());
		custom.put("groupId", info.getGroupId() + "");
		custom.put("messageType", group.getType() + "");
		
		 MessageIOS iosMessage = new MessageIOS();
		 iosMessage.setCustom(custom);
	     iosMessage.setExpireTime(259200);
	     iosMessage.setAlert(user1.getUsername()+"给你发送了一条新的消息");
		 iosMessage.setCustom(custom);
	     iosMessage.setBadge(1);
	     iosMessage.setSound("blow.aiff");
	     TimeInterval acceptTime2 = new TimeInterval(0, 0, 23, 59);
	     iosMessage.addAcceptTime(acceptTime2);

		if ("ANDROID".equals(user.getAppType()) && user.getXingeToken() != null
				&& !"".equals(user.getXingeToken())) {
			Long AndroidAccessId = CommonUtils
					.parseLong(resSystemPropertiesService.selectByKey(
							"android_access_id").getPropValue());
			String AndroidSecretKey = resSystemPropertiesService.selectByKey(
					"android_secret_key").getPropValue();
			 System.out.println(SendXinGeMsg.pushSingleDeviceMessageToAndroid(flag,AndroidAccessId, AndroidSecretKey, custom, user.getXingeToken()));
		} else if ("IPHONE".equals(user.getAppType())
				&& user.getXingeToken() != null
				&& !"".equals(user.getXingeToken())) {
			Long IosAccessId = CommonUtils.parseLong(resSystemPropertiesService
					.selectByKey("ios_c_access_id").getPropValue());
			String IosSecretKey = resSystemPropertiesService
					.selectByKey("ios_c_secret_key").getPropValue();
			XingeApp xinge1 = new XingeApp(IosAccessId, IosSecretKey);
			xinge1.pushSingleDevice(user.getXingeToken(), iosMessage, XingeApp.IOSENV_DEV);
		}
	}
	
	
	/**
	 * * 发送报价信鸽推送信息
	 * 
	 * @author lumw
	 * @param info
	 * @param group
	 * @param flag
	 */
	public void sendPriceXGMsg(MsgInfo info, MsgGroup group, Integer flag) {
		RmsUser user = rmsUserMapper.selectByPrimaryKey(info.getToId());
		RmsUser user1 = rmsUserMapper.selectByPrimaryKey(info.getFromId());
		Map<String, Object> custom = new HashMap<String, Object>();
		custom.put("type", flag + "");// 类型：判断是推送的消息类型（1订单消息，2聊天消息,中标消息）
		custom.put("fromName", user.getUsername());
		custom.put("content", info.getContent());
		 MessageIOS iosMessage = new MessageIOS();
		 iosMessage.setCustom(custom);
	     iosMessage.setExpireTime(259200);
	     iosMessage.setAlert(user1.getUsername()+"给你报价了！");
		 iosMessage.setCustom(custom);
	     iosMessage.setBadge(1);
	     iosMessage.setSound("blow.aiff");
	     TimeInterval acceptTime2 = new TimeInterval(0, 0, 23, 59);
	     iosMessage.addAcceptTime(acceptTime2);

		if ("ANDROID".equals(user.getAppType()) && user.getXingeToken() != null
				&& !"".equals(user.getXingeToken())) {
			Long AndroidAccessId = CommonUtils
					.parseLong(resSystemPropertiesService.selectByKey(
							"android_access_id").getPropValue());
			String AndroidSecretKey = resSystemPropertiesService.selectByKey(
					"android_secret_key").getPropValue();
			 System.out.println(SendXinGeMsg.pushSingleDeviceMessageToAndroid(flag,AndroidAccessId, AndroidSecretKey, custom, user.getXingeToken()));
		} else if ("IPHONE".equals(user.getAppType())
				&& user.getXingeToken() != null
				&& !"".equals(user.getXingeToken())) {
			Long IosAccessId = CommonUtils.parseLong(resSystemPropertiesService
					.selectByKey("ios_access_id").getPropValue());
			String IosSecretKey = resSystemPropertiesService
					.selectByKey("ios_secret_key").getPropValue();
			XingeApp xinge1 = new XingeApp(IosAccessId, IosSecretKey);
			xinge1.pushSingleDevice(user.getXingeToken(), iosMessage, XingeApp.IOSENV_DEV);
		}
	}
	
	
	/**
	 * * 发送信鸽推送信息B端
	 * 
	 * @author lumw
	 * @param info
	 * @param group
	 * @param flag
	 */
	public void sendBXGMsg(MsgInfo info, MsgGroup group, Integer flag) {
		RmsUser user = rmsUserMapper.selectByPrimaryKey(info.getToId());
		RmsUser user1 = rmsUserMapper.selectByPrimaryKey(info.getFromId());
		Map<String, Object> custom = new HashMap<String, Object>();
		custom.put("type", flag + "");// 类型：判断是推送的消息类型（1订单消息，2聊天消息,中标消息）
		custom.put("fromName", user.getUsername());
		custom.put("groupId", info.getGroupId() + "");
		custom.put("messageType", group.getType() + "");
		
		 MessageIOS iosMessage = new MessageIOS();
	     iosMessage.setExpireTime(259200);
	     iosMessage.setAlert(user1.getUsername()+"给你发送了一条新的消息");
		 iosMessage.setCustom(custom);
	     iosMessage.setBadge(1);
	     iosMessage.setSound("blow.aiff");
	     TimeInterval acceptTime2 = new TimeInterval(0, 0, 23, 59);
	     iosMessage.addAcceptTime(acceptTime2);

		if ("ANDROID".equals(user.getAppType()) && user.getXingeToken() != null
				&& !"".equals(user.getXingeToken())) {
			Long AndroidAccessId = CommonUtils
					.parseLong(resSystemPropertiesService.selectByKey(
							"android_access_id").getPropValue());
			String AndroidSecretKey = resSystemPropertiesService.selectByKey(
					"android_secret_key").getPropValue();
			 System.out.println(SendXinGeMsg.pushSingleDeviceMessageToAndroid(flag,AndroidAccessId, AndroidSecretKey, custom, user.getXingeToken()));
		} else if ("IPHONE".equals(user.getAppType())
				&& user.getXingeToken() != null
				&& !"".equals(user.getXingeToken())) {
			Long IosAccessId = CommonUtils.parseLong(resSystemPropertiesService
					.selectByKey("ios_c_access_id").getPropValue());
			String IosSecretKey = resSystemPropertiesService
					.selectByKey("ios_c_secret_key").getPropValue();	
  
			XingeApp xinge1 = new XingeApp(IosAccessId, IosSecretKey);
			xinge1.pushSingleDevice(user.getXingeToken(), iosMessage, XingeApp.IOSENV_DEV);
		}
	}

	@Override
	public int deleteGroupMessageById(Long groupId) {
		
		if(msgGroupMapper.deleteByPrimaryKey(groupId)!=-1&&
		   msgInfoMapper.deleteMessageByGroupId(groupId)!=-1)
		{
		     return 1;
		}else{
			return -1;
		}
	}

	@Override
	public int deleteMessageById(Long id) {
		return msgInfoMapper.deleteByPrimaryKey(id);
	}

}
