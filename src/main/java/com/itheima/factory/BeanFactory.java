package com.itheima.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Date;
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
            InvocationHandler handler = new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object obj = null;
                    StringBuffer sb = new StringBuffer();
                    sb.append("调用时间" + new Date().toLocaleString());
                    sb.append("类名" + newInstance.getClass().getName());
                    sb.append("方法名" + method.getName());
                    sb.append("入参" + Arrays.toString(args));
                    //调用目标方法

                    try {
                        obj = method.invoke(newInstance, args);
                    } catch (Exception e) {
                        e.printStackTrace();
                        sb.append("异常信息" + e.getMessage());
                    }
                    String log = sb.toString();
                    writeLog(log);
                    return obj;
                }
            };
            //生成代理对象
            Object instance = Proxy.newProxyInstance(newInstance.getClass().getClassLoader(),
                    newInstance.getClass().getInterfaces(),
                    handler);
            return instance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写日志
     *
     * @param log
     */
    private static void writeLog(String log) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/wangxin/Documents/travel.txt", true));
            writer.write(log);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
