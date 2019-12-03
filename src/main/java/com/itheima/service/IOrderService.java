package com.itheima.service;

import com.itheima.domain.Order;

/**
 * @author wangxin
 * @date 2019/12/3 20:11
 * @description: TODO
 * GOOD LUCK！
 */
public interface IOrderService {
    //创建uid对应的订单
    Order createOrder(int uid);
}
