package com.itheima.domain;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wangxin
 * @date 2019/12/3 16:57
 * @description: TODO
 * GOOD LUCK！
 * 购物车bean
 */
@Data
public class Cart {
    private int cartNum;//购物车商品数量
    private Map<Integer, CarItem> cartItems = new LinkedHashMap<>();//存放购物项的map集合 key 用户id
    private Double cartPrice;

    /**
     * 计算购物车内所有商品价格
     *
     * @return 商品的价格
     */
    public Double getCartPrice() {
        cartPrice = 0d;
        cartItems.values().stream().forEach(carItem -> cartPrice += carItem.getPrice());
        return cartPrice;
    }

    /**
     * 计算购物车内的所有商品数量
     *
     * @return 商品的数量
     */
    public int getCartNum() {
        cartNum = 0;
        cartItems.values().stream().forEach(carItem -> cartNum += carItem.getNum());
        return cartNum;
    }

    /**
     * 向购物车内添加商品
     *
     * @param num   添加的商品数量
     * @param route 商品实体
     */
    public void save(int num, Route route) {
        //判断购物车内是否有当前商品
        if (cartItems.containsKey(route.getRid())) {
            //已经存在 数量增加
            int newNum = cartItems.get(route.getRid()).getNum() + num;
            cartItems.get(route.getRid()).setNum(newNum);
        } else {
            //不存在添加到集合中
            CarItem carItem = new CarItem();
            carItem.setNum(num);
            carItem.setRoute(route);
            cartItems.put(route.getRid(), carItem);
        }
    }

    /**
     * 删除购物车内的商品
     *
     * @param rid 路线route rid
     */
    public void remove(Integer rid) {
        cartItems.remove(rid);

    }
}
