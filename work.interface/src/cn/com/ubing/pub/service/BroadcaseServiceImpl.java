package cn.com.ubing.pub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hlvtech.ubing.common.utils.CommonUtils;

import cn.com.ubing.pub.dao.PubBroadcastSendDetailMapper;
import cn.com.ubing.pub.dao.PubBroadcastSendMapper;
import cn.com.ubing.pub.dto.BroadcastDto;
import cn.com.ubing.pub.dto.PubBroadcastRequestDto;
import cn.com.ubing.pub.dto.PubBroadcastResponseDto;
import cn.com.ubing.pub.model.PubBroadcastSend;

@Service("broadcaseService")
public class BroadcaseServiceImpl implements BroadcastServiceI {
    @Autowired
    private PubBroadcastSendDetailMapper pubBroadcastSendDetailMapper;
    @Autowired
    private PubBroadcastSendMapper pubBroadcastSendMapper;
    @Override
    public PubBroadcastResponseDto getBroadcast(PubBroadcastRequestDto dto,PubBroadcastResponseDto res) {
        // 获取最新旅游播报
        PageBounds pageBounds = new PageBounds();
        pageBounds.setLimit(1);
        pageBounds.setPage(CommonUtils.parseInteger(dto.getPage()));
        PageList<PubBroadcastSend> broadcastList = pubBroadcastSendMapper.listBroadcastSendInfo(CommonUtils.parseLong(dto.getUid()), pageBounds);
        res.setTotalCount(broadcastList.getPaginator().getTotalCount()+"");
        res.setTotalPages(broadcastList.getPaginator().getTotalPages()+"");
        res.setPageNow(broadcastList.getPaginator().getPage()+"");
        if(broadcastList!=null&&broadcastList.size()>0){
            List<BroadcastDto> list = pubBroadcastSendDetailMapper.getBroadcastListBySendId(broadcastList.get(0).getId());
            List<BroadcastDto> resL = new ArrayList();
            for(BroadcastDto broad:list){
                String url = broad.getUrl();
                if(url!=null&&url.contains("?")){
                    url = url+"&source=mobile";
                }else if(url!=null&&!url.contains("?")){
                    url = url+"?source=mobile";
                }
                broad.setUrl(url);
                resL.add(broad);
            }
            res.setBroadcastList(resL);
            // 更新获取记录
            pubBroadcastSendDetailMapper.updateSendStatusByUser(dto);
        }
        return res;
    }

}
