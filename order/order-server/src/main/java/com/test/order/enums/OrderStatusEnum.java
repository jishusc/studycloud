package com.test.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
	NEW(0, "新订单"), FINISHED(1, "完结束"), CANCEL(2, "取消");
	private Integer code;
	private String message;

	OrderStatusEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
