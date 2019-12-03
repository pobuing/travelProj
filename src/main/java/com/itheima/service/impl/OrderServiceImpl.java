package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.dao.OrderItemDao;
import com.itheima.domain.Cart;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.service.IOrderService;
import com.itheima.utils.CartRedisUtils;
import com.itheima.utils.MyBatisUtil;
import com.itheima.utils.UUIDUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * @author wangxin
 * @date 2019/12/3 20:12
 * @description: TODO
 * GOOD LUCK！
 */
public class OrderServiceImpl implements IOrderService {
    private final SqlSession sqlSession = MyBatisUtil.openSession();
    OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
    OrderItemDao orderItemDao = sqlSession.getMapper(OrderItemDao.class);

    @Override
    public Order createOrder(int uid) {
        //取出redis中的购物车
        Cart cart = CartRedisUtils.getCart(uid);
        //构造订单对象
        Order order = new Order();
        order.setOid(UUIDUtil.getUuid());
        order.setOrdertime(new Date());
        order.setTotal(cart.getCartPrice());
        order.setState(0);//订单未支付
        order.setUid(uid);
        //入库
        orderDao.save(order);
        cart.getCartItems().values().stream().forEach(carItem ->
                {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setNum(carItem.getNum());
                    orderItem.setSubtotal(carItem.getPrice());
                    orderItem.setRid(carItem.getRoute().getRid());
                    orderItem.setOid(order.getOid());
                    //存储订单项
                    orderItemDao.save(orderItem);
                }

        );
        CartRedisUtils.remoeCart(uid);

        return order;
    }
}
