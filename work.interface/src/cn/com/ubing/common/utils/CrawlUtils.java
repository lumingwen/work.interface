/**
 * 
 */
package cn.com.ubing.common.utils;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 抓取工具类
 * @author zhangxujun
 * 
 *
 */
public class CrawlUtils {
    
    
    public static void crawl(String name) throws IOException {
	Document document = Jsoup
		.connect("http://www.ciku5.com/s")
		.data("wd", name)
		.userAgent(
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
		.referrer("www.ciku5.com").get();
	
	System.out.println(document.html());

	
	
//	Elements tables = document.select("div").attr("class", "search_table");
//	if (tables!=null && tables.size()>0){
////	    Element table = tables.get(0);
////	    System.out.println(table.html());
////	    Elements trs = table.select("tbody tr");
////	    for (int i=0;i<trs.size();i++){
////		Element tr = trs.get(i);
////		//System.out.println(tr.html());
////		//System.out.println("\n\n--------------------"+i);
////	    }
//	    
//	}
    }
    
    
    public static void main(String[] args) throws IOException {
	crawl("成都1");
    }

}
