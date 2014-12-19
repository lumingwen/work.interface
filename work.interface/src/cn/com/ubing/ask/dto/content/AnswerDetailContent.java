/**
 * 
 */
package cn.com.ubing.ask.dto.content;

/**
 * 回答详情
 * @author zhangxujun
 * 
 *
 */
public class AnswerDetailContent {

    /**
     * 回答id
     */
    private String id;
   
    /**
     * 回答者姓名
     */
    private String answerUserName;
    
    
    /**
     * 回答者头像地址
     */
    private String answerUserIcon;
    
    /**
     * 回答内容
     */
    private String answerContent;
    
    /**
     * 回答时间
     */
    private String answerTime;
    
 
    
    
    /**
     * 能否评价改条回答为最佳(1:能,0:否)
     */
    private String appraiseBestFlag;
    
    
    /**
     *  能否评价改条回答为满意(1:能,0:否)
     */
    private String appraiseGoodFlag;
    
    
    /**
     *  能否评价改条回答为不满意(1:能,0:否)
     */
    private String appraiseBadFlag;

    
    /**
     * 评价状态(0:未评价,1:最佳,2:有用,3:无用)
     */
    private String status;
    


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


   


    public String getAnswerUserName() {
		return answerUserName;
	}


	public void setAnswerUserName(String answerUserName) {
		this.answerUserName = answerUserName;
	}


	public String getAnswerContent() {
        return answerContent;
    }


    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }


    public String getAnswerTime() {
        return answerTime;
    }


    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }


    public String getAppraiseBestFlag() {
        return appraiseBestFlag;
    }


    public void setAppraiseBestFlag(String appraiseBestFlag) {
        this.appraiseBestFlag = appraiseBestFlag;
    }


    public String getAppraiseGoodFlag() {
        return appraiseGoodFlag;
    }


    public void setAppraiseGoodFlag(String appraiseGoodFlag) {
        this.appraiseGoodFlag = appraiseGoodFlag;
    }


    public String getAppraiseBadFlag() {
        return appraiseBadFlag;
    }


    public void setAppraiseBadFlag(String appraiseBadFlag) {
        this.appraiseBadFlag = appraiseBadFlag;
    }


    public String getAnswerUserIcon() {
        return answerUserIcon;
    }


    public void setAnswerUserIcon(String answerUserIcon) {
        this.answerUserIcon = answerUserIcon;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    
}
