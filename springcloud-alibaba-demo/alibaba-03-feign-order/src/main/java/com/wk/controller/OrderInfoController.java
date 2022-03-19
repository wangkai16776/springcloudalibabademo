package com.wk.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wk.entity.OrderInfo;
import com.wk.entity.ProductInfo;
import com.wk.feignapi.productcenter.ProductCenterFeignApi;
import com.wk.mapper.OrderInfoMapper;
import com.wk.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smlz on 2019/11/17.
 */
@Slf4j
@RestController
public class OrderInfoController {


    @Autowired
    private ProductCenterFeignApi productCenterFeignApi;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/selectOrderInfoById/{orderNo}")
    public Object selectOrderInfoById(@PathVariable("orderNo") String orderNo) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        OrderInfo orderInfo = orderInfoMapper.selectOrderInfoById(orderNo);
        if(null == orderInfo) {
            return "根据orderNo:"+orderNo+"查询没有该订单";
        }

        ProductInfo productInfo = productCenterFeignApi.selectProductInfoById(orderNo);

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

    //此处 需要 有 ordereNo参数，不然会报错FallbackDefinitionException: fallback method wasn't found
    //默认两秒时间，两秒时间调不通服务，则进入error方法
    public Object error(String orderNo) {
        return "error";
    }

}
