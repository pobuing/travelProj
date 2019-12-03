package com.itheima.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Cart;
import com.sun.management.jmx.Trace;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * @author wangxin
 * @date 2019/12/3 17:10
 * @description: TODO
 * GOOD LUCK！
 * 操作购物车redis工具类
 */
public class CartRedisUtils {

    private static String TRAVEL_CART_TAG = "travel:cart:";;
    static ObjectMapper mapper = new ObjectMapper();


    /**
     * 向redis中写入购物车
     *
     * @param uid  购物车标识 --> 用户id
     * @param cart 购物车实体
     */
    public static void setCart(Integer uid, Cart cart) {
        try {
            Jedis jedis = JedisUtil.getJedis();
            if (cart.getCartNum()==0) {
                //购物车为空删除购物车
                jedis.del(TRAVEL_CART_TAG+uid);
            }else{
                //不为空 更新购物车
                String cartStr = mapper.writeValueAsString(cart);
                //cart --> jsonStr
                //存储数据
                jedis.set(TRAVEL_CART_TAG + uid, cartStr);
            }
            jedis.close();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从redis中获取对应用户的购物车
     *
     * @param uid 用户uid
     * @return
     */
    public static Cart getCart(Integer uid) {
        try {
            Jedis jedis = JedisUtil.getJedis();
            String cartStr = jedis.get(TRAVEL_CART_TAG + uid);
            jedis.close();

            //判空
            Cart cart = null;
            if (StringUtils.isNotEmpty(cartStr)) {
                cart = mapper.readValue(cartStr, Cart.class);
            } else {
                cart = new Cart();
            }
            return cart;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 从redis中删除购物车
     *
     * @param uid 用户标识
     */
    public static void remoeCart(Integer uid) {
        Jedis jedis = JedisUtil.getJedis();
        jedis.del(TRAVEL_CART_TAG + uid);
        jedis.close();
    }
}
