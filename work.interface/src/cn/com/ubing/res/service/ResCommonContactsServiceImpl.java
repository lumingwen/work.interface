package cn.com.ubing.res.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.ubing.res.dao.ResCommonContactsMapper;
import cn.com.ubing.res.dto.ResCommonContactsDetailRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsDetailResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsDto;
import cn.com.ubing.res.dto.ResCommonContactsListRequestDto;
import cn.com.ubing.res.dto.ResCommonContactsListResponseDto;
import cn.com.ubing.res.dto.ResCommonContactsSaveRequestDto;
import cn.com.ubing.res.model.ResCommonContacts;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;
@Service("resCommonContactsService")
public class ResCommonContactsServiceImpl implements ResCommonContactsServiceI {
    @Autowired
    private ResCommonContactsMapper resCommonContactsMapper;
    @Override
    public ResCommonContactsListResponseDto queryList(ResCommonContactsListRequestDto param, PageBounds pageBounds) {
        // TODO Auto-generated method stub
        ResCommonContactsListResponseDto res = new ResCommonContactsListResponseDto();
        PageList<ResCommonContactsDto> pageList = resCommonContactsMapper.queryList(param, pageBounds);
        res.setPageNow(pageList.getPaginator().getPage()+"");
        res.setTotalPages(pageList.getPaginator().getTotalPages()+"");
        res.setTotalCount(pageList.getPaginator().getTotalCount()+"");
        res.setContactsList(pageList);        
        return res;
    }

    @Override
    public ResCommonContactsDetailResponseDto getDetail(ResCommonContactsDetailRequestDto param) {
        // TODO Auto-generated method stub
        return resCommonContactsMapper.getDetail(param);
    }

    @Override
    public boolean saveContacts(ResCommonContactsSaveRequestDto param) {
        // TODO Auto-generated method stub
        boolean flag = false;
        String contactId = param.getContactId();
        ResCommonContacts mo = null;
        if(contactId!=null&&!"".equals(contactId)){
            mo = resCommonContactsMapper.selectByPrimaryKey(CommonUtils.parseLong(contactId));
            mo.setUpdateTime(new Date());
            mo.setUserId(CommonUtils.parseLong(param.getUid()));
            mo.setName(param.getName());
            mo.setTel(param.getTel());
            mo.setCertificateTypeId(CommonUtils.parseLong(param.getCertificateTypeId()));
            mo.setCertificateCode(param.getCertificateCode());
            resCommonContactsMapper.updateByPrimaryKey(mo);
            flag = true;
        }else{
            mo = new ResCommonContacts();
            mo.setCreateTime(new Date());
            mo.setUpdateTime(new Date());
            mo.setDeleteFlag(Constants.DEL_FLAG_NO);
            mo.setUserId(CommonUtils.parseLong(param.getUid()));
            mo.setName(param.getName());
            mo.setTel(param.getTel());
            mo.setCertificateTypeId(CommonUtils.parseLong(param.getCertificateTypeId()));
            mo.setCertificateCode(param.getCertificateCode());
            resCommonContactsMapper.insert(mo);
            flag=true;
        }
        return flag;
    }

}
