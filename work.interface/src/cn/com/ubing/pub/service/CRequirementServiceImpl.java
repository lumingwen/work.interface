package cn.com.ubing.pub.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.common.utils.DateHelper;
import cn.com.ubing.pub.dao.PubRequirementCheckMapper;
import cn.com.ubing.pub.dao.PubRequirementGroupVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementHotelMapper;
import cn.com.ubing.pub.dao.PubRequirementPersonalVisitAddedMapper;
import cn.com.ubing.pub.dao.PubRequirementPersonalVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementTicketMapper;
import cn.com.ubing.pub.dao.PubRequirementUserMapper;
import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.CRequirementGroupVisitDetailResponseDto;
import cn.com.ubing.pub.dto.CRequirementHotelDetailResponseDto;
import cn.com.ubing.pub.dto.CRequirementListDto;
import cn.com.ubing.pub.dto.CRequirementListRequestDto;
import cn.com.ubing.pub.dto.CRequirementListResponseDto;
import cn.com.ubing.pub.dto.CRequirementPersonalVisitDetailResponseDto;
import cn.com.ubing.pub.dto.CRequirementTicketDetailResponseDto;
import cn.com.ubing.pub.dto.PubPlanCountOutResponseDto;
import cn.com.ubing.pub.dto.SaveGroupRequirementRequestDto;
import cn.com.ubing.pub.dto.SaveHotelRequirementRequestDto;
import cn.com.ubing.pub.dto.SavePersonalRequirementRequestDto;
import cn.com.ubing.pub.dto.SaveTicketRequirementRequestDto;
import cn.com.ubing.pub.model.PubRequirementCheck;
import cn.com.ubing.pub.model.PubRequirementGroupVisit;
import cn.com.ubing.pub.model.PubRequirementHotel;
import cn.com.ubing.pub.model.PubRequirementPersonalVisit;
import cn.com.ubing.pub.model.PubRequirementPersonalVisitAdded;
import cn.com.ubing.pub.model.PubRequirementTicket;
import cn.com.ubing.res.dao.ResCommonContactsMapper;
import cn.com.ubing.res.dao.ResCouponMapper;
import cn.com.ubing.res.dao.ResDictMapper;
import cn.com.ubing.res.dao.ResSystemPropertiesMapper;
import cn.com.ubing.res.dto.ResCouponCountTimeOutResponseDto;
import cn.com.ubing.res.model.ResCommonContacts;
import cn.com.ubing.res.model.ResCoupon;
import cn.com.ubing.res.model.ResDict;
import cn.com.ubing.res.model.ResSystemProperties;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;
@Service("cRequirementService")
public class CRequirementServiceImpl implements CRequirementServiceI {
    @Autowired
    private ResDictMapper ResDictMapper;
    @Autowired
    private PubRequirementTicketMapper pubRequirementTicketMapper;
    @Autowired
    private PubRequirementHotelMapper pubRequirementHotelMapper;
    @Autowired
    private PubRequirementPersonalVisitMapper pubRequirementPersonalVisitMapper;
    @Autowired
    private PubRequirementPersonalVisitAddedMapper pubRequirementPersonalVisitAddedMapper;
    @Autowired
    private PubRequirementGroupVisitMapper pubRequirementGroupVisitMapper;
    @Autowired
    private PubRequirementCheckMapper pubRequirementCheckMapper;
    @Autowired
    private ResSystemPropertiesMapper resSystemPropertiesMapper;
    @Autowired
    private ResCommonContactsMapper resCommonContactsMapper;
    @Autowired
    private PubRequirementUserMapper pubRequirementUserMapper;
    @Autowired
    private ResCouponMapper resCouponMapper;
    @Override
    public Integer SavePersonalRequirement(SavePersonalRequirementRequestDto param) throws ParseException {
        Integer flag = 0;
        PubRequirementPersonalVisit mo = new PubRequirementPersonalVisit();
        String birthlandName = "未知地点";
        String destinationName = "未知地点";
        Long birthland = CommonUtils.parseLong(param.getBirthland());
        ResDict birthlandObj = ResDictMapper.selectByPrimaryKey(birthland);
        if(birthlandObj!=null){
            birthlandName = birthlandObj.getCname();
        }
        mo.setCreateTime(new Date());
        mo.setUpdateTime(new Date());
        mo.setDeleteFlag(Constants.DEL_FLAG_NO);
        mo.setUserId(CommonUtils.parseLong(param.getUid()));
        mo.setBirthland(birthland);
        Long destination = CommonUtils.parseLong(param.getDestination());
        if(destination==null){
            mo.setDestination(-1L);//如果没有目的地
            mo.setTitle(param.getDepartureTime()+"从<span>" + birthlandName + "</span>出发的自由行");
        }else{
            ResDict destinationObj = ResDictMapper.selectByPrimaryKey(destination);
            if(destinationObj!=null){
                destinationName = destinationObj.getCname();
            }
            mo.setDestination(destination);
            mo.setTitle(param.getDepartureTime()+"从<span>" + birthlandName + "</span>到<span>" + destinationName + "</span>的自由行");
        }
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date departureTime = formatDate.parse(param.getDepartureTime());
        Calendar c = Calendar.getInstance();
        c.setTime(departureTime);
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        mo.setDepartureTime(departureTime);
        mo.setEndTime(c.getTime());
        mo.setTripCount(CommonUtils.parseInteger(param.getTripCount()));
        mo.setPeopleCount(CommonUtils.parseInteger(param.getPeopleCount()));
        mo.setDetail(param.getDetail());
        mo.setChildPeopleCount(CommonUtils.parseInteger(param.getChildPeopleCount()));
        mo.setTheme(CommonUtils.parseLong(param.getTheme()));
        mo.setBudget(param.getBudget());
        //如果选择了优惠卷，将优惠卷置为已使用
        Long couponId = CommonUtils.parseLong(param.getCoupon());
        if(couponId!=null){
            ResCoupon resCoupon = resCouponMapper.selectByPrimaryKey(couponId);
            if(resCoupon!=null){
                resCoupon.setUseStatus(1);//将优惠卷置为已使用
                resCouponMapper.updateByPrimaryKey(resCoupon);
                mo.setCoupon(couponId);
            }
        }
        //保存联系人到常用联系人
        if(param.getContactsTel()!=null&&!"".equals(param.getContactsTel())&&param.getContactsName()!=null&&!"".equals(param.getContactsName())){
            ResCommonContacts req = new ResCommonContacts();
            req.setName(param.getContactsName());
            req.setTel(param.getContactsTel());
            ResCommonContacts res = resCommonContactsMapper.selectByNameAndTel(req);
            if(res!=null){
                mo.setContacts(res.getId());
            }else{
                req.setCreateTime(new Date());
                req.setUpdateTime(new Date());
                req.setDeleteFlag(Constants.DEL_FLAG_NO);
                req.setUserId(CommonUtils.parseLong(param.getUid()));
                resCommonContactsMapper.insert(req);
                mo.setContacts(req.getId());
            }
        }
        mo.setTransportation(CommonUtils.parseLong(param.getTransportation()));
        mo.setFromSys(2);//来源为app
        mo.setManualStatus(0);//手工处理状态为未处理
        mo.setStatus(0);//状态为未中标
        mo.setSendStatus(0);//推送状态为未推送
        mo.setA1(param.getHotelLevel());//酒店星级
        flag = pubRequirementPersonalVisitMapper.insert(mo);
        //***增值服务信息保存
        String added = param.getAddeds();
        if(!"".equals(added)&&added!=null){
            String[] addeds = added.split(",");
            Long addedId = null;
            for(String temp:addeds){
                addedId = CommonUtils.parseLong(temp);
                if(addedId!=null){
                    PubRequirementPersonalVisitAdded addObj = new PubRequirementPersonalVisitAdded();
                    addObj.setCreateTime(new Date());
                    addObj.setUpdateTime(new Date());
                    addObj.setDeleteFlag(Constants.DEL_FLAG_NO);
                    addObj.setAddedServiceId(addedId);
                    addObj.setRequirementId(mo.getId());
                    pubRequirementPersonalVisitAddedMapper.insert(addObj);
                }
            }
        }
        //***添加新需求审核请求
        PubRequirementCheck checkInfo = new PubRequirementCheck();
        checkInfo.setCreateTime(new Date());
        checkInfo.setUpdateTime(new Date());
        checkInfo.setDeleteFlag(Constants.DEL_FLAG_NO);
        checkInfo.setRequirementType(3);//需求类型为自由行
        checkInfo.setRequirementId(mo.getId());
        checkInfo.setCheckStatus(0);//审核状态为未审核
        pubRequirementCheckMapper.insert(checkInfo);
        return flag;
    }
    @Override
    public Integer CheckSubmitRequirementStatus(Long userId) {
        // TODO Auto-generated method stub
        Integer result=0;
        Integer max=0;
        ResSystemProperties sysPro = resSystemPropertiesMapper.selectByKey("SYSTEM_PRO_COMPOSITE_RULE_XUQIUZUIDAFASONGCISHU");
        if(sysPro!=null){
            max = CommonUtils.parseInteger(sysPro.getPropValue());
        }
        Integer now = pubRequirementPersonalVisitMapper.selectRequirementCountByUser(userId);
        if(now>=max){
            result = 1;
        }else{
            result = 0;
        }
        return result;
    }
    @Override
    public Integer SaveGroupRequirement(SaveGroupRequirementRequestDto param) throws ParseException {
        Integer flag = 0;
        PubRequirementGroupVisit mo = new PubRequirementGroupVisit();
        String birthlandName = "未知地点";
        String destinationName = "未知地点";
        Long birthland = CommonUtils.parseLong(param.getBirthland());
        ResDict birthlandObj = ResDictMapper.selectByPrimaryKey(birthland);
        if(birthlandObj!=null){
            birthlandName = birthlandObj.getCname();
        }
        mo.setCreateTime(new Date());
        mo.setUpdateTime(new Date());
        mo.setDeleteFlag(Constants.DEL_FLAG_NO);
        mo.setUserId(CommonUtils.parseLong(param.getUid()));
        mo.setBirthland(birthland);
        Long destination = CommonUtils.parseLong(param.getDestination());
        if(destination==null){
            mo.setDestination(-1L);//如果没有目的地
            mo.setTitle(param.getDepartureTime()+"从<span>" + birthlandName + "</span>出发的跟团行");
        }else{
            ResDict destinationObj = ResDictMapper.selectByPrimaryKey(destination);
            if(destinationObj!=null){
                destinationName = destinationObj.getCname();
            }
            mo.setDestination(destination);
            mo.setTitle(param.getDepartureTime()+"从<span>" + birthlandName + "</span>到<span>" + destinationName + "</span>的跟团行");
        }
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date departureTime = formatDate.parse(param.getDepartureTime());
        Calendar c = Calendar.getInstance();
        c.setTime(departureTime);
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        mo.setDepartureTime(departureTime);
        mo.setEndTime(c.getTime());
        mo.setTripCount(CommonUtils.parseInteger(param.getTripCount()));
        mo.setPeopleCount(CommonUtils.parseInteger(param.getPeopleCount()));
        mo.setDetail(param.getDetail());
        mo.setChildPeopleCount(CommonUtils.parseInteger(param.getChildPeopleCount()));
        mo.setBudget(param.getBudget());
        //如果选择了优惠卷，将优惠卷置为已使用
        Long couponId = CommonUtils.parseLong(param.getCoupon());
        if(couponId!=null){
            ResCoupon resCoupon = resCouponMapper.selectByPrimaryKey(couponId);
            if(resCoupon!=null){
                resCoupon.setUseStatus(1);//将优惠卷置为已使用
                resCouponMapper.updateByPrimaryKey(resCoupon);
                mo.setCoupon(couponId);
            }
        }
        //保存联系人到常用联系人
        if(param.getContactsTel()!=null&&!"".equals(param.getContactsTel())&&param.getContactsName()!=null&&!"".equals(param.getContactsName())){
            ResCommonContacts req = new ResCommonContacts();
            req.setName(param.getContactsName());
            req.setTel(param.getContactsTel());
            ResCommonContacts res = resCommonContactsMapper.selectByNameAndTel(req);
            if(res!=null){
                mo.setContacts(res.getId());
            }else{
                req.setCreateTime(new Date());
                req.setUpdateTime(new Date());
                req.setDeleteFlag(Constants.DEL_FLAG_NO);
                req.setUserId(CommonUtils.parseLong(param.getUid()));
                resCommonContactsMapper.insert(req);
                mo.setContacts(req.getId());
            }
        }
        mo.setFromSys(2);//来源为app
        mo.setManualStatus(0);//手工处理状态为未处理
        mo.setStatus(0);//状态为未中标
        mo.setSendStatus(0);//推送状态为未推送
        mo.setA1(param.getHotelLevel());//酒店星级
        flag = pubRequirementGroupVisitMapper.insert(mo);
        //***添加新需求审核请求
        PubRequirementCheck checkInfo = new PubRequirementCheck();
        checkInfo.setCreateTime(new Date());
        checkInfo.setUpdateTime(new Date());
        checkInfo.setDeleteFlag(Constants.DEL_FLAG_NO);
        checkInfo.setRequirementType(4);//需求类型为自由行
        checkInfo.setRequirementId(mo.getId());
        checkInfo.setCheckStatus(0);//审核状态为未审核
        pubRequirementCheckMapper.insert(checkInfo);
        return flag;
    }
    @Override
    public Integer SaveTicketRequirement(SaveTicketRequirementRequestDto param) throws ParseException {
        Integer flag = 0;
        PubRequirementTicket mo = new PubRequirementTicket();
        String birthlandName = "未知地点";
        String destinationName = "未知地点";
        Long birthland = CommonUtils.parseLong(param.getBirthland());
        ResDict birthlandObj = ResDictMapper.selectByPrimaryKey(birthland);
        if(birthlandObj!=null){
            birthlandName = birthlandObj.getCname();
        }
        mo.setCreateTime(new Date());
        mo.setUpdateTime(new Date());
        mo.setDeleteFlag(Constants.DEL_FLAG_NO);
        mo.setUserId(CommonUtils.parseLong(param.getUid()));
        mo.setBirthland(birthland);
        Long destination = CommonUtils.parseLong(param.getDestination());
        ResDict destinationObj = ResDictMapper.selectByPrimaryKey(destination);
        if(destinationObj!=null){
            destinationName = destinationObj.getCname();
        }
        mo.setDestination(destination);
        mo.setTitle(param.getDepartureTime()+"从<span>" + birthlandName + "</span>到<span>" + destinationName + "</span>的机票");
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date departureTime = formatDate.parse(param.getDepartureTime());
        mo.setTicketType(CommonUtils.parseInteger(param.getTicketType()));
        if("2".equals(param.getTicketType())){
            Date returnTime = formatDate.parse(param.getReturnTime());
            mo.setReturnTime(returnTime);
        }
        Calendar c = Calendar.getInstance();
        c.setTime(departureTime);
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        mo.setDepartureTime(departureTime);
        mo.setEndTime(c.getTime());
        mo.setPeopleCount(CommonUtils.parseInteger(param.getPeopleCount()));
        mo.setDetail(param.getDetail());
        mo.setDepartureTimeDay(CommonUtils.parseLong(param.getDepartureTimeDay()));
        mo.setTicketSpace(CommonUtils.parseLong(param.getTicketSpace()));
        //如果选择了优惠卷，将优惠卷置为已使用
        Long couponId = CommonUtils.parseLong(param.getCoupon());
        if(couponId!=null){
            ResCoupon resCoupon = resCouponMapper.selectByPrimaryKey(couponId);
            if(resCoupon!=null){
                resCoupon.setUseStatus(1);//将优惠卷置为已使用
                resCouponMapper.updateByPrimaryKey(resCoupon);
                mo.setCoupon(couponId);
            }
        }
        //保存联系人到常用联系人
        if(param.getContactsTel()!=null&&!"".equals(param.getContactsTel())&&param.getContactsName()!=null&&!"".equals(param.getContactsName())){
            ResCommonContacts req = new ResCommonContacts();
            req.setName(param.getContactsName());
            req.setTel(param.getContactsTel());
            ResCommonContacts res = resCommonContactsMapper.selectByNameAndTel(req);
            if(res!=null){
                mo.setContacts(res.getId());
            }else{
                req.setCreateTime(new Date());
                req.setUpdateTime(new Date());
                req.setDeleteFlag(Constants.DEL_FLAG_NO);
                req.setUserId(CommonUtils.parseLong(param.getUid()));
                resCommonContactsMapper.insert(req);
                mo.setContacts(req.getId());
            }
        }
        mo.setFromSys(2);//来源为app
        mo.setManualStatus(0);//手工处理状态为未处理
        mo.setStatus(0);//状态为未中标
        mo.setSendStatus(0);//推送状态为未推送
        flag = pubRequirementTicketMapper.insert(mo);
        
        //***添加新需求审核请求
        PubRequirementCheck checkInfo = new PubRequirementCheck();
        checkInfo.setCreateTime(new Date());
        checkInfo.setUpdateTime(new Date());
        checkInfo.setDeleteFlag(Constants.DEL_FLAG_NO);
        checkInfo.setRequirementType(1);//需求类型为自由行
        checkInfo.setRequirementId(mo.getId());
        checkInfo.setCheckStatus(0);//审核状态为未审核
        pubRequirementCheckMapper.insert(checkInfo);
        return flag;
    }
    @Override
    public Integer SaveHotelRequirement(SaveHotelRequirementRequestDto param) throws ParseException {
        Integer flag = 0;
        PubRequirementHotel mo = new PubRequirementHotel();
        String destinationName = "未知地点";
        mo.setCreateTime(new Date());
        mo.setUpdateTime(new Date());
        mo.setDeleteFlag(Constants.DEL_FLAG_NO);
        mo.setUserId(CommonUtils.parseLong(param.getUid()));
        Long destination = CommonUtils.parseLong(param.getDestination());
        ResDict destinationObj = ResDictMapper.selectByPrimaryKey(destination);
        if(destinationObj!=null){
            destinationName = destinationObj.getCname();
        }
        mo.setDestination(destination);
        mo.setTitle(param.getDepartureTime()+"到<span>" + destinationName + "</span>的酒店");
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date departureTime = formatDate.parse(param.getDepartureTime());
        Calendar c = Calendar.getInstance();
        c.setTime(departureTime);
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        mo.setDepartureTime(departureTime);
        mo.setEndTime(c.getTime());
        mo.setTripCount(CommonUtils.parseInteger(param.getTripCount()));
        mo.setDetail(param.getDetail());
        mo.setHotelRooms(CommonUtils.parseInteger(param.getHotelRooms()));
        mo.setHotelPrice(CommonUtils.parseLong(param.getHotelPrice()));
        mo.setHotelLevel(CommonUtils.parseLong(param.getHotelLevel()));
        mo.setPoint(param.getPoint());
        //如果选择了优惠卷，将优惠卷置为已使用
        Long couponId = CommonUtils.parseLong(param.getCoupon());
        if(couponId!=null){
            ResCoupon resCoupon = resCouponMapper.selectByPrimaryKey(couponId);
            if(resCoupon!=null){
                resCoupon.setUseStatus(1);//将优惠卷置为已使用
                resCouponMapper.updateByPrimaryKey(resCoupon);
                mo.setCoupon(couponId);
            }
        }
        //保存联系人到常用联系人
        if(param.getContactsTel()!=null&&!"".equals(param.getContactsTel())&&param.getContactsName()!=null&&!"".equals(param.getContactsName())){
            ResCommonContacts req = new ResCommonContacts();
            req.setName(param.getContactsName());
            req.setTel(param.getContactsTel());
            ResCommonContacts res = resCommonContactsMapper.selectByNameAndTel(req);
            if(res!=null){
                mo.setContacts(res.getId());
            }else{
                req.setCreateTime(new Date());
                req.setUpdateTime(new Date());
                req.setDeleteFlag(Constants.DEL_FLAG_NO);
                req.setUserId(CommonUtils.parseLong(param.getUid()));
                resCommonContactsMapper.insert(req);
                mo.setContacts(req.getId());
            }
        }
        mo.setFromSys(2);//来源为app
        mo.setManualStatus(0);//手工处理状态为未处理
        mo.setStatus(0);//状态为未中标
        mo.setSendStatus(0);//推送状态为未推送
        flag = pubRequirementHotelMapper.insert(mo);
        
        //***添加新需求审核请求
        PubRequirementCheck checkInfo = new PubRequirementCheck();
        checkInfo.setCreateTime(new Date());
        checkInfo.setUpdateTime(new Date());
        checkInfo.setDeleteFlag(Constants.DEL_FLAG_NO);
        checkInfo.setRequirementType(2);//需求类型为自由行
        checkInfo.setRequirementId(mo.getId());
        checkInfo.setCheckStatus(0);//审核状态为未审核
        pubRequirementCheckMapper.insert(checkInfo);
        return flag;
    }
    @Override
    public CRequirementListResponseDto queryRequirementList(CRequirementListRequestDto param, PageBounds pageBounds) {
        // TODO Auto-generated method stub
        PageList<CRequirementListDto> requirementList = pubRequirementUserMapper.queryCRequirementList(param, pageBounds);
        CRequirementListResponseDto res = new CRequirementListResponseDto();
        if(requirementList!=null){
            res.setPageNow(requirementList.getPaginator().getPage()+"");
            res.setTotalCount(requirementList.getPaginator().getTotalCount()+"");
            res.setTotalPages(requirementList.getPaginator().getTotalPages()+"");
            res.setRequirementList(requirementList);
        }
        return res;
    }
   
    /**
     * 根据id查询需求详情(机票)
     * @param param
     * @param pageBounds
     * @return
     */
    
	@Override
	public CRequirementTicketDetailResponseDto queryRequirementTickDetailById(
			CRequirementDetailRequestDto param) {
		
		CRequirementTicketDetailResponseDto dto=pubRequirementTicketMapper.queryRequirementTickDetailById(param);
//		dto.setCreateTimeStr(dto.getCreateTime()!=null?DateHelper.formatDateTimeForFileName1(dto.getCreateTime()):null);
//		dto.setDepartureTimeStr(dto.getDepartureTime()!=null?DateHelper.formatDateTimeForFileName1(dto.getDepartureTime()):null);
//		dto.setReturnTimeStr(dto.getReturnTime()!=null?DateHelper.formatDateTimeForFileName1(dto.getReturnTime()):null);;
//		dto.setEndTimeStr(dto.getEndTime()!=null?DateHelper.formatDateTimeForFileName1(dto.getEndTime()):null);
		dto.setCreateTimeStr(DateHelper.formatDateTimeForFileName1(dto.getCreateTime()));
		dto.setDepartureTimeStr(DateHelper.formatDateTimeForFileName1(dto.getDepartureTime()));
		dto.setReturnTimeStr(DateHelper.formatDateTimeForFileName1(dto.getReturnTime()));
		dto.setEndTimeStr(DateHelper.formatDateTimeForFileName1(dto.getEndTime()));
		return dto;
	}
	   
    /**
     * 根据id查询需求详情(酒店)
     * @param param
     * @param pageBounds
     * @return
     */
	@Override
	public CRequirementHotelDetailResponseDto queryRequirementHotelDetailById(
			CRequirementDetailRequestDto param) {
		CRequirementHotelDetailResponseDto dto=pubRequirementHotelMapper.queryRequirementHotelDetailById(param);
		dto.setCreateTimeStr(DateHelper.formatDateTimeForFileName1(dto.getCreateTime()));
		dto.setDepartureTimeStr(DateHelper.formatDateTimeForFileName1(dto.getDepartureTime()));
		dto.setEndTimeStr(DateHelper.formatDateTimeForFileName1(dto.getEndTime()));
		return dto;
	}
	   
    /**
     * 根据id查询需求详情(自由行)
     * @param param
     * @param pageBounds
     * @return
     */
	@Override
	public CRequirementPersonalVisitDetailResponseDto queryRequirementPersonalVisitDetailById(
			CRequirementDetailRequestDto param) {
		CRequirementPersonalVisitDetailResponseDto dto=pubRequirementPersonalVisitMapper.queryRequirementPersonalVisitDetailById(param);
		dto.setCreateTimeStr(DateHelper.formatDateTimeForFileName1(dto.getCreateTime()));
		dto.setDepartureTimeStr(DateHelper.formatDateTimeForFileName1(dto.getDepartureTime()));
		dto.setEndTimeStr(DateHelper.formatDateTimeForFileName1(dto.getEndTime()));
		return dto;
	}
	   
    /**
     * 根据id查询需求详情(更团行)
     * @param param
     * @param pageBounds
     * @return
     */
	@Override
	public CRequirementGroupVisitDetailResponseDto queryRequirementGroupVisiDetailById(
			CRequirementDetailRequestDto param) {
		CRequirementGroupVisitDetailResponseDto dto=pubRequirementGroupVisitMapper.queryRequirementGroupVisiDetailById(param);
		dto.setCreateTimeStr(DateHelper.formatDateTimeForFileName1(dto.getCreateTime()));
		dto.setDepartureTimeStr(DateHelper.formatDateTimeForFileName1(dto.getDepartureTime()));
		dto.setEndTimeStr(DateHelper.formatDateTimeForFileName1(dto.getEndTime()));
		return dto;
	}
	
	@Override
	public PubPlanCountOutResponseDto queryPubPlanCount(RequestDto param) {
		    PubPlanCountOutResponseDto res = new PubPlanCountOutResponseDto();
	        res.setPubPlanCount(pubRequirementUserMapper.queryPubPlanCount(param)+"");
	        return res;
	}

}
