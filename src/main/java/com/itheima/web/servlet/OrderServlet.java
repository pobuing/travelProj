package com.itheima.web.servlet;

import com.itheima.domain.Cart;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IOrderService;
import com.itheima.utils.CartRedisUtils;
import com.itheima.web.servlet.base.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangxin
 * @date 2019/12/3 19:50
 * @description: TODO
 * GOOD LUCK！
 */
@WebServlet("/order")
public class OrderServlet extends BaseServlet {
    IOrderService IOrderService = (IOrderService) BeanFactory.getBean("orderService");

    private void preOrder(HttpServletRequest request, HttpServletResponse resp) {
        try {
            User loginUser = (User) request.getSession().getAttribute("loginUser");
            if (loginUser == null) {
                resp.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            }
            //获取用户购物车
            Cart cart = CartRedisUtils.getCart(loginUser.getUid());
            request.setAttribute("cart", cart);
            request.getRequestDispatcher("/order_info.jsp")
                    .forward(request, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建订单
     *
     * @param req
     * @param resp
     */
    private void createOrder(HttpServletRequest req, HttpServletResponse resp) {

        try {
            //判断是否登录
            User loginUser = (User) req.getSession().getAttribute("loginUser");
            if (loginUser == null) {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }
            //生成订单
            Order order = IOrderService.createOrder(loginUser.getUid());
            System.out.println(order);

            //数据转发
            resp.sendRedirect(req.getContextPath()+"/pay.jsp");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
