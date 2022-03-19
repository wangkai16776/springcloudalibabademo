package com.wk.controller;

import com.wk.entity.OrderInfo;
import com.wk.entity.ProductInfo;
import com.wk.mapper.OrderInfoMapper;
import com.wk.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by smlz on 2019/11/17.
 */
@RestController
public class OrderInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) {

        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ResponseEntity<ProductInfo> responseEntity = null;
        try {
            responseEntity = restTemplate.getForEntity("http://product-center/selectProductInfoById/"+orderInfo.getProductNo(), ProductInfo.class);

        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        ProductInfo productInfo = responseEntity.getBody();

        if(productInfo == null) {
            return "没有对应的商品";
        }

        OrderVo orderVo = new OrderVo();
        orderVo.setOrderNo(orderInfo.getOrderNo());
        orderVo.setUserName(orderInfo.getUserName());
        orderVo.setProductName(productInfo.getProductName());
        orderVo.setProductNum(orderInfo.getProductCount());

        return orderVo;
    }


}
