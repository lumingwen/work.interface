package cn.com.ubing.msg.dao;

import java.util.List;

import cn.com.ubing.msg.model.MsgBlacklist;

/**
 * 黑名单
 * @author zhangxujun
 * 
 *
 */
public interface MsgBlacklistMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(MsgBlacklist record);

    MsgBlacklist selectByPrimaryKey(Long id);

    int updateByPrimaryKey(MsgBlacklist record);
    
    /**
     * 查询黑名单
     * @param param
     * @return
     */
    List<MsgBlacklist> listMsgBlacklist(MsgBlacklist param);
}