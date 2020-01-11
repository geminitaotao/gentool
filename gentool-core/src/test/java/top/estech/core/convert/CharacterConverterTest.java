package top.estech.core.convert;

import org.junit.Assert;
import org.junit.Test;
import top.estech.core.convert.impl.CharacterConverter;

/**
 * @author taoml
 * @date 2019-09-04
 */
public class CharacterConverterTest {

    @Test
    public void testBooleanToChar() {
        CharacterConverter converter = new CharacterConverter();

        boolean value = true;

        Character expect = Character.valueOf((char) 1);
        Character actual = converter.convert(value, 'a');
        Assert.assertEquals(expect.charValue(), actual.charValue());
    }
}
