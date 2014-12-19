/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.rms.model.RmsUser;



/**
 * 系统用户dto
 * @author zhangxujun
 * 
 *
 */
public class RmsUserDto extends RmsUser {
    
    /**
     * 字符串参数全匹配
     */
    private boolean fullMatch = false;
    
    /**
     * 角色名称
     */
    private String roleName;
    
    

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isFullMatch() {
        return fullMatch;
    }

    public void setFullMatch(boolean fullMatch) {
        this.fullMatch = fullMatch;
    }

    

}
