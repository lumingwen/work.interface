package cn.com.ubing.res.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.res.dto.ResCommonContactsDetailRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsDetailResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsDto;
import cn.com.ubing.res.dto.ResCommonContactsListRequestDto;
import cn.com.ubing.res.model.ResCommonContacts;

public interface ResCommonContactsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResCommonContacts record);

    ResCommonContacts selectByPrimaryKey(Long id);
    
    /**
     * 根据姓名和电话查询对应的联系人信息
     * 
     * @author 邱全松 2014-10-31 下午3:38:38
     * @param id
     * @return
     */
    ResCommonContacts selectByNameAndTel(ResCommonContacts param);

    int updateByPrimaryKey(ResCommonContacts record);
    
    PageList<ResCommonContactsDto> queryList(ResCommonContactsListRequestDto param,PageBounds pageBounds);
    
    ResCommonContactsDetailResponseDto getDetail(ResCommonContactsDetailRequestDto param);
}