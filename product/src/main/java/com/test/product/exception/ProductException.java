package com.test.product.exception;

import com.test.product.enums.ResultEnum;

public class ProductException extends RuntimeException {

	private Integer code;

	public ProductException(String message, Integer code) {
		super(message);
		this.code = code;
	}

	public ProductException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}
