package com.test.order.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.order.dataobject.ProductInfo;
import com.test.order.dto.CartDTO;

@FeignClient(name = "product")
public interface ProductClient {
	@GetMapping("/msg")
	String productMsg();
	
	@PostMapping("/product/listForOrder")
	List<ProductInfo> listForOrder(List<String> productIdList);
	
	@PostMapping("/product/decreaseStock")
	void decreaseStock(List<CartDTO> cartDTOList);
}
