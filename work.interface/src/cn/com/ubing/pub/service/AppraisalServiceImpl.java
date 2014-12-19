package cn.com.ubing.pub.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;


import cn.com.ubing.pub.dao.PubAppraisalMapper;
import cn.com.ubing.pub.dto.AppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.AppraisalDto;
import cn.com.ubing.pub.dto.AppraisalListRequestDto;
import cn.com.ubing.pub.dto.AppraisalSaveRequestDto;
import cn.com.ubing.pub.dto.PubAppraisalListDto;
import cn.com.ubing.pub.model.PubAppraisal;

@Service("appraisalService")
public class AppraisalServiceImpl implements AppraisalServiceI {
    @Autowired
    private PubAppraisalMapper pubAppraisalMapper;
    @Override
    public AppraisalDto getAppraisalDetail(AppraisalDetailRequestDto dto) {
        // TODO Auto-generated method stub
        return pubAppraisalMapper.appraisalDetail(dto);
    }

    @Override
    public List<PubAppraisalListDto> getAppraisalList(AppraisalListRequestDto dto,PageBounds pageBounds) {
        // TODO Auto-generated method stub
        return pubAppraisalMapper.queryAppraisalList(dto,pageBounds);
    }

    @Override
    public int saveAppraisal(AppraisalSaveRequestDto dto) {
        // TODO Auto-generated method stub
        PubAppraisal param = new PubAppraisal();
        param.setCreateTime(new Date());
        param.setUpdateTime(new Date());
        param.setDeleteFlag(Constants.DEL_FLAG_NO);
        param.setFromId(CommonUtils.parseLong(dto.getUid()));
        param.setToId(CommonUtils.parseLong(dto.getRequirementUserId()));
        param.setContent(dto.getAppraisalResponseContent());
        param.setPlanId(CommonUtils.parseLong(dto.getPlanId()));
        param.setType(2);//方案被采纳才能进行回评，此处设置为方案已被采纳
        param.setStatus(1);//默认为被开启        
        return pubAppraisalMapper.insert(param);
    }

}
