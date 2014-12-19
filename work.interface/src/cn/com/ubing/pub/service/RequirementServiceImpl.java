package cn.com.ubing.pub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hlvtech.ubing.common.utils.CommonUtils;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.msg.model.MsgGroup;
import cn.com.ubing.msg.service.MessageServiceI;
import cn.com.ubing.pub.dao.GiveUpRequirementRequestDto;
import cn.com.ubing.pub.dao.PubAppraisalMapper;
import cn.com.ubing.pub.dao.PubPlanMapper;
import cn.com.ubing.pub.dao.PubRequirementCheckMapper;
import cn.com.ubing.pub.dao.PubRequirementGroupVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementHotelMapper;
import cn.com.ubing.pub.dao.PubRequirementPersonalVisitAddedMapper;
import cn.com.ubing.pub.dao.PubRequirementPersonalVisitMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryGroupVisitMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryPersonalVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementTicketMapper;
import cn.com.ubing.pub.dao.PubRequirementUserMapper;
import cn.com.ubing.pub.dto.GetRequirementInfoRequest;
import cn.com.ubing.pub.dto.GetRequirementInfoResponse;
import cn.com.ubing.pub.dto.GrabRequirementRequestDto;
import cn.com.ubing.pub.dto.GrabRequirementResponseDto;
import cn.com.ubing.pub.dto.HomePageInfoDto;
import cn.com.ubing.pub.dto.PubAppraisalDto;
import cn.com.ubing.pub.dto.PubRequirementGroupVisitDto;
import cn.com.ubing.pub.dto.PubRequirementHotelDto;
import cn.com.ubing.pub.dto.PubRequirementPersonVisitAddDto;
import cn.com.ubing.pub.dto.PubRequirementPersonalVisitDto;
import cn.com.ubing.pub.dto.PubRequirementTicketDto;
import cn.com.ubing.pub.dto.RequirementDetailRequestDto;
import cn.com.ubing.pub.dto.RequirementDetailResponseDto;
import cn.com.ubing.pub.dto.RequirementDto;
import cn.com.ubing.pub.dto.RequirementListRequest;
import cn.com.ubing.pub.model.PubPlan;
import cn.com.ubing.pub.model.PubPlanHistoryGroupVisit;
import cn.com.ubing.pub.model.PubPlanHistoryPersonalVisit;
import cn.com.ubing.pub.model.PubRequirementCheck;
import cn.com.ubing.pub.model.PubRequirementGroupVisit;
import cn.com.ubing.pub.model.PubRequirementPersonalVisit;
import cn.com.ubing.pub.model.PubRequirementUser;
import cn.com.ubing.res.dao.ResAttachmentMapper;
import cn.com.ubing.res.dao.ResDictMapper;
import cn.com.ubing.res.model.ResAttachment;
import cn.com.ubing.res.model.ResDict;
import cn.com.ubing.rms.dao.RmsUserMapper;
import cn.com.ubing.rms.dto.RmsUserRequestDto;
import cn.com.ubing.rms.model.RmsUser;

@Service("requirementService")
public class RequirementServiceImpl implements RequirementServiceI {
	@Autowired
	private PubRequirementUserMapper pubRequirementUserMapper;
	@Autowired
	private PubRequirementTicketMapper pubRequirementTicketMapper;
	@Autowired
	private PubRequirementHotelMapper pubRequirementHotelMapper;
	@Autowired
	private PubRequirementPersonalVisitMapper pubRequirementPersonalVisitMapper;
	@Autowired
	private PubRequirementGroupVisitMapper pubRequirementGroupVisitMapper;
	@Autowired
	private PubPlanMapper pubPlanMapper;
	@Autowired
	private PubAppraisalMapper pubAppraisalMapper;
	@Autowired
	private ResDictMapper resDictMapper;
	@Autowired
	private PubPlanHistoryPersonalVisitMapper PubPlanHistoryPersonalVisitMapper;
	@Autowired
	private PubPlanHistoryGroupVisitMapper PubPlanHistoryGroupVisitMapper;
	@Autowired
	private RmsUserMapper rmsUserMapper;
	@Autowired
	private ResAttachmentMapper resAttachmentMapper;
	@Autowired
	private PubRequirementCheckMapper pubRequirementCheckMapper;
	@Autowired
	private MessageServiceI messageService;
	
	@Autowired
	private PubRequirementPersonalVisitAddedMapper pubRequirementPersonalVisitAddedMapper;
	
    /**
     * 注入配置文件
     */
    @Value(value = "${hostAddr}")
    private String hostAddr;
	
	public HomePageInfoDto getHomePageInfoDto(RequestDto resDto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<RequirementDto> queryRequirementList(RequirementListRequest dto,PageBounds pageBounds) {
		// TODO Auto-generated method stub
	    List<RequirementDto> reList = pubRequirementUserMapper.queryRequirementList(dto,pageBounds);
	    List<RequirementDto> result = new ArrayList();
	    for(RequirementDto reDto:reList){
	        MsgGroup group = messageService.getMsgGroupByUser(CommonUtils.parseLong(dto.getUid()), CommonUtils.parseLong(reDto.getRequirementById()));
	        if(group!=null){
	            reDto.setGroupId(group.getId()+"");
	        }
	        result.add(reDto);
	    }
		return result;
	}

	@Override
	public RequirementDetailResponseDto getRequirementDetail(
			RequirementDetailRequestDto reqDto) {
	    //构造返回对象
        RequirementDetailResponseDto res = new RequirementDetailResponseDto();
	    Integer type = CommonUtils.parseInteger(reqDto.getRequirementType());
	    //查询审核信息
	    PubRequirementCheck param = new PubRequirementCheck();
	    param.setRequirementId(CommonUtils.parseLong(reqDto.getRequirementId()));
	    param.setRequirementType(CommonUtils.parseInteger(reqDto.getRequirementType()));
	    PubRequirementCheck checkInfo = pubRequirementCheckMapper.selectByIdAndType(param);
	    if(checkInfo!=null){
	        res.setBuchong(checkInfo.getUpdateRequirementContent());
	    }
	  //查需求
	    if(type==1){//机票
	    	PubRequirementTicketDto ticket = pubRequirementTicketMapper.queryRequirementTickById(CommonUtils.parseLong(reqDto.getRequirementId()));
	        if(ticket!=null){
    	        res.setBirthlandName(resDictMapper.selectByPrimaryKey(ticket.getBirthland()).getCname());
    	        res.setDestinationName(resDictMapper.selectByPrimaryKey(ticket.getDestination()).getCname());
    	        res.setDepartureTime(CommonUtils.parseDateToString(ticket.getDepartureTime()));
    	        res.setTripCount(ticket.getPeopleCount()+"");
    	        res.setReturnTime(CommonUtils.parseDateToString(ticket.getReturnTime()));
    	        res.setRemark(ticket.getDetail());
    	        res.setRequirementById(ticket.getUserId().toString());
    	        res.setStrDepartureTimeDay(ticket.getStrDepartureTimeDay());
    	        res.setTicketSpace(ticket.getStrTicketSpace());
    	        res.setContactsName(ticket.getContactsName());
    	        res.setContactsTel(ticket.getContactsTel());
    	        res.setCouponName(ticket.getCouponName());
    	        res.setCouponStatus(ticket.getCouponStatus());
	        }
	    }else if(type==2){//酒店
	    	PubRequirementHotelDto hotel = pubRequirementHotelMapper.queryRequirementHotelById(CommonUtils.parseLong(reqDto.getRequirementId()));
	        if(hotel!=null){
    	        res.setDestinationName(resDictMapper.selectByPrimaryKey(hotel.getDestination()).getCname());
    	        res.setDepartureTime(CommonUtils.parseDateToString(hotel.getDepartureTime()));
    	        res.setTripCount(hotel.getTripCount()+"");
    	        res.setHotelRooms(hotel.getHotelRooms()+"");
    	        res.setHotelPrice(resDictMapper.selectByPrimaryKey(hotel.getHotelPrice()).getCname());
    	        res.setHotelLevel(resDictMapper.selectByPrimaryKey(hotel.getHotelLevel()).getCname());
    	        res.setRemark(hotel.getDetail());
    	        res.setRequirementById(hotel.getUserId().toString());
    	        res.setContactsName(hotel.getContactsName());
    	        res.setContactsTel(hotel.getContactsTel());
    	        res.setCouponName(hotel.getCouponName());
    	        res.setCouponStatus(hotel.getCouponStatus());
	        }
	    }else if(type==3){//自由行
	    	PubRequirementPersonalVisitDto personalVisit = pubRequirementPersonalVisitMapper.queryRequirementPersonalVisitById(CommonUtils.parseLong(reqDto.getRequirementId()));
	        if(personalVisit!=null){
	            res.setRequirementTitle(personalVisit.getTitle());
	            RmsUser rmsUser = rmsUserMapper.selectByPrimaryKey(personalVisit.getUserId());
	            if(rmsUser!=null){
	                res.setRequirementById(rmsUser.getId().toString());
	                res.setRequirementByName(rmsUser.getNickname());
	                ResAttachment att = resAttachmentMapper.selectByPrimaryKey(rmsUser.getImageAttahcmentId());
	                if(att!=null){
	                    res.setRequirementByUrl(att.getSavePath());
	                }
	            }
	            ResDict birthlandDict = resDictMapper.selectByPrimaryKey(personalVisit.getBirthland());
	            if(birthlandDict!=null){
	                res.setBirthlandName(birthlandDict.getCname());
	            }
	            ResDict destinationDict = resDictMapper.selectByPrimaryKey(personalVisit.getDestination());
                if(destinationDict!=null){
                    res.setDestinationName(destinationDict.getCname());
                }
                
                //增值服务
                List<PubRequirementPersonVisitAddDto> addServicedList=pubRequirementPersonalVisitAddedMapper.findPersonVisitAddedByRequirementId(CommonUtils.parseLong(reqDto.getRequirementId()));
                for(int i=0;i<addServicedList.size();i++)
                {
                	addServicedList.get(i).setIcon(hostAddr+addServicedList.get(i).getIcon());
                }
                res.setAddServiceList(addServicedList);
                res.setDepartureTime(CommonUtils.parseDateToString(personalVisit.getDepartureTime()));
                res.setTripCount(personalVisit.getPeopleCount()+"");
                res.setDays(personalVisit.getTripCount()+"");
                res.setRemark(personalVisit.getDetail());
                
    	        res.setContactsName(personalVisit.getContactsName());
    	        res.setContactsTel(personalVisit.getContactsTel());
    	        res.setCouponName(personalVisit.getCouponName());
    	        res.setCouponStatus(personalVisit.getCouponStatus());
    	        res.setThemName(personalVisit.getThemName());
    	        res.setThemIcon(personalVisit.getThemIcon());
    	        res.setBudget(personalVisit.getBudget());
    	        res.setTransportationStr(personalVisit.getTransportationStr());
    	        res.setHotelLevel(personalVisit.getHotelLevelStr());
	        }
	    }else if(type==4){//跟团行
	    	PubRequirementGroupVisitDto groupVisit = pubRequirementGroupVisitMapper.queryRequirementGroupVisitById(CommonUtils.parseLong(reqDto.getRequirementId()));
	        if(groupVisit!=null){
	            res.setRequirementById(groupVisit.getUserId().toString());
	            res.setRequirementTitle(groupVisit.getTitle());
	            RmsUser rmsUser = rmsUserMapper.selectByPrimaryKey(groupVisit.getUserId());
                if(rmsUser!=null){
                    res.setRequirementByName(rmsUser.getNickname());
                    ResAttachment att = resAttachmentMapper.selectByPrimaryKey(rmsUser.getImageAttahcmentId());
                    if(att!=null){
                        res.setRequirementByUrl(att.getSavePath());
                    }
                }
    	        res.setBirthlandName(resDictMapper.selectByPrimaryKey(groupVisit.getBirthland()).getCname());
                res.setDestinationName(resDictMapper.selectByPrimaryKey(groupVisit.getDestination()).getCname());
                res.setDepartureTime(CommonUtils.parseDateToString(groupVisit.getDepartureTime()));
                //设置推送状态 
                res.setTripCount(groupVisit.getPeopleCount()+"");
                res.setDays(groupVisit.getTripCount()+"");
                res.setRemark(groupVisit.getDetail());
                res.setContactsName(groupVisit.getContactsName());
    	        res.setContactsTel(groupVisit.getContactsTel());
    	        res.setCouponName(groupVisit.getCouponName());
    	        res.setCouponStatus(groupVisit.getCouponStatus());
    	        res.setBudget(groupVisit.getBudget());
    	        //res.setTransportationStr(groupVisit.getTransportationStr());
    	        res.setHotelLevel(groupVisit.getHotelLevelStr());
                
                ResDict resDict = resDictMapper.selectByPrimaryKey(CommonUtils.parseLong(groupVisit.getA1()));
                if(resDict!=null){
                    res.setHotelLevel(resDict.getCname());
                }
	        }
	    }
	    //查方案
        PubPlan record = new PubPlan();
        record.setUserId(CommonUtils.parseLong(reqDto.getUid()));
        record.setRequirementId(CommonUtils.parseLong(reqDto.getRequirementId()));
        record.setRequirementType(CommonUtils.parseInteger(reqDto.getRequirementType()));
        PubPlan plan = pubPlanMapper.getByRequirementIdAndType(record);
        if(plan!=null){
            res.setPlanId(plan.getId()+"");
            res.setPlanTitle(plan.getTitle());
            res.setPlanPrice(plan.getPrice()+"");
            res.setPlanStartTime(CommonUtils.parseDateToString(plan.getStartTime()));
            res.setPlanEndTime(CommonUtils.parseDateToString(plan.getEndTime()));
            res.setPlanRemark(plan.getRemark());
            res.setPlanRelationId(plan.getHistoryPlanId()+"");
            if(plan.getPlanType()!=null){
                if(plan.getPlanType()==3){
                    PubPlanHistoryPersonalVisit a = PubPlanHistoryPersonalVisitMapper.selectByPrimaryKey(plan.getHistoryPlanId());
                    if(a!=null){
                        res.setPlanRelationTitle(a.getName());
                    }
                }else if(plan.getPlanType()==4){
                    PubPlanHistoryGroupVisit a = PubPlanHistoryGroupVisitMapper.selectByPrimaryKey(plan.getHistoryPlanId());
                    res.setPlanRelationTitle(a.getName());
                }
            }
        }
        //查评价
        if(plan!=null){
            PubAppraisalDto ad = new PubAppraisalDto();
            ad.setUid(CommonUtils.parseLong(reqDto.getUid()));
            ad.setPlanId(plan.getId());
            PubAppraisalDto appraisalDone = pubAppraisalMapper.appraisalDone(ad);
            PubAppraisalDto appraisalReject = pubAppraisalMapper.appraisalReject(ad);
            PubAppraisalDto appraisalResponse = pubAppraisalMapper.appraisalResponse(ad);
            if(appraisalDone!=null){
                res.setAppraisalName(appraisalDone.getAppraisalName());
                res.setAppraisalTime(CommonUtils.parseDateToString(appraisalDone.getCreateTime()));
                res.setAppraisalDescription(appraisalDone.getDoneDescriptionLabelId()+"");
                res.setAppraisalService(appraisalDone.getDoneServiceLabelId()+"");
                res.setAppraisalResult(appraisalDone.getAppraisalResult()+"");
                res.setAppraisalContent(appraisalDone.getContent());
            }
            if(appraisalResponse!=null){
                res.setAppraisalResponseContent(appraisalResponse.getContent());
                res.setAppraisalResponseTime(CommonUtils.parseDateToString(appraisalResponse.getCreateTime()));
            }
            if(appraisalReject!=null){
                res.setAppraisalRejectBy(appraisalReject.getAppraisalName());
                if(appraisalReject.getLabelName()!=null){
                    res.setAppraisalRejectContent(appraisalReject.getLabelName());
                }else{
                    res.setAppraisalRejectContent(appraisalReject.getRejectContent());
                }                
                res.setAppraisalRejectTime(CommonUtils.parseDateToString(appraisalReject.getCreateTime()));
            }
        }
        MsgGroup group = messageService.getMsgGroupByUser(CommonUtils.parseLong(reqDto.getUid()), CommonUtils.parseLong(res.getRequirementById()));
        if(group!=null)
        res.setGroupId(group.getId()+"");
        return res;
	}

	@Override
	public int countRequirement(RmsUserRequestDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}


    @Override
    public GrabRequirementResponseDto grapRequirement(GrabRequirementRequestDto dto) {
        // TODO Auto-generated method stub
        if(pubRequirementUserMapper.checkGrapRequirement(dto)==0){
            return null;
        }else{
            PubRequirementUser mo = new PubRequirementUser();
            PubRequirementUser mo1 = new PubRequirementUser();
            GrabRequirementResponseDto res = new GrabRequirementResponseDto();
            mo.setRequirementId(dto.getRequirementId());
            mo.setRequirementType(dto.getRequirementType());
            mo.setUserId(CommonUtils.parseLong(dto.getUid()));
            mo1 = pubRequirementUserMapper.selectByIdAndTypeAndUser(mo);
            mo1.setStatus(1);//将状态设置抢单成功
            mo1.setGrapTime(new Date());//抢单时间
            mo1.setReadStatus(1);//阅读状态设置为已阅读
            mo1.setReadTime(new Date());//阅读时间
            System.out.println(pubRequirementUserMapper.updateByPrimaryKey(mo1));
            if(mo.getRequirementType()==3){
                PubRequirementPersonalVisit p = pubRequirementPersonalVisitMapper.selectByPrimaryKey(mo.getRequirementId());
                if(p!=null){
                    res.setRequirementBy(rmsUserMapper.selectByPrimaryKey(p.getUserId()).getUsername());
                    res.setResult("1");//失败0 成功1
                    res.setRequirementId(p.getId()+"");
                    res.setRequirementType("3");
                    res.setRequirementTitle(p.getTitle());
                    res.setRequirementDetail(p.getDetail());
                }
            }else if(mo.getRequirementType()==4){
                PubRequirementGroupVisit g = pubRequirementGroupVisitMapper.selectByPrimaryKey(mo.getRequirementId());
                if(g!=null){
                    res.setRequirementBy(rmsUserMapper.selectByPrimaryKey(g.getUserId()).getUsername());
                    res.setResult("1");//失败0 成功1
                    res.setRequirementId(g.getId()+"");
                    res.setRequirementType("4");
                    res.setRequirementTitle(g.getTitle());
                    res.setRequirementDetail(g.getDetail());
                }
            }
            return res;
        }
    }


    @Override
    public int giveUpRequirement(GiveUpRequirementRequestDto dto) {
        // TODO Auto-generated method stub
        PubRequirementUser mo = new PubRequirementUser();
        mo.setRequirementId(dto.getRequirementId());
        mo.setRequirementType(dto.getRequirementType());
        mo.setUserId(CommonUtils.parseLong(dto.getUid()));
        mo = pubRequirementUserMapper.selectByIdAndTypeAndUser(mo);
        mo.setStatus(3);//将状态设置为已放弃
        return pubRequirementUserMapper.updateByPrimaryKey(mo);
    }


    @Override
    public GetRequirementInfoResponse getRequirementInfo(GetRequirementInfoRequest dto) {
        // TODO Auto-generated method stub
        GetRequirementInfoResponse res = null;
        if(dto!=null){
            if("1".equals(dto.getRequirementType())){
                res = pubRequirementUserMapper.getTicketRequirementInfo(dto);
            }else if("2".equals(dto.getRequirementType())){
                res = pubRequirementUserMapper.getHotelRequirementInfo(dto);
            }else if("3".equals(dto.getRequirementType())){
                res = pubRequirementUserMapper.getPersonalRequirementInfo(dto);
            }else if("4".equals(dto.getRequirementType())){
                res = pubRequirementUserMapper.getGroupRequirementInfo(dto);
            }
        }
        return res;
    }
}
