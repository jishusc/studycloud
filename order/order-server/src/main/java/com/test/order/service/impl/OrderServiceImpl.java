package com.test.order.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.order.dataobject.OrderDetail;
import com.test.order.dataobject.OrderMaster;
import com.test.order.dto.OrderDTO;
import com.test.order.enums.OrderStatusEnum;
import com.test.order.enums.PayStatusEnum;
import com.test.order.repository.OrderDetailRepository;
import com.test.order.repository.OrderMasterRepository;
import com.test.order.service.OrderService;
import com.test.order.utils.KeyUtil;
import com.test.product.client.ProductClient;
import com.test.product.common.DecreaseStockInput;
import com.test.product.common.ProductInfoOutput;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMasterRepository orderMasterRepository;
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ProductClient productClient;
	
	@Override
	@Transactional
	public OrderDTO create(OrderDTO orderDTO) {
		/**
		 * 
name: "张三"
phone: "18868822111"
address: "慕课网总部"
openid: "ew3euwhd7sjw9diwkq" //用户的微信openid
items: [{
    productId: "157875196366160022",
    productQuantity: 2 //购买数量
}]
查询商品详情
计算总价
扣库存（调用商品服务）
入库
		 */
		String orderId = KeyUtil.genUniqueKey();
		List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
		List<ProductInfoOutput> productInfoOutputList = productClient.listForOrder(productIdList);
		//计算总价
		BigDecimal orderAmount = BigDecimal.ZERO;
		for(OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
			for(ProductInfoOutput productInfoOutput : productInfoOutputList) {
				if(productInfoOutput.getProductId().equals(orderDetail.getProductId())) {
					orderAmount = productInfoOutput.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity()))
							.add(orderAmount);
					//订单详情表入库
					BeanUtils.copyProperties(productInfoOutput, orderDetail);
					orderDetail.setOrderId(orderId);
					orderDetail.setDetailId(KeyUtil.genUniqueKey());
					orderDetailRepository.save(orderDetail);
				}
			}
		}
		
		//扣库存
		List<DecreaseStockInput> decreaseStockList = orderDTO.getOrderDetailList().stream().map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
		productClient.decreaseStock(decreaseStockList);
		
		//订单主表入库
		OrderMaster orderMaster = new OrderMaster();
		orderDTO.setOrderId(orderId);
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(orderAmount);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMasterRepository.save(orderMaster);
		return orderDTO;
	}

}
