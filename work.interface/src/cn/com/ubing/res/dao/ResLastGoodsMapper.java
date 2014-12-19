package cn.com.ubing.res.dao;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.res.dto.WelfareListDto;
import cn.com.ubing.res.dto.WelfareListRequestDto;
import cn.com.ubing.res.model.ResLastGoods;

public interface ResLastGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResLastGoods record);

    ResLastGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ResLastGoods record);
    
    ResLastGoods selectFirst();
    /**
     * 首页焦点图
     * 
     * @author 邱全松 2014-11-20 下午1:42:28
     * @return
     */
    List<ResLastGoods> selectFocusList();
    /**
     * 查询游福利列表
     * 
     * @author 邱全松 2014-11-28 下午3:17:22
     * @param param
     * @param pageBounds
     * @return
     */
    PageList<WelfareListDto> queryWelfareList(WelfareListRequestDto param,PageBounds pageBounds);
}