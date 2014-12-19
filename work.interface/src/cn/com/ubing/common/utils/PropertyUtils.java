/**
 * 
 */
package cn.com.ubing.common.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author zhangxujun
 * 
 *
 */
public class PropertyUtils {
    
    
    
    public static String getProp(String key){
	return pro.getProperty(key);
    }
    
    private static Properties pro = new Properties();
    static{
	try {
	    pro.load(PropertyUtils.class.getResourceAsStream("/config.properties"));
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
}
