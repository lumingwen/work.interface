package cn.com.ubing.msg.dto;

import cn.com.ubing.common.dto.RequestDto;

public class GroupMessageListRequestDto extends RequestDto {
    private String limit;// 每页显示条数
    private String pageNow;// 当前第几页

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

	public String getPageNow() {
		return pageNow;
	}

	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}



}
