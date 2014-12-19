package cn.com.ubing.res.dao;

import java.util.Date;

import cn.com.ubing.res.model.ResWxAccessToken;

/**
 * 保存微信token
 * @author zhangxujun
 * 
 *
 */
public interface ResWxAccessTokenMapper {
    
    
    int deleteByPrimaryKey(Long id);

    int insert(ResWxAccessToken record);

    ResWxAccessToken selectByPrimaryKey(Long id);

    int updateByPrimaryKey(ResWxAccessToken record);
    
    
    /**
     * 根据appId和appSecret查询为过期的token,若无则返回null
     * @param appId
     * @param appSecret
     * @return
     */
    ResWxAccessToken getByAppIdAndSecret(String appId,String appSecret,Date now);
}