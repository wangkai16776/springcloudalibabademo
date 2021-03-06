package com.wk.controller;


import com.wk.entity.ProductInfo;
import com.wk.mapper.ProductInfoMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by smlz on 2019/11/17.
 */
@RestController
@RequestMapping("/product")
public class ProductInfoController {


    @Resource
    private ProductInfoMapper productInfoMapper;

    @RequestMapping("/selectProductInfoById/{productNo}")
    public Object selectProductInfoById(@PathVariable("productNo") String productNo) {

        ProductInfo productInfo = productInfoMapper.selectProductInfoById(productNo);
        return productInfo;
    }

    @RequestMapping("/gateWay4Header")
    public Object gateWay4Header(@RequestHeader("X-Request-Company") String company) {

        return "gateWay拿到请求头"+company;
    }

    @RequestMapping("/gateWay4RequestParam")
    public Object gateWay4RequestParam(@RequestParam(value = "company",defaultValue = "hehe") String company) {

        return "gateWay拿到请求参数"+company;
    }

    @RequestMapping("/getProduct")
    public String getProduct(@RequestParam(value = "company") String company)  {
        return company;
    }
}
