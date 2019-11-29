package cn.itheima.probuing.travel;

import com.itheima.utils.SmsUtil;
import org.junit.Test;

/**
 * 环境测试
 */
public class testEnvironment {

    @Test
    public void testSmsCode(){
        SmsUtil.sendSms("13466773423","123456");

    }
}
