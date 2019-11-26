package com.itheima.utils;

import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信支付工具类
 */
public class WxPayUtil {

    // 公众账号ID
    private static final String APP_ID = "wx8397f8696b538317";

    // 商户号ID
    private static final String MCH_ID = "1473426802";

    // 生成签名的秘钥
    private static final String KEY = "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb";

    /**
     * 发起微信支付请求
     *
     * @param orderId 订单号
     * @param price   金额
     * @return 本次交易支付地址
     */
    public static String createPay(String orderId, Double price) {
        try {
            //1 组装请求数据
            Map<String, String> data = new HashMap<>();
            data.put("appid", APP_ID);// 公众账号ID
            data.put("mch_id", MCH_ID);// 商户号ID
            data.put("nonce_str", WXPayUtil.generateNonceStr()); // 随机数
            data.put("body", "黑马旅游网支付中心-商品支付");//商品描述
            data.put("out_trade_no", orderId);//订单号
            data.put("total_fee", "1"); // 实际支付价格 测试时 使用1分钱
            data.put("spbill_create_ip", "127.0.0.1");//调用微信支付的终端IP
            data.put("notify_url", "www.itheima.com");//回调地址,本次不需要,只要是一个合法的网址即可
            data.put("trade_type", "NATIVE");// 交易类型为扫码支付
            String timeExpire = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date().getTime() + 1000 * 60 * 5);
            data.put("time_expire", timeExpire);

            //2 将数据转xml格式
            String paramXml = WXPayUtil.generateSignedXml(data, KEY);

            //3 基于RestTemplate工具类，调用微信支付平台，完成支付操作
            String resultString = getRestTemplate().postForObject("https://api.mch.weixin.qq.com/pay/unifiedorder", paramXml, String.class);

            //4 将返回结果转成map结构
            Map<String, String> stringStringMap = WXPayUtil.xmlToMap(resultString);

            //5 获取返回的支付地址
            String codeUrl = stringStringMap.get("code_url");

            return codeUrl;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 支付状态查询
     *
     * @param orderId 订单号
     * @return 0 支付成功 1 未支付
     */
    public static String queryPayStatus(String orderId) {
        try {
            //1 组装请求数据
            Map<String, String> data = new HashMap<>();
            data.put("appid", APP_ID);// 公众账号ID
            data.put("mch_id", MCH_ID);// 商户号ID
            data.put("nonce_str", WXPayUtil.generateNonceStr()); // 随机数
            data.put("out_trade_no", orderId);//订单号

            //2 将参数转xml
            String paramXml = WXPayUtil.generateSignedXml(data, KEY);

            //3 基于restTemplate工具类，调用微信支付平台，完成支付状态操作操作
            String resultString = getRestTemplate().postForObject("https://api.mch.weixin.qq.com/pay/orderquery", paramXml, String.class);

            //4 处理响应结果
            Map<String, String> resultMap = WXPayUtil.xmlToMap(resultString);

            //支付成功，返回状态0
            if ("SUCCESS".equals(resultMap.get("trade_state"))) {
                return "0";
            } else {
                return "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    // 获取操作http的工具
    private static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        stringHttpMessageConverter.setDefaultCharset(Charset.forName("utf-8"));//处理乱码
        restTemplate.getMessageConverters().set(1, stringHttpMessageConverter);
        return restTemplate;
    }

    // 测试
    public static void main(String[] args) {
//        String a = createPay("11111111sssss", 0d);
//        System.out.println(a);


//        String a = queryPayStatus("11111111sssss");
//        System.out.println(a);
    }
}

