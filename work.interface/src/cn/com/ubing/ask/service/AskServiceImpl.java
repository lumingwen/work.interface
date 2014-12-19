/**
 * 
 */
package cn.com.ubing.ask.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.ask.dao.AskAnswerMapper;
import cn.com.ubing.ask.dao.AskQuestionFacilitatorMapper;
import cn.com.ubing.ask.dao.AskQuestionMapper;
import cn.com.ubing.ask.dto.AnswerAppraiseRequestDto;
import cn.com.ubing.ask.dto.AnswerDetailRequestDto;
import cn.com.ubing.ask.dto.AnswerListRequestDto;
import cn.com.ubing.ask.dto.QuestionListRequestDto;
import cn.com.ubing.ask.dto.QuestionSubmitRequestDto;
import cn.com.ubing.ask.dto.content.AnswerDetailContent;
import cn.com.ubing.ask.dto.content.QuestionDetailContent;
import cn.com.ubing.ask.model.AskAnswer;
import cn.com.ubing.ask.model.AskQuestion;
import cn.com.ubing.ask.model.AskQuestionFacilitator;
import cn.com.ubing.common.utils.StringUtils;
import cn.com.ubing.msg.service.MessageServiceI;
import cn.com.ubing.pub.dao.PubRequirementAndQuestionMapper;
import cn.com.ubing.pub.dto.PushQuestionDto;
import cn.com.ubing.pub.service.PubRequirementNoticeServiceI;
import cn.com.ubing.res.dao.ResDictMapper;
import cn.com.ubing.res.dao.ResSystemPropertiesMapper;
import cn.com.ubing.res.model.ResDict;
import cn.com.ubing.res.model.ResSystemProperties;
import cn.com.ubing.res.service.ResAttachmentServiceI;
import cn.com.ubing.rms.dao.RmsUserMapper;
import cn.com.ubing.rms.dto.RmsUserDto;
import cn.com.ubing.rms.model.RmsUser;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.thread.ScheduledExecutorServiceFactory;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * 旅行问答service
 * @author zhangxujun
 * 
 *
 */
@Service("askService")
public class AskServiceImpl implements AskServiceI {
    
    
    private final Logger log = Logger.getLogger(getClass());
    
    
    /**
     * dao
     */
    @Autowired
    private AskQuestionMapper askQuestionMapper;
    
    /**
     * dao
     */
    @Autowired
    private AskAnswerMapper askAnswerMapper;
    
    
    /**
     * dao
     */
    @Autowired
    private RmsUserMapper rmsUserMapper;
    
    /**
     * dao
     */
    @Autowired
    private ResDictMapper resDictMapper;
    
    /**
     * dao
     */
    @Autowired
    private PubRequirementAndQuestionMapper pubRequirementAndQuestionMapper;
    
    /**
     * dao
     */
    @Autowired
    private AskQuestionFacilitatorMapper askQuestionFacilitatorMapper;
    
    /**
     * dao
     */
    @Autowired
    private PubRequirementNoticeServiceI pubRequirementNoticeService;
    
    
    /**
     * 消息service
     */
    @Autowired
    private MessageServiceI messageService;
    
    /**
     * dao
     */
    @Autowired
    private ResSystemPropertiesMapper resSystemPropertiesMapper;
    
    @Autowired
    private ResAttachmentServiceI resAttachmentService;
    
    /**
     * 提交提问,返回问题推送数量
     * 
     */
    @Override
    public Integer submitQuestion(QuestionSubmitRequestDto param) {
	// 保存提问
	final AskQuestion record = new AskQuestion();
	record.setCreateTime(new Date());
	record.setUpdateTime(new Date());
	record.setDeleteFlag(Constants.DEL_FLAG_NO);
	record.setFromId(CommonUtils.parseLong(param.getUid()));
	record.setTargetRegionId(CommonUtils.parseLong(param
		.getTargetRegionId()));
	record.setContent(param.getContent());
	record.setStatus(Constants.QUESTION_STATUS_UN_RESOLVED);
	askQuestionMapper.insert(record);
	// 查询推送列表
	final List<RmsUserDto> userList = new ArrayList<RmsUserDto>();
	PushQuestionDto pushDto = new PushQuestionDto();
	pushDto.setQuestionId(record.getId());
	pubRequirementAndQuestionMapper.getPushQuestionUserIds(pushDto);
	if (StringUtils.isNotBlank(pushDto.getResult())) {
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("userIds", pushDto.getResult());
	    List<RmsUserDto> temps = pubRequirementAndQuestionMapper
		    .getRmsUserByIds(map);
	    if (CollectionUtils.isNotEmpty(temps)) {
		userList.addAll(temps);
	    }
	}
	// 保存推送关系
	for (RmsUserDto user : userList) {
	    AskQuestionFacilitator pub = new AskQuestionFacilitator();
	    pub.setCreateTime(new Date());
	    pub.setUpdateTime(new Date());
	    pub.setDeleteFlag(Constants.DEL_FLAG_NO);
	    pub.setQuestionId(record.getId());
	    pub.setFacilitatorId(user.getId());
	    pub.setStatus(0);
	    pub.setReadTime(null);
	    askQuestionFacilitatorMapper.insert(pub);
	}
	// 推送微信消息到B端、管理员
	long delay = 500;
	ScheduledExecutorServiceFactory.buildScheduledExecutorService()
		.schedule(new Runnable() {
		    @Override
		    public void run() {
			RmsUser askUser = rmsUserMapper.selectByPrimaryKey(record
				.getFromId());
			ResDict dict = resDictMapper.selectByPrimaryKey(record
				.getTargetRegionId());
			// 推送给管理员
			List<RmsUser> list = pubRequirementNoticeService.listPubRequirementNoticeUser();
			if (CollectionUtils.isNotEmpty(list)) {
			    StringBuffer sb = new StringBuffer(
				    askUser == null ? "" : askUser.getTel())
				    .append("提交了一个提问\n\n");
			    sb.append("目的地:\n      ").append(
				    dict == null ? "" : dict.getCname());
			    sb.append("\n提问内容:      ").append(
				    record.getContent());
			    String notice = sb.toString();
			    for (RmsUser user : list) {
				try {
				    pubRequirementNoticeService.sendWxNotice(
					    user, notice);
				} catch (Exception e) {
				    log.error(e.getMessage(), e);
				}
			    }
			}
			// 推送给B端
			if (CollectionUtils.isNotEmpty(userList)) {
			    String weixinText = "您收到了一条来自"
				    + (askUser == null ? "" : askUser.getTel())
				    + "的提问，快去回答吧，回答将增加您的竞争力哟";
			    for (RmsUserDto user : userList) {
				try {
				    pubRequirementNoticeService.sendWxNotice(
					    user, weixinText);
				} catch (Exception e) {
				    log.error(e.getMessage(), e);
				}
			    }
			}
		    }
		}, delay, TimeUnit.MILLISECONDS);
	// 返回推送数
	return userList.size();
    }
    
    
    /**
     * 查询需求列表
     * 
     */
    @Override
	public PageList<QuestionDetailContent> listQuestionContent(
			QuestionListRequestDto param) {
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(StringUtils.isBlank(param.getPage()) ? 1
				: CommonUtils.parseInteger(param.getPage()));
		pageBounds
				.setLimit(StringUtils.isBlank(param.getLimit()) ? Integer.MAX_VALUE
						: CommonUtils.parseInteger(param.getLimit()));
		pageBounds.getOrders()
				.add(new Order("update_time", Direction.DESC, ""));
		PageList<QuestionDetailContent> list = askQuestionMapper.listQuestionContent(param, pageBounds);
		if (list!=null){
			for (QuestionDetailContent qdc:list){
				qdc.setFromeUserIcon(resAttachmentService.getFullHttpUrl(qdc.getFromeUserIcon()));
			}
		}
		return list;
	}
    
    
    
    
    /**
     * 查看需求详情
     * 
     */
    @Override
    public QuestionDetailContent getQuestionContent(Long id){
    	QuestionDetailContent content =  askQuestionMapper.getQuestionContent(id);
    	if (content!=null){
    		content.setFromeUserIcon(resAttachmentService.getFullHttpUrl(content.getFromeUserIcon()));
    	}
    	return content;
    }

    
    /**
     * 查询回答列表
     * 
     */
    @Override
	public PageList<AnswerDetailContent> listAnswerContent(
			AnswerListRequestDto param) {
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(StringUtils.isBlank(param.getPage()) ? 1
				: CommonUtils.parseInteger(param.getPage()));
		pageBounds
				.setLimit(StringUtils.isBlank(param.getLimit()) ? Integer.MAX_VALUE
						: CommonUtils.parseInteger(param.getLimit()));
		pageBounds.getOrders()
				.add(new Order("update_time", Direction.DESC, ""));
		PageList<AnswerDetailContent> list = askAnswerMapper.listAnswerContent(
				param, pageBounds);
		if (list!=null){
			for (AnswerDetailContent adc:list){
				adc.setAnswerUserIcon(resAttachmentService.getFullHttpUrl(adc.getAnswerUserIcon()));
			}
		}
		return list;
	}
    
    /**
     * 查询回答详情
     */
    @Override
    public AnswerDetailContent getAnswerContent(AnswerDetailRequestDto param){
    	AnswerDetailContent content = askAnswerMapper.getAnswerContent(param);
    	if (content!=null){
    		content.setAnswerUserIcon(resAttachmentService.getFullHttpUrl(content.getAnswerUserIcon()));
    	}
    	return content;
    }
    
    /**
     * 评价回答
     */
    @Override
    public void answerAppraise(AnswerAppraiseRequestDto param){
	AskAnswer as = askAnswerMapper.selectByPrimaryKey(CommonUtils.parseLong(param.getId()));
	if (as != null) {
	    //最佳
	    if ("1".equals(param.getAppraise())) {
		AskQuestion aq = askQuestionMapper.selectByPrimaryKey(as.getQuestionId());
		if (aq!=null){
		    aq.setStatus(Constants.QUESTION_STATUS_RESOLVED);
		    aq.setUpdateTime(new Date());
		    askQuestionMapper.updateByPrimaryKey(aq);
		}
		as.setStatus(Constants.ANSWER_STATUS_BEST);
		as.setUpdateTime(new Date());
		askAnswerMapper.updateByPrimaryKey(as);
		ResDict dict = resDictMapper.selectByPrimaryKey(aq.getTargetRegionId());
		messageService.sendMessage(Constants.MESSAGE_TYPE_SYSTEM, -1L, CommonUtils.parseLong(param.getUid()), "您回答的一条关于"+(dict==null?"":dict.getCname())+"回答被采纳为最佳回答");
		ResSystemProperties prop = resSystemPropertiesMapper.selectByKey(Constants.SYSTEM_PRO_COMPOSITE_RULE_WENTIBEICAINAI);
		if (prop!=null){
		    Double addScore = CommonUtils.parseDouble(prop.getPropValue());
		    if (addScore!=null){
			RmsUser score = new RmsUser();
			score.setId(as.getFromId());
			score.setScore(addScore);
			rmsUserMapper.addScore(score);
		    }
		}
	    }
	    //有用
	    if ("2".equals(param.getAppraise())) {
		as.setStatus(Constants.ANSWER_STATUS_USEFULL);
		as.setUpdateTime(new Date());
		askAnswerMapper.updateByPrimaryKey(as);
		ResSystemProperties prop = resSystemPropertiesMapper.selectByKey(Constants.SYSTEM_PRO_COMPOSITE_RULE_WENTIBEIZHAN);
		if (prop!=null){
		    Double addScore = CommonUtils.parseDouble(prop.getPropValue());
		    if (addScore!=null){
			RmsUser score = new RmsUser();
			score.setId(as.getFromId());
			score.setScore(addScore);
			rmsUserMapper.addScore(score);
		    }
		}
	    }
	    //无用
	    if ("3".equals(param.getAppraise())) {
		as.setStatus(Constants.ANSWER_STATUS_USELESS);
		as.setUpdateTime(new Date());
		askAnswerMapper.updateByPrimaryKey(as);
		ResSystemProperties prop = resSystemPropertiesMapper.selectByKey(Constants.SYSTEM_PRO_COMPOSITE_RULE_WENTIBEICAI);
		if (prop!=null){
		    Double addScore = CommonUtils.parseDouble(prop.getPropValue());
		    if (addScore!=null){
			RmsUser score = new RmsUser();
			score.setId(as.getFromId());
			score.setScore(addScore);
			rmsUserMapper.addScore(score);
		    }
		}
	    }
	}
    }
}
