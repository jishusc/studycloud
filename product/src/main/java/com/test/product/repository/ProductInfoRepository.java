package com.test.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.product.dataobject.ProductInfo;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
	/**
	 * 1.查询所有在架的商品
	 * 
	 * @param productStatus
	 * @return
	 */
	List<ProductInfo> findByProductStatus(Integer productStatus);
}
