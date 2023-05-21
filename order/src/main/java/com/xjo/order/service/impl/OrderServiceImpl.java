package com.xjo.order.service.impl;


import com.xjo.order.dataobject.OrderMaster;
import com.xjo.order.dto.OrderDTO;
import com.xjo.order.enums.OrderStatusEnum;
import com.xjo.order.enums.PayStatusEnum;
import com.xjo.order.repository.OrderDetailRepository;
import com.xjo.order.repository.OrderMasterRepository;
import com.xjo.order.service.OrderService;
import com.xjo.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by cjc
 * 2018-12-10 16:44
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
       //TODO查询商品信息(调用商品服务）
       //TODO计算总价
       //TODO扣库存(调用商品服务)
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5)); //先写死
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
