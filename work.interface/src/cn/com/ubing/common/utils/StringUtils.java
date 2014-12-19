/**
 * 
 */
package cn.com.ubing.common.utils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

import cn.com.ubing.common.dto.RequestDto;
import cn.com.ubing.rms.dto.UserLoginRequestDto;

/**
 * 
 * 字符串处理工具类
 * @author zhangxujun
 * 
 *
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {
    
    
    
    private static final Logger log = Logger.getLogger(StringUtils.class);
    
    
    /**
     * 对象转json字符串
     * @param o 对象
     * @return 字符串
     */
    @SuppressWarnings("rawtypes")
    public static String toJson(Object o){
	if (o!=null){
	    if (o instanceof List){
		List list = (List) o;
		if (list.isEmpty()){
		    return null;
		}
		JSONArray json = JSONArray.fromObject(o);
		String s = json.toString();
		return s;
	    }else{
		JSONObject json = JSONObject.fromObject(o);
		String s = json.toString();
		return s;
	    }
	}
	return null;
    }
    
    
    
    
    /**
     * json字符串转对象
     * @param cls 对象类型
     * @param json json字符串
     * @return 对象
     */
    @SuppressWarnings({ "static-access", "unchecked" })
    public static <T> T getObjectJson(Class<T> cls,String json){
	JSONObject obj=new JSONObject().fromObject(json);
	T info = (T)JSONObject.toBean(obj, cls);
	return info;
    }
    
    
    /**
     * json字符串转对象集合
     * @param cls 对象类型
     * @param json json字符串
     * @return 对象集合
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> List<T> getObjectListByJson(Class<T> cls,String json){
	List<T> objs = new ArrayList<T>();
        JSONArray jsonArray=(JSONArray)JSONSerializer.toJSON(json);
        if(jsonArray!=null){
            List list=(List)JSONSerializer.toJava(jsonArray);
            for(Object o:list){
                JSONObject jsonObject=JSONObject.fromObject(o);
                T obj=(T)JSONObject.toBean(jsonObject, cls);
                objs.add(obj);
            }
        }
        return objs;
    }
    
    
    /**
     * 根据请求头获得加密字符串
     * @param req 请求头
     * @return 加密串
     */
    @SuppressWarnings("rawtypes")
    public static String getToken(RequestDto req) {
	try {
	    // 获得所有字段并以字母顺序排列
	    Map<String, String> map = new TreeMap<String, String>();
	    PropertyDescriptor[] pds = PropertyUtils
		    .getPropertyDescriptors(req);
	    for (PropertyDescriptor pd : pds) {
		Class type = pd.getPropertyType();
		if (!Class.class.equals(type)) {
		    String fieldName = pd.getName();
		    if (!"token".equals(fieldName)) {
			Object filedValue = PropertyUtils.getProperty(req,
				fieldName);
			if (filedValue == null) {
			    map.put(fieldName, "");
			} else {
			    map.put(fieldName, filedValue.toString());
			}
			//System.out.println(fieldName + " | " + filedValue);
		    }
		}
	    }
	    //字符串拼接
	    Iterator<String> it = map.keySet().iterator();
	    StringBuffer sb = new StringBuffer();
	    while (it.hasNext()){
		String key = it.next();
		String value = map.get(key);
		sb.append(key).append("=").append(value).append("&");
	    }
	    if (sb.length()>0){
		sb.deleteCharAt(sb.length()-1);
	    }
	    
	    //加密
	    String token =  DigestUtils.md5Hex(sb.toString());
	    
	    //返回
	    return token;
	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	}
	return "";
    }
    
    
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
	
	
	List<UserLoginRequestDto> list = new ArrayList<UserLoginRequestDto>();
	UserLoginRequestDto user = new UserLoginRequestDto();
	list.add(user);
//	System.out.println(toJson(list));
//	System.out.println(toJson(user));
//	System.out.println(getObjectJson(UserLoginRequestDto.class, toJson(user)));
//	System.out.println(getObjectListByJson(UserLoginRequestDto.class, toJson(list)));
	
	System.out.println(getToken(user));
    }

}
