package top.estech.core.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author taoml
 * @date 2019-08-08
 */
public class NetUtilTest {

    @Test
    public void testStringIpToLong() {
        String ip = "192.168.1.1";
        Long expect = NetUtil.ipv4ToLong(ip);
        Long actual = 3232235777L;
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testLongIpToString() {
        Long ip = 3232235777L;
        String expect = "192.168.1.1";
        String actual = NetUtil.longToIpv4(ip);
        Assert.assertEquals(expect, actual);
    }
}
