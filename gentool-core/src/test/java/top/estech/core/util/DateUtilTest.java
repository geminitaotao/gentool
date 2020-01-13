package top.estech.core.util;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @author taoml
 * @date 2020-01-13
 */
public class DateUtilTest {

    @Test
    public void testTimestamp() {
        LocalDateTime time = LocalDateTime.of(2018, 6, 27, 18, 12, 5, 678000000);
        long expect = 1530094325678l;
        long actual = DateUtil.timestamp(time);
        Assert.assertEquals(expect, actual);
    }
}
