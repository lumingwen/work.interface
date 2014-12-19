/**
 * 
 */
package test.base;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.httpclient.HttpClient;




/**
 * 
 * 测试基类
 * 
 * @author zhangxujun
 * 
 * 
 */
public class BaseTest extends TestCase {
    
    
    
    
    
    
    
    /**
     * 根据对象解析为参数
     * @param obj 对象
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     */
    @SuppressWarnings("rawtypes")
    protected List<String[]> getParamterList(String namePrefix,Object obj){
	try{
	    	List<String[]> resultList = new ArrayList<String[]>();
	    	if (obj==null){
	    	    return resultList;
	    	}
        	PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj);
        	for (PropertyDescriptor pd : pds) {
        	    Class type = pd.getPropertyType();
        	    if (!Class.class.equals(type)) {
        		if (List.class.equals(type)) {
        		    String fieldName = pd.getName();
        		    List list = (List)PropertyUtils.getProperty(obj, fieldName);
        		    if (list!=null && list.size()>0){
        			for (int i=0;i<list.size();i++){
        			    List<String[]> temp =  getParamterList(fieldName+"["+i+"].",list.get(i));
        			    resultList.addAll(temp);
        			}
        		    }
        		} else {
        		    String fieldName = pd.getName();
        		    Object val = PropertyUtils.getProperty(obj, fieldName);
        		    if (val!=null){
        			if (Date.class.equals(type)){
        			    resultList.add(new String[]{namePrefix+fieldName, String.valueOf(val)});
        			}else{
        			    resultList.add(new String[]{namePrefix+fieldName, String.valueOf(val)});
        			}
        		    }
        		}
        	    }
        	}
        	return resultList;
	}catch(Exception e){
	    e.printStackTrace();
	    return null;
	}
    }
    
    
    
    
    
    /**
     * 发送http的post请求
     * @param path 路径(不包含服务器地址)
     * @param list 参数集合,键值对
     * @return 响应数据
     */
    protected String postRequest(String path, List<String[]> list) {
	try {
	    String host = cn.com.ubing.common.utils.PropertyUtils.getProp("hostAddr");
	    String url = host + "/" + path;
	    URI uri = new URI(url);
	    HttpClient client = new HttpClient();
	    client.getHostConfiguration().setHost(uri.getHost(), uri.getPort(), "http");
	    UTF8PostMethod method = new UTF8PostMethod(uri.getPath());
	    if (CollectionUtils.isNotEmpty(list)) {
		for (String[] s : list) {
		    method.addParameter(s[0], s[1]);
		}
	    }
	    client.executeMethod(method);
	    String response = new String(method.getResponseBodyAsString()
		    .getBytes("utf-8"));
	    return response;
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

   
}
