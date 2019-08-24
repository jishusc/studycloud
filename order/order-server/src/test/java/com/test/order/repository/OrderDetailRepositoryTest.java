package com.test.order.repository;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.order.OrderApplicationTest;
import com.test.order.dataobject.OrderDetail;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTest {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Test
	public void test() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDetailId("111111");
		orderDetail.setOrderId("123456");
		orderDetail.setProductIcon("http://xxxx/1.jpg");
		orderDetail.setProductId("157875196366160022");
		orderDetail.setProductName("皮蛋粥");
		orderDetail.setProductPrice(new BigDecimal(0.01));
		orderDetail.setProductQuantity(1);
		OrderDetail entity = orderDetailRepository.save(orderDetail);
		Assert.assertTrue(entity != null);
	}

}
