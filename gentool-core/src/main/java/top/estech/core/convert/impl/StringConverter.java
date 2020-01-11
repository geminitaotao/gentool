package top.estech.core.convert.impl;

import top.estech.core.convert.Converter;
import top.estech.core.util.StringUtil;

import java.nio.charset.Charset;

/**
 * @author taoml
 * @date 2019-08-12
 */
public class StringConverter implements Converter<String> {

    @Override
    public String convert(Object value, String defaultValue) {
        if (value == null) {
            return defaultValue;
        }

        return StringUtil.of(value, Charset.defaultCharset());
    }
}
