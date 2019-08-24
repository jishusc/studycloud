package com.test.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClientController {

	@GetMapping("/getMsgFromProduct")
	public String getMsgFromProduct() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("http://localhost:9124/msg", String.class);
		log.info("getMsgFromProduct:{}", response);
		return response;
	}
}
