package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 旅游线路图片实体类
 */
@Data
public class RouteImg implements Serializable {

    private int rgid;//商品图片id
    private int rid;//旅游商品id
    private String bigPic;//详情商品大图
    private String smallPic;//详情商品小图


}
