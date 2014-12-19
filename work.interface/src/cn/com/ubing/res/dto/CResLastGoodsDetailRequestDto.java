package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

public class CResLastGoodsDetailRequestDto extends RequestDto{
    private String lastGoodId;//尾单id

    public String getLastGoodId() {
        return lastGoodId;
    }

    public void setLastGoodId(String lastGoodId) {
        this.lastGoodId = lastGoodId;
    }
}
