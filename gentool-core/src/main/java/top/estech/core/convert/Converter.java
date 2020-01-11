package top.estech.core.convert;

/**
 * 类型转换接口。
 * <p>
 * 转换标准：转换的数据无法转换成目标类型，则返回默认值
 *
 * @author taoml
 * @date 2019-08-09
 */
public interface Converter<T> {

    /**
     * 转换为指定类型数据。
     *
     * @param value        被转换的数据
     * @param defaultValue 默认值
     * @return 转换后的类型
     */
    T convert(Object value, T defaultValue);
}
