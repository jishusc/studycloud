package com.test.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.product.dataobject.ProductCategory;
import com.test.product.repository.ProductCategoryRepository;
import com.test.product.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
		return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
	}

}
