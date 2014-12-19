package cn.com.ubing.res.dto;

import cn.com.ubing.common.dto.RequestDto;

public class ResDictExpandRequestDto extends RequestDto{
    private String type;//旅游主题：TOURISM_THEME 增值服务：PERSONAL_VISIT_ADDED_SERVICE

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
