package com.itheima.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 写一个MD5算法,运行结果与MySQL的md5()函数相同  哈希算法（不可逆）  加密的密码长度为32位
 * 将明文密码转成MD5密码
 * 123456->e10adc3949ba59abbe56e057f20f883e
 * 123456->e10adc3949ba59abbe56e057f20f883e
 * 特性:
 * 	  恒等性: 多次对同一个字符串加密,得到的结果是一样的
 *    定长输出:  无论输入的字符串长度为多少,输出的长度都是一致的32
 *    雪崩效应:  输入的字符串,一旦出现一点点改变,结果大不一样
 *    不可逆性:
 */
public class MD5Util {

	//字符串加密
	public static String encodeByMd5(String text){
		byte[] secretBytes = null;
		try {
			//Java中MessageDigest类封装了MD5算法
			secretBytes = MessageDigest.getInstance("md5").digest(
					text.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}
	
	//测试
	public static void main(String[] args) throws Exception{
		String password = "12345611111";
		String passwordMD5 = MD5Util.encodeByMd5(password);
		System.out.println(password);
		System.out.println(passwordMD5);
	}
}
