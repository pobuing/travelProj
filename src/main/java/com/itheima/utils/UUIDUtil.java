package com.itheima.utils;

import java.util.UUID;

/**
 * 产生UUID随机字符串工具类
 */
public final class UUIDUtil {

	public static String getUuid(){
		return UUID.randomUUID().toString().replace("-","");
	}

	//测试
	public static void main(String[] args) {
		System.out.println(UUIDUtil.getUuid());
		System.out.println(UUIDUtil.getUuid());
	}
}
