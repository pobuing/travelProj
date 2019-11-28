package com.itheima.factory;

import java.util.ResourceBundle;

/**
 * @author wangxin
 * @date 2019/11/28 18:23
 * @description: TODO
 * GOOD LUCK！
 */
public class BeanFactory {
    public static Object getBean(String classKey) {
        try {
            //读取配置文件
            ResourceBundle bundle = ResourceBundle.getBundle("beans");
            String className = bundle.getString(classKey);
            Class<?> aClass = Class.forName(className);
            Object newInstance = aClass.newInstance();
            return newInstance;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
