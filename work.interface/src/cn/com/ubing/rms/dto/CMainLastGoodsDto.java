package cn.com.ubing.rms.dto;

/**
 * c端app下方尾单信息
 * 
 * @author 邱全松 2014-11-17 上午10:52:50
 */
public class CMainLastGoodsDto {
    private String title;// 尾单标题
    private String endTime;// 结束时间
    private String quantity;// 数量
    private String birthland;// 出发地
    private String imageUrl;// 封面图
    private String singlePrice;// 单价
    private String lastGoodsId;// 尾单ID,用于查看详情跳转

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBirthland() {
        return birthland;
    }

    public void setBirthland(String birthland) {
        this.birthland = birthland;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }

    public String getLastGoodsId() {
        return lastGoodsId;
    }

    public void setLastGoodsId(String lastGoodsId) {
        this.lastGoodsId = lastGoodsId;
    }
}
