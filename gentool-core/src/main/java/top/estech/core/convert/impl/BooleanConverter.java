package top.estech.core.convert.impl;

import top.estech.core.convert.Converter;
import top.estech.core.util.BooleanUtil;
import top.estech.core.util.StringUtil;

import java.nio.charset.Charset;

/**
 * @author taoml
 * @date 2019-08-30
 */
public class BooleanConverter implements Converter<Boolean> {

    @Override
    public Boolean convert(Object value, Boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }

        if (value instanceof Boolean) {
            return (Boolean) value;
        }
        if (value.getClass() == boolean.class) {
            return Boolean.valueOf((boolean) value);
        }

        String strValue = StringUtil.of(value, Charset.defaultCharset());
        return Boolean.valueOf(BooleanUtil.toBoolean(strValue));
    }
}
