package cn.itheima.probuing.travel;

import com.itheima.utils.SmsUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 环境测试
 */
public class testEnvironment {

    @Test
    public void testSmsCode() {
        SmsUtil.sendSms("13466773423", "123456");

    }

    @Test
    public void testRedis() {

    }

}
