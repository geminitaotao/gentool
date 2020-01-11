package top.estech.core.convert;

import top.estech.core.convert.impl.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class ConverterRegistry {

    private final static Map<Class, Converter> CONVERTERS = new ConcurrentHashMap<>();

    static {

        CONVERTERS.put(int.class, new PrimitiveConverter(int.class));
        CONVERTERS.put(long.class, new PrimitiveConverter(long.class));
        CONVERTERS.put(float.class, new PrimitiveConverter(float.class));
        CONVERTERS.put(double.class, new PrimitiveConverter(double.class));
        CONVERTERS.put(short.class, new PrimitiveConverter(short.class));
        CONVERTERS.put(byte.class, new PrimitiveConverter(byte.class));
        CONVERTERS.put(char.class, new PrimitiveConverter(char.class));
        CONVERTERS.put(boolean.class, new PrimitiveConverter(boolean.class));

        CONVERTERS.put(Integer.class, new IntegerConverter());
        CONVERTERS.put(Long.class, new LongConverter());
        CONVERTERS.put(Float.class, new FloatConverter());
        CONVERTERS.put(Double.class, new DoubleConverter());
        CONVERTERS.put(Short.class, new ShortConverter());
        CONVERTERS.put(Byte.class, new ByteConverter());
        CONVERTERS.put(Character.class, new CharacterConverter());
        CONVERTERS.put(Boolean.class, new BooleanConverter());

        CONVERTERS.put(String.class, new StringConverter());
        CONVERTERS.put(BigDecimal.class, new BigDecimalConverter());
        CONVERTERS.put(BigInteger.class, new BigIntegerConverter());
        CONVERTERS.put(AtomicIntegeConverter.class, new AtomicIntegeConverter());
        CONVERTERS.put(AtomicLongConverter.class, new AtomicLongConverter());

        CONVERTERS.put(int[].class, new ArrayConverter(int[].class));
        CONVERTERS.put(long[].class, new ArrayConverter(long[].class));
        CONVERTERS.put(float[].class, new ArrayConverter(float[].class));
        CONVERTERS.put(double[].class, new ArrayConverter(double[].class));
        CONVERTERS.put(short[].class, new ArrayConverter(short[].class));
        CONVERTERS.put(byte[].class, new ArrayConverter(byte[].class));
        CONVERTERS.put(char[].class, new ArrayConverter(char[].class));
        CONVERTERS.put(boolean[].class, new ArrayConverter(boolean[].class));

        CONVERTERS.put(Integer[].class, new ArrayConverter(Integer[].class));
        CONVERTERS.put(Long[].class, new ArrayConverter(Long[].class));
        CONVERTERS.put(Float[].class, new ArrayConverter(Float[].class));
        CONVERTERS.put(Double[].class, new ArrayConverter(Double[].class));
        CONVERTERS.put(Short[].class, new ArrayConverter(Short[].class));
        CONVERTERS.put(Byte[].class, new ArrayConverter(Byte[].class));
        CONVERTERS.put(Boolean[].class, new ArrayConverter(Boolean[].class));
        CONVERTERS.put(Character[].class, new ArrayConverter(Character[].class));
        CONVERTERS.put(BigDecimal[].class, new ArrayConverter(BigDecimal[].class));
        CONVERTERS.put(BigInteger[].class, new ArrayConverter(BigInteger[].class));
        CONVERTERS.put(String[].class, new ArrayConverter(String[].class));

    }

    public static ConverterRegistry me() {
        return ConverterRegistryEnum.INSTANCE.getRegistry();
    }

    public <T> Converter<T> converter(Class<T> clazz) throws ConvertException {
        Converter<T> converter = CONVERTERS.get(clazz);
        if (converter != null) {
            return converter;
        }
        if (clazz.isArray()) {
            converter = new ArrayConverter<>(clazz);
            CONVERTERS.put(clazz, converter);
            return converter;
        }

        throw new ConvertException("不支持{}类型转换器", clazz.getName());
    }

    private enum ConverterRegistryEnum {
        INSTANCE;

        private ConverterRegistry registry;

        ConverterRegistryEnum() {
            registry = new ConverterRegistry();
        }

        public ConverterRegistry getRegistry() {
            return this.registry;
        }
    }
}
