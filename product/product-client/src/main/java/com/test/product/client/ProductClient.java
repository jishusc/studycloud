package com.test.product.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.product.common.DecreaseStockInput;
import com.test.product.common.ProductInfoOutput;

@FeignClient(name = "product")
public interface ProductClient {
	@GetMapping("/msg")
	String productMsg();

	@PostMapping("/product/listForOrder")
	List<ProductInfoOutput> listForOrder(List<String> productIdList);

	@PostMapping("/product/decreaseStock")
	void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}