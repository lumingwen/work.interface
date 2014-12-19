/**
 * 
 */
package cn.com.ubing.res.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hlvtech.ubing.common.constant.Constants;
import com.hlvtech.ubing.common.utils.CommonUtils;

import cn.com.ubing.res.dao.ResDictExpandMapper;
import cn.com.ubing.res.dao.ResDictMapper;
import cn.com.ubing.res.dto.ResDictDto;
import cn.com.ubing.res.dto.ResDictExpandDto;
import cn.com.ubing.res.dto.ResDictExpandRequestDto;
import cn.com.ubing.res.dto.ResDictRequestDto;
import cn.com.ubing.res.dto.ResDictResponseDto;
import cn.com.ubing.res.model.ResDict;

/**
 * 字典service
 * 
 * @author zhangxujun
 * 
 * 
 */
@Service("resDictService")
public class ResDictServiceImpl implements ResDictServiceI {

    /**
     * 字典dao
     */
    @Autowired
    private ResDictMapper resDictMapper;
    @Autowired
    private ResDictExpandMapper resDictExpandMapper;
    
    /**
     * 注入配置文件
     */
    @Value(value = "${manageHostAddr}")
    private String manageHostAddr;
    
    /**
     * 根据类型查询所有字典
     * 
     * @param type
     * @return
     */
    @Override
    public List<ResDict> listAllDictByType(String type) {
        ResDict param = new ResDict();
        param.setType(type);
        return resDictMapper.listAllDict(param);
    }

    /**
     * 根据类型查询所有字典
     * 
     * @param type
     * @return
     */
    @Override
    public List<ResDictDto> listAllDictDtoByType(String type) {
        ResDict param = new ResDict();
        param.setType(type);
        return resDictMapper.listAllDictDto(param);
    }

    /**
     * 插入字典
     * 
     * @param dict
     */
    @Override
    public void insertDict(ResDict dict) {
        resDictMapper.insert(dict);
    }

    /**
     * 级联删除字典
     * 
     * @param id
     */
    @Override
    public void removeDict(Long id) {
        ResDict param = new ResDict();
        param.setPid(id);
        List<ResDict> list = resDictMapper.listAllDict(param);
        if (CollectionUtils.isNotEmpty(list)) {
            for (ResDict dict : list) {
                removeDict(dict.getId());
            }
        }
        resDictMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改字典
     * 
     * @param dict
     */
    @Override
    public void updateDict(ResDict dict) {
        ResDict db = resDictMapper.selectByPrimaryKey(dict.getId());
        if (db != null) {
            db.setCname(dict.getCname());
            db.setUpdateTime(new Date());
            resDictMapper.updateByPrimaryKey(db);
        }
    }

    /**
     * 根据类型和名称查询字典
     * 
     * @param type
     * @param name
     * @return
     */
    @Override
    public List<ResDict> listDictByTypeAndName(String type, String name) {
        ResDict param = new ResDict();
        param.setType(type);
        param.setCname(name);
        List<ResDict> list = resDictMapper.listAllDict(param);
        return resDictMapper.listAllDict(param);
    }

    /**
     * 根据类型和父id查询字典
     * 
     * @param type
     * @param pid
     * @return
     * @author lumingwen
     */
    @Override
    public List<ResDict> listDictByTypeAndPid(String type, Long pid) {
        ResDict param = new ResDict();
        param.setType(type);
        param.setPid(null);
        List<ResDict> list = resDictMapper.listAllDict(param);
        return list;
    }

    @Override
    public List<ResDict> listParentDict(Long pid) {
        ResDict param = new ResDict();
        param.setPid(pid);
        List<ResDict> list = resDictMapper.listAllDict(param);
        return list;
    }

    @Override
    public ResDictResponseDto GetDictByType(ResDictRequestDto param) {
        // TODO Auto-generated method stub
        ResDictResponseDto res = new ResDictResponseDto();
        Integer type = CommonUtils.parseInteger(param.getType());
        if (type != null) {
            if (type == 1) {
                param.setType(Constants.DICT_JPXZQU_GL);
                param.setParam(" and id in (SELECT pid FROM res_dict t WHERE t.type='" + param.getType() + "' AND t.delete_flag="
                        + Constants.DEL_FLAG_NO + " AND t.status=" + Constants.DICT_STAUTS_ENABLE
                        + " AND NOT  EXISTS (SELECT 1 FROM res_dict WHERE pid=t.id AND delete_flag=" + Constants.DEL_FLAG_NO + " LIMIT 1))");
            } else if (type == 2) {
                param.setType(Constants.DICT_JPXZQU_GJ);
            } else if (type == 3) {
                param.setType(Constants.DICT_JPXZQU_GL);
                param.setParam(" and id in (SELECT pid FROM res_dict t WHERE t.type='" + param.getType() + "' AND t.delete_flag="
                        + Constants.DEL_FLAG_NO + " AND t.status=" + Constants.DICT_STAUTS_ENABLE
                        + " AND NOT  EXISTS (SELECT 1 FROM res_dict WHERE pid=t.id AND delete_flag=" + Constants.DEL_FLAG_NO + " LIMIT 1))");
            } else if (type == 4) {
                param.setType(Constants.DICT_JPXZQU_GJ);
            } else if (type == 5) {
                param.setType(Constants.DICT_GLXZQH);
                param.setParam(" and( id not in (SELECT id FROM res_dict WHERE pid IS  NULL OR pid=0) OR code='zhixia')");
            } else if (type == 6) {
                param.setType(Constants.DICT_GJXZQH);
                param.setParam(" and( id not in (SELECT id FROM res_dict WHERE pid IS  NULL OR pid=0) OR code='zhixia')");
            } else if (type == 7) {
                param.setType(Constants.DICT_GLXZQH);
            } else if (type == 8) {
                param.setType(Constants.DICT_GJXZQH);
            } else if (type == 9) {
                param.setType(Constants.DICT_JLXL);
                param.setParam(" and( id not in (SELECT id FROM res_dict WHERE pid IS  NULL OR pid=0) OR code='zhixia')");
            } else if (type == 10) {
                param.setType(Constants.DICT_JWXL);
                param.setParam(" and( id not in (SELECT id FROM res_dict WHERE pid IS  NULL OR pid=0) OR code='zhixia')");
            } else if (type == 11) {
                param.setType(Constants.DICT_GLXZQH);
            } else if (type == 12) {
                param.setType(Constants.DICT_GJXZQH);
            } else if (type == 13) {
                param.setType(Constants.DICT_JLXL);
                param.setParam(" and( id not in (SELECT id FROM res_dict WHERE pid IS  NULL OR pid=0) OR code='zhixia')");
            } else if (type == 14) {
                param.setType(Constants.DICT_JWXL);
                param.setParam(" and( id not in (SELECT id FROM res_dict WHERE pid IS  NULL OR pid=0) OR code='zhixia')");
            } else if (type == 15) {
                param.setType(Constants.DICT_JLXL);
                param.setParam(" and( id not in (SELECT id FROM res_dict WHERE pid IS  NULL OR pid=0) OR code='zhixia')");
            } else if (type == 16) {
                param.setType(Constants.DICT_JWXL);
                param.setParam(" and( id not in (SELECT id FROM res_dict WHERE pid IS  NULL OR pid=0) OR code='zhixia')");
            }
            List<ResDictDto> dictList = resDictMapper.getDictByType(param);
            res.setDictList(dictList);
        }
        return res;
    }

    @Override
    public List<ResDictExpandDto> queryDictExpandDtoList(ResDictExpandRequestDto param) {
        // TODO Auto-generated method stub
        List<ResDictExpandDto> res = new ArrayList<ResDictExpandDto>();
        List<ResDictExpandDto> list = resDictExpandMapper.queryDtoList(param);
        for(ResDictExpandDto dto:list){
            if(dto!=null&&dto.getIcon()!=null&&!"".equals(dto.getIcon())&&!"null".equals(dto.getIcon())){
                dto.setIcon(manageHostAddr+dto.getIcon());
            }
            res.add(dto);
        }
        return res;
    }
}
