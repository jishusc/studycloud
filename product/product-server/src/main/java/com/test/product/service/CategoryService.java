package com.test.product.service;

import java.util.List;

import com.test.product.dataobject.ProductCategory;

public interface CategoryService {
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
