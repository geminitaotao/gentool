package top.estech.core.convert.impl;

import top.estech.core.convert.Converter;
import top.estech.core.util.BooleanUtil;
import top.estech.core.util.StringUtil;

import java.nio.charset.Charset;

/**
 * @author taoml
 * @date 2019-09-02
 */
public class CharacterConverter implements Converter<Character> {

    @Override
    public Character convert(Object value, Character defaultValue) {
        if (value == null) {
            return defaultValue;
        }

        if (value.getClass() == char.class) {
            return Character.valueOf((char) value);
        }
        if (value.getClass() == boolean.class) {
            return BooleanUtil.toCharacter((boolean) value);
        }
        if (value instanceof Character) {
            return (Character) value;
        }

        if (value instanceof Boolean) {
            return BooleanUtil.toCharacter((Boolean) value);
        }

        String strValue = StringUtil.of(value, Charset.defaultCharset());
        return strValue == null ? defaultValue : strValue.charAt(0);
    }
}
