package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 订单项实体
 */
@Data
public class OrderItem implements Serializable {

    private Integer iid;  // 订单项id

    private Integer num;  // 购买数量

    private Double subtotal; // 小计

    private Integer rid; // 商品id（线路）

    private String oid;  // 订单id

    private Route route;  // 商品（线路）

    private Order order;  // 订单
}
