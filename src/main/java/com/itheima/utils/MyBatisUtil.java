package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 生产SqlSession会话对象的工具类
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        try {
            // 加载核心配置文件
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 获取SqlSessionFactory工厂对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Mybatis核心配置文件加载失败...");
        }
    }

    // 获取SqlSession
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession(true);
    }
}
