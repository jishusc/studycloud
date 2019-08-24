package com.test.product.service;

import java.util.List;

import com.test.product.dataobject.ProductInfo;

public interface ProductService {
	/**
	 * 查询所有在架商品列表
	 */
	List<ProductInfo> findUpAll();

	List<ProductInfo> findList(List<String> productIdList);
}
