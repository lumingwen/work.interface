package cn.com.ubing.pub.controller.binterace;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.ubing.common.controller.BaseController;
import cn.com.ubing.common.dto.ResponseDto;
import cn.com.ubing.msg.model.MsgGroup;
import cn.com.ubing.msg.service.MessageServiceI;
import cn.com.ubing.pub.dto.BPubOrdersDetailsRequestDto;
import cn.com.ubing.pub.dto.BPubOrdersDetailsResponseDto;
import cn.com.ubing.pub.dto.BPubOrdersListDto;
import cn.com.ubing.pub.dto.BPubOrdersListRequestDto;
import cn.com.ubing.pub.dto.BPubOrdersListResponseDto;
import cn.com.ubing.pub.service.PubOrdersServiceI;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;
@Controller
public class BPubOrdersController extends BaseController {
    private final Logger log = Logger.getLogger(getClass());
    @Autowired
    private PubOrdersServiceI pubOrdersService;
    @Autowired
    private MessageServiceI messageService;
    /**
     * B端订单列表
     * 
     * @author 邱全松 2014-12-9 下午1:41:48
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping("/getOrdersListForB")
    public void getOrdersList(HttpServletRequest request,HttpServletResponse response,BPubOrdersListRequestDto param) {
        try {
            // 构建返回参数对象
            BPubOrdersListResponseDto dto = buildResponse(BPubOrdersListResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
                        "用户未登录！");
            } else {
                // 查询及封装
                PageBounds pageBounds = new PageBounds();
                pageBounds.setContainsTotalCount(true);
                pageBounds.getOrders().add(new Order("requirement_create_time", Direction.DESC, ""));
                pageBounds.setLimit(CommonUtils.parseInteger(param.getLimit()));
                pageBounds.setPage(CommonUtils.parseInteger(param.getPage()));
                if (param.getLimit() == null || "".equals(param.getLimit())) {
                    pageBounds.setLimit(10);
                }
                if (param.getPage() == null || "".equals(param.getPage())) {
                    pageBounds.setPage(1);
                }
                PageList<BPubOrdersListDto> list = pubOrdersService.queryBOrderList(param, pageBounds);
                List<BPubOrdersListDto> resList = new ArrayList<BPubOrdersListDto>();
                if(list!=null&&list.size()!=0){
                    dto.setPageNow(list.getPaginator().getPage()+"");
                    dto.setTotalCount(list.getPaginator().getTotalCount()+"");
                    dto.setTotalPages(list.getPaginator().getTotalPages()+"");
                    for(BPubOrdersListDto t:list){
                        Long user1 = CommonUtils.parseLong(t.getRequirementById());
                        Long user2 = CommonUtils.parseLong(t.getOrderById());
                        MsgGroup ms = messageService.getMsgGroupByUser(user1,user2);
                        if(ms!=null){
                            t.setGroupId(ms.getId()+"");
                        }
                        resList.add(t);
                    }
                    dto.setOrdersList(resList);
                }
                outputSuccessReponse(response, dto);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(),
                    Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    
    
    /**
     * B端订单详情
     * 
     */
    @RequestMapping("/getOrdersDetailsForB")
    public void getOrdersDetailsForB(HttpServletRequest request,HttpServletResponse response,BPubOrdersDetailsRequestDto param) {
        try {
            // 构建返回参数对象
        	BPubOrdersDetailsResponseDto dto = buildResponse(BPubOrdersDetailsResponseDto.class, param);
            // 参数校验
            if (!checkRequest(param)) {
                outputParamCheckError(response, dto);
                return;
            }
            if (!isLogin(param)) {
                outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
                        "用户未登录！");
                return;
            } 
            if (param.getOrderId()==null){
            	outputReponse(response, dto, Constants.RESULT_CODE_FAIL,
                        "订单id不能为空！");
                return;
            }
            pubOrdersService.getOrdersDetailsForB(param, dto);
            outputSuccessReponse(response, dto);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            outputReponse(response, new ResponseDto(),
                    Constants.RESULT_CODE_FAIL, "未知错误!");
        }
    }
    
}
