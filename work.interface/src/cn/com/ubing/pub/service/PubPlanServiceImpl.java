/**
 * 
 */
package cn.com.ubing.pub.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.pub.dao.PubPlanMapper;
import cn.com.ubing.pub.dto.CPubPlanDto;
import cn.com.ubing.pub.dto.CRequirementDetailRequestDto;
import cn.com.ubing.pub.dto.PubPlanDto;
import cn.com.ubing.rms.dao.RmsUserTitleMapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * 方案services
 * @author lumw
 * 
 *
 */
@Service("pubPlanService")
public class PubPlanServiceImpl implements PubPlanServiceI {
    
    /**
     * 方案dao
     */
    @Autowired
    private PubPlanMapper pubPlanMapper;
    @Autowired
    private RmsUserTitleMapper rmsUserTitleMapper;

    @Override
    public List<CPubPlanDto> listPubPlanByPage(CRequirementDetailRequestDto param, PageBounds pageBounds) {
        List<CPubPlanDto> pubPlanDtoList = pubPlanMapper.listPubPlanByPage(param, pageBounds);
        return pubPlanDtoList;
    }


}
