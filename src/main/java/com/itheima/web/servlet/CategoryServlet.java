package com.itheima.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Category;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAddressService;
import com.itheima.service.ICategoryService;
import com.itheima.utils.JedisUtil;
import com.itheima.utils.ResultInfo;
import com.itheima.web.servlet.base.BaseServlet;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author wangxin
 * @date 2019/11/30 12:12
 * @description: TODO
 * GOOD LUCK！
 */
@WebServlet("/category")
public class CategoryServlet extends BaseServlet {
    ICategoryService categoryService = (ICategoryService) BeanFactory.getBean("categoryService");
    private ResultInfo rs;

    private void findAllCategory(HttpServletRequest req, HttpServletResponse response) {
        Jedis jedis = null;
        try {
            //先从redis数据库查询
            jedis = JedisUtil.getJedis();
            ObjectMapper mapper = new ObjectMapper();
            //查询导航栏存储
            String navStr = jedis.get("travel:nav");
            if (StringUtils.isEmpty(navStr)) {
                System.out.println("from mysql");
                // TODO: redis没有查询到查询数据库
                List<Category> categories = categoryService.findAllCategory();
                rs = new ResultInfo(0, "查询成功", categories);
                //存入redis数据库
                String writeValueAsString = mapper.writeValueAsString(categories);
                jedis.set("travel:nav", writeValueAsString);
            } else {
                System.out.println("from redis");
                // TODO: 查询redis到了
                //str ---> list
                List categoryList = mapper.readValue(navStr, List.class);
                //存储数据
                rs = new ResultInfo(0, "查询成功", categoryList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //数据写回
        writeJson2front(response, rs);
        jedis.close();


    }
}
