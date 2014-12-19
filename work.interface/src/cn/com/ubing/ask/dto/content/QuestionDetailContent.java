package cn.com.ubing.ask.dto.content;

public class QuestionDetailContent {
    
    
    /**
	 * id
	 */
	private String id;
	
	/**
	 * 提问内容
	 */
	private String content;
	
	/**
	 * 回答总数
	 */
	private String answerCount;
	
	
	/**
	 * 提问时间
	 */
	private String createTime;
	
	
	
	/**
	 * 目的地名称
	 */
	private String targetRegionName;
	
	
	/**
	 * 提问者昵称
	 */
	private String fromUserName;
	
	/**
	 * 提问者头像地址
	 */
	private String fromeUserIcon;


	public String getId() {
	    return id;
	}


	public void setId(String id) {
	    this.id = id;
	}


	public String getContent() {
	    return content;
	}


	public void setContent(String content) {
	    this.content = content;
	}


	public String getAnswerCount() {
	    return answerCount;
	}


	public void setAnswerCount(String answerCount) {
	    this.answerCount = answerCount;
	}


	public String getCreateTime() {
	    return createTime;
	}


	public void setCreateTime(String createTime) {
	    this.createTime = createTime;
	}


	public String getTargetRegionName() {
	    return targetRegionName;
	}


	public void setTargetRegionName(String targetRegionName) {
	    this.targetRegionName = targetRegionName;
	}



	public String getFromUserName() {
		return fromUserName;
	}


	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}


	public String getFromeUserIcon() {
	    return fromeUserIcon;
	}


	public void setFromeUserIcon(String fromeUserIcon) {
	    this.fromeUserIcon = fromeUserIcon;
	}
	
	

}
