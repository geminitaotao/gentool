package top.estech.core.convert.impl;

import top.estech.core.convert.Converter;
import top.estech.core.convert.ConverterRegistry;
import top.estech.core.util.ArrayUtil;
import top.estech.core.util.IterationUtil;
import top.estech.core.util.StringUtil;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author taoml
 * @date 2019-08-30
 */
public class ArrayConverter<T> implements Converter<T> {

    private Class targetType;
    private Class targetComponentType;

    public ArrayConverter(Class targetType) {
        this.targetType = targetType;
        this.targetComponentType = targetType.getComponentType();
    }

    @Override
    public T convert(Object value, T defaultValue) {
        if (value == null) {
            return defaultValue;
        }

        if (value.getClass() == targetType) {
            return (T) value;
        }
        if (value.getClass().isArray()) {
            return (T) arrayToTargetArray(value);
        }
        if (value instanceof CharSequence) {
            return (T) stringToTargetArray(value);
        }
        if (value instanceof List) {
            return (T) listToTargetArray((List<?>) value);
        }
        if (value instanceof Collection) {
            Collection<?> collection = (Collection<?>) value;
            return (T) arrayToTargetArray(collection.toArray());
        }
        if (value instanceof Iterable) {
            Iterable<?> iterable = (Iterable<?>) value;
            List<?> list = IterationUtil.toList(iterable.iterator());
            return (T) listToTargetArray(list);
        }
        if (value instanceof Iterator) {
            List<?> list = IterationUtil.toList((Iterator<?>) value);
            return (T) listToTargetArray(list);
        }

        return (T) singleElementToTargetArray(value);
    }

    private Object arrayToTargetArray(Object convertArray) {
        final int length = ArrayUtil.length(convertArray);
        final Object targetArray = Array.newInstance(targetComponentType, length);

        Converter converter = ConverterRegistry.me().converter(targetComponentType);
        for (int i = 0; i < length; i++) {
            Object value = converter.convert(Array.get(convertArray, i), null);
            Array.set(targetArray, i, value);
        }
        return targetArray;
    }

    private Object stringToTargetArray(Object value) {
        if (targetComponentType == char.class || targetComponentType == Character.class) {
            return arrayToTargetArray(value.toString().toCharArray());
        }

        String[] splits = value.toString().split(StringUtil.COMMA);
        if (splits == null) {
            splits = new String[]{};
        }
        return arrayToTargetArray(splits);
    }

    private Object listToTargetArray(List<?> list) {
        final Object targetArray = ArrayUtil.newArray(targetComponentType, list.size());
        Converter converter = ConverterRegistry.me().converter(targetComponentType);

        for (int i = 0; i < list.size(); i++) {
            Object temp = converter.convert(Array.get(list.get(i), i), null);
            Array.set(targetArray, i, temp);
        }
        return targetArray;
    }

    private Object singleElementToTargetArray(Object value) {
        final Object[] targetArray = ArrayUtil.newArray(targetComponentType, 1);
        Converter converter = ConverterRegistry.me().converter(targetComponentType);
        targetArray[0] = converter.convert(value, null);
        return targetArray;
    }
}
