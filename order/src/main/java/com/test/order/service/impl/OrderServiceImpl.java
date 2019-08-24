package com.test.order.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.order.dataobject.OrderMaster;
import com.test.order.dto.OrderDTO;
import com.test.order.enums.OrderStatusEnum;
import com.test.order.enums.PayStatusEnum;
import com.test.order.repository.OrderDetailRepository;
import com.test.order.repository.OrderMasterRepository;
import com.test.order.service.OrderService;
import com.test.order.utils.KeyUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMasterRepository orderMasterRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Override
	public OrderDTO create(OrderDTO orderDTO) {
		/**
		 * 
name: "张三"
phone: "18868822111"
address: "慕课网总部"
openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
items: [{
    productId: "1423113435324",
    productQuantity: 2 //购买数量
}]

计算总价
扣库存（调用商品服务）
入库
		 */
		String orderId = KeyUtil.genUniqueKey();
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(orderId);
		BeanUtils.copyProperties(orderDTO, orderMaster);
		//TODO
		orderMaster.setOrderAmount(new BigDecimal(5));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMasterRepository.save(orderMaster);
		return orderDTO;
	}

}
