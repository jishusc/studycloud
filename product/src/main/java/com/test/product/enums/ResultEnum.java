package com.test.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
	PRODUCT_NOT_EXIST(1, "商品不存在"), PRODUCT_STOCK_ERROE(2, "库存有误"),;

	private Integer code;

	private String message;

	ResultEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
