package cn.com.ubing.pub.dto;

public class CPubPlanHistoryTicketDto {
	private String Id;

	private String leaveLocationStr;//出发地
	
	private String reachLocationStr;//目的地

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getLeaveLocationStr() {
		return leaveLocationStr;
	}

	public void setLeaveLocationStr(String leaveLocationStr) {
		this.leaveLocationStr = leaveLocationStr;
	}

	public String getReachLocationStr() {
		return reachLocationStr;
	}

	public void setReachLocationStr(String reachLocationStr) {
		this.reachLocationStr = reachLocationStr;
	}
	
}
