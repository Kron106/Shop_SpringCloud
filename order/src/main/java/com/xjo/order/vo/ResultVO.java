package com.xjo.order.vo;

import lombok.Data;

/**
 * Created by cjc
 * 2018-12-10 18:02
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
