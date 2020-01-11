package top.estech.core.convert;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import top.estech.core.convert.impl.ArrayConverter;

/**
 * @author taoml
 * @date 2019-08-30
 */
public class ArrayConverterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testLongArrayToIntegerArray() {
        Converter<Integer[]> converter = new ArrayConverter<>(Integer[].class);

        Long[] longArray = {1L, 2L, 3L};
        Integer[] expect = converter.convert(longArray, null);
        Assert.assertEquals(Integer.valueOf(1), expect[0]);
        Assert.assertEquals(Integer.valueOf(2), expect[1]);
        Assert.assertEquals(Integer.valueOf(3), expect[2]);
    }

    @Test
    public void testSingleLongElementToIntegerArray() {
        Converter<Integer[]> converter = new ArrayConverter<>(Integer[].class);

        Long value = 199999L;
        Integer[] actual = converter.convert(value, null);

        Assert.assertEquals(1, actual.length);
        Assert.assertEquals(199999, actual[0].intValue());
    }

    @Test
    public void testErrorForUnSurpportConverter() {
        Converter<Source[]> converter = new ArrayConverter<>(Source[].class);

        System.out.println(Source[].class.getName());
        expectedException.expect(ConvertException.class);
        expectedException.expectMessage("不支持top.estech.core.convert.ArrayConverterTest$Source类型转换器");
        Long[] longArray = {1L, 2L, 3L};
        converter.convert(longArray, null);
    }

    @Test
    public void testStringToIntegerArrayNormal() {
        Converter<Integer[]> converter = new ArrayConverter<>(Integer[].class);

        String value = "1,2,3,4,5";
        Integer[] expect = {1, 2, 3, 4, 5};
        Integer[] actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testStringSingleElementToIntegerArray() {
        Converter<Integer[]> converter = new ArrayConverter<>(Integer[].class);

        String value = "1";
        Integer[] expect = {1};
        Integer[] actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testStringNullElementToIntegerArray() {
        Converter<Integer[]> converter = new ArrayConverter<>(Integer[].class);

        String value = "1,h,3";
        Integer[] expect = {1, null, 3};
        Integer[] actual = converter.convert(value, null);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testLongToPrimitiveIntArray() {
        Converter<int[]> converter = new ArrayConverter<>(int[].class);

        Long[] longArray = {1L, 2L, 3L};
        int[] expect = converter.convert(longArray, null);
        Assert.assertEquals(1, expect[0]);
        Assert.assertEquals(2, expect[1]);
        Assert.assertEquals(3, expect[2]);

    }

    @Test
    public void testStringToPrimitiveIntArray() {
        Converter<int[]> converter = new ArrayConverter<>(int[].class);

        String value = "1,2,3";
        int[] expect = {1, 2, 3};
        int[] actual = converter.convert(value, new int[]{});
        Assert.assertEquals(expect[0], actual[0]);
        Assert.assertEquals(expect[1], actual[1]);
        Assert.assertEquals(expect[2], actual[2]);
    }

    @Test
    public void testSingleObjectToIntegerArray() {
        Converter<Integer[]> converter = new ArrayConverter<>(Integer[].class);

        Source source = new Source();
        Integer[] expect = {null};
        Integer[] actual = converter.convert(source, new Integer[]{null});
        Assert.assertEquals(1, actual.length);
        Assert.assertEquals(expect[0], actual[0]);
    }

    private class Source {

    }
}
