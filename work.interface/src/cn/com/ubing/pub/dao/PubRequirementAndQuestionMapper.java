/**
 * 
 */
package cn.com.ubing.pub.dao;

import java.util.List;
import java.util.Map;

import cn.com.ubing.pub.dto.PushQuestionDto;
import cn.com.ubing.pub.dto.PushRequirementDto;
import cn.com.ubing.rms.dto.RmsUserDto;




/**
 * 
 *  需求及问题推送dao
 * @author zhangxujun
 * 
 *
 */
public interface PubRequirementAndQuestionMapper {
    
    /**
     * 查询需求推送用户的id
     *
     */
    String getPushRequirementUserIds(PushRequirementDto dto);
    
    /**
     * 查询问题推送用户的id
     *
     */
    String getPushQuestionUserIds(PushQuestionDto dto);
    
    
    /**
     * 根据多个id查询用户
     *
     */
    List<RmsUserDto> getRmsUserByIds(Map map);

}
