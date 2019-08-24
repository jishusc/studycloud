package com.test.order.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.order.OrderApplicationTest;

@Component
public class ClientControllerTest extends OrderApplicationTest {

	@Autowired
	private ClientController clientController;
	@Test
	public void testGetMsgFromProduct() {
		clientController.getMsgFromProduct();
	}

}
