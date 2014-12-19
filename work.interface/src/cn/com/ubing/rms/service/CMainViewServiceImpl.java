package cn.com.ubing.rms.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.res.dao.ResAttachmentMapper;
import cn.com.ubing.res.dao.ResLastGoodsMapper;
import cn.com.ubing.res.dao.ResLastGoodsPriceQuantityMapper;
import cn.com.ubing.res.model.ResAttachment;
import cn.com.ubing.res.model.ResLastGoods;
import cn.com.ubing.res.model.ResLastGoodsPriceQuantity;
import cn.com.ubing.rms.dto.CMainFocusDto;
import cn.com.ubing.rms.dto.CMainLastGoodsDto;
import cn.com.ubing.rms.dto.CMainViewResponseDto;

@Service("cMainViewService")
public class CMainViewServiceImpl implements CMainViewServiceI {
    @Autowired
    private ResLastGoodsMapper resLastGoodsMapper;
    @Autowired
    private ResLastGoodsPriceQuantityMapper resLastGoodsPriceQuantityMapper;
    @Autowired
    private ResAttachmentMapper resAttachmentMapper;
    @Value(value = "${imageAttachmentHostAddr}")
    private String imageAttachmentHostAddr;

    @Override
    public CMainViewResponseDto getMainViewDto(RequestDto param) {
        CMainViewResponseDto res = new CMainViewResponseDto();
        CMainLastGoodsDto cMainLastGoodsDto = new CMainLastGoodsDto();
        ResLastGoods resLastGoods = resLastGoodsMapper.selectFirst();
        if (resLastGoods != null) {
            ResLastGoodsPriceQuantity resLastGoodsPriceQuantity = resLastGoodsPriceQuantityMapper.selectFirstById(resLastGoods.getId());
            if (resLastGoodsPriceQuantity != null) {
                cMainLastGoodsDto.setQuantity(resLastGoodsPriceQuantity.getQuantity() + "");
                cMainLastGoodsDto.setSinglePrice(resLastGoodsPriceQuantity.getSinglePrice() + "");
            }
            cMainLastGoodsDto.setTitle(resLastGoods.getTitle());
            Date endTime = resLastGoods.getEndTime();
            cMainLastGoodsDto.setEndTime((endTime.getTime()-new Date().getTime())+"");
            cMainLastGoodsDto.setBirthland(resLastGoods.getDeparturePlace());
            ResAttachment att = resAttachmentMapper.selectByPrimaryKey(resLastGoods.getMainImageId());
            cMainLastGoodsDto.setImageUrl(imageAttachmentHostAddr + att.getSavePath());
            cMainLastGoodsDto.setLastGoodsId(resLastGoods.getId() + "");
            res.setLastGoods(cMainLastGoodsDto);
        }
        List<ResLastGoods> resLastGoodsList = resLastGoodsMapper.selectFocusList();
        List<CMainFocusDto> focus = new ArrayList<CMainFocusDto>();
        for (ResLastGoods goods : resLastGoodsList) {
            CMainFocusDto temp = new CMainFocusDto();
            temp.setType("1");// 1尾单，2活动
            temp.setLastGoodsId(goods.getId() + "");
            ResAttachment att = resAttachmentMapper.selectByPrimaryKey(goods.getMainImageId());
            temp.setUrl(imageAttachmentHostAddr + att.getSavePath());
            focus.add(temp);
        }
        res.setFocus(focus);
        return res;
    }

}
