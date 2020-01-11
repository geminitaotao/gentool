package top.estech.core.convert;

import org.junit.Assert;
import org.junit.Test;
import top.estech.core.convert.impl.FloatConverter;
import top.estech.core.convert.impl.IntegerConverter;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class NumberConvertTest {

    @Test
    public void testIntegeConvert() {
        Converter<Integer> converter = new IntegerConverter();

        Object value = 123.45F;
        Integer expect = 123;
        Integer actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);

        value = -123.45F;
        expect = -123;
        actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);

        value = 123.45D;
        expect = 123;
        actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);

        value = 123L;
        expect = 123;
        actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);

        value = "123.45";
        expect = 123;
        actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);

        value = "-123.45";
        expect = -123;
        actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);

        value = ".45";
        actual = converter.convert(value, null);
        Assert.assertNull(actual);

        value = "1.";
        actual = converter.convert(value, null);
        Assert.assertNull(actual);

        value = "rr.45";
        expect = 1;
        actual = converter.convert(value, 1);
        Assert.assertEquals(expect, actual);

        int intValue = 123;
        expect = 123;
        actual = converter.convert(intValue, 1);
        Assert.assertEquals(expect, actual);

        long longValue = 12345667;
        expect = 12345667;
        actual = converter.convert(longValue, 1);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFloatConvert() {
        Converter<Float> converter = new FloatConverter();

        Object value = 123.45F;
        Float expect = 123.45F;
        Float actual = converter.convert(value, 1F);
        Assert.assertEquals(expect, actual);

        value = "123.45";
        expect = 123.45F;
        actual = converter.convert(value, 1F);
        Assert.assertEquals(expect, actual);

        value = "123";
        expect = 123.0F;
        actual = converter.convert(value, 1F);
        Assert.assertEquals(expect, actual);

        value = "中国";
        expect = null;
        actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);

        value = "中国";
        expect = 1F;
        actual = converter.convert(value, 1F);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testCharacterToInteger() {
        Converter<Integer> converter = new IntegerConverter();

        Character value = 'a';
        Integer expect = 97;
        Integer actual = converter.convert(value, 1);
        Assert.assertEquals(expect, actual);
    }
}
