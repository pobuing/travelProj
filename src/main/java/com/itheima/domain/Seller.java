package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 商家实体类
 */
@Data
public class Seller implements Serializable {
    private int sid;//商家id
    private String sname;//商家名称
    private String consphone;//商家电话
    private String address;//商家地址

}
