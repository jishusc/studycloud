package com.test.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.product.common.DecreaseStockInput;
import com.test.product.common.ProductInfoOutput;
import com.test.product.dataobject.ProductInfo;
import com.test.product.enums.ProductStatusEnum;
import com.test.product.enums.ResultEnum;
import com.test.product.exception.ProductException;
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

	@Override
	public List<ProductInfoOutput> findList(List<String> productIdList) {
		return productInfoRepository.findByProductIdIn(productIdList).stream().map(e -> {
			ProductInfoOutput output = new ProductInfoOutput();
			BeanUtils.copyProperties(e, output);
			return output;
		}).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
		for(DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
			Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
			if(!productInfoOptional.isPresent()) {
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			ProductInfo productInfo = productInfoOptional.get();
			int result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
			if(result < 0) {
				throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROE);
			}
			productInfo.setProductStock(result);
			productInfoRepository.save(productInfo);
		}
	}

}
