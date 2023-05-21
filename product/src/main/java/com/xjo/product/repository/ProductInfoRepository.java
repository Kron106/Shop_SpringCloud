package com.xjo.product.repository;

import com.xjo.product.dataobject.ProductInfo;
import com.xjo.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cjc
 * 2017-12-09 21:29
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>{

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);

}
