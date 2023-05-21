package com.xjo.product.utils;

import com.xjo.product.vo.ResultVO;

/**
 * Created by cjc
 * 2018-12-09 22:53
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
