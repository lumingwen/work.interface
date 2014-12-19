package cn.com.ubing.pub.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

import cn.com.ubing.msg.dao.MsgGroupMapper;
import cn.com.ubing.msg.model.MsgGroup;
import cn.com.ubing.pub.dao.PubOrdersMapper;
import cn.com.ubing.pub.dao.PubPlanMapper;
import cn.com.ubing.pub.dao.PubRequirementGroupVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementHotelMapper;
import cn.com.ubing.pub.dao.PubRequirementPersonalVisitMapper;
import cn.com.ubing.pub.dao.PubRequirementTicketMapper;
import cn.com.ubing.pub.dto.OperationPlanRequestDto;
import cn.com.ubing.pub.dto.OperationPlanResponseDto;
import cn.com.ubing.pub.model.PubOrders;
import cn.com.ubing.pub.model.PubPlan;
import cn.com.ubing.pub.model.PubRequirementGroupVisit;
import cn.com.ubing.pub.model.PubRequirementHotel;
import cn.com.ubing.pub.model.PubRequirementPersonalVisit;
import cn.com.ubing.pub.model.PubRequirementTicket;
import cn.com.ubing.res.dao.ResCouponMapper;
import cn.com.ubing.res.model.ResCoupon;
import cn.com.ubing.res.model.ResSystemProperties;
import cn.com.ubing.res.service.ResSystemPropertiesServiceI;
import cn.com.ubing.rms.dao.RmsUserMapper;
import cn.com.ubing.rms.model.RmsUser;
@Service("cPlanService")
public class CPlanServiceImpl implements CPlanServiceI {
    @Autowired
    private PubPlanMapper pubPlanMapper;
    @Autowired
    private MsgGroupMapper msgGroupMapper;
    @Autowired
    private PubRequirementTicketMapper pubRequirementTicketMapper;
    @Autowired
    private PubRequirementHotelMapper pubRequirementHotelMapper;
    @Autowired
    private PubRequirementPersonalVisitMapper pubRequirementPersonalVisitMapper;
    @Autowired
    private PubRequirementGroupVisitMapper pubRequirementGroupVisitMapper;
    @Autowired
    private PubOrdersMapper pubOrdersMapper;
    @Autowired
    private ResSystemPropertiesServiceI resSystemPropertiesService;
    @Autowired
    private ResCouponMapper resCouponMapper;
    @Autowired
    private RmsUserMapper rmsUserMapper;
    @Override
    public OperationPlanResponseDto operationPlan(OperationPlanRequestDto param) {
        OperationPlanResponseDto res = new OperationPlanResponseDto();
        if(param!=null){
            PubPlan plan = pubPlanMapper.selectByPrimaryKey(CommonUtils.parseLong(param.getPlanId()));
            if(plan!=null){
                if("0".equals(param.getOperationParam())){//0拒绝
                    //拒绝该条方案
                    pubPlanMapper.rejectPlan(plan.getId());
                }else if("1".equals(param.getOperationParam())){//1同意
                    Double total_price = 0D;
                    Double preferential_price = 0D;
                    //同意该条方案
                    pubPlanMapper.agreePlan(plan.getId());
                    //拒绝关联需求的其他方案
                    pubPlanMapper.rejectOtherPlan(plan);
                    //改变需求状态
                    if(plan.getRequirementType()==1){
                        PubRequirementTicket ticket = pubRequirementTicketMapper.selectByPrimaryKey(plan.getRequirementId());
                        if(ticket!=null){
                            ticket.setStatus(1);//将需求的状态改为已中标
                            pubRequirementTicketMapper.updateByPrimaryKey(ticket);
                            if(plan.getPrice()!=null&&ticket.getPeopleCount()!=null){
                                total_price = plan.getPrice()*ticket.getPeopleCount()+total_price;
                            }
                            if(ticket.getCoupon()!=null){
                                ResCoupon resCoupon = resCouponMapper.selectByPrimaryKey(ticket.getCoupon());
                                if(resCoupon!=null){
                                    preferential_price = CommonUtils.parseDouble(resCoupon.getMoney()+"");
                                }
                            }                                
                        }
                    }else if(plan.getRequirementType()==2){
                        PubRequirementHotel hotel = pubRequirementHotelMapper.selectByPrimaryKey(plan.getRequirementId());
                        hotel.setStatus(1);//将需求的状态改为已中标
                        pubRequirementHotelMapper.updateByPrimaryKey(hotel);
                        if(plan.getPrice()!=null&&hotel.getTripCount()!=null&&hotel.getHotelRooms()!=null){
                            total_price = plan.getPrice()*hotel.getTripCount()*hotel.getHotelRooms();
                        }
                        if(hotel.getCoupon()!=null){
                            ResCoupon resCoupon = resCouponMapper.selectByPrimaryKey(hotel.getCoupon());
                            if(resCoupon!=null){
                                preferential_price = CommonUtils.parseDouble(resCoupon.getMoney()+"");
                            }
                        }
                    }else if(plan.getRequirementType()==3){
                        PubRequirementPersonalVisit personal = pubRequirementPersonalVisitMapper.selectByPrimaryKey(plan.getRequirementId());
                        personal.setStatus(1);//将需求的状态改为已中标
                        pubRequirementPersonalVisitMapper.updateByPrimaryKey(personal);
                        if(plan.getPrice()!=null&&personal.getPeopleCount()!=null){
                            total_price = plan.getPrice()*personal.getPeopleCount();
                        }
                        if(plan.getChildPrice()!=null&&personal.getChildPeopleCount()!=null){
                            total_price = plan.getChildPrice()*personal.getChildPeopleCount()+total_price;
                        }
                        if(personal.getCoupon()!=null){
                            ResCoupon resCoupon = resCouponMapper.selectByPrimaryKey(personal.getCoupon());
                            if(resCoupon!=null){
                                preferential_price = CommonUtils.parseDouble(resCoupon.getMoney()+"");
                            }
                        }
                    }else if(plan.getRequirementType()==4){
                        PubRequirementGroupVisit group = pubRequirementGroupVisitMapper.selectByPrimaryKey(plan.getRequirementId());
                        group.setStatus(1);//将需求的状态改为已中标
                        pubRequirementGroupVisitMapper.updateByPrimaryKey(group);
                        if(plan.getPrice()!=null&&group.getPeopleCount()!=null){
                            total_price = plan.getPrice()*group.getPeopleCount();
                        }
                        if(plan.getChildPrice()!=null&&group.getChildPeopleCount()!=null){
                            total_price = plan.getChildPrice()*group.getChildPeopleCount()+total_price;
                        }
                        if(group.getCoupon()!=null){
                            ResCoupon resCoupon = resCouponMapper.selectByPrimaryKey(group.getCoupon());
                            if(resCoupon!=null){
                                preferential_price = CommonUtils.parseDouble(resCoupon.getMoney()+"");
                            }
                        }
                    }
                    //生成订单---------start
                    PubOrders order = new PubOrders();
                    order.setCreateTime(new Date());
                    order.setUpdateTime(new Date());
                    order.setDeleteFlag(Constants.DEL_FLAG_NO);
                    order.setType(1);//订单类型为方案订单
                    order.setProductName(plan.getTitle());
                    order.setSellUserId(plan.getUserId());
                    order.setBuyUserId(CommonUtils.parseLong(param.getUid()));
                    order.setTotalMoney(total_price);
                    order.setPreferentialMoney(preferential_price);
                    order.setPayMoney(total_price-preferential_price);
                    order.setPubPlanId(plan.getId());
                    order.setPayStatus(0);//支付状态为默认未支付
                    //最后付款时间  
                    if(plan.getStartTime()!=null){
                        order.setLastPayTime(plan.getStartTime());
                    }else{
                        Calendar c = Calendar.getInstance();
                        c.setTime(new Date());
                        c.add(Calendar.DAY_OF_MONTH, 7);
                    }
                    order.setConfirmTravelStatus(0);//出行状态默认为未出行
                    //自动确认出行时间
                    if(plan.getEndTime()!=null){
                        Calendar temp = Calendar.getInstance();
                        temp.setTime(plan.getEndTime());
                        ResSystemProperties tempPro = resSystemPropertiesService.selectByKey("SYSTEM_PRO_COMPOSITE_RULE_AUTO_COMFIRM_TRAVEL_DAYS");
                        if(tempPro!=null){
                            temp.add(Calendar.DAY_OF_MONTH, CommonUtils.parseInteger(tempPro.getPropValue()));
                        }
                        order.setLastConfirmTravelTime(temp.getTime());
                    }else{
                        Calendar temp = Calendar.getInstance();
                        temp.setTime(new Date());
                        ResSystemProperties tempPro = resSystemPropertiesService.selectByKey("SYSTEM_PRO_COMPOSITE_RULE_AUTO_COMFIRM_TRAVEL_DAYS");
                        if(tempPro!=null){
                            temp.add(Calendar.DAY_OF_MONTH, CommonUtils.parseInteger(tempPro.getPropValue()));
                        }
                        order.setLastConfirmTravelTime(temp.getTime());
                    }                    
                    pubOrdersMapper.insert(order);
                    //生成订单---------end
                }else if("2".equals(param.getOperationParam())){//联系他
                    MsgGroup requ = new MsgGroup();
                    requ.setFromId(CommonUtils.parseLong(param.getUid()));
                    requ.setToId(plan.getUserId());
                    MsgGroup resp = msgGroupMapper.selectGroupId(requ);
                    if(resp!=null){
                        res.setMessageGroupId(resp.getId()+"");
                    }else{
                        requ.setCreateTime(new Date());
                        requ.setUpdateTime(new Date());
                        requ.setDeleteFlag(Constants.DEL_FLAG_NO);
                        requ.setType(2);
                        msgGroupMapper.insert(requ);
                        res.setMessageGroupId(requ.getId()+"");
                    }
                    RmsUser mUser = rmsUserMapper.selectByPrimaryKey(resp.getToId());
                    res.setFromUserName(mUser.getNickname());
                }
            }
        }
        return res;
    }

}
