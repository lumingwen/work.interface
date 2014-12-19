package cn.com.ubing.pub.dao;

import java.util.List;

import cn.com.ubing.pub.dto.LibraryPlanDetailRequestDto;
import cn.com.ubing.pub.dto.LibraryPlanDetailResponseDto;
import cn.com.ubing.pub.dto.LibraryPlanListDto;
import cn.com.ubing.pub.dto.LibraryPlanListRequestDto;
import cn.com.ubing.pub.model.PubPlanLibrary;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface PubPlanLibraryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubPlanLibrary record);

    int insertSelective(PubPlanLibrary record);

    PubPlanLibrary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PubPlanLibrary record);

    int updateByPrimaryKey(PubPlanLibrary record);
    /**
     * 查询方案库方案详细信息
     * 
     * @author 邱全松 2014-6-25 下午6:57:18
     * @param dto
     * @return
     */
    LibraryPlanDetailResponseDto getLibraryPlanDetail(LibraryPlanDetailRequestDto dto);
    /**
     * (B端)获取方案库方案列表信息
     * @author 邱全松 2014-6-25 下午8:28:54
     * @param dto
     * @return
     */
    List<LibraryPlanListDto> queryLibraryPlanList(LibraryPlanListRequestDto dto,PageBounds pageBounds);
}