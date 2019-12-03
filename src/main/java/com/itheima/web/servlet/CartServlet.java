package com.itheima.web.servlet;

import com.itheima.domain.CarItem;
import com.itheima.domain.Cart;
import com.itheima.domain.Route;
import com.itheima.domain.User;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IRouteService;
import com.itheima.utils.CartRedisUtils;
import com.itheima.web.servlet.base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wangxin
 * @date 2019/12/3 17:40
 * @description: TODO
 * GOOD LUCK！
 * 购物车Servlet
 */
@WebServlet("/cart")
public class CartServlet extends BaseServlet {
    IRouteService routeService = (IRouteService) BeanFactory.getBean("routeService");

    private void addCart(HttpServletRequest request, HttpServletResponse resp) {
        try {
            //判断是否登录
            User loginUser = (User) request.getSession().getAttribute("loginUser");
            if (loginUser == null) {
                //未登录 重定向
                resp.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            }
            String rid = request.getParameter("rid");
            String num = request.getParameter("num");
            //调用routeService查询路线
            Route route = routeService.findRouteByRid(rid);
            //获取购物车
            Cart cart = CartRedisUtils.getCart(loginUser.getUid());
            //向购物车添加商品
            int itemNum = Integer.parseInt(num);
            cart.save(itemNum, route);
            //写回redis数据库
            CartRedisUtils.setCart(loginUser.getUid(), cart);
            CarItem carItem = new CarItem();
            carItem.setNum(itemNum);
            carItem.setRoute(route);
            request.setAttribute("cartItem", carItem);
            request.getRequestDispatcher("/cart_success.jsp")
                    .forward(request, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看购物车
     *
     * @param req
     * @param resp
     */
    private void showCart(HttpServletRequest req, HttpServletResponse resp) {
        //判断是否登录
        try {
            User loginUser = (User) req.getSession().getAttribute("loginUser");
            if (loginUser == null) {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }

            int uid = loginUser.getUid();
            //从redis中取出购物车数据
            Cart cart = CartRedisUtils.getCart(uid);
            req.setAttribute("cart", cart);
            req.getRequestDispatcher("/cart.jsp")
                    .forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除购物项
     *
     * @param req
     * @param resp
     */
    private void delCartItem(HttpServletRequest req, HttpServletResponse resp) {
        try {
            User loginUser = (User) req.getSession().getAttribute("loginUser");
            if (loginUser == null) {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
                return;
            }
            String ridStr = req.getParameter("rid");
            int rid = Integer.parseInt(ridStr);
            //获取购物车
            Cart cart = CartRedisUtils.getCart(loginUser.getUid());
            //从购物车中删除指定的item
            cart.remove(rid);
            //写回购物车
            CartRedisUtils.setCart(loginUser.getUid(), cart);
            //页面重定向回查看购物车页面
            resp.sendRedirect(req.getContextPath() + "/cart?action=showCart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
