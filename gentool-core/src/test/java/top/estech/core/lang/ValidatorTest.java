package top.estech.core.lang;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author taoml
 * @date 2019-08-08
 */
public class ValidatorTest {

    @Test
    public void testIsIPV4() {
        String ip = "122.33.44";
        Assert.assertFalse(Validator.isIpv4(ip));
    }

    @Test
    public void testIsInnerIP() {
        String ip = "183.129.218.236";
        Assert.assertTrue(Validator.isInnerIP(ip));

        ip = "10.0.0.0";
        Assert.assertFalse(Validator.isInnerIP(ip));

        ip = "10.255.255.255";
        Assert.assertFalse(Validator.isInnerIP(ip));

        ip = "172.16.0.0";
        Assert.assertFalse(Validator.isInnerIP(ip));

        ip = "172.31.255.255";
        Assert.assertFalse(Validator.isInnerIP(ip));

        ip = "192.168.0.0";
        Assert.assertFalse(Validator.isInnerIP(ip));

        ip = "192.168.255.255";
        Assert.assertFalse(Validator.isInnerIP(ip));
    }

    @Test
    public void testIsNumeric() {
        BigDecimal bigDecimal = new BigDecimal("-12.");
        System.out.println(bigDecimal);

        String value = "123";
        Assert.assertTrue(Validator.isNumeric(value));

        value = "123.123";
        Assert.assertTrue(Validator.isNumeric(value));

        value = "0.123";
        Assert.assertTrue(Validator.isNumeric(value));

        value = "0123.123";
        Assert.assertTrue(Validator.isNumeric(value));

        value = "-0123.123";
        Assert.assertTrue(Validator.isNumeric(value));

        value = "-123.123";
        Assert.assertTrue(Validator.isNumeric(value));
    }

    @Test
    public void testIsNotNumeric() {

        String value = "中";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "1中";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "-";
        Assert.assertFalse(Validator.isNumeric(value));

        value = ".123";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "-.123";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "-12.";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "#.123";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "1.123.4";
        Assert.assertFalse(Validator.isNumeric(value));

        value = ".123.4";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "-";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "*";
        Assert.assertFalse(Validator.isNumeric(value));

        value = "z";
        Assert.assertFalse(Validator.isNumeric(value));
    }
}
