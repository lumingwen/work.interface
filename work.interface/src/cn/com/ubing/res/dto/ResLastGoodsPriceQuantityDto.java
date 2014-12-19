package cn.com.ubing.res.dto;

public class ResLastGoodsPriceQuantityDto {
    private String time;//时间
    private String singlePrice;//单价
    private String marketPrice;//市场价
    private String quantity;//剩余数量
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getSinglePrice() {
        return singlePrice;
    }
    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }
    public String getMarketPrice() {
        return marketPrice;
    }
    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
