package com.test.order.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.product.client.ProductClient;
import com.test.product.common.DecreaseStockInput;
import com.test.product.common.ProductInfoOutput;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClientController {

	@Autowired
	private ProductClient productClient;
	
	@GetMapping("/getMsgFromProduct")
	public String getMsgFromProduct() {
		return productClient.productMsg();
	}
	
	@GetMapping("/getProductList")
	public List<ProductInfoOutput> listForOrder() {
		List<ProductInfoOutput> lists = productClient.listForOrder(Arrays.asList(new String[] {"157875196366160022"}));
		log.info(lists.toString());
		return lists;
	}
	
	@GetMapping("/decreaseProductStock")
	public String decreaseProductStock() {
		productClient.decreaseStock(Arrays.asList(new DecreaseStockInput("157875196366160022", 3), new DecreaseStockInput("157875227953464068", 2)));
		return "ok";
	}
}
