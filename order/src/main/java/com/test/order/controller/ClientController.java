package com.test.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.order.client.ProductClient;

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
}
