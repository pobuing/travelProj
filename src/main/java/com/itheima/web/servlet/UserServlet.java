package com.itheima.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.ResultInfo;
import com.itheima.web.servlet.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author wangxin
 * @date 2019/11/27 11:33
 * @description: TODO
 * GOOD LUCK！
 */
@WebServlet("/user")
public class UserServlet extends BaseServlet {
    UserService userService = new UserService();

    /**
     * 验证用户是否已经存在
     *
     * @param req
     * @param resp
     */
    private void isExistByUsername(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //接收参数
        String username = req.getParameter("username");
        ResultInfo res = null;
        //调用service查询
        if (userService.isExistByUsername(username)) {
            //已经存在
            res = new ResultInfo(1, "用户名已经存在");
        } else {
            res = new ResultInfo(2, "用户名不存在");
        }
        writeJson2front(resp, res);
    }


    private void isExistByTelephone(HttpServletRequest req, HttpServletResponse resp) {
        //接收参数
        String telephone = req.getParameter("telephone");
        //调用service查询
        ResultInfo res = null;
        if (userService.isExistByUserTelephone(telephone)) {
            res = new ResultInfo(1, "手机号已经存在");
        } else {
            res = new ResultInfo(2, "手机号不存在");
        }
        writeJson2front(resp, res);
    }

    /**
     * 用户注册
     *
     * @param req
     * @param resp
     */
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取验证码
        String telephone = req.getParameter("telephone");
        //获取输入的验证码
        String smsCode = req.getParameter("smsCode");
        String savedSmsCode = (String) req.getSession().getAttribute(telephone);
        //判断验证码是否正确
        if (!StringUtils.isEmpty(smsCode) && StringUtils.equals(smsCode, savedSmsCode)) {
            //正确 清除session中的数据
            req.getSession().removeAttribute(telephone);
        } else {
            req.setAttribute("resultInfo", new ResultInfo(3, "短信验证码错误"));
            //请求转发
            req.getRequestDispatcher("/register.jsp")
                    .forward(req, resp);
            return;
        }

        //参数封装对象
        Map<String, String[]> paramMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, paramMap);
            //创建service
            ResultInfo resultInfo = userService.register(user);
            //判断执行结果
            if (resultInfo.getCode() == 0) {
                //成功
                //重定向到首页
                resp.sendRedirect(req.getContextPath() + "/register_ok.jsp");
            } else {
                //失败转发回首页
                req.setAttribute("resultInfo", resultInfo);
                req.getRequestDispatcher("/register.jsp")
                        .forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送短信验证码方法
     *
     * @param req
     * @param resp
     */
    private void sendSmsCode(HttpServletRequest req, HttpServletResponse resp) {
        String telephone = req.getParameter("telephone");
        //调用service发送验证码
        String smsCode = userService.sendSmsCode(telephone);
        System.out.println("生成的验证码" + smsCode);
        //返回用户提示
        ResultInfo resultInfo = null;
        if (!StringUtils.isEmpty(smsCode)) {
            //存储验证码到session
            req.getSession().setAttribute(telephone, smsCode);
            resultInfo = new ResultInfo(0, "发送短信成功");
        } else {
            resultInfo = new ResultInfo(0, "发送短信成功");
        }
        //写回数据
        writeJson2front(resp, resultInfo);

    }

}
