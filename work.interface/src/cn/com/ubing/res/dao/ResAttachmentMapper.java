package cn.com.ubing.res.dao;

import java.util.List;

import cn.com.ubing.res.model.ResAttachment;

public interface ResAttachmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResAttachment record);

    int insertSelective(ResAttachment record);

    ResAttachment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResAttachment record);

    int updateByPrimaryKey(ResAttachment record);
    
    List<ResAttachment> selectByRel(ResAttachment record);
}