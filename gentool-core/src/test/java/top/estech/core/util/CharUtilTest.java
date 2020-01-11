package top.estech.core.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author taoml
 * @date 2019-06-06
 */
public class CharUtilTest {

    @Test
    public void testIsEmoji() throws UnsupportedEncodingException {
        String test = "\uD83D\uDD63";
        Assert.assertTrue(CharUtil.isEmoji(test.charAt(0)));
    }
}
