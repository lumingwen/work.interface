package cn.com.ubing.pub.dto;
/**
 * 目的地dto
 *  
 * @author 邱全松 2014-9-2 上午11:57:00
 */
public class PubPlanDestinationDto {
    private String destinationId;// 目的地ID
    private String destinationName;// 目的地名称

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

}
