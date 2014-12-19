package cn.com.ubing.rms.service;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.rms.dto.CMainViewResponseDto;

/**
 * c端主页信息
 *  
 * @author 邱全松 2014-11-17 下午2:10:51
 */
public interface CMainViewServiceI {
    /**
     * 获取主页信息
     * 
     * @author 邱全松 2014-11-17 下午2:12:24
     * @param param
     * @return
     */
    public CMainViewResponseDto getMainViewDto(RequestDto param);
}
