package top.estech.core.convert;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author taoml
 * @date 2019-09-03
 */
public class PrimitiveConverterTest {

    @Test
    public void testLongToInt() {
        Long value = 123456L;

        int expect = 123456;
        int actual = ConverterRegistry.me().converter(int.class).convert(value, 1);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testCharToInt() {
        Character value = 'a';

        int expect = 97;
        int actual = ConverterRegistry.me().converter(int.class).convert(value, 1);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testCharToByte() {
        Character value = 'a';

        byte expect = 97;
        byte actual = ConverterRegistry.me().converter(byte.class).convert(value, (byte) 1);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testIntToChar() {
        int value = 97;

        char expect = 'a';
        char actual = ConverterRegistry.me().converter(char.class).convert(value, '0');
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testIntToBoolean() {
        int value = 1;

        boolean expect = true;
        boolean actual = ConverterRegistry.me().converter(boolean.class).convert(value, false);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testCharToBoolean() {
        int original = 1;
        char value = (char) original;

        boolean expect = true;
        boolean actual = ConverterRegistry.me().converter(boolean.class).convert(value, false);
        Assert.assertEquals(expect, actual);
    }

}
