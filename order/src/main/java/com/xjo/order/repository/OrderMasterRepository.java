package com.xjo.order.repository;

import com.xjo.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cjc
 * 2018-12-10 16:11
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
