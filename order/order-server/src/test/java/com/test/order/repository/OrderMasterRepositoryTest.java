package com.test.order.repository;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.order.OrderApplicationTest;
import com.test.order.dataobject.OrderMaster;
import com.test.order.enums.OrderStatusEnum;
import com.test.order.enums.PayStatusEnum;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTest {

	@Autowired
	private OrderMasterRepository orderMasterRepository;

	@Test
	public void testSave() {
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setOrderId("123456");
		orderMaster.setBuyerName("张三");
		orderMaster.setBuyerPhone("18321417777");
		orderMaster.setBuyerAddress("六安市分路口镇");
		orderMaster.setBuyerOpenid("1111");
		orderMaster.setOrderAmount(new BigDecimal(11));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		OrderMaster entity = orderMasterRepository.save(orderMaster);
		Assert.assertTrue(entity != null);
	}

}
