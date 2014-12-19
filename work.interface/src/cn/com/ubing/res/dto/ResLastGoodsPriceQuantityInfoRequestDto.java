package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

public class ResLastGoodsPriceQuantityInfoRequestDto extends RequestDto {
    private String lastGoodsId;

    public String getLastGoodsId() {
        return lastGoodsId;
    }

    public void setLastGoodsId(String lastGoodsId) {
        this.lastGoodsId = lastGoodsId;
    }
}
