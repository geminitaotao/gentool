package top.estech.core.convert.impl;

import top.estech.core.convert.Converter;
import top.estech.core.lang.Validator;
import top.estech.core.util.BooleanUtil;
import top.estech.core.util.StringUtil;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * @author taoml
 * @date 2019-09-03
 */
public class PrimitiveConverter implements Converter<Object> {

    private Class<?> targetType;

    public PrimitiveConverter(Class<?> targetType) {
        this.targetType = targetType;
    }

    @Override
    public Object convert(Object value, Object defaultValue) {
        defaultValue = defaultValue == null ? 0 : defaultValue;
        if (value == null) {
            return defaultValue;
        }

        if (targetType == value.getClass()) {
            return value;
        }

        if (int.class == targetType) {
            return toNumber(value, defaultValue,
                    number -> number.intValue(),
                    bool -> BooleanUtil.toInt(bool),
                    strValue -> new BigDecimal(strValue).intValue());
        }
        if (long.class == targetType) {
            return toNumber(value, defaultValue,
                    number -> number.longValue(),
                    bool -> BooleanUtil.toLong(bool),
                    strValue -> new BigDecimal(strValue).intValue());
        }
        if (float.class == targetType) {
            return toNumber(value, defaultValue,
                    number -> number.floatValue(),
                    bool -> BooleanUtil.toFloat(bool),
                    strValue -> new BigDecimal(strValue).floatValue());
        }
        if (double.class == targetType) {
            return toNumber(value, defaultValue,
                    number -> number.doubleValue(),
                    bool -> BooleanUtil.toDouble(bool),
                    strValue -> new BigDecimal(strValue).doubleValue());
        }
        if (short.class == targetType) {
            return toNumber(value, defaultValue,
                    number -> number.shortValue(),
                    bool -> BooleanUtil.toShort(bool),
                    strValue -> new BigDecimal(strValue).shortValue());
        }
        if (byte.class == targetType) {
            return toNumber(value, defaultValue,
                    number -> number.byteValue(),
                    bool -> BooleanUtil.toByte(bool),
                    strValue -> new BigDecimal(strValue).byteValue());
        }
        if (char.class == targetType) {
            return toChar(value);
        }
        if (boolean.class == targetType) {
            return toBoolean(value);
        }
        return defaultValue;
    }

    private Object toNumber(Object value, Object defaultValue,
                            Function<Number, Object> numberFunc,
                            Function<Boolean, Object> booleanFunc,
                            Function<String, Object> strFunc) {
        if (value instanceof Number) {
            return numberFunc.apply((Number) value);
        }
        if (value instanceof Boolean) {
            return booleanFunc.apply((Boolean) value);
        }
        if (value instanceof Character) {
            Number number = (int) ((Character) value).charValue();
            return numberFunc.apply(number);
        }
        String strValue = StringUtil.of(value);
        return Validator.isNumeric(strValue) ? strFunc.apply(strValue) : defaultValue;
    }

    private Object toChar(Object value) {
        if (value instanceof Character) {
            return ((Character) value).charValue();
        }
        if (value instanceof Boolean) {
            return BooleanUtil.toChar(((Boolean) value).booleanValue());
        }
        if (value instanceof Number) {
            return (char) ((Number) value).intValue();
        }

        return StringUtil.of(value).charAt(0);
    }

    private Object toBoolean(Object value) {
        if (value instanceof Boolean) {
            return ((Boolean) value).booleanValue();
        }
        if (value instanceof Character) {
            return BooleanUtil.toBoolean(((Character) value).charValue());
        }

        return BooleanUtil.toBoolean(StringUtil.of(value));
    }
}
