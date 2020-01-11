package top.estech.core.lang;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author taoml
 * @date 2019-06-10
 */
public class AssertsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testIsNotEmptyOfString01() {
        String testStr01 = null;
        expectedException.expect(IllegalArgumentException.class);
        Asserts.isNotEmpty(testStr01);
    }

    @Test
    public void testIsNotEmptyOfString02() {
        String testStr01 = "";
        expectedException.expect(IllegalArgumentException.class);
        Asserts.isNotEmpty(testStr01);
    }

    @Test
    public void testIsNotEmptyOfString03() {
        String testStr01 = " ";
        String actual = Asserts.isNotEmpty(testStr01);
        org.junit.Assert.assertEquals(" ", actual);
    }

    @Test
    public void testIsInstanceOf01() {
        String testStr = "test";
        String actual = Asserts.isInstanceOf(String.class, testStr);
        org.junit.Assert.assertEquals(testStr, actual);
    }

    @Test
    public void testIsInstanceOf02() {
        String testStr = "test";
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("类型错误，检查对象： test");
        Asserts.isInstanceOf(Integer.class, testStr, "类型错误，检查对象： {}", "test");
    }
}
