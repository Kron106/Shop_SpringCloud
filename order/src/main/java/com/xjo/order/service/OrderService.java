package com.xjo.order.service;

import com.xjo.order.dto.OrderDTO;

/**
 * Created by cjc
 * 2018-12-10 16:39
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
