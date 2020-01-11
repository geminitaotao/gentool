package top.estech.core.util;

import java.util.*;

/**
 * @author taoml
 * @date 2019-08-30
 */
public class CollectionUtil {

    /**
     * 新建一个空ArrayList。
     *
     * @param <T> 集合元素类型
     * @return ArrayList对象
     */
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * 新建一个ArrayList。
     * 提供的参数为null时返回空{@link ArrayList}
     *
     * @param <T>        集合元素类型
     * @param enumration {@link Enumeration}
     * @return ArrayList对象
     */
    public static <T> ArrayList<T> newArrayList(Enumeration<T> enumration) {
        ArrayList<T> list = new ArrayList<>();
        if (null != enumration) {
            while (enumration.hasMoreElements()) {
                list.add(enumration.nextElement());
            }
        }
        return list;
    }

    /**
     * 新建一个List。
     * 提供的参数为null时返回空{@link ArrayList}
     *
     * @param <T>      集合元素类型
     * @param iterable {@link Iterable}
     * @return List对象
     */
    public static <T> ArrayList<T> newArrayList(Iterable<T> iterable) {
        if (null == iterable) {
            return new ArrayList<>();
        }
        return newArrayList(iterable.iterator());
    }

    /**
     * 新建一个ArrayList。
     * 提供的参数为null时返回空{@link ArrayList}
     *
     * @param <T>      集合元素类型
     * @param iterator {@link Iterator}
     * @return ArrayList对象
     */
    public static <T> ArrayList<T> newArrayList(Iterator<T> iterator) {
        ArrayList<T> list = new ArrayList<>();
        if (null != iterator) {
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }
        return list;
    }

    /**
     * 新建一个ArrayList。
     *
     * @param <T>        集合元素类型
     * @param collection 集合
     * @return ArrayList对象
     */
    public static <T> ArrayList<T> newArrayList(Collection<T> collection) {
        return new ArrayList<>(collection);
    }

    /**
     * {@link Iterable}转为{@link Collection}。
     * <p>
     * 首先尝试强转，强转失败则构建一个新的{@link ArrayList}
     *
     * @param <T>      集合元素类型
     * @param iterable {@link Iterable}
     * @return {@link Collection} 或者 {@link ArrayList}
     */
    public static <T> Collection<T> toCollection(Iterable<T> iterable) {
        if (iterable == null) {
            return Collections.emptyList();
        }
        return (iterable instanceof Collection) ? (Collection<T>) iterable : newArrayList(iterable.iterator());
    }
}
