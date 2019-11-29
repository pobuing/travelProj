package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import com.itheima.utils.MD5Util;
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
public class UserServiceImpl implements IUserService {
    UserDao userDao = MyBatisUtil.openSession().getMapper(UserDao.class);

    /**
     * 用户注册
     *
     * @param user 用户user
     * @return
     */
    @Override
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
    @Override

    public boolean isExistByUsername(String username) {
        User byUserName = userDao.findByUserName(username);

        return byUserName != null;
    }

    /**
     * 生成并发送验证码
     *
     * @param telephone
     */
    @Override

    public String sendSmsCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int itemRandom = new Random().nextInt(9) + 1;
            sb.append(itemRandom);
        }
        //调用工具生成验证码
        String code = sb.toString();
        try {
            SmsUtil.sendSms(telephone, code);
        } catch (Exception e) {
            e.printStackTrace();
            code = "";
        }
        return code;
    }

    @Override
    public boolean isExistByUserTelephone(String telephone) {
        User existByUserTelephone = userDao.findUserByTelephone(telephone);
        return existByUserTelephone != null;
    }

    /**
     * 账号密码登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User pwdLogin(String username, String password) {
        //密码价目
        String encodeByMd5 = MD5Util.encodeByMd5(password);
        return userDao.findByUserNameAndPassword(username, password);
    }

    @Override
    public User findByTelephone(String telephone) {
        return userDao.findUserByTelephone(telephone);
    }

    /**
     * 通过uid查询user
     *
     * @param loginUserUid
     * @return
     */
    @Override
    public User findByUid(int loginUserUid) {

        return userDao.findByUid(loginUserUid);
    }

    @Override
    public void updateInfo(User user) {
        userDao.update(user);
    }
}
