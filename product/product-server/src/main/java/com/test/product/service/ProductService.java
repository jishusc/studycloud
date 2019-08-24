package com.test.product.service;

import java.util.List;

import com.test.product.common.DecreaseStockInput;
import com.test.product.common.ProductInfoOutput;
import com.test.product.dataobject.ProductInfo;

public interface ProductService {
	/**
	 * 查询所有在架商品列表
	 */
	List<ProductInfo> findUpAll();

	/**
	 * 根据商品ID查询商品信息
	 * 
	 * @param productIdList
	 * @return
	 */
	List<ProductInfoOutput> findList(List<String> productIdList);
	
	/**
	 * 扣库存
	 * @param cardDTOList
	 */
	void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
	
}
