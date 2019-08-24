package com.test.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.order.dataobject.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
