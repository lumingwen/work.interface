package cn.com.ubing.pub.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import cn.com.ubing.pub.dto.AppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.AppraisalDto;
import cn.com.ubing.pub.dto.AppraisalListRequestDto;
import cn.com.ubing.pub.dto.PubAppraisalDto;
import cn.com.ubing.pub.dto.PubAppraisalListDto;
import cn.com.ubing.pub.model.PubAppraisal;

public interface PubAppraisalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubAppraisal record);

    int insertSelective(PubAppraisal record);

    PubAppraisal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubAppraisal record);

    int updateByPrimaryKey(PubAppraisal record);

    PubAppraisalDto appraisalDone(PubAppraisalDto record);

    PubAppraisalDto appraisalReject(PubAppraisalDto record);

    PubAppraisalDto appraisalResponse(PubAppraisalDto record);
    
    List<PubAppraisalListDto> queryAppraisalList(AppraisalListRequestDto dto,PageBounds pageBounds);
    
    AppraisalDto appraisalDetail(AppraisalDetailRequestDto dto);
    /**
     * 根据方案id和评价人查询评价信息
     * 
     * @author 邱全松 2014-11-19 下午2:22:46
     * @param param
     * @return
     */
    PubAppraisal selectByPlanIdAndFromId(PubAppraisal param);

}