package cn.com.ubing.pub.dao;

import cn.com.ubing.pub.model.PubRequirementCheck;

public interface PubRequirementCheckMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PubRequirementCheck record);

    /**
     * 根据需求id和需求类型查询需求的审核信息
     * 
     * @author 邱全松 2014-9-17 下午5:21:12
     * @param param
     * @return
     */
    PubRequirementCheck selectByIdAndType(PubRequirementCheck param);
    
    PubRequirementCheck selectByPrimaryKey(Long id);

    int updateByPrimaryKey(PubRequirementCheck record);
}