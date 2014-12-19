package cn.com.ubing.res.dto;

import java.util.List;

import cn.com.ubing.common.dto.ResponseDto;

public class ResLastGoodsPriceQuantityInfoResponseDto extends ResponseDto {
    private String lastGoodsId;
    private List<ResLastGoodsPriceQuantityDto> quantityInfoList;

    public String getLastGoodsId() {
        return lastGoodsId;
    }

    public void setLastGoodsId(String lastGoodsId) {
        this.lastGoodsId = lastGoodsId;
    }

    public List<ResLastGoodsPriceQuantityDto> getQuantityInfoList() {
        return quantityInfoList;
    }

    public void setQuantityInfoList(List<ResLastGoodsPriceQuantityDto> quantityInfoList) {
        this.quantityInfoList = quantityInfoList;
    }
}
