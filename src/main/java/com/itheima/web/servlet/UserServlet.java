package com.itheima.web.servlet;

import com.itheima.domain.Address;
import com.itheima.domain.User;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAddressService;
import com.itheima.service.impl.AddressServiceImpl;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.service.IUserService;
import com.itheima.utils.JedisUtil;
import com.itheima.utils.ResultInfo;
import com.itheima.utils.UUIDUtil;
import com.itheima.web.servlet.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * @author wangxin
 * @date 2019/11/27 11:33
 * @description: TODO
 * GOOD LUCK！
 */
@WebServlet("/user")
//支持文件上传
@MultipartConfig
public class UserServlet extends BaseServlet {
    IUserService userServiceImpl = (UserServiceImpl) BeanFactory.getBean("userService");
    IAddressService addressService = (AddressServiceImpl) BeanFactory.getBean("addressService");

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
        if (userServiceImpl.isExistByUsername(username)) {
            //已经存在
            res = new ResultInfo(1, "用户名已经存在");
        } else {
            res = new ResultInfo(2, "用户名不存在");
        }
        writeJson2front(resp, res);
    }

    /**
     * 查询手机号是否存在
     *
     * @param req
     * @param resp
     */
    private void isExistByTelephone(HttpServletRequest req, HttpServletResponse resp) {
        //接收参数
        String telephone = req.getParameter("telephone");
        //调用service查询
        ResultInfo res = null;
        if (userServiceImpl.isExistByUserTelephone(telephone)) {
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
        /*
        String savedSmsCode = (String) req.getSession().getAttribute(telephone);
         */
        //从redis中获取验证码
        Jedis jedis = JedisUtil.getJedis();
        String savedSmsCode = jedis.get(telephone);
        //判断验证码是否正确
        if (!StringUtils.isEmpty(smsCode) && StringUtils.equals(smsCode, savedSmsCode)) {
            //正确 清除session中的数据
//            req.getSession().removeAttribute(telephone);
            //正确 删除redis中的数据
            jedis.del(telephone);
            jedis.close();
        } else {
            req.setAttribute("resultInfo", new ResultInfo(3, "短信验证码错误"));
            //请求转发
            req.getRequestDispatcher("/register.jsp")
                    .forward(req, resp);
            jedis.close();
            return;
        }

        //参数封装对象
        Map<String, String[]> paramMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, paramMap);
            //创建service
            ResultInfo resultInfo = userServiceImpl.register(user);
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
        String smsCode = userServiceImpl.sendSmsCode(telephone);
        System.out.println("生成的验证码" + smsCode);
        //返回用户提示
        ResultInfo resultInfo = null;
        if (!StringUtils.isEmpty(smsCode)) {
            /*
            //存储验证码到session
            req.getSession().setAttribute(telephone, smsCode);
            resultInfo = new ResultInfo(0, "发送短信成功");
             */
            //存储验证码到redis 设置过期时间5分钟
            JedisUtil.getJedis().setex(telephone, 300, smsCode);
            resultInfo = new ResultInfo(0, "发送短信成功");
        } else {
            resultInfo = new ResultInfo(0, "发送短信失败，请重试");
        }
        //写回数据
        writeJson2front(resp, resultInfo);

    }

    /**
     * 用户名密码登录
     *
     * @param req
     * @param resp
     */
    private void pwdLogin(HttpServletRequest req, HttpServletResponse resp) {
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用service登录
        User user = userServiceImpl.pwdLogin(username, password);
        ResultInfo res = null;
        //判断user是否存在
        if (user == null) {
            res = new ResultInfo(1, "用户名或密码错误");
        } else {
            //存储session数据
            req.getSession().setAttribute("loginUser", user);
            res = new ResultInfo(0);
        }
        //写回数据
        writeJson2front(resp, res);
    }

    /**
     * 手机号验证码登录
     *
     * @param request
     * @param resp
     */
    private void telLogin(HttpServletRequest request, HttpServletResponse resp) {
        //接收参数
        String telephone = request.getParameter("telephone");
        String smsCode = request.getParameter("smsCode");
        //查询手机号是否存在
        User user = userServiceImpl.findByTelephone(telephone);
        ResultInfo resi = null;
        if (user == null) {
            resi = new ResultInfo(1, "手机号不存在");
        } else {
            //获取生成的验证码
            String smsCodeFromat = (String) request.getSession().getAttribute(telephone);
            if (StringUtils.isNotEmpty(smsCodeFromat)
                    && StringUtils.isNotEmpty(smsCode)
                    && StringUtils.equals(smsCode, smsCodeFromat)) {
                //记录user到当前session
                request.getSession().setAttribute("loginUser", user);
                //清理存储的验证码
                request.getSession().removeAttribute(telephone);
                resi = new ResultInfo(0);
            } else {
                resi = new ResultInfo(2, "验证码错误");
            }
        }
        writeJson2front(resp, resi);
    }

    /**
     * 用户退出
     *
     * @param request
     * @param resp
     */
    private void logout(HttpServletRequest request, HttpServletResponse resp) {
        //注销session
        request.getSession().removeAttribute("loginUser");
        //重定向到首页
        try {
            resp.sendRedirect(request.getContextPath() + "/index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取用户信息
     *
     * @param req
     * @param resp
     */
    private void userInfo(HttpServletRequest req, HttpServletResponse resp) {
        //判断用户是否登录
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            try {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        try {
            req.getRequestDispatcher("/home_index.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新用户信息
     *
     * @param req
     * @param resp
     */
    private void updateInfo(HttpServletRequest req, HttpServletResponse resp) {
        //判断用户是否登录
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        try {
            if (loginUser == null) {
                //未登录，重定向到index
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }
            //已经登录 封装参数为user对象
            User user = new User();
            BeanUtils.populate(user, req.getParameterMap());
            //此时user已经存储更新数据
            //更改uid
            user.setUid(loginUser.getUid());
            // TODO:图片上传
            //获取上传的图片
            Part part = req.getPart("pic");
            //获取上传的文件名称
            String cd = part.getHeader("Content-Disposition");
            System.out.println(cd);
            String fileName = cd.substring(cd.lastIndexOf("=") + 2, cd.length() - 1);
            System.out.println("fileName = " + fileName);
            if (StringUtils.isEmpty(fileName)) {
                //判断如果没有存储才设置为空，有图片存储不更换图片
                if (StringUtils.isEmpty(user.getPic())) {
                    user.setPic(null);
                }
            } else {
                //有文件上传
                //创建唯一名字
                String newFileName = UUIDUtil.getUuid() + fileName;
                //组织文件上传路径
                String newFilePath = "/pic/" + newFileName;
                System.out.println("newFileName = " + newFileName);
                //获取绝对路径
                String realPath = req.getServletContext().getRealPath(newFilePath);
                System.out.println("realPath = " + realPath);
                //写入文件(上传文件写入 必须使用绝对路径)
                part.write(realPath);
                //写入完成后 设置到用户实体中
                user.setPic(newFilePath);
            }

            //调用service
            userServiceImpl.updateInfo(user);
            //再查询一次
            User u = userServiceImpl.findByUid(loginUser.getUid());
            //覆盖session域中的数据
            req.getSession().setAttribute("loginUser", u);
            //重定向
            resp.sendRedirect(req.getContextPath() + "/user?action=userInfo");

        } catch (IOException | IllegalAccessException | InvocationTargetException | ServletException e) {
            e.printStackTrace();
        }


    }

    /**
     * 查找用户的地址
     *
     * @param request
     * @param resp
     */
    private void findAddress(HttpServletRequest request, HttpServletResponse resp) {
        //判断用户是否登录
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        try {
            if (loginUser == null) {
                //重定向到index
                resp.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            }
            //调用service查询地址
            List<Address> addresses = addressService.findMyAddress(loginUser.getUid());
            //放入request
            request.setAttribute("addressList", addresses);
            request.getRequestDispatcher("/home_address.jsp")
                    .forward(request, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加地址
     *
     * @param req
     * @param resp
     */
    private void addAddress(HttpServletRequest req, HttpServletResponse resp) {
        User loginUser = (User) req.getSession().getAttribute("loginUser");
        try {
            if (loginUser == null) {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }
            //封装参数为对象
            Address address = new Address();
            BeanUtils.populate(address, req.getParameterMap());
            //调用service添加
            //取出登录用户uid
            address.setUid(loginUser.getUid());
            addressService.save(address);
            //重定向回地址页面
            resp.sendRedirect(req.getContextPath() + "/user?action=findAddress");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除地址byid
     *
     * @param req
     * @param resp
     */
    private void delAddressById(HttpServletRequest req, HttpServletResponse resp) {
        //获取address id
        String addressId = req.getParameter("addressId");
        //调用service删除address
        addressService.delAddressById(addressId);
        //重定向回用户页面
        try {
            resp.sendRedirect(req.getContextPath() + "/user?action=findAddress");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
