package cn.com.ubing.pub.dto;

import java.util.List;

import cn.com.ubing.pub.model.PubPlan;
import cn.com.ubing.res.model.ResAttachment;
import cn.com.ubing.rms.model.RmsUserTitle;



/**
 * 方案详细
 * @author Administrator
 *
 */
public class CPubPlanRequestDto extends PubPlan {
    private String username;// 招标人
    private String nickname;// 别名
    private List<RmsUserTitle> userTitleList;// 商家称号列表
    private PubPlanTicketDto ticket;//关联的机票方案信息
    private PubPlanHotelDto hotel;//关联的酒店方案信息
    private PubPlanPersonalVisitDto personalVisit;//关联的自由行方案信息
    private PubPlanGroupVisitDto groupVisit;//关联的跟团行方案信息
    private List<ResAttachment> attachmentList;//图片列表
    
    public PubPlanTicketDto getTicket() {
        return ticket;
    }
    public void setTicket(PubPlanTicketDto ticket) {
        this.ticket = ticket;
    }
    public PubPlanHotelDto getHotel() {
        return hotel;
    }
    public void setHotel(PubPlanHotelDto hotel) {
        this.hotel = hotel;
    }
    public PubPlanPersonalVisitDto getPersonalVisit() {
        return personalVisit;
    }
    public void setPersonalVisit(PubPlanPersonalVisitDto personalVisit) {
        this.personalVisit = personalVisit;
    }
    public PubPlanGroupVisitDto getGroupVisit() {
        return groupVisit;
    }
    public void setGroupVisit(PubPlanGroupVisitDto groupVisit) {
        this.groupVisit = groupVisit;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public List<RmsUserTitle> getUserTitleList() {
        return userTitleList;
    }
    public void setUserTitleList(List<RmsUserTitle> userTitleList) {
        this.userTitleList = userTitleList;
    }
    public List<ResAttachment> getAttachmentList() {
        return attachmentList;
    }
    public void setAttachmentList(List<ResAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

}
