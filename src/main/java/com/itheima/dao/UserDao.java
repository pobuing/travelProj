package com.itheima.dao;

import com.itheima.domain.User;

/**
 * @author wangxin
 * @date 2019/11/27 11:41
 * @description: 用户持久层Dao
 * GOOD LUCK！
 */
public interface UserDao {
    /**
     * 通过用户名查询User
     *
     * @param name
     * @return
     */
    User findByUserName(String name);

    /**
     * 通过手机号查询用户
     *
     * @param phone
     * @return
     */
    User findUserByTelephone(String phone);

    /**
     * 保存数据
     *
     * @param user
     */
    void save(User user);
}
