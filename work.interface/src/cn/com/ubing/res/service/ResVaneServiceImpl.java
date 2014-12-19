package cn.com.ubing.res.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.res.dao.ResDictMapper;
import cn.com.ubing.res.dao.ResVaneLineAnalysisMapper;
import cn.com.ubing.res.dto.VaneDetailDto;
import cn.com.ubing.res.dto.VaneLineAnalysisDto;
import cn.com.ubing.res.model.ResDict;
import cn.com.ubing.res.model.ResVaneLineAnalysis;
import cn.com.ubing.rms.dao.RmsUserMapper;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;
/**
 * 风向标service
 * @author zhangxujun
 * 
 *
 */
@Service("resVaneService")
public class ResVaneServiceImpl implements ResVaneServiceI {
    
    /**
     * 风向标(经营线路分析)dao
     */
    @Autowired
    private ResVaneLineAnalysisMapper resVaneLineAnalysisMapper;
    
    /**
     * 用户dao
     */
    @Autowired
    private RmsUserMapper rmsUserMapper;
    
    /**
     * 字典dao
     */
    @Autowired
    private ResDictMapper resDictMapper;

    /**
     * 查询用户经营线路风向标字符串(第一个经营线路)
     * @param userId 用户id
     * @return 字符串
     */
    @Override
    public String generateFristLineAnalysisString(Long userId) {
	List<VaneLineAnalysisDto> list = generateLineAnalysisVane(userId);
	StringBuffer sb = new StringBuffer();
	if (CollectionUtils.isNotEmpty(list)) {
	    VaneLineAnalysisDto dto = list.get(0);
	    sb.append(dto.getLineName()).append("咨询量本月")
		    .append(dto.getCurrentMonthCount()).append("个,上月此时")
		    .append(dto.getLastMonthCount()).append("个,同比增长")
		    .append(dto.getAddPercent()).append(".");
	}
	return sb.toString();
    }
    
    
    /**
     * 查询经营线路风向标
     * @param userId 用户id
     * @return 集合
     */
    @Override
    public List<VaneLineAnalysisDto> generateLineAnalysisVane(Long userId){
	List<VaneLineAnalysisDto> list = new ArrayList<VaneLineAnalysisDto>();
	List<Long> lines = rmsUserMapper.listBusinessUserLine(userId);
	for (int i=0;i<lines.size();i++){
	    //查询数据
	    ResVaneLineAnalysis ra = resVaneLineAnalysisMapper.getResVaneLineAnalysisByLineId(lines.get(i));
	    if (ra==null){
		//假数据
		ra = new ResVaneLineAnalysis();
		ra.setCreateTime(new Date());
		ra.setUpdateTime(new Date());
		ra.setDeleteFlag(Constants.DEL_FLAG_NO);
		ra.setLineId(lines.get(i));
		ra.setLastMonthCount(new Random().nextInt(1000));
		ra.setCurrentMonthCount(new Random().nextInt(1000));
		ra.setStatisticsTime(new Date());
		resVaneLineAnalysisMapper.insert(ra);
	    }
	    //封装
	    VaneLineAnalysisDto dto = new VaneLineAnalysisDto();
	    dto.setRank(i+1);
	    dto.setLastMonthCount(ra.getLastMonthCount());
	    dto.setCurrentMonthCount(ra.getCurrentMonthCount());
	    dto.setAddPercent(CommonUtils.getPercent(dto.getLastMonthCount(),dto.getCurrentMonthCount()));
	    ResDict dict = resDictMapper.selectByPrimaryKey(lines.get(i));
	    if (dict!=null){
		dto.setLineName(dict.getCname());
	    }
	    list.add(dto);
	}
	return list;
    }
    
    
    
    /**
     * 查询热门城市风向标
     * @param userId 用户id
     * @return 集合
     */
    @Override
    public List<VaneDetailDto> generateHotCityVane(Long userId){
	return null;
    }
    
    /**
     * 查询搜索关键字风向标(第一个经营线路)
     * @param userId 用户id
     * @return 集合
     */
    @Override
    public List<VaneDetailDto> generateKeywordsVane(Long userId){
	return null;
    }

}
