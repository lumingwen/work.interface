/**
 * 
 */
package cn.com.ubing.pub.service;


import java.util.List;

import cn.com.ubing.pub.dto.CPubPlanDto;
import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.PubPlanDto;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


/**
 * 方案service
 * @author lumw
 * 
 *
 */
public interface PubPlanServiceI {
    

    /**
     * 根据需求id查询相关方案信息列表
     * 
     * @author Administrator 2014-6-9 上午10:56:24
     * @param requirementId
     * @param pageBounds
     * @return
     */
    List<CPubPlanDto> listPubPlanByPage(CRequirementDetailRequestDto param,PageBounds pageBounds);
    


}
