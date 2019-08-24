package com.test.order.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.test.order.client.ProductClient;
import com.test.order.dataobject.ProductInfo;

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
	public List<ProductInfo> listForOrder() {
		List<ProductInfo> lists = productClient.listForOrder(Arrays.asList(new String[] {"157875196366160022"}));
		log.info(lists.toString());
		return lists;
	}
}
