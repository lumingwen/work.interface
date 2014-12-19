package cn.com.ubing.pub.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import cn.com.ubing.pub.dto.AppraisalDetailRequestDto;
import cn.com.ubing.pub.dto.AppraisalDto;
import cn.com.ubing.pub.dto.AppraisalListRequestDto;
import cn.com.ubing.pub.dto.AppraisalSaveRequestDto;
import cn.com.ubing.pub.dto.PubAppraisalListDto;

/**
 * 评价信息
 * 
 * @author 邱全松 2014-6-27 下午2:03:09
 */
public interface AppraisalServiceI {
    /**
     * （B端）获取评价详细信息
     * 
     * @author 邱全松 2014-6-27 下午2:04:43
     * @param dto中方案ID必填
     * @return
     */
    public AppraisalDto getAppraisalDetail(AppraisalDetailRequestDto dto);

    /**
     * （B端）获取评价列表信息
     * 
     * @author 邱全松 2014-6-27 下午2:06:42
     * @param dto
     * @return
     */
    public List<PubAppraisalListDto> getAppraisalList(AppraisalListRequestDto dto,PageBounds pageBounds);

    /**
     * （B端）保存评价信息
     * 
     * @author 邱全松 2014-6-27 下午2:07:58
     * @param dto
     * @return
     */
    public int saveAppraisal(AppraisalSaveRequestDto dto);
}
