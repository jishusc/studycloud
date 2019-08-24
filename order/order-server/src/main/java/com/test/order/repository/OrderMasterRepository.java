package com.test.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.order.dataobject.OrderMaster;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}
