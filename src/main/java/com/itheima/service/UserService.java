package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.MyBatisUtil;
import com.itheima.utils.ResultInfo;
import com.itheima.utils.SmsUtil;

import java.util.Random;

/**
 * @author wangxin
 * @date 2019/11/27 11:39
 * @description: TODO
 * GOOD LUCK！
 */
public class UserService {
    UserDao userDao = MyBatisUtil.openSession().getMapper(UserDao.class);
    /**
     * 用户注册
     *
     * @param user 用户user
     * @return
     */
    public ResultInfo register(User user) {
        //查询user
        User byUserName = userDao.findByUserName(user.getUsername());
        if (byUserName != null) {
            //用户名重复
            return new ResultInfo(1, "用户名重复");
        }
        User userByTelephone = userDao.findUserByTelephone(user.getTelephone());
        if (userByTelephone != null) {
            return new ResultInfo(2, "手机号重复");
        }
        //账号和密码都不重复 可以直接插入数据库
        userDao.save(user);
        return new ResultInfo(0);
    }

    /**
     * 查询用户是否已经存在
     *
     * @param username 需要查询的用户名
     * @return
     */
    public boolean isExistByUsername(String username) {
        User byUserName = userDao.findByUserName(username);

        return byUserName != null;
    }

    /**
     * 生成并发送验证码
     *
     * @param telephone
     */
    public String sendSmsCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int itemRandom = new Random().nextInt(9) + 1;
            sb.append(itemRandom);
        }
        //调用工具生成验证码
        String code = sb.toString();
        try {
//            SmsUtil.sendSms(telephone, code);
        } catch (Exception e) {
            e.printStackTrace();
            code = "";
        }
        return code;
    }

    public boolean isExistByUserTelephone(String telephone) {
        User existByUserTelephone = userDao.findUserByTelephone(telephone);
        return existByUserTelephone!=null;
    }
}
