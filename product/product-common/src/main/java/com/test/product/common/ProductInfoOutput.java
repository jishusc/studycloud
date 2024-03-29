package com.test.product.common;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductInfoOutput {
	private String productId;

	/** 名字. */
	private String productName;

	/** 单价. */
	private BigDecimal productPrice;

	/** 库存. */
	private Integer productStock;

	/** 描述. */
	private String productDescription;

	/** 小图. */
	private String productIcon;

	/** 状态, 0正常1下架. */
	private Integer productStatus;

}
