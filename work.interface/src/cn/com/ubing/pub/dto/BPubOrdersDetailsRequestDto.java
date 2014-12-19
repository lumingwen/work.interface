/**
 * 
 */
package cn.com.ubing.pub.dto;

import cn.com.ubing.common.dto.RequestDto;

/**
 * B端APP订单详情
 * @author jokiye
 *
 */
public class BPubOrdersDetailsRequestDto extends RequestDto {
	
	
	/**
	 * 订单id
	 */
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	

}
