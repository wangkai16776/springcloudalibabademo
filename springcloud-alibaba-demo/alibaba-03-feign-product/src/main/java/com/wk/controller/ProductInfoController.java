package com.wk.controller;

import com.wk.entity.ProductInfo;
import com.wk.feignapi.productcenter.ProductCenterFeignApi;
import com.wk.mapper.ProductInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: wangkai
 * Date: 2022/2/23
 * Time: 1:16
 * Description: No Description
 */
@RestController
@Slf4j
public class ProductInfoController implements ProductCenterFeignApi {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @RequestMapping("/selectProductInfoById/{productNo}")
    public ProductInfo selectProductInfoById(@PathVariable("productNo") String productNo)  {

        ProductInfo productInfo = productInfoMapper.selectProductInfoById(productNo);

        /*ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("wangkai");
        productInfo.setProductNo("1");
        productInfo.setProductPrice(12.21);
        productInfo.setProductStore("213");*/
        return productInfo;
    }

    @RequestMapping("/getToken4Header")
    public String getToken4Header(@RequestHeader("token") String token)  {
        log.info("token:{}",token);
        return token;
    }
}
