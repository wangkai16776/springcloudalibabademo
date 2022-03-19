package com.wk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: wangkai
 * Date: 2021/7/7
 * Time: 23:50
 * Description: No Description
 */
@RestController
public class Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "hello springcloud";
    }


}
