package com.xjo.order.controller;

import com.xjo.order.client.ProductClient;
import com.xjo.order.dataobject.ProductInfo;
import com.xjo.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> productInfoList=productClient.listForOrder(Arrays.asList("157875196366160022"));
        log.info("response={}",productInfoList);
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("157875196366160022",2)));
        return "ok";
    }


}
