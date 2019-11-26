package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 分类实体类
 */
@Data
public class Category implements Serializable {

    private int cid;//分类id
    private String cname;//分类名称

}
