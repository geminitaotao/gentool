package top.estech.core.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoml
 * @date 2019-06-07
 */
public class IterationUtilTest {

    @Test
    public void testJoin() {
        List test = new ArrayList();
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("d");

        String expect = "[a],[b],[c],[d]";
        String actual = IterationUtil.join(test, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        List<List<String>> testNested = new ArrayList<>();
        List sub = new ArrayList();
        sub.add(1);
        sub.add(2);
        sub.add(3);
        sub.add(4);
        testNested.add(sub);
        sub = new ArrayList();
        sub.add("a");
        sub.add("b");
        sub.add("c");
        sub.add("d");
        testNested.add(sub);
        expect = "[1],[2],[3],[4],[a],[b],[c],[d]";
        actual = IterationUtil.join(testNested, ",", "[", "]");
        Assert.assertEquals(expect, actual);

        testNested = new ArrayList<>();
        sub = new ArrayList();
        sub.add(1);
        sub.add(2);
        sub.add(3);
        sub.add(4);
        testNested.add(sub);
        sub = new ArrayList();
        sub.add("a");
        sub.add("b");
        sub.add("c");
        sub.add("d");
        testNested.add(sub);
        expect = "1],2],3],4],a],b],c],d]";
        actual = IterationUtil.join(testNested, ",", null, "]");
        Assert.assertEquals(expect, actual);

        testNested = new ArrayList<>();
        sub = new ArrayList();
        sub.add(1);
        sub.add(2);
        sub.add(3);
        sub.add(4);
        testNested.add(sub);
        sub = new ArrayList();
        sub.add("a");
        sub.add("b");
        sub.add("c");
        sub.add("d");
        testNested.add(sub);
        expect = "[1,[2,[3,[4,[a,[b,[c,[d";
        actual = IterationUtil.join(testNested, ",", "[", null);
        Assert.assertEquals(expect, actual);
    }
}
