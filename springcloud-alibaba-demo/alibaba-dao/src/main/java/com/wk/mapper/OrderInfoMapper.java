package com.wk.mapper;

import com.wk.entity.OrderInfo;

/**
 * Created by smlz on 2019/11/17.
 */
public interface OrderInfoMapper {

    OrderInfo selectOrderInfoById(String orderNo);
}
