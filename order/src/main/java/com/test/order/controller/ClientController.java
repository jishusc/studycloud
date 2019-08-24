package com.test.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClientController {

//	@Autowired
//	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/getMsgFromProduct")
	public String getMsgFromProduct() {
		String response = "";
		// 第一种方式，直接写死url
//		RestTemplate restTemplate = new RestTemplate();
//		String response = restTemplate.getForObject("http://localhost:9124/msg", String.class);
//		log.info("getMsgFromProduct:{}", response);
//		return response;
		// 第二种方式 通过loadBalancerClient
//		ServiceInstance serviceInstance = loadBalancerClient.choose("product");
//		log.info("serviceInstance={}", serviceInstance);
//		String url = String.format("http://%s:%s/msg", serviceInstance.getHost(), serviceInstance.getPort());
//		RestTemplate restTemplate = new RestTemplate();
//		response = restTemplate.getForObject(url, String.class);
//		log.info("getMsgFromProduct:{}", response);
//		return response;
		
		//使用RestTemplate的第三种方式
		return restTemplate.getForObject("http://product/msg", String.class);
	}
}
