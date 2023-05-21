package com.xjo.order.repository;

import com.xjo.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cjc
 * 2018-12-10 16:12
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
