package com.test.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	PARAM_ERROR(1, "参数错误"), CART_EMPTY(2, "购物车为空"), CART_ERROR(3, "购物车信息不正确");

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
