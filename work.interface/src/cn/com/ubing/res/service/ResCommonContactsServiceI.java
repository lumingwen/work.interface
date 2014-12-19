package cn.com.ubing.res.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import cn.com.ubing.res.dto.ResCommonContactsDetailRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsDetailResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsListRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsListResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsSaveRequestDto;

public interface ResCommonContactsServiceI {
    /**
     * 查询常用联系人列表
     * 
     * @author 邱全松 2014-10-22 上午11:24:36
     * @param param
     * @return
     */
    public ResCommonContactsListResponseDto queryList(ResCommonContactsListRequestDto param,PageBounds pageBounds);
    /**
     * 查询常用联系人详细信息
     * 
     * @author 邱全松 2014-10-22 上午11:25:29
     * @param param
     * @return
     */
    public ResCommonContactsDetailResponseDto getDetail(ResCommonContactsDetailRequestDto param);
    /**
     * 保存常用联系人
     * 
     * @author 邱全松 2014-10-22 上午11:27:59
     * @param param
     * @return
     */
    public boolean saveContacts(ResCommonContactsSaveRequestDto param);
    
}
