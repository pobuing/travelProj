package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 地址实体类
 */
@Data
public class Address implements Serializable {

    private Integer aid;

    private Integer uid;

    private String contact;

    private String address;

    private String telephone;

    private String isDefault;

}
