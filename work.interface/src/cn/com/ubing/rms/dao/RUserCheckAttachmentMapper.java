package cn.com.ubing.rms.dao;

import cn.com.ubing.rms.model.RUserCheckAttachment;

public interface RUserCheckAttachmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RUserCheckAttachment record);

    int insertSelective(RUserCheckAttachment record);

    RUserCheckAttachment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RUserCheckAttachment record);

    int updateByPrimaryKey(RUserCheckAttachment record);
    /**
     * 根据user_check_id删除以后的关联关系
     * 
     * @author 邱全松 2014-6-26 下午5:58:44
     * @param checkId
     * @return
     */
    int deleteHistoryRecord(Long checkId);
}