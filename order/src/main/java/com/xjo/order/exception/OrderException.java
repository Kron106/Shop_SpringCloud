package com.xjo.order.exception;

import com.xjo.order.enums.ResultEnum;

/**
 * Created by cjc
 * 2018-12-10 17:27
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
