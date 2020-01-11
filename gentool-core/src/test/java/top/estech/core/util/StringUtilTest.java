package top.estech.core.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taoml
 * @date 2019-06-04
 */
public class StringUtilTest {

    @Test
    public void testIsEmpty() {
        String strNull = null;
        String strEmpty = "";
        String strNotEmpty = "abc";

        Assert.assertTrue(StringUtil.isNullOrEmpty(strNull));
        Assert.assertTrue(StringUtil.isNullOrEmpty(strEmpty));
        Assert.assertFalse(StringUtil.isNullOrEmpty(strNotEmpty));
    }

    @Test
    public void testIsNotEmpty() {
        String strNull = null;
        String strEmpty = "";
        String testValue = "aa bb cc";

        Assert.assertFalse(StringUtil.isNotEmpty(strNull));
        Assert.assertFalse(StringUtil.isNotEmpty(strEmpty));
        Assert.assertTrue(StringUtil.isNotEmpty(testValue));
    }

    @Test
    public void testNullToEmpty() {
        String test = null;
        String expect = "";
        String actual = StringUtil.nullToEmpty(test);

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSubString() {
        String value01 = "上下五千年";
        String value02 = "about5000year";

        String expect = "五千年";
        Assert.assertEquals(expect, StringUtil.subString(value01, 2));
        Assert.assertEquals(expect, StringUtil.subString(value01, 2, 5));

        expect = "5000year";
        Assert.assertEquals(expect, StringUtil.subString(value02, 5));
        Assert.assertEquals(expect, StringUtil.subString(value02, 5, 13));

        expect = "年";
        Assert.assertEquals(expect, StringUtil.subString(value01, -1));
        Assert.assertEquals(expect, StringUtil.subString(value01, -1, -7));

        expect = "下五千";
        Assert.assertEquals(expect, StringUtil.subString(value01, -1, -4));

        expect = "r";
        Assert.assertEquals(expect, StringUtil.subString(value02, -1));
        Assert.assertEquals(expect, StringUtil.subString(value02, -1, -14));

        expect = "000yea";
        Assert.assertEquals(expect, StringUtil.subString(value02, -1, -7));
    }

    @Test
    public void testRepeatChar() {
        char c = 'a';
        int count = 100;
        StringBuilder test = new StringBuilder();
        for (int i = 0; i < count; i++) {
            test.append(c);
        }
        String expect = test.toString();
        String actual = StringUtil.repeat(c, count);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testRepeatString() {
        int count = 10000;
        int length = 100;
        StringBuilder test = new StringBuilder();
        for (int i = 0; i < length; i++) {
            test.append("abc");
        }
        String testString = test.toString();

        long start = System.currentTimeMillis();
        String actual = StringUtil.repeat(testString, count);
        long end = System.currentTimeMillis();
        System.out.println("repeat timespan: " + (end - start));

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(testString);
        }
        String expect = sb.toString();
        end = System.currentTimeMillis();
        System.out.println("sb time span: " + (end - start));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testReverse() {
        String test = "abcd";
        String expect = "dcba";
        String actual = StringUtil.reverse(test);

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testPadLeft() {
        String part = "abc";
        String expect = "000abc";
        String actual = StringUtil.padLeft(part, 6, '0');
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testPadRight() {
        String part = "abc";
        String expect = "abc000";
        String actual = StringUtil.padRight(part, 6, '0');
        Assert.assertEquals(expect, actual);

        part = "abcdefgh";
        expect = "abcdefgh";
        actual = StringUtil.padRight(part, 6, '0');
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testSubLeft() {
        String test = "abcdefg";
        String expect = "abcd";
        String actual = StringUtil.subLeft(test, 4);
        Assert.assertEquals(expect, actual);

        expect = "abcdef";
        actual = StringUtil.subLeft(test, -1);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testWrap() {
        String test = "中国";
        String expect = "[中国]";
        String actual = StringUtil.wrap(test, "[", "]");
        Assert.assertEquals(expect, actual);

        expect = "[中国";
        actual = StringUtil.wrap(test, "[", null);
        Assert.assertEquals(expect, actual);

        expect = "中国]";
        actual = StringUtil.wrap(test, null, "]");
        Assert.assertEquals(expect, actual);

        expect = "中国";
        actual = StringUtil.wrap(test, "", "");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFormat() {
        String template = "我的名字是: {name}, 我来自: {place}";
        Map<String, String> map = new HashMap<>();
        map.put("name", "李明");
        map.put("place", "中国");
        String expect = "我的名字是: 李明, 我来自: 中国";
        String actual = StringUtil.format(template, map);
        Assert.assertEquals(expect, actual);

        template = "我的名字是: , 我来自: ";
        expect = "我的名字是: , 我来自: ";
        actual = StringUtil.format(template, "李明", "中国");
        Assert.assertEquals(expect, actual);

        template = "我的名字是: {}, 我来自: {}";
        expect = "我的名字是: 李明, 我来自: 中国";
        actual = StringUtil.format(template, "李明", "中国");
        Assert.assertEquals(expect, actual);

        template = "我的名字是: {}, 我来自: ";
        expect = "我的名字是: 李明, 我来自: ";
        actual = StringUtil.format(template, "李明", "中国");
        Assert.assertEquals(expect, actual);

        template = "我的名字是: {}, 我来自: {}";
        expect = "我的名字是: 李明, 我来自: {}";
        actual = StringUtil.format(template, "李明");
        Assert.assertEquals(expect, actual);

        template = "我的名字是: {}{}, 我来自: {}";
        expect = "我的名字是: 李明{}, 我来自: {}";
        actual = StringUtil.format(template, "李明");
        Assert.assertEquals(expect, actual);

        template = "我的名字是: {}{}, 我来自: {}";
        expect = "我的名字是: 李明中国, 我来自: {}";
        actual = StringUtil.format(template, "李明", "中国");
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testIsNumber() {
        String value = "123.45";
        Assert.assertTrue(StringUtil.isNumber(value));

        value = ".45";
        Assert.assertTrue(StringUtil.isNumber(value));

        value = "-.45";
        Assert.assertTrue(StringUtil.isNumber(value));
    }

    @Test
    public void test() {
        String test = "var is {name}, var2 is {name}".replace("{name}", "goods");
        System.out.println(test);

        test = "abcdef";
        StringBuilder builder = new StringBuilder();
        builder.append(test, 1, 3);
        System.out.println(builder.toString());

        test = "\\r{}{}";
        System.out.println(test.indexOf(StringUtil.EMPTY_JSON));
    }
}
