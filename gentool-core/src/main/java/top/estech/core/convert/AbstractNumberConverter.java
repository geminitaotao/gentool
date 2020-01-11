package top.estech.core.convert;

import top.estech.core.lang.Validator;
import top.estech.core.util.ClassUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author taoml
 * @date 2019-08-29
 */
public abstract class AbstractNumberConverter<T extends Number> implements Converter<T> {

    private Class<T> targetType;

    protected AbstractNumberConverter() {
        targetType = (Class<T>) ClassUtil.getTypeArgument(getClass());
    }

    @Override
    public T convert(Object value, T defaultValue) {
        if (value == null) {
            return defaultValue;
        }

        if (value.getClass() == targetType) {
            return (T) value;
        }
        if (value instanceof Number) {
            Number number = (Number) value;
            return cast(number);
        }
        if (value instanceof Character) {
            int intValue = ((Character) value).charValue();
            return cast(intValue);
        }
        if (value instanceof CharSequence) {
            return CharSequenceToTarget(value, defaultValue);
        }
        return defaultValue;
    }

    protected abstract T cast(Number number);

    protected BigDecimal toBigDecimal(Number number) {
        if (number instanceof BigDecimal) {
            return (BigDecimal) number;
        }
        if (number instanceof Integer) {
            return new BigDecimal(number.intValue());
        }
        if (number instanceof Long) {
            return new BigDecimal(number.longValue());
        }
        if (number instanceof Float) {
            return new BigDecimal(number.floatValue());
        }
        if (number instanceof Double) {
            return new BigDecimal(number.doubleValue());
        }
        if (number instanceof Short) {
            return new BigDecimal(number.shortValue());
        }
        if (number instanceof Byte) {
            return new BigDecimal(number.byteValue());
        }
        if (number instanceof BigInteger) {
            return new BigDecimal((BigInteger) number);
        }
        if (number instanceof AtomicInteger) {
            return new BigDecimal(((AtomicInteger) number).get());
        }
        if (number instanceof AtomicLong) {
            return new BigDecimal(((AtomicLong) number).get());
        }
        return null;
    }

    private T CharSequenceToTarget(Object value, T defaultValue) {
        String strValue = value.toString();
        if (!Validator.isNumeric(strValue)) {
            return defaultValue;
        }
        BigDecimal decimal = new BigDecimal(strValue);
        T result = cast(decimal);
        return result == null ? defaultValue : result;
    }
}
