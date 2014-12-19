/**
 * 
 */
package cn.com.ubing.msg.dto;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 消息列表响应dto
 * 
 * @author lumw
 * 
 * 
 */
public class GroupMessageListResponseDto extends ResponseDto {


    /**
     * 消息组列表
     */
    private PageList<GroupMessageDto> groupMessageList;
    private String pageNow;// 当前页
    private String totalPages;// 总页数
    private String totalCount;// 总条数
	public PageList<GroupMessageDto> getGroupMessageList() {
		return groupMessageList;
	}
	public void setGroupMessageList(PageList<GroupMessageDto> groupMessageList) {
		this.groupMessageList = groupMessageList;
	}
	public String getPageNow() {
		return pageNow;
	}
	public void setPageNow(String pageNow) {
		this.pageNow = pageNow;
	}
	public String getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}


}
