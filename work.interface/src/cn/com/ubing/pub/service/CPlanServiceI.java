package cn.com.ubing.pub.service;

import cn.com.ubing.pub.dto.OperationPlanRequestDto;
import cn.com.ubing.pub.dto.OperationPlanResponseDto;

public interface CPlanServiceI {
    /**
     * 采纳或拒绝方案
     * 
     * @author 邱全松 2014-11-5 上午9:52:38
     * @param param
     * @return 0失败  1成功 
     */
    OperationPlanResponseDto operationPlan(OperationPlanRequestDto param);
}
