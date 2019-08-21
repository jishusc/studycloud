package com.test.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.product.dataobject.ProductInfo;
import com.test.product.enums.ProductStatusEnum;
import com.test.product.repository.ProductInfoRepository;
import com.test.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Override
	public List<ProductInfo> findUpAll() {
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

}
