package cn.com.ubing.pub.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.msg.model.MsgGroup;
import cn.com.ubing.msg.service.MessageServiceI;
import cn.com.ubing.pub.dao.PubAppraisalMapper;
import cn.com.ubing.pub.dao.PubOrdersMapper;
import cn.com.ubing.pub.dao.PubPlanMapper;
import cn.com.ubing.pub.dao.PubRequirementGroupVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementMapper;
import cn.com.ubing.pub.dao.PubRequirementPersonalVisitMapper;
import cn.com.ubing.pub.dto.BPubOrdersDetailsRequestDto;
import cn.com.ubing.pub.dto.BPubOrdersDetailsResponseDto;
import cn.com.ubing.pub.dto.BPubOrdersListDto;
import cn.com.ubing.pub.dto.BPubOrdersListRequestDto;
import cn.com.ubing.pub.dto.CAppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.CAppraisalDetailResponseDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailRequestDto;
import cn.com.ubing.pub.dto.CPubOrdersDetailResponseDto;
import cn.com.ubing.pub.dto.CSaveAppraisalRequestDto;
import cn.com.ubing.pub.dto.PubOrdersListDto;
import cn.com.ubing.pub.dto.PubOrdersListRequestDto;
import cn.com.ubing.pub.model.PubAppraisal;
import cn.com.ubing.pub.model.PubOrders;
import cn.com.ubing.pub.model.PubPlan;
import cn.com.ubing.pub.model.PubRequirementGroupVisit;
import cn.com.ubing.pub.model.PubRequirementPersonalVisit;
import cn.com.ubing.res.dao.ResAttachmentMapper;
import cn.com.ubing.res.service.ResAttachmentServiceI;
import cn.com.ubing.rms.dao.RmsUserExtendMapper;
import cn.com.ubing.rms.dao.RmsUserMapper;
import cn.com.ubing.rms.dao.RmsUserMoneyDetailsMapper;
import cn.com.ubing.rms.model.RmsUser;
import cn.com.ubing.rms.model.RmsUserExtend;
import cn.com.ubing.rms.model.RmsUserMoneyDetails;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

@Service("pubOrdersService")
public class PubOrdersServiceImpl implements PubOrdersServiceI {
    @Autowired
    private PubOrdersMapper pubOrdersMapper;
    @Autowired
    private RmsUserExtendMapper rmsUserExtendMapper;
    @Autowired
    private RmsUserMoneyDetailsMapper rmsUserMoneyDetailsMapper;
    @Autowired
    private PubPlanMapper pubPlanMapper;
    @Autowired
    private PubAppraisalMapper pubAppraisalMapper;
    @Autowired
    private RmsUserMapper rmsUserMapper;
    @Autowired
    private ResAttachmentMapper resAttachmentMapper;
	
	@Autowired
	private MessageServiceI messageService;
	@Autowired
	private PubRequirementMapper pubRequirementMapper;
	@Autowired
	private ResAttachmentServiceI resAttachmentService;
	
	@Autowired
	private PubRequirementPersonalVisitMapper pubRequirementPersonalVisitMapper;
	
	@Autowired
	private PubRequirementGroupVisitMapper pubRequirementGroupVisitMapper;

    @Override
    public PageList<PubOrdersListDto> queryOrderList(PubOrdersListRequestDto param, PageBounds pageBounds) {
        return pubOrdersMapper.queryOrderList(param, pageBounds);
    }

    @Override
    public CPubOrdersDetailResponseDto getOrderDetail(CPubOrdersDetailRequestDto param) {
        return pubOrdersMapper.getOrderDetail(param);
    }

    @Override
    public String confirmTravel(Long orderId) {
        String res = "确认出行失败";
        PubOrders pubOrders = pubOrdersMapper.selectByPrimaryKey(orderId);
        // 校验订单是否存在
        if (pubOrders != null) {
            // 校验是否付款
            if (pubOrders.getPayStatus() == 1) {
                // 否已经确认出行
                if (pubOrders.getConfirmTravelStatus() == 0) {
                    // 确认出行，更改订单状态，
                    pubOrders.setConfirmTravelStatus(1);// 订单的确认出行状态设置为已确认出行
                    pubOrders.setConfirmTravelTime(new Date());
                    pubOrdersMapper.updateByPrimaryKey(pubOrders);
                    // 将金额转到商家rms_user_extend
                    RmsUserExtend rmsUserExtend = rmsUserExtendMapper.selectByPrimaryKey(pubOrders.getSellUserId());
                    if (rmsUserExtend != null) {
                        rmsUserExtend.setMoney(rmsUserExtend.getMoney() + pubOrders.getPayMoney());
                        rmsUserExtend.setUpdateTime(new Date());
                        rmsUserExtendMapper.updateByPrimaryKey(rmsUserExtend);
                    } else {
                        rmsUserExtend = new RmsUserExtend();
                        rmsUserExtend.setCreateTime(new Date());
                        rmsUserExtend.setUpdateTime(new Date());
                        rmsUserExtend.setDeleteFlag(Constants.DEL_FLAG_NO);
                        rmsUserExtend.setUserId(pubOrders.getSellUserId());
                        rmsUserExtend.setMoney(pubOrders.getPayMoney());
                        rmsUserExtendMapper.insert(rmsUserExtend);
                    }
                    // 添加转账记录rms_user_money_details
                    RmsUserMoneyDetails rmsUserMoneyDetails = new RmsUserMoneyDetails();
                    rmsUserMoneyDetails.setCreateTime(new Date());
                    rmsUserMoneyDetails.setUpdateTime(new Date());
                    rmsUserMoneyDetails.setDeleteFlag(Constants.DEL_FLAG_NO);
                    rmsUserMoneyDetails.setUserId(pubOrders.getSellUserId());
                    rmsUserMoneyDetails.setType(1);
                    rmsUserMoneyDetails.setAddMoney(pubOrders.getPayMoney());
                    rmsUserMoneyDetails.setTitle(pubOrders.getProductName());
                    rmsUserMoneyDetails.setDescription("已确认出行，费用转入商家账户！");
                    rmsUserMoneyDetails.setStatus(2);// 客户确认出行，不需要审核，直接汇款至商家
                    rmsUserMoneyDetails.setApprovalTime(new Date());
                    rmsUserMoneyDetails.setApprovalDescription("已确认出行，费用转入商家账户！");
                    rmsUserMoneyDetailsMapper.insert(rmsUserMoneyDetails);
                    res = "确认出行成功";
                } else {
                    res = "订单已进行过出行确认！";
                }
            } else {
                res = "订单未付款！";
            }
        } else {
            res = "订单不存在";
        }
        return res;
    }

    @Override
    public String cSaveAppraisal(CSaveAppraisalRequestDto param) {
        String res = "保存失败";
        PubPlan pubPlan = pubPlanMapper.selectByPrimaryKey(CommonUtils.parseLong(param.getPlanId()));
        if (pubPlan != null) {
            PubAppraisal pubAppraisal = new PubAppraisal();
            pubAppraisal.setPlanId(CommonUtils.parseLong(param.getPlanId()));
            pubAppraisal.setFromId(CommonUtils.parseLong(param.getFromId()));
            PubAppraisal appInfo = pubAppraisalMapper.selectByPlanIdAndFromId(pubAppraisal);
            if (appInfo != null) {
                res = "你已经进行过评价了！";
            } else {
                appInfo = new PubAppraisal();
                appInfo.setCreateTime(new Date());
                appInfo.setUpdateTime(new Date());
                appInfo.setDeleteFlag(Constants.DEL_FLAG_NO);
                appInfo.setFromId(CommonUtils.parseLong(param.getFromId()));
                appInfo.setToId(CommonUtils.parseLong(param.getToId()));
                appInfo.setContent(param.getContent());
                appInfo.setType(2);// 类型设置为方案被采纳
                appInfo.setPlanId(CommonUtils.parseLong(param.getPlanId()));
                appInfo.setDoneServiceLabelId(CommonUtils.parseLong(param.getDoneServiceLabelId()));
                appInfo.setDoneDescriptionLabelId(CommonUtils.parseLong(param.getDoneDescriptionLabelId()));
                appInfo.setStatus(1);// 状态默认设置为开启
                appInfo.setAppraisalResult(CommonUtils.parseInteger(param.getAppraisalResult()));
                pubAppraisalMapper.insert(appInfo);
                res = "保存评价信息成功！";
            }
        } else {
            res = "没有找到对应方案信息！";
        }
        return res;
    }

    @Override
    public int queryOrdersCount(RequestDto param) {
        return pubOrdersMapper.queryOrdersCount(param);
    }

    @Override
    public CAppraisalDetailResponseDto appraisalDetail(CAppraisalDetailRequestDto param) {
        CAppraisalDetailResponseDto res = new CAppraisalDetailResponseDto();
        PubOrders pubOrders = pubOrdersMapper.selectByPrimaryKey(CommonUtils.parseLong(param.getOrderId()));
        if (pubOrders != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            res.setCreateTime(sdf.format(pubOrders.getCreateTime()));
            res.setOrderId(pubOrders.getId().toString());
            res.setPayTime(sdf.format(pubOrders.getPayTime()));
            res.setProductName(pubOrders.getProductName());
            res.setTotalMoney(pubOrders.getTotalMoney() + "");
            if (pubOrders.getPubPlanId() != null) {
                PubPlan plan = pubPlanMapper.selectByPrimaryKey(pubOrders.getPubPlanId());
                if (plan != null) {
                    res.setPlanId(plan.getId().toString());
                    res.setFromId(param.getUid());
                    res.setToId(plan.getUserId().toString());
                    res.setResultMsg("执行成功");
                } else {
                    res.setResultMsg("方案信息不存在");
                }
            } else {
                res.setResultMsg("请求参数错误");
            }
        } else {
            res.setResultMsg("订单信息不存在");
        }
        return res;
    }

    @Override
    public PageList<BPubOrdersListDto> queryBOrderList(BPubOrdersListRequestDto param, PageBounds pageBounds) {
        // TODO Auto-generated method stub
        return pubOrdersMapper.queryBOrderList(param, pageBounds);
    }
    
    
    /**
     * 
     * B端订单详情
     */
    public void getOrdersDetailsForB(BPubOrdersDetailsRequestDto req,BPubOrdersDetailsResponseDto resp){
    	PubOrders orders = pubOrdersMapper.selectByPrimaryKey(CommonUtils.parseLong(req.getOrderId()));
    	if (orders != null){
    		//订单信息
    		resp.setOrderId(String.valueOf(orders.getId()));
    		resp.setOrderTitle(orders.getProductName());
    		resp.setPlanId(String.valueOf(orders.getPubPlanId()));
    		BPubOrdersListRequestDto param = new BPubOrdersListRequestDto();
    		//param.setUid(req.getUid());
    		param.setOrderId(orders.getId());
    		PageBounds pageBounds = new PageBounds();
    		pageBounds.setPage(1);
    		pageBounds.setLimit(1);
    		pageBounds.setContainsTotalCount(false);
    		PageList<BPubOrdersListDto> list = queryBOrderList(param, pageBounds);
    		if (CollectionUtils.isNotEmpty(list)){
    			BPubOrdersListDto listDto = list.get(0);
    			resp.setOrderStatus(listDto.getOrderResStatus());
    		}
    		if (orders.getPubPlanId()!=null){
    			PubPlan plan = pubPlanMapper.selectByPrimaryKey(orders.getPubPlanId());
    			if (plan!=null){
    				//成人、儿童
    				if (Constants.REQUIREMENT_TYPE_PERSONAL_VISIT.equals(plan.getRequirementType()) && plan.getRequirementId()!=null){
    					PubRequirementPersonalVisit rq = pubRequirementPersonalVisitMapper.selectByPrimaryKey(plan.getRequirementId());
    					resp.setPeopleCount(rq==null||rq.getPeopleCount()==null?"":rq.getPeopleCount().toString());
    					resp.setChildCount(rq==null||rq.getChildPeopleCount()==null?"":rq.getChildPeopleCount().toString());
    				}
    				if (Constants.REQUIREMENT_TYPE_GROUP_VISIT.equals(plan.getRequirementType()) && plan.getRequirementId()!=null){
    					PubRequirementGroupVisit rq = pubRequirementGroupVisitMapper.selectByPrimaryKey(plan.getRequirementId());
    					resp.setPeopleCount(rq==null||rq.getPeopleCount()==null?"":rq.getPeopleCount().toString());
    					resp.setChildCount(rq==null||rq.getChildPeopleCount()==null?"":rq.getChildPeopleCount().toString());
    				}
    				resp.setPeoplePrice(plan.getPrice()==null?"":plan.getPrice().toString());
    				resp.setChildPrice(plan.getChildPrice()==null?"":plan.getChildPrice().toString());
    				resp.setRequirementType(String.valueOf(plan.getRequirementType()));
    				resp.setRequirementId(String.valueOf(plan.getRequirementId()));
    				//需求来源
    				Integer source = pubRequirementMapper.getRequirementSouce(plan.getRequirementType(), plan.getRequirementId());
    	    		if (source==null){
    	    			resp.setSource("其他");
    	    		}else
    	    			if (source==1){
    	    				resp.setSource("微信");
    	    			}else 
    	    				if (source==2){
    	    					resp.setSource("APP");
    	    				}else 
        	    				if (source==3){
        	    					resp.setSource("其他");
        	    				}
    				
    			}
    		}
    		//购买者信息
    		resp.setBuyUserId(String.valueOf(orders.getBuyUserId()));
    		RmsUser user = rmsUserMapper.selectByPrimaryKey(orders.getBuyUserId());
    		if (user != null){
    			resp.setBuyUsername(user.getNickname());
    			resp.setBuyUserTel(user.getTel());
    			resp.setBuyUserIconUrl(resAttachmentService.getFullHttpUrl(user.getImageAttahcmentId()));
    		}
    		//消息组id
    		MsgGroup group = messageService.getMsgGroupByUser(CommonUtils.parseLong(resp.getUid()), CommonUtils.parseLong(resp.getBuyUserId()));
    		resp.setChatGroupId(String.valueOf(group==null?null:group.getId()));
    	}
    }

}
