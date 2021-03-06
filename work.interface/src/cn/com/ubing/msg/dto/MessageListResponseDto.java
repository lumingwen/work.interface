/**
 * 
 */
package cn.com.ubing.msg.dto;

import com.github.miemiedev.mybatis.paginator.domain.PageList;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * 消息列表响应dto
 * 
 * @author zhangxujun
 * 
 * 
 */
public class MessageListResponseDto extends ResponseDto {

    /**
     * 吆喝消息
     */
    private String userMessage;
    private String userNickname;

    /**
     * 消息组列表
     */
    private PageList<MessageGroupDto> groupFromUser;
    private String pageNow;// 当前页
    private String totalPages;// 总页数
    private String totalCount;// 总条数

    public String getPageNow() {
        return pageNow;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
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

    public PageList<MessageGroupDto> getGroupFromUser() {
        return groupFromUser;
    }

    public void setGroupFromUser(PageList<MessageGroupDto> groupFromUser) {
        this.groupFromUser = groupFromUser;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}
