package com.xjo.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cjc
 * 2022-12-10 20:37
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product' msg2";
    }
}
