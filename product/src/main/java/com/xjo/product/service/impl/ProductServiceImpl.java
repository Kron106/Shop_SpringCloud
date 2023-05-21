package com.xjo.product.service.impl;

import com.xjo.product.dataobject.ProductInfo;
import com.xjo.product.dto.CartDTO;
import com.xjo.product.enums.ProductStatusEnum;
import com.xjo.product.enums.ResultEnum;
import com.xjo.product.exception.ProductException;
import com.xjo.product.repository.ProductInfoRepository;
import com.xjo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by cjc
 * 2018-12-09 21:59
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList){
        for(CartDTO cartDTO:cartDTOList){
            //先查商品库存是否够
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            //判断商品是否存在
            if(!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //商品存在，判断数量是否充足
            ProductInfo productInfo=productInfoOptional.get();
            //数据库中查询到的库存减去购物车中的商品数量
            Integer result = productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //更新库存数量
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }


}
