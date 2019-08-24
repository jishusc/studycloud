package com.test.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.product.dataobject.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	/**
	 * 2.获取类目type列表
	 * 
	 * @param categoryTypeList
	 * @return
	 */
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
