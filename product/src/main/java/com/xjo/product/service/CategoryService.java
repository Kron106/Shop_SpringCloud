package com.xjo.product.service;

import com.xjo.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by cjc
 * 2018-12-09 22:06
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
