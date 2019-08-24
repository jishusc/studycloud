package com.test.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

	@GetMapping("/msg")
	public String msg() {
		return "this is product's msg!";
	}
}
