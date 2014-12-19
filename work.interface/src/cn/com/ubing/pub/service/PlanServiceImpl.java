package cn.com.ubing.pub.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.ubing.common.utils.DateHelper;
import cn.com.ubing.msg.service.MessageServiceI;
import cn.com.ubing.pub.dao.PubPlanHistoryGroupVisitDestinationMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryGroupVisitMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryHotelMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryHotelServiceMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryPersonalVisitDestinationMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryPersonalVisitMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryPersonalVisitServiceMapper;
import cn.com.ubing.pub.dao.PubPlanHistoryTicketMapper;
import cn.com.ubing.pub.dao.PubPlanLibraryMapper;
import cn.com.ubing.pub.dao.PubPlanMapper;
import cn.com.ubing.pub.dao.PubRequirementGroupVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementHotelMapper;
import cn.com.ubing.pub.dao.PubRequirementPersonalVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementTicketMapper;
import cn.com.ubing.pub.dto.CHistoryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.CPlanHistoryHotelDto;
import cn.com.ubing.pub.dto.CPubPlanHistoryDto;
import cn.com.ubing.pub.dto.CPubPlanHistoryGroupVisitDto;
import cn.com.ubing.pub.dto.CPubPlanHistoryPersonalVisitDto;
import cn.com.ubing.pub.dto.CPubPlanHistoryTicketDto;
import cn.com.ubing.pub.dto.CUpdatePubPlanRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.HistoryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.HistoryPlanListDto;
import cn.com.ubing.pub.dto.HistoryPlanListRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.LibraryPlanListDto;
import cn.com.ubing.pub.dto.LibraryPlanListRequestDto;
import cn.com.ubing.pub.dto.PubPlanHistoryDto;
import cn.com.ubing.pub.dto.PubPlanHistoryGroupVisitDestinationDto;
import cn.com.ubing.pub.dto.PubPlanHistoryGroupVisitDto;
import cn.com.ubing.pub.dto.PubPlanHistoryPersonalVisitDestinationDto;
import cn.com.ubing.pub.dto.PubPlanHistoryPersonalVisitDto;
import cn.com.ubing.pub.dto.PubPlanHistoryPersonalVisitServiceDto;
import cn.com.ubing.pub.dto.PubPlanLibraryGroupVisitDto;
import cn.com.ubing.pub.dto.PubPlanLibraryPersonalVisitDto;
import cn.com.ubing.pub.dto.SavePlanRequestDto;
import cn.com.ubing.pub.dto.SavePlanResponseDto;
import cn.com.ubing.pub.model.PubPlan;
import cn.com.ubing.pub.model.PubPlanHistoryGroupVisit;
import cn.com.ubing.pub.model.PubPlanHistoryGroupVisitDestination;
import cn.com.ubing.pub.model.PubPlanHistoryPersonalVisit;
import cn.com.ubing.pub.model.PubPlanHistoryPersonalVisitDestination;
import cn.com.ubing.pub.model.PubPlanHistoryPersonalVisitService;
import cn.com.ubing.pub.model.PubRequirementGroupVisit;
import cn.com.ubing.pub.model.PubRequirementHotel;
import cn.com.ubing.pub.model.PubRequirementPersonalVisit;
import cn.com.ubing.pub.model.PubRequirementTicket;
import cn.com.ubing.pub.util.PubPlanUtils;
import cn.com.ubing.res.dao.ResAttachmentMapper;
import cn.com.ubing.res.dao.ResPlanLibraryGroupVisitDestinationMapper;
import cn.com.ubing.res.dao.ResPlanLibraryGroupVisitMapper;
import cn.com.ubing.res.dao.ResPlanLibraryPersonalVisitDestinationMapper;
import cn.com.ubing.res.dao.ResPlanLibraryPersonalVisitMapper;
import cn.com.ubing.res.dao.ResPlanLibraryPersonalVisitServiceMapper;
import cn.com.ubing.res.model.ResAttachment;
import cn.com.ubing.rms.dao.RmsUserMapper;
import cn.com.ubing.rms.model.RmsUser;
import cn.com.ubing.weixin.bean.resBean.Article;
import cn.com.ubing.weixin.service.WexinInterfaceCallServiceI;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

@Service("planService")
public class PlanServiceImpl implements PlanServiceI {
    @Autowired
    private PubPlanMapper pubPlanMapper;
    @Autowired
    private PubPlanLibraryMapper pubPlanLibraryMapper;
    @Autowired
    private PubPlanHistoryGroupVisitMapper pubPlanHistoryGroupVisitMapper;
    @Autowired
    private PubPlanHistoryPersonalVisitMapper pubPlanHistoryPersonalVisitMapper;
    @Autowired
    private ResPlanLibraryGroupVisitMapper resPlanLibraryGroupVisitMapper;
    @Autowired
    private ResPlanLibraryPersonalVisitMapper resPlanLibraryPersonalVisitMapper;
    @Autowired
    private PubPlanHistoryGroupVisitDestinationMapper pubPlanHistoryGroupVisitDestinationMapper;
    @Autowired
    private PubPlanHistoryPersonalVisitDestinationMapper pubPlanHistoryPersonalVisitDestinationMapper;
    @Autowired
    private PubPlanHistoryPersonalVisitServiceMapper pubPlanHistoryPersonalVisitServiceMapper;
    @Autowired
    private ResPlanLibraryGroupVisitDestinationMapper resPlanLibraryGroupVisitDestinationMapper;
    @Autowired
    private ResPlanLibraryPersonalVisitDestinationMapper resPlanLibraryPersonalVisitDestinationMapper;
    @Autowired
    private ResPlanLibraryPersonalVisitServiceMapper resPlanLibraryPersonalVisitServiceMapper;
    @Autowired
    private RmsUserMapper rmsUserMapper;
    @Autowired
    private PubRequirementTicketMapper pubRequirementTicketMapper;
    @Autowired
    private PubRequirementHotelMapper pubRequirementHotelMapper;
    @Autowired
    private PubRequirementGroupVisitMapper pubRequirementGroupVisitMapper;
    @Autowired
    private PubRequirementPersonalVisitMapper pubRequirementPersonalVisitMapper;
    @Autowired
    private WexinInterfaceCallServiceI wexinInterfaceCallService;
    
    @Autowired
    private PubPlanHistoryTicketMapper pubPlanHistoryTicketMapper;
    
    @Autowired
    private PubPlanHistoryHotelMapper pubPlanHistoryHotelMapper;
    
    @Autowired
    private PubPlanHistoryHotelServiceMapper pubPlanHistoryHotelServiceMapper;
    
    @Autowired
    private ResAttachmentMapper resAttachmentMapper;
    
	/**
	 * 消息service
	 */
	@Autowired
	private MessageServiceI messageService;
	
    /**
     * 注入配置文件
     */
    @Value(value = "${appId}")
    private String appId;

    /**
     * 注入配置文件
     */
    @Value(value = "${weixinRedirectUrl}")
    private String weixinRedirectUrl;
    
	@Value(value = "${imageAttachmentHostAddr}")
	private String imageAttachmentHostAddr;

    @Override
    public HistoryPlanDetailResponseDto getHistoryPlanDetail(HistoryPlanDetailRequestDto dto) {
        // TODO Auto-generated method stub
        HistoryPlanDetailResponseDto res = new HistoryPlanDetailResponseDto();
        res.setRequirementId(dto.getRequirementId());
        PubPlan plan = pubPlanMapper.selectByPrimaryKey(CommonUtils.parseLong(dto.getPlanId()));
        PubPlanHistoryDto p = new PubPlanHistoryDto();
        if (plan != null) {
            p.setPrice(plan.getPrice() + "");
            p.setRemark(plan.getRemark());
            p.setTitle(plan.getTitle());
            p.setChildPrice(plan.getChildPrice()+"");
            p.setPoint(plan.getPoint());
            res.setPubPlan(p);
            res.setType(plan.getPlanType() + "");
            if(plan.getPlanType()!=null){
                if(plan.getPlanType()==1){// 机票
                	
                }
                else if (plan.getPlanType()==2) {//酒店
    
                } 
                else if (plan.getPlanType()==3) {// 自由行
                    PubPlanHistoryPersonalVisitDto pubPlanHistoryPersonalVisitDto = pubPlanHistoryPersonalVisitMapper.selectDetail(plan.getHistoryPlanId());
                    if(pubPlanHistoryPersonalVisitDto!=null){
                        pubPlanHistoryPersonalVisitDto.setServiceList(pubPlanHistoryPersonalVisitServiceMapper.selectDto(CommonUtils.parseLong(pubPlanHistoryPersonalVisitDto.getId())));
                        pubPlanHistoryPersonalVisitDto.setDestinationList(pubPlanHistoryPersonalVisitDestinationMapper.selectDto(CommonUtils.parseLong(pubPlanHistoryPersonalVisitDto.getId())));
                    }
                    res.setPubPlanHistoryPersonalVisitDto(pubPlanHistoryPersonalVisitDto);
                }                 
                 else if (plan.getPlanType()==4) {// 跟团行
                    PubPlanHistoryGroupVisitDto pubPlanHistoryGroupVisitDto = pubPlanHistoryGroupVisitMapper.selectDetail(plan.getHistoryPlanId());
                    if(pubPlanHistoryGroupVisitDto!=null){
                        pubPlanHistoryGroupVisitDto.setDestinationList(pubPlanHistoryGroupVisitDestinationMapper.selectDto(CommonUtils.parseLong(pubPlanHistoryGroupVisitDto.getId())));
                    }
                    res.setPubPlanHistoryGroupVisitDto(pubPlanHistoryGroupVisitDto);
                }
            }
        }
        return res;
    }

    @Override
    public LibraryPlanDetailResponseDto getLibraryPlanDetail(LibraryPlanDetailRequestDto dto) {
        LibraryPlanDetailResponseDto res = new LibraryPlanDetailResponseDto();
        if ("4".equals(dto.getType())) {
            res.setType("4");
            PubPlanLibraryGroupVisitDto pubPlanLibraryGroupVisitDto = resPlanLibraryGroupVisitMapper.selectDetail(CommonUtils.parseLong(dto.getId()));
            if(pubPlanLibraryGroupVisitDto!=null){
                pubPlanLibraryGroupVisitDto.setDestinationList(resPlanLibraryGroupVisitDestinationMapper.selectDto(CommonUtils.parseLong(pubPlanLibraryGroupVisitDto.getId())));
            }
            res.setPubPlanLibraryGroupVisitDto(pubPlanLibraryGroupVisitDto);
        } else if ("3".equals(dto.getType())) {
            res.setType("3");
            PubPlanLibraryPersonalVisitDto pubPlanLibraryPersonalVisitDto = resPlanLibraryPersonalVisitMapper.selectDetail(CommonUtils.parseLong(dto.getId()));
            if(pubPlanLibraryPersonalVisitDto!=null){
                pubPlanLibraryPersonalVisitDto.setDestinationList(resPlanLibraryPersonalVisitDestinationMapper.selectDto(CommonUtils.parseLong(pubPlanLibraryPersonalVisitDto.getId())));
                pubPlanLibraryPersonalVisitDto.setServiceList(resPlanLibraryPersonalVisitServiceMapper.selectDto(CommonUtils.parseLong(pubPlanLibraryPersonalVisitDto.getId())));
            }
            res.setPubPlanLibraryPersonalVisitDto(pubPlanLibraryPersonalVisitDto);
        }
        res.setRequirementId(dto.getRequirementId());
        // TODO Auto-generated method stub
        return res;
    }

    @Override
    public List<LibraryPlanListDto> queryLibraryPlanList(LibraryPlanListRequestDto dto,PageBounds pageBounds) {
        // TODO Auto-generated method stub
        return pubPlanLibraryMapper.queryLibraryPlanList(dto,pageBounds);
    }

    @Override
    public List<HistoryPlanListDto> queryHistoryPlanList(HistoryPlanListRequestDto dto,PageBounds pageBounds) {
        // TODO Auto-generated method stub
        return pubPlanMapper.HistoryPlanList(dto,pageBounds);
    }

    @Override
    public SavePlanResponseDto savePlan(SavePlanRequestDto dto) {
        // TODO Auto-generated method stub
        if ("1".equals(dto.getPlanType())) {
            // 保存机票
        } else if ("2".equals(dto.getPlanType())) {
            // 保存酒店
        } else if ("3".equals(dto.getPlanType())&&dto.getPubPlanHistoryPersonalVisitDto()!=null) {
            // 保存自由行
            PubPlanHistoryPersonalVisitDto pdto = dto.getPubPlanHistoryPersonalVisitDto();
            if(!"".equals(pdto.getName())){
                PubPlanHistoryPersonalVisit p = new PubPlanHistoryPersonalVisit();
                //封装对象。。。
                p.setCreateTime(new Date());
                p.setUpdateTime(new Date());
                p.setDeleteFlag(Constants.DEL_FLAG_NO);
                p.setDays(pdto.getDays());
                p.setFeeRemark(pdto.getFeeRemark());
                p.setIntroduction(pdto.getIntroduction());
                p.setLeaveLocation(CommonUtils.parseLong(pdto.getLeaveLocationId()));
                p.setName(pdto.getName());
                p.setNights(pdto.getNights());
                p.setRemark(pdto.getRemark());
                p.setTrafficLeave(CommonUtils.parseLong(pdto.getTrafficLeaveId()));
                p.setTrafficReach(CommonUtils.parseLong(pdto.getTrafficReachId()));
                p.setType(CommonUtils.parseInteger(pdto.getType()));
                p.setUserId(CommonUtils.parseLong(dto.getUid()));
                p.setImageId(CommonUtils.parseLong(pdto.getImageId()));
                pubPlanHistoryPersonalVisitMapper.insert(p);
                //目的地。。。服务...信息保存
                List<PubPlanHistoryPersonalVisitServiceDto> serviceList =  pdto.getServiceList();
                if(serviceList!=null){
                    for(PubPlanHistoryPersonalVisitServiceDto service:serviceList){
                        PubPlanHistoryPersonalVisitService serviceModel = new PubPlanHistoryPersonalVisitService();
                        serviceModel.setCreateTime(new Date());
                        serviceModel.setDeleteFlag(Constants.DEL_FLAG_NO);
                        serviceModel.setPersonalVisitId(p.getId());
                        serviceModel.setServiceId(CommonUtils.parseLong(service.getServiceId()));
                        serviceModel.setUpdateTime(new Date());
                        pubPlanHistoryPersonalVisitServiceMapper.insert(serviceModel);
                    }
                }
                List<PubPlanHistoryPersonalVisitDestinationDto> destinationList = pdto.getDestinationList();
                if(destinationList!=null){
                    for(PubPlanHistoryPersonalVisitDestinationDto destinationDto:destinationList){
                        PubPlanHistoryPersonalVisitDestination dModel = new PubPlanHistoryPersonalVisitDestination();
                        dModel.setCreateTime(new Date());
                        dModel.setDeleteFlag(Constants.DEL_FLAG_NO);
                        dModel.setDestinationId(CommonUtils.parseLong(destinationDto.getDestinationId()));
                        dModel.setPersonalVisitId(p.getId());
                        dModel.setUpdateTime(new Date());
                        pubPlanHistoryPersonalVisitDestinationMapper.insert(dModel);
                    }
                }
                savePubPlan(dto,3,p.getId()); 
            }
            savePubPlan(dto,null,null);            
        } else if ("4".equals(dto.getPlanType())&&dto.getPubPlanHistoryGroupVisitDto()!=null) {
            // 保存跟团行
            PubPlanHistoryGroupVisitDto gdto=dto.getPubPlanHistoryGroupVisitDto();
            if(!"".equals(gdto.getName())){
                PubPlanHistoryGroupVisit g = new PubPlanHistoryGroupVisit();
                //封装对象。。。
                g.setCreateTime(new Date());
                g.setUpdateTime(new Date());
                g.setDeleteFlag(Constants.DEL_FLAG_NO);
                g.setDays(gdto.getDays());
                g.setFeeRemark(gdto.getFeeRemark());
                g.setImageId(CommonUtils.parseLong(gdto.getImageId()));
                g.setIntroduction(gdto.getIntroduction());
                g.setLeaveLocation(CommonUtils.parseLong(gdto.getLeaveLocationId()));
                g.setName(gdto.getName());
                g.setNights(gdto.getNights());
                g.setRemark(gdto.getRemark());
                g.setTrafficLeave(CommonUtils.parseLong(gdto.getTrafficLeaveId()));
                g.setTrafficReach(CommonUtils.parseLong(gdto.getTrafficReachId()));
                g.setType(CommonUtils.parseInteger(gdto.getType()));
                g.setUserId(CommonUtils.parseLong(dto.getUid()));
                //目的地。。。
                pubPlanHistoryGroupVisitMapper.insert(g);
                List<PubPlanHistoryGroupVisitDestinationDto> dList = gdto.getDestinationList();
                if(dList!=null){
                    for(PubPlanHistoryGroupVisitDestinationDto dDto:dList){
                        PubPlanHistoryGroupVisitDestination mo = new PubPlanHistoryGroupVisitDestination();
                        mo.setCreateTime(new Date());
                        mo.setDeleteFlag(Constants.DEL_FLAG_NO);
                        mo.setDestinationId(CommonUtils.parseLong(dDto.getDestinationId()));
                        mo.setGroupVisitId(g.getId());
                        mo.setUpdateTime(new Date());
                        pubPlanHistoryGroupVisitDestinationMapper.insert(mo);
                    }
                }
                savePubPlan(dto,4,g.getId());
            }
            savePubPlan(dto,null,null);
        }else{
            savePubPlan(dto,null,null);
        }
        
      //发送微信消息到需求提交人
        String openId = "";
        Long toId = null;
        if ("1".equals(dto.getRequirementType())){
            PubRequirementTicket rt = pubRequirementTicketMapper.selectByPrimaryKey(CommonUtils.parseLong(dto.getRequirementId()));
            if (rt != null && rt.getUserId()!=null){
            RmsUser rtUser = rmsUserMapper.selectByPrimaryKey(rt.getUserId());
            if (rtUser != null){
                openId = rtUser.getWeixinOpenId(); 
                toId=rtUser.getId();
            }
            }
        }
        if ("2".equals(dto.getRequirementType())){
            PubRequirementHotel rt = pubRequirementHotelMapper.selectByPrimaryKey(CommonUtils.parseLong(dto.getRequirementId()));
            if (rt != null && rt.getUserId()!=null){
            RmsUser rtUser = rmsUserMapper.selectByPrimaryKey(rt.getUserId());
            if (rtUser != null){
                openId = rtUser.getWeixinOpenId(); 
                toId=rtUser.getId();
            }
            }
        }
        if ("4".equals(dto.getRequirementType())){
            PubRequirementGroupVisit rt = pubRequirementGroupVisitMapper.selectByPrimaryKey(CommonUtils.parseLong(dto.getRequirementId()));
            if (rt != null && rt.getUserId()!=null){
            RmsUser rtUser = rmsUserMapper.selectByPrimaryKey(rt.getUserId());
            if (rtUser != null){
                openId = rtUser.getWeixinOpenId(); 
                toId=rtUser.getId();
            }
            }
        }
        if ("3".equals(dto.getRequirementType())){
            PubRequirementPersonalVisit rt = pubRequirementPersonalVisitMapper.selectByPrimaryKey(CommonUtils.parseLong(dto.getRequirementId()));
            if (rt != null && rt.getUserId()!=null){
            RmsUser rtUser = rmsUserMapper.selectByPrimaryKey(rt.getUserId());
            if (rtUser != null){
                //openId = rtUser.getWeixinOpenId(); 
                toId=rtUser.getId();
            }
            }
        }
        if (StringUtils.isNotBlank(openId)){
            List<Article> atList = new ArrayList<Article>();
            Article at = new Article();
            at.setTitle(dto.getPubPlan().getTitle());
            at.setDescription(dto.getPubPlan().getPoint());
            at.setUrl(PubPlanUtils.getWeixinViewRequirementUrl(appId, weixinRedirectUrl,CommonUtils.parseInteger(dto
                .getRequirementType()), CommonUtils.parseLong(dto.getRequirementId())));
            atList.add(at);
            wexinInterfaceCallService.sendImageTextMessage(openId, atList);

        }
        //发送消息给c端
		Long fromId = CommonUtils.parseLong(dto.getUid());
		
		messageService.sendMessage(
				CommonUtils.parseInteger("4"), fromId,toId, dto.getRequirementId()+"|"+dto.getRequirementType());
        
        return null;
    }
    public int savePubPlan(SavePlanRequestDto dto,Integer planType,Long planId){
        if(dto.getPubPlan()!=null&&dto.getRequirementId()!=null){
            PubPlan plan = new PubPlan();
            plan.setCreateTime(new Date());
            plan.setUpdateTime(new Date());
            plan.setDeleteFlag(Constants.DEL_FLAG_NO);
            plan.setUserId(CommonUtils.parseLong(dto.getUid()));
            plan.setRequirementType(CommonUtils.parseInteger(dto.getRequirementType()));
            plan.setRequirementId(CommonUtils.parseLong(dto.getRequirementId()));
            plan.setTitle(dto.getPubPlan().getTitle());
            if(dto.getPubPlan().getPrice()!=null){
                plan.setPrice(Double.valueOf(dto.getPubPlan().getPrice()));
            }
            if(dto.getPubPlan().getChildPrice()!=null){
                plan.setChildPrice(Double.valueOf(dto.getPubPlan().getChildPrice()));
            }
            plan.setStartTime(CommonUtils.parseDate(dto.getPubPlan().getStartTime()));
            plan.setEndTime(CommonUtils.parseDate(dto.getPubPlan().getEndTime()));
            plan.setPoint(dto.getPubPlan().getPoint());
            plan.setRemark(dto.getPubPlan().getRemark());
            plan.setStatus(1);//默认为等待中标状态
            plan.setReadStatus(0);//默认为未阅读状态'
            plan.setHistoryPlanId(planId);
            plan.setPlanType(planType);
            return pubPlanMapper.insert(plan);
        }else{
            return 0;
        }
    }
    
    
	/**
	 * (B端)根据需求类型和需求id查询关联的优惠券字符串
	 * 
	 */
	@Override
	public String getCouponStr(Integer requirementType,Long requirementId){
	    return pubPlanMapper.getCouponStr(requirementType, requirementId);
	}

	@Override
	public CHistoryPlanDetailResponseDto getHistoryCPlanDetail(
			HistoryPlanDetailRequestDto dto) {
		 // TODO Auto-generated method stub
		CHistoryPlanDetailResponseDto res = new CHistoryPlanDetailResponseDto();
        res.setRequirementId(dto.getRequirementId());
        PubPlan plan = pubPlanMapper.selectByPrimaryKey(CommonUtils.parseLong(dto.getPlanId()));
        RmsUser rmsUser=rmsUserMapper.selectByPrimaryKey(plan.getUserId());
        CPubPlanHistoryDto p = new CPubPlanHistoryDto();
        if (plan != null) {
            p.setPrice(plan.getPrice() + "");
            p.setRemark(plan.getRemark());
            p.setTitle(plan.getTitle());
            p.setChildPrice(plan.getChildPrice()+"");
            p.setPoint(plan.getPoint());
            p.setStartTime(DateHelper.formatDateTimeForFileName1(plan.getStartTime()));
            p.setEndTime(DateHelper.formatDateTimeForFileName1(plan.getEndTime()));
            p.setCreateTime(DateHelper.formatDateTimeForFileName1(plan.getCreateTime()));
            p.setUserName(rmsUser.getUsername());
            p.setUserTel(rmsUser.getTel());
            p.setStatus(plan.getStatus().toString());
            res.setPubPlan(p);
            res.setType(plan.getPlanType() + "");
            if(plan.getPlanType()!=null){
                if(plan.getPlanType()==1){// 机票
                	CPubPlanHistoryTicketDto cPubPlanHistoryTicketDto=pubPlanHistoryTicketMapper.selectDetail(plan.getHistoryPlanId());
                	res.setcPubPlanHistoryTicketDto(cPubPlanHistoryTicketDto);
                }
                else if (plan.getPlanType()==2) {//酒店
                	CPlanHistoryHotelDto cPlanHistoryHotelDto=pubPlanHistoryHotelMapper.selectDetail(plan.getHistoryPlanId());
                	if(cPlanHistoryHotelDto!=null)
                	{
                		cPlanHistoryHotelDto.setServiceList(pubPlanHistoryHotelServiceMapper.listServiceInfoByHistoryId(CommonUtils.parseLong(cPlanHistoryHotelDto.getId())));
                		
                	}
                	ResAttachment rat=new ResAttachment();
                	rat.setRelId(plan.getId());
                	rat.setRelType(13);
                	List<ResAttachment> r=resAttachmentMapper.selectByRel(rat);
                	cPlanHistoryHotelDto.setAttachmentList(r);
                	res.setcPlanHistoryHotelDto(cPlanHistoryHotelDto);
    
                } 
                else if (plan.getPlanType()==3) {// 自由行
                    CPubPlanHistoryPersonalVisitDto pubPlanHistoryPersonalVisitDto = pubPlanHistoryPersonalVisitMapper.selectCPubPlanDetail(plan.getHistoryPlanId());
                    if(pubPlanHistoryPersonalVisitDto!=null){
                        pubPlanHistoryPersonalVisitDto.setServiceList(pubPlanHistoryPersonalVisitServiceMapper.selectDto(CommonUtils.parseLong(pubPlanHistoryPersonalVisitDto.getId())));
                        pubPlanHistoryPersonalVisitDto.setDestinationList(pubPlanHistoryPersonalVisitDestinationMapper.selectDto(CommonUtils.parseLong(pubPlanHistoryPersonalVisitDto.getId())));
                    }
                  	ResAttachment rat=new ResAttachment();
                	rat.setRelId(plan.getId());
                	rat.setRelType(13);
                	List<ResAttachment> r=resAttachmentMapper.selectByRel(rat);
                    for(int i=0;i<r.size();i++)
                    {
                    	r.get(i).setSavePath(imageAttachmentHostAddr+"//"+r.get(i).getSavePath());
                    }
                	pubPlanHistoryPersonalVisitDto.setAttachmentList(r);
                    res.setPubPlanHistoryPersonalVisitDto(pubPlanHistoryPersonalVisitDto);
                }                 
                 else if (plan.getPlanType()==4) {// 跟团行
                    CPubPlanHistoryGroupVisitDto pubPlanHistoryGroupVisitDto = pubPlanHistoryGroupVisitMapper.selectCPubPlanDetail(plan.getHistoryPlanId());
                    if(pubPlanHistoryGroupVisitDto!=null){
                        pubPlanHistoryGroupVisitDto.setDestinationList(pubPlanHistoryGroupVisitDestinationMapper.selectDto(CommonUtils.parseLong(pubPlanHistoryGroupVisitDto.getId())));
                    }
                  	ResAttachment rat=new ResAttachment();
                	rat.setRelId(plan.getId());
                	rat.setRelType(13);
                	List<ResAttachment> r=resAttachmentMapper.selectByRel(rat);
                    for(int i=0;i<r.size();i++)
                    {
                    	r.get(i).setSavePath(imageAttachmentHostAddr+"//"+r.get(i).getSavePath());
                    }
                	pubPlanHistoryGroupVisitDto.setAttachmentList(r);
                    res.setPubPlanHistoryGroupVisitDto(pubPlanHistoryGroupVisitDto);
 
                 }
                //快速报方案无出发地和目的地
            }
            //else{
//                if(plan.getRequirementType()==1){// 机票
//                	CRequirementDetailRequestDto param=new CRequirementDetailRequestDto();
//                	param.setRequirementId(plan.getRequirementId().toString());
//                	CRequirementTicketDetailResponseDto cRequirementTicketDetailResponseDto=pubRequirementTicketMapper.queryRequirementTickDetailById(param);
//                	CPubPlanHistoryTicketDto cPubPlanHistoryTicketDto=new CPubPlanHistoryTicketDto();
////                	cPubPlanHistoryTicketDto.setGoLeaveLocationStr(cRequirementTicketDetailResponseDto.getBirthlandName());
////                	cPubPlanHistoryTicketDto.setGoReachLocationStr(cRequirementTicketDetailResponseDto.getDestinationName());
//                	res.setcPubPlanHistoryTicketDto(cPubPlanHistoryTicketDto);
//                }
//                else if (plan.getRequirementType()==2) {//酒店
//                	CRequirementDetailRequestDto param=new CRequirementDetailRequestDto();
//                	CRequirementHotelDetailResponseDto cRequirementHotelDetailResponseDto=pubRequirementHotelMapper.queryRequirementHotelDetailById(param);
//                	CPlanHistoryHotelDto cPlanHistoryHotelDto=new CPlanHistoryHotelDto();
//                	res.setcPlanHistoryHotelDto(cPlanHistoryHotelDto);
//                	
//                } 
//                else if (plan.getRequirementType()==3) {// 自由行
//                	CRequirementDetailRequestDto requirementDetail=new CRequirementDetailRequestDto();
//                	requirementDetail.setRequirementId(plan.getRequirementId().toString());
//                	CRequirementPersonalVisitDetailResponseDto pubRequirementPersonalVisitDto=pubRequirementPersonalVisitMapper.queryRequirementPersonalVisitDetailById(requirementDetail);
//                	
//                	CPubPlanHistoryPersonalVisitDto pubPlanHistoryPersonalVisitDto=new CPubPlanHistoryPersonalVisitDto();
//                	//出发地
//                	pubPlanHistoryPersonalVisitDto.setLeaveLocationName(pubRequirementPersonalVisitDto.getBirthlandName());
//                	//目的地
//                	List<PubPlanHistoryPersonalVisitDestinationDto> destinationList=new ArrayList<PubPlanHistoryPersonalVisitDestinationDto>();
//                	PubPlanHistoryPersonalVisitDestinationDto personalDestionationDto=new PubPlanHistoryPersonalVisitDestinationDto();
//                	personalDestionationDto.setDestinationName(pubRequirementPersonalVisitDto.getDestinationName());
//                	destinationList.add(personalDestionationDto);
//                	pubPlanHistoryPersonalVisitDto.setDestinationList(destinationList);
//                	pubPlanHistoryPersonalVisitDto.setDays(pubRequirementPersonalVisitDto.getTripCount().toString());
//                	pubPlanHistoryPersonalVisitDto.setTrafficLeaveName(pubRequirementPersonalVisitDto.getTransportationStr());
//                	res.setPubPlanHistoryPersonalVisitDto(pubPlanHistoryPersonalVisitDto);
//                }                 
//                 else if (plan.getRequirementType()==4) {// 跟团行
//                	 
//                	 CRequirementDetailRequestDto param=new CRequirementDetailRequestDto();
//                	 param.setRequirementId(plan.getRequirementId().toString());
//                	 CRequirementGroupVisitDetailResponseDto cRequirementGroupVisitDetailResponseDto=pubRequirementGroupVisitMapper.queryRequirementGroupVisiDetailById(param);
//                	 CPubPlanHistoryGroupVisitDto cPubPlanHistoryGroupVisitDto=new CPubPlanHistoryGroupVisitDto();
//                	 cPubPlanHistoryGroupVisitDto.setLeaveLocationName(cRequirementGroupVisitDetailResponseDto.getBirthlandName());
//                	 
//                	//目的地
//                 	List<PubPlanHistoryGroupVisitDestinationDto> destinationList=new ArrayList<PubPlanHistoryGroupVisitDestinationDto>();
//                 	PubPlanHistoryGroupVisitDestinationDto groupDestionationDto=new PubPlanHistoryGroupVisitDestinationDto();
//                 	groupDestionationDto.setDestinationName(cRequirementGroupVisitDetailResponseDto.getDestinationName());
//                 	destinationList.add(groupDestionationDto);
//                 	cPubPlanHistoryGroupVisitDto.setDestinationList(destinationList);
//                 	cPubPlanHistoryGroupVisitDto.setDays(cRequirementGroupVisitDetailResponseDto.getTripCount().toString());
//                    res.setPubPlanHistoryGroupVisitDto(cPubPlanHistoryGroupVisitDto);
//                 }
            	
          //  }
        }
        return res;
	}

	@Override
	public void updatePubPlanById(CUpdatePubPlanRequestDto dto) {
		dto.setUpdateTime(new Date());
		pubPlanMapper.updatePubPlanById(dto);
	}

}
