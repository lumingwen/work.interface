/**
 * 
 */
package cn.com.ubing.rms.dto;

import cn.com.ubing.common.dto.ResponseDto;

/**
 * (B端)菜单
 * 
 * @author lumingwen
 * 
 * 
 */
public class RmsUserResponseDto extends ResponseDto {

	// 历史方案
	private int pubPlanCount;

	private int messageCount;

	private int pubRequirementCount;

	private int evaluationCount;

	public int getPubPlanCount() {
		return pubPlanCount;
	}

	public void setPubPlanCount(int pubPlanCount) {
		this.pubPlanCount = pubPlanCount;
	}

	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}

	public int getPubRequirementCount() {
		return pubRequirementCount;
	}

	public void setPubRequirementCount(int pubRequirementCount) {
		this.pubRequirementCount = pubRequirementCount;
	}

	public int getEvaluationCount() {
		return evaluationCount;
	}

	public void setEvaluationCount(int evaluationCount) {
		this.evaluationCount = evaluationCount;
	}

}
