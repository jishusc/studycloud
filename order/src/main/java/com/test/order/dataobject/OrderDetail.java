package com.test.order.dataobject;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class OrderDetail {

	/** 订单详情id **/
	@Id
	private String detailId;

	/** 订单id **/
	private String orderId;

	/** 商品id **/
	private String productId;

	/** 商品名称 **/
	private String productName;

	/** 商品单价 **/
	private BigDecimal productPrice;

	/** 商品数量 **/
	private Integer productQuantity;

	/** 商品小图 **/
	private String productIcon;

	/** 创建时间 **/
	private Date createTime;

	/** 更新时间 **/
	private Date updateTime;
}
