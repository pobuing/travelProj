package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.utils.ResultInfo;

/**
 * @author wangxin
 * @date 2019/11/28 18:21
 * @description: TODO
 * GOOD LUCK！
 */
public interface IUserService {
    ResultInfo register(User user);

    boolean isExistByUsername(String username);

    String sendSmsCode(String telephone);

    boolean isExistByUserTelephone(String telephone);

    User pwdLogin(String username, String password);

    User findByTelephone(String telephone);

    User findByUid(int loginUserUid);

    void updateInfo(User user);
}
