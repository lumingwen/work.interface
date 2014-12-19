package cn.com.ubing.rms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.res.dao.RUserBusinessLineMapper;
import cn.com.ubing.res.dto.ResDictDto;
import cn.com.ubing.res.model.RUserBusinessLine;
import cn.com.ubing.rms.dao.RmsUserBusinessTypeMapper;
import cn.com.ubing.rms.dto.BusinessTypeAndLinesRequestDto;
import cn.com.ubing.rms.dto.RmsUserBusinessTypeDto;
import cn.com.ubing.rms.model.RmsUserBusinessType;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

/**
 * 经营类型
 * 
 * @author lumingwen
 * 
 * 
 */
@Service("rmsUserBusinessTypeService")
public class RmsUserBusinessTypeServiceImpl implements RmsUserBusinessTypeServiceI {
    /**
     * 经营类型dao
     */
    @Autowired
    private RmsUserBusinessTypeMapper rmsUserBusinessTypeMapper;

    /**
     * 主营线路dao
     */
    @Autowired
    private RUserBusinessLineMapper rUserBusinessLineMapper;

    /**
     * 保存或更新经营类型
     * 
     * @param user
     *            经营类型
     */
    @Override
    public boolean saveOrUpdateRmsUserBusinessType(List<RmsUserBusinessType> rmsUserBusinessType, String[] btypeArray) {
        boolean flag = true;

        // 判断该线路存不存在
        // 找出不相同的线路选择
        // 有两种情况，1：用户曾经选过该路线 2：用户选了之后又不选择该路线
        boolean flag1 = false;
        for (int i = 0; i < btypeArray.length; i++) {
            flag1 = false;
            for (int j = 0; j < rmsUserBusinessType.size(); j++) {
                if (Integer.parseInt(btypeArray[i]) == rmsUserBusinessType.get(j).getBusinessType()) {
                    // 线路选择不变，例如：原来选择1号线路，现在1号线路任然选择
                    flag1 = true;
                }
            }
            if (!flag1) {
                RmsUserBusinessType rmsType = new RmsUserBusinessType();
                rmsType.setCreateTime(new Date());
                rmsType.setUpdateTime(new Date());
                rmsType.setDeleteFlag(Constants.DEL_FLAG_NO);
                rmsType.setUserId(rmsUserBusinessType.get(0).getUserId());
                rmsType.setBusinessType(Integer.parseInt(btypeArray[i]));
                if (rmsUserBusinessTypeMapper.insert(rmsType) != 1) {
                    flag = false;
                    return flag;
                }
            }
        }
        // 查找上次选择，这次没有选择的路线，并且删除
        boolean flag2 = false;
        for (int j = 0; j < rmsUserBusinessType.size(); j++) {
            flag2 = false;
            for (int i = 0; i < btypeArray.length; i++) {
                if (Integer.parseInt(btypeArray[i]) == rmsUserBusinessType.get(j).getBusinessType()) {
                    // 线路选择不变，例如：原来选择1号线路，现在1号线路任然选择
                    flag2 = true;
                }
            }
            if (!flag2) {
                if (rmsUserBusinessTypeMapper.deleteByPrimaryKey(rmsUserBusinessType.get(j).getId()) != 1) {
                    flag = false;
                    return flag;
                }
            }

        }

        return flag;
    }

    /**
     * 保存经营类型
     * 
     * @param user
     *            经营类型
     */
    @Override
    public boolean saveRmsUserBusinessType(String[] btypeArray, String userId) {
        boolean flag = true;
        for (int i = 0; i < btypeArray.length; i++) {
            RmsUserBusinessType rmsType = new RmsUserBusinessType();
            rmsType.setCreateTime(new Date());
            rmsType.setUpdateTime(new Date());
            rmsType.setDeleteFlag(Constants.DEL_FLAG_NO);
            rmsType.setUserId(Long.parseLong(userId));
            rmsType.setBusinessType(Integer.parseInt(btypeArray[i]));
            if (rmsUserBusinessTypeMapper.insert(rmsType) != 1) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }

    /**
     * 根据用户查出相应的线路信息
     * 
     * @author Administrator 2014年6月25日 下午2:00:43
     * @param userid
     * @return
     */
    @Override
    public List<RmsUserBusinessType> selectByUserId(Long userid) {

        return rmsUserBusinessTypeMapper.selectByUserId(userid);
    }

    /**
     * 保存或更新主营线路
     * 
     * @param user
     *            主营线路
     */
    @Override
    public boolean saveRmsUserBusinessLine(String[] lineArray, String userId) {
        boolean flag = true;
        for (int i = 0; i < lineArray.length; i++) {
            RUserBusinessLine rmsBusinessLine = new RUserBusinessLine();
            rmsBusinessLine.setCreateTime(new Date());
            rmsBusinessLine.setUpdateTime(new Date());
            rmsBusinessLine.setDeleteFlag(Constants.DEL_FLAG_NO);
            rmsBusinessLine.setUserId(Long.parseLong(userId));
            rmsBusinessLine.setLineId(Long.parseLong(lineArray[i]));
            if (rUserBusinessLineMapper.insert(rmsBusinessLine) != 1) {
                flag = false;
                return flag;
            }
        }
        return flag;
    }
    
    @Override
    public List<ResDictDto> getLinesDtoByUser(Long userId, Integer businessType) {
        // TODO Auto-generated method stub
        return rUserBusinessLineMapper.getLinesDtoByUser(userId, businessType);
    }
    
    @Override
    public List<RUserBusinessLine> getLinesByUser(Long userId, Integer businessType) {
        // TODO Auto-generated method stub
        return rUserBusinessLineMapper.getLinesByUser(userId, businessType);
    }

    @Override
    public List<RmsUserBusinessTypeDto> getBusinessTypeByUser(Long userId) {
        // TODO Auto-generated method stub
        return rmsUserBusinessTypeMapper.getBusinessTypeByUser(userId);
    }

    @Override
    public boolean saveOrUpdateBusinessTypeAndLines(BusinessTypeAndLinesRequestDto dto) {
        // TODO Auto-generated method stub
        boolean flag = false;
        try {
            // 删除已有线路信息数据
            rUserBusinessLineMapper.deleteByUserIdAndType(CommonUtils.parseLong(dto.getUid()),
                    CommonUtils.parseInteger(dto.getBusinessType()));
            // 删除已有的主营业务类型信息数据
            rmsUserBusinessTypeMapper.deleteByUserIdAndType(CommonUtils.parseLong(dto.getUid()),
                    CommonUtils.parseInteger(dto.getBusinessType()));
            // 插入新主营范围信息数据
            RmsUserBusinessType type = new RmsUserBusinessType();
            type.setBusinessType(CommonUtils.parseInteger(dto.getBusinessType()));
            type.setUserId(CommonUtils.parseLong(dto.getUid()));
            type.setDeleteFlag(Constants.DEL_FLAG_NO);
            type.setCreateTime(new Date());
            type.setUpdateTime(new Date());
            rmsUserBusinessTypeMapper.insert(type);
            // 插入新经营线路信息数据
            String[] lines = dto.getLineIds().split(",");
            RUserBusinessLine line = null;
            for (int i = 0; i < lines.length; i++) {
                line = new RUserBusinessLine();
                line.setCreateTime(new Date());
                line.setDeleteFlag(Constants.DEL_FLAG_NO);
                line.setUpdateTime(new Date());
                line.setUserId(CommonUtils.parseLong(dto.getUid()));
                line.setLineId(CommonUtils.parseLong(lines[i]));
                line.setBusinessType(CommonUtils.parseInteger(dto.getBusinessType()));
                rUserBusinessLineMapper.insert(line);
            }
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
