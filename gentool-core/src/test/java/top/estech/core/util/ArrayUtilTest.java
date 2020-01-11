package top.estech.core.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoml
 * @date 2019-06-05
 */
public class ArrayUtilTest {

    @Test
    public void testIsEmpty() {
        int[] expect = new int[10];
        // 整形数组在初始化时，默认会将所有元素赋值0
        Assert.assertFalse(ArrayUtil.isNullOrEmpty(expect));

        byte[] expect2 = {};
        Assert.assertTrue(ArrayUtil.isNullOrEmpty(expect2));
    }

    @Test
    public void testIsNotEmpty() {
        int[] expect01 = new int[10];
        int[] expect02 = {};
        Assert.assertTrue(ArrayUtil.isNotEmpty(expect01));
        Assert.assertFalse(ArrayUtil.isNotEmpty(expect02));

        long[] expectInt03 = new long[10];
        long[] expectInt04 = {};
        Assert.assertTrue(ArrayUtil.isNotEmpty(expectInt03));
        Assert.assertFalse(ArrayUtil.isNotEmpty(expectInt04));

        String[] expect05 = new String[10];
        String[] expect06 = {};
        Assert.assertTrue(ArrayUtil.isNotEmpty(expect05));
        Assert.assertFalse(ArrayUtil.isNotEmpty(expect06));
    }

    @Test
    public void testReverse() {
        String[] strArray01 = {"1", "2", "3", "4", "5"};
        ArrayUtil.reverse(strArray01);
        Assert.assertEquals("5", strArray01[0]);
        Assert.assertEquals("4", strArray01[1]);
        Assert.assertEquals("3", strArray01[2]);
        Assert.assertEquals("2", strArray01[3]);
        Assert.assertEquals("1", strArray01[4]);

        String[] strArray02 = {"1", "2", "3", "4", "5"};
        ArrayUtil.reverse(strArray02, 2, 4);
        Assert.assertEquals("1", strArray02[0]);
        Assert.assertEquals("2", strArray02[1]);
        Assert.assertEquals("5", strArray02[2]);
        Assert.assertEquals("4", strArray02[3]);
        Assert.assertEquals("3", strArray02[4]);

        String[] strArray03 = {"1", "2", "3", "4", "5"};
        ArrayUtil.reverse(strArray03, -1, 8);
        Assert.assertEquals("5", strArray03[0]);
        Assert.assertEquals("4", strArray03[1]);
        Assert.assertEquals("3", strArray03[2]);
        Assert.assertEquals("2", strArray03[3]);
        Assert.assertEquals("1", strArray03[4]);

        Long[] longArray01 = {1L, 2L, 3L, 4L, 5L};
        ArrayUtil.reverse(longArray01);
        Assert.assertEquals((Long) 5L, longArray01[0]);
        Assert.assertEquals((Long) 4L, longArray01[1]);
        Assert.assertEquals((Long) 3L, longArray01[2]);
        Assert.assertEquals((Long) 2L, longArray01[3]);
        Assert.assertEquals((Long) 1L, longArray01[4]);

        Long[] longArray02 = {1L, 2L, 3L, 4L, 5L};
        ArrayUtil.reverse(longArray02, 2, 4);
        Assert.assertEquals((Long) 1L, longArray02[0]);
        Assert.assertEquals((Long) 2L, longArray02[1]);
        Assert.assertEquals((Long) 5L, longArray02[2]);
        Assert.assertEquals((Long) 4L, longArray02[3]);
        Assert.assertEquals((Long) 3L, longArray02[4]);

        int[] intArray01 = {1, 2, 3, 4, 5};
        ArrayUtil.reverse(intArray01);
        Assert.assertEquals(5, intArray01[0]);
        Assert.assertEquals(4, intArray01[1]);
        Assert.assertEquals(3, intArray01[2]);
        Assert.assertEquals(2, intArray01[3]);
        Assert.assertEquals(1, intArray01[4]);

        int[] intArray02 = {1, 2, 3, 4, 5};
        ArrayUtil.reverse(intArray02, 2, 4);
        Assert.assertEquals(1, intArray02[0]);
        Assert.assertEquals(2, intArray02[1]);
        Assert.assertEquals(5, intArray02[2]);
        Assert.assertEquals(4, intArray02[3]);
        Assert.assertEquals(3, intArray02[4]);
    }

    @Test
    public void testToString() {
        Long test = null;
        String expect = null;
        String actual = StringUtil.toString(test);
        Assert.assertEquals(expect, actual);

        test = 3L;
        expect = "3";
        actual = StringUtil.toString(test);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testOf() {
        byte[] test = "abcdefg".getBytes();
        String expect = "abcdefg";
        String actual = StringUtil.of(test);

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testIsArray() {
        Object expect = null;
        Assert.assertFalse(ArrayUtil.isArray(expect));

        expect = new int[10];
        Assert.assertTrue(ArrayUtil.isArray(expect));

    }

    @Test
    public void testJoin() {
        String[] test = {"a", "b", "c", "d"};
        String expect = "[a],[b],[c],[d]";
        String actual = ArrayUtil.join(test, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        List[] array = new List[2];
        List<String> sub = new ArrayList<>();
        sub.add("a");
        sub.add("b");
        sub.add("c");
        sub.add("d");
        array[0] = sub;
        List<Integer> sub2 = new ArrayList<>();
        sub2.add(1);
        sub2.add(2);
        sub2.add(3);
        sub2.add(4);
        array[1] = sub2;
        expect = "[a],[b],[c],[d],[1],[2],[3],[4]";
        actual = ArrayUtil.join(array, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        int[] testInt = {1, 2, 3, 4};
        expect = "[1],[2],[3],[4]";
        actual = ArrayUtil.join(testInt, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        long[] testLong = {1L, 2L, 3L, 4L};
        expect = "[1],[2],[3],[4]";
        actual = ArrayUtil.join(testLong, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        short[] testShort = {1, 2, 3, 4};
        expect = "[1],[2],[3],[4]";
        actual = ArrayUtil.join(testShort, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        double[] testDouble = {1D, 2D, 3D, 4D};
        expect = "[1.0],[2.0],[3.0],[4.0]";
        actual = ArrayUtil.join(testDouble, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        float[] testFloat = {1F, 2F, 3F, 4F};
        expect = "[1.0],[2.0],[3.0],[4.0]";
        actual = ArrayUtil.join(testFloat, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        char[] testChar = {'1', '2', '3', '4'};
        expect = "[1],[2],[3],[4]";
        actual = ArrayUtil.join(testChar, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        byte[] testBtyte = {1, 2, 3, 4};
        expect = "[1],[2],[3],[4]";
        actual = ArrayUtil.join(testBtyte, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        boolean[] testBoolean = {false, false, true, true};
        expect = "[false],[false],[true],[true]";
        actual = ArrayUtil.join(testBoolean, ",", "[", "]");
        Assert.assertEquals(expect, actual);

    }

    @Test
    public void print() {
        double test = 1.25d;
        System.out.println(test);
        float test2 = 1f;
        System.out.println(test2);
    }
}
