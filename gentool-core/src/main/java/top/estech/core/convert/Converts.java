package top.estech.core.convert;

/**
 * @author taoml
 * @date 2019-09-04
 */
public class Converts {

    /**
     * 转换为指定的数据类型。
     * <p>
     * 默认值：
     * 类：null
     * 原始类型：0
     *
     * @param clazz 类型
     * @param value 转换的数据
     * @param <T>   目标类型
     * @return 转换值
     * @throws ConvertException
     */
    public static <T> T convert(Class<T> clazz, Object value) throws ConvertException {
        return convert(clazz, value, null);
    }

    /**
     * 转换为指定的数据类型。
     *
     * @param clazz        类型
     * @param value        转换的数据
     * @param defaultValue 默认值
     * @param <T>          目标类型
     * @return 转换值
     * @throws ConvertException
     */
    public static <T> T convert(Class<T> clazz, Object value, T defaultValue) throws ConvertException {
        return ConverterRegistry.me().converter(clazz).convert(value, defaultValue);
    }


    /**
     * 转换为int值。
     * <p>
     * 无法转换则默认值为0
     *
     * @param value 转换数据
     * @return int
     */
    public static int toInt(Object value) {
        return toInt(value, 0);
    }

    /**
     * 转换为int
     *
     * @param value        转换数据
     * @param defaultValue 默认值
     * @return int
     */
    public static int toInt(Object value, int defaultValue) {
        return ConverterRegistry.me().converter(int.class).convert(value, defaultValue);
    }
}
