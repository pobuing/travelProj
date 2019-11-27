package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 */
@Data
public class User implements Serializable {

    private int uid;//用户id
    private String username;//用户名，账号
    private String password;//密码
    private String telephone;//手机号
    private String nickname;//昵称
    private String sex;//男或女
    private String birthday;//出生日期
    private String email;//邮箱
    private String pic; // 头像


}
