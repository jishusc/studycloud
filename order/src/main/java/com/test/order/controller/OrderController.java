package com.test.order.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.order.VO.ResultVO;
import com.test.order.converter.OrderForm2OrderDTOConverter;
import com.test.order.dataobject.OrderDetail;
import com.test.order.dto.OrderDTO;
import com.test.order.enums.ResultEnum;
import com.test.order.exception.OrderException;
import com.test.order.form.OrderForm;
import com.test.order.service.OrderService;
import com.test.order.utils.ResultVOUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@Autowired
	private OrderService orderService;
	
    /**
     * 1.参数检验
     * 2.查询商品信息（调用商品服务）
     * 3.计算总价
     * 4.扣库存（调用商品服务）
     * 5.订单入库
     */
    @PostMapping("/create")
	public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("【创建订单】参数不正确，orderForm={}", orderForm);
			throw new OrderException(ResultEnum.PARAM_ERROR);
		}
		
		// orderForm -> orderDTO
		OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
		if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
			log.error("【创建订单】购物车信息为空");
			throw new OrderException(ResultEnum.CART_EMPTY);
		}
		for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
			if (StringUtils.isEmpty(orderDetail.getProductId()) || orderDetail.getProductQuantity() == null) {
				log.error("【创建订单】购物车信息不正确");
				throw new OrderException(ResultEnum.CART_ERROR);
			}
		}

		OrderDTO result = orderService.create(orderDTO);
		HashMap<String, String> map = new HashMap<>();
		map.put("orderId", result.getOrderId());
		return ResultVOUtil.success(map);
	}

}
