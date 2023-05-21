package com.xjo.product.service;

import com.xjo.product.dataobject.ProductInfo;
import com.xjo.product.dto.CartDTO;

import java.util.List;

/**
 * Created by cjc
 * 2018-12-09 21:57
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);



}
