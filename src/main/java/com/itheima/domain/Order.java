package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
@Data
public class Order implements Serializable {

    private String oid;  // 订单id

    private Date ordertime; // 下单时间

    private Double total;  // 订单金额

    private Integer state;  // 支付状态

    private String address; // 地址

    private String contact; // 联系人

    private String telephone; // 手机号

    private Integer uid;// 用户id

    private User user; // 用户

    private List<OrderItem> orderItemList; // 订单项列表
}
