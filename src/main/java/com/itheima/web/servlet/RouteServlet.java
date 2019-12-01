package com.itheima.web.servlet;

import com.itheima.domain.Route;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IRouteService;
import com.itheima.utils.PageBean;
import com.itheima.web.servlet.base.BaseServlet;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wangxin
 * @date 2019/12/1 12:02
 * @description: TODO
 * GOOD LUCK！
 * 查询路线详情
 */
@WebServlet("/route")
public class RouteServlet extends BaseServlet {
    IRouteService routerService = (IRouteService) BeanFactory.getBean("routerService");

    private void findRoutByPage(HttpServletRequest req, HttpServletResponse resp) {
        //获取参数
        String cidStr = req.getParameter("cid");
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
        String rname = req.getParameter("rname");
        //赋值默认
        if (StringUtils.isEmpty(currentPageStr)) {
            currentPageStr = "1";
        }
        if (StringUtils.isEmpty(pageSizeStr)) {
            pageSizeStr = "10";
        }
        //String ---> integer
        Integer cid = Integer.valueOf(cidStr);
        Integer currentPage = Integer.valueOf(currentPageStr);
        Integer pageSize = Integer.valueOf(pageSizeStr);
        //调用service查询
        PageBean<Route> pageBean = routerService.findRouteByPage(cid, currentPage, pageSize, rname);
        //查询cname
        String cname = routerService.findCnameByCid(cid);
        if (StringUtils.isEmpty(cname)) {
            cname = "首页";
        }
        req.setAttribute("pb", pageBean);
        req.setAttribute("cid", cid);
        req.setAttribute("cname", cname);

        req.setAttribute("rname", rname);
        //页面转发
        try {
            req.getRequestDispatcher("/route_list.jsp")
                    .forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
