package com.xjo.order.repository;

import com.xjo.order.OrderApplicationTests;
import com.xjo.order.dataobject.OrderMaster;
import com.xjo.order.enums.OrderStatusEnum;
import com.xjo.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cjc
 * 2018-12-10 16:13
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("刘备");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("Oracle总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }

}