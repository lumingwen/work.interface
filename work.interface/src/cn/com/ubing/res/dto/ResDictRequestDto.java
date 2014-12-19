package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * 线路信息获取请求dto
 *  
 * @author 邱全松 2014-6-30 下午4:33:11
 */
public class ResDictRequestDto extends RequestDto{
    /**c:
     * 1:机票出发地(国内),2:机票出发地(国际),3:机票目的地(国内),4:机票目的地(国际)
        5:酒店目的地(国内),6:酒店目的地(国际)
        7:自由行出发地(国内),8:自由行出发地(国际),9:自由行目的地(国内),10:自由行目的地(国际)
        11:跟团行出发地(国内),12:跟团行出发地(国际),13:跟团行目的地(国内),14:跟团行目的地(国际)
        15:提问目的地(国内),16：提问目的地(国际)
     */
    private String type;//B:线路类型：JWXL境外线路   JLXL境内线路
    private String param;//用于查询
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
    
}
