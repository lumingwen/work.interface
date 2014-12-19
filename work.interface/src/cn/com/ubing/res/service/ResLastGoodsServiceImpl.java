package cn.com.ubing.res.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

import cn.com.ubing.pub.dao.PubOrdersMapper;
import cn.com.ubing.pub.model.PubOrders;
import cn.com.ubing.res.dao.ResAttachmentMapper;
import cn.com.ubing.res.dao.ResLastGoodsMapper;
import cn.com.ubing.res.dao.ResLastGoodsPriceQuantityMapper;
import cn.com.ubing.res.dao.ResLastGoodsSalesMapper;
import cn.com.ubing.res.dao.ResLastGoodsTripMapper;
import cn.com.ubing.res.dto.CResBuyLastGoodsRequestDto;
import cn.com.ubing.res.dto.CResBuyLastGoodsResponseDto;
import cn.com.ubing.res.dto.CResLastGoodsDetailRequestDto;
import cn.com.ubing.res.dto.CResLastGoodsDetailResponseDto;
import cn.com.ubing.res.dto.ResGoodsIdAndDateQueryDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityInfoRequestDto;
import cn.com.ubing.res.dto.ResLastGoodsPriceQuantityInfoResponseDto;
import cn.com.ubing.res.dto.ResLastGoodsTripDto;
import cn.com.ubing.res.dto.WelfareListDto;
import cn.com.ubing.res.dto.WelfareListRequestDto;
import cn.com.ubing.res.dto.WelfareListResponseDto;
import cn.com.ubing.res.model.ResAttachment;
import cn.com.ubing.res.model.ResLastGoods;
import cn.com.ubing.res.model.ResLastGoodsPriceQuantity;
import cn.com.ubing.res.model.ResLastGoodsSales;
import cn.com.ubing.res.model.ResSystemProperties;
@Service("resLastGoodsService")
public class ResLastGoodsServiceImpl implements ResLastGoodsServiceI {
    @Autowired
    private ResLastGoodsMapper resLastGoodsMapper;
    @Autowired
    private ResLastGoodsPriceQuantityMapper resLastGoodsPriceQuantityMapper;
    @Autowired
    private ResLastGoodsTripMapper resLastGoodsTripMapper;
    @Autowired
    private ResAttachmentMapper resAttachmentMapper;
    @Autowired
    private ResLastGoodsSalesMapper resLastGoodsSalesMapper;
    @Autowired
    private PubOrdersMapper pubOrdersMapper;
    @Autowired
    private ResSystemPropertiesServiceI resSystemPropertiesService;
    /**
     * 注入配置文件
     */
    @Value(value = "${imageAttachmentHostAddr}")
    private String imageAttachmentHostAddr;
    @Override
    public CResLastGoodsDetailResponseDto getLastGoodsDetail(CResLastGoodsDetailRequestDto param) {
        CResLastGoodsDetailResponseDto res = new CResLastGoodsDetailResponseDto();
        //主表信息
        ResLastGoods resLastGoods = resLastGoodsMapper.selectByPrimaryKey(CommonUtils.parseLong(param.getLastGoodId()));
        if(resLastGoods!=null){
            //图片
            List<String> attList = new ArrayList<String>();;
            ResAttachment queryParam = new ResAttachment();
            queryParam.setRelId(resLastGoods.getId());
            queryParam.setRelType(Constants.ATTACHMENT_TYPE_LAST_GOODS_IMAGE);
            List<ResAttachment> attachmentList = resAttachmentMapper.selectByRel(queryParam);
            for(ResAttachment att:attachmentList){
                if(att.getId()==resLastGoods.getMainImageId()){
                    attList.add(imageAttachmentHostAddr+att.getSavePath());
                }
            }
            for(ResAttachment att:attachmentList){
                if(att.getId()!=resLastGoods.getMainImageId()){
                    attList.add(imageAttachmentHostAddr+att.getSavePath());
                }
            }
            //所有价格信息表
            List<ResLastGoodsPriceQuantity> quantityList = resLastGoodsPriceQuantityMapper.selectByLastGoodsId(resLastGoods.getId());
            //最近一条价格信息
            ResLastGoodsPriceQuantity firstQuantity = resLastGoodsPriceQuantityMapper.selectFirstById(resLastGoods.getId());
            //行程安排
            List<ResLastGoodsTripDto> tripList = resLastGoodsTripMapper.selectByLastGoodsId(resLastGoods.getId());
            res.setLastGoodId(resLastGoods.getId()+"");
            res.setTitle(resLastGoods.getTitle());
            if(firstQuantity!=null){
                res.setSinglePrice(firstQuantity.getSinglePrice()+"");
                res.setMarketPrice(firstQuantity.getMarketPrice()+"");
                res.setQuantity(firstQuantity.getQuantity()+"");
            }
            if(quantityList!=null&&quantityList.size()>0){
                List<String> departureTimes = new ArrayList<String>();
                SimpleDateFormat sdf=new SimpleDateFormat("MM-dd");
                for(ResLastGoodsPriceQuantity qu:quantityList){
                    departureTimes.add(sdf.format(qu.getTime()));
                }
                res.setDepartureTimes(departureTimes);
            }
            res.setImageList(attList);
            res.setDeparturePlace(resLastGoods.getDeparturePlace());
            res.setPopularReasons(resLastGoods.getPopularReasons());
            res.setFeeDescription(resLastGoods.getFeeDescription());
            res.setFeeExclude(resLastGoods.getFeeExclude());
            res.setTrips(tripList);            
        }
        return res;
    }
    @Override
    public ResLastGoodsPriceQuantityInfoResponseDto queryPriceQuantityInfo(ResLastGoodsPriceQuantityInfoRequestDto param) {
        List<ResLastGoodsPriceQuantityDto> quantityList = resLastGoodsPriceQuantityMapper.selectDtoByLastGoodsId(CommonUtils.parseLong(param.getLastGoodsId()));
        ResLastGoodsPriceQuantityInfoResponseDto res = new ResLastGoodsPriceQuantityInfoResponseDto();
        res.setQuantityInfoList(quantityList);
        res.setLastGoodsId(param.getLastGoodsId());
        return res;
    }
    @Override
    public CResBuyLastGoodsResponseDto buyLastGoods(CResBuyLastGoodsRequestDto param) throws ParseException {
        String resultMessage = "购买成功，请及时付款";
        String orderId = "";
        ResLastGoods resLastGoods = resLastGoodsMapper.selectByPrimaryKey(CommonUtils.parseLong(param.getLastGoodsId()));
        if(resLastGoods!=null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date travelTime = sdf.parse(param.getTravelTime());
            ResGoodsIdAndDateQueryDto queryParam = new ResGoodsIdAndDateQueryDto();
            queryParam.setLastGoodId(CommonUtils.parseLong(param.getLastGoodsId()));
            queryParam.setTravelTime(param.getTravelTime());
            ResLastGoodsPriceQuantity quan = resLastGoodsPriceQuantityMapper.selectByLastGoodsIdAndDate(queryParam);
            if(quan!=null){
                if(quan.getQuantity()>0){
                  //记录购买信息
                    ResLastGoodsSales Sales = new ResLastGoodsSales();
                    Sales.setCreateTime(new Date());
                    Sales.setUpdateTime(new Date());
                    Sales.setDeleteFlag(Constants.DEL_FLAG_NO);
                    Sales.setLastGoodsId(CommonUtils.parseLong(param.getLastGoodsId()));
                    Sales.setUserId(CommonUtils.parseLong(param.getUid()));
                    Sales.setTravelTime(travelTime);
                    Sales.setTravelCount(CommonUtils.parseInteger(param.getPeopleCount()));
                    resLastGoodsSalesMapper.insert(Sales);
                    //生成订单信息
                    //生成订单---------start
                    PubOrders order = new PubOrders();
                    Double money = CommonUtils.parseInteger(param.getPeopleCount())*quan.getSinglePrice();
                    order.setCreateTime(new Date());
                    order.setUpdateTime(new Date());
                    order.setDeleteFlag(Constants.DEL_FLAG_NO);
                    order.setType(2);//订单类型为尾单订单
                    order.setProductName(resLastGoods.getTitle());
                    order.setSellUserId(-1L);//所有卖家都是游必应
                    order.setBuyUserId(CommonUtils.parseLong(param.getUid()));
                    order.setTotalMoney(money);
                    order.setPreferentialMoney(0D);
                    order.setPayMoney(money);
                    order.setEndRequirmentId(resLastGoods.getId());
                    order.setPayStatus(0);//支付状态为默认未支付
                    //最后付款时间  
                    if(travelTime!=null){
                        order.setLastPayTime(travelTime);
                    }else{
                        Calendar c = Calendar.getInstance();
                        c.setTime(new Date());
                        c.add(Calendar.DAY_OF_MONTH, 7);
                    }
                    order.setConfirmTravelStatus(0);//出行状态默认为未出行
                    //自动确认出行时间
                    if(travelTime!=null){
                        Calendar temp = Calendar.getInstance();
                        temp.setTime(travelTime);
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
                    orderId = order.getId().toString();
                }else{
                    resultMessage = "已经没有库存了";
                }
            }else{
                resultMessage = "该日期价格信息不存在！";
            }
        }else{
            resultMessage = "该尾单信息不存在！";
        }
        CResBuyLastGoodsResponseDto res = new CResBuyLastGoodsResponseDto();
        res.setResultMessage(resultMessage);
        res.setOrderId(orderId);
        return res;
    }
    @Override
    public WelfareListResponseDto queryWelfareList(WelfareListRequestDto param, PageBounds pageBounds) {
        // TODO Auto-generated method stub
        WelfareListResponseDto res = new WelfareListResponseDto();
        PageList<WelfareListDto> list = resLastGoodsMapper.queryWelfareList(param, pageBounds);
        if(list!=null){
            List<WelfareListDto> resList = new ArrayList<WelfareListDto>();
            for(WelfareListDto dto:list){
                WelfareListDto temp = new WelfareListDto();
                temp.setWelfareId(dto.getWelfareId());
                temp.setWelfareTitle(dto.getWelfareTitle());
                temp.setWelfareType(dto.getWelfareType());
                temp.setImageUrl(imageAttachmentHostAddr+dto.getImageUrl());
                temp.setWelfareUrl(dto.getWelfareUrl());
                resList.add(temp);
            }
            res.setWelfareList(resList);
            res.setTotalCount(list.getPaginator().getTotalCount()+"");
            res.setTotalPages(list.getPaginator().getTotalPages()+"");
            res.setPageNow(list.getPaginator().getPage()+"");
        }
        return res;
    }

}
