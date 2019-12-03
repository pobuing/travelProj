package com.itheima.domain;

import com.itheima.domain.Route;
import lombok.Data;

/**
 * @author wangxin
 * @date 2019/12/3 16:55
 * @description: TODO
 * GOOD LUCK！
 * 购物项
 */
@Data
public class CarItem {
    private Route route;//购买的路线
    private int num;//商品数量
    private Double price;//商品价格

    public Double getPrice() {
        return route.getPrice() * num;
    }
}
