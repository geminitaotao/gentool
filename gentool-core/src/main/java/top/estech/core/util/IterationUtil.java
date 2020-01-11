package top.estech.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author taoml
 * @date 2019-06-07
 */
public class IterationUtil {

    /**
     * 判断Iterator是否为null或为空。
     *
     * @param iterator 检测对象
     * @return 是否为null或空
     */
    public static boolean isNullOrEmpty(Iterator<?> iterator) {
        return iterator == null || !iterator.hasNext();
    }

    /**
     * 判断Iterable是否为null或为空。
     *
     * @param iterable 检测对象
     * @return 是否为null或空
     */
    public static boolean isNullOrEmpty(Iterable<?> iterable) {
        return iterable == null || isNullOrEmpty(iterable.iterator());
    }

    /**
     * 以conjunction为分隔符将集合连接起来。
     *
     * @param iterable    集合
     * @param conjunction 连接符
     * @param <T>         集合类型
     * @return 连接后的字符串
     */
    public static <T> String join(Iterable<T> iterable, CharSequence conjunction) {
        return join(iterable.iterator(), conjunction, null, null);
    }

    /**
     * 以conjunction为分隔符将集合连接起来。
     *
     * <pre>
     *      List: a b c d
     *      IterationUtil.join(List,",","[","]") -> "[a],[b],[c],[d]"
     * </pre>
     *
     * @param iterable    集合
     * @param conjunction 连接符
     * @param prefix      集合元素被包装的前缀
     * @param suffix      集合元素被包装的后缀
     * @param <T>         集合类型
     * @return 连接后的字符串
     */
    public static <T> String join(Iterable<T> iterable, CharSequence conjunction, String prefix, String suffix) {
        return join(iterable.iterator(), conjunction, prefix, suffix);
    }

    /**
     * 以conjunction为分隔符将集合连接起来。
     *
     * @param iterator    集合
     * @param conjunction 连接符
     * @param <T>         集合类型
     * @return 连接后的字符串
     */
    public static <T> String join(Iterator<T> iterator, CharSequence conjunction) {
        return join(iterator, conjunction, null, null);
    }

    /**
     * 以conjunction为分隔符将集合连接起来。
     *
     * @param iterator    集合
     * @param conjunction 连接符
     * @param prefix      集合元素被包装的前缀
     * @param suffix      集合元素被包装的后缀
     * @param <T>         集合类型
     * @return 连接后的字符串
     */
    public static <T> String join(Iterator<T> iterator, CharSequence conjunction, String prefix, String suffix) {
        if (iterator == null) {
            return null;
        }

        boolean isFirst = true;
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            T item = iterator.next();
            if (ArrayUtil.isArray(item)) {
                builder.append(item);
            } else if (item instanceof Iterator<?>) {
                builder.append(join((Iterator<?>) item, conjunction, prefix, suffix));
            } else if (item instanceof Iterable<?>) {
                builder.append(join((Iterable<?>) item, conjunction, prefix, suffix));
            } else {
                builder.append(StringUtil.wrap(String.valueOf(item), prefix, suffix));
            }
        }
        return builder.toString();
    }

    public static <T> List<T> toList(Iterator<T> iterator) {
        final List<T> list = new ArrayList();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
