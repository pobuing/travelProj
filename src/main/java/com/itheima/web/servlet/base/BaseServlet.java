package com.itheima.web.servlet.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.utils.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangxin
 * @date 2019/11/27 17:55
 * @description: TODO
 * GOOD LUCK！
 * 基类BaseServlet
 */
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取action
        String action = req.getParameter("action");
        Class<? extends BaseServlet> aClass = this.getClass();
        try {
            Method method = aClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * 将json字符串发送到front
     *
     * @param resp
     * @param res
     * @throws IOException
     */
    protected void writeJson2front(HttpServletResponse resp, ResultInfo res) {
        try {
            //对象转json字符串
            ObjectMapper mapper = new ObjectMapper();
            String value = mapper.writeValueAsString(res);
            resp.getWriter().write(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
