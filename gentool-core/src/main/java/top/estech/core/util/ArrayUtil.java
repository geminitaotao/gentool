package top.estech.core.util;

import top.estech.core.exception.UtilException;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 数组工具类.
 *
 * @author taoml
 * @date 2019-06-05
 */
public class ArrayUtil {

    /**
     * 数组中元素未找到的下标，值为-1
     */
    public static final int INDEX_NOT_FOUND = -1;

    /**
     * 数组中是否包含元素
     *
     * @param <T>   数组元素类型
     * @param array 数组
     * @param value 被检查的元素
     * @return 是否包含
     */
    public static <T> boolean contains(T[] array, T value) {
        return indexOf(array, value) > INDEX_NOT_FOUND;
    }

    /**
     * 获取数组对象的元素类型。
     *
     * @param array 数组对象
     * @return 元素类型
     */
    public static Class<?> getComponentType(Object array) {
        return null == array ? null : array.getClass().getComponentType();
    }

    /**
     * 返回数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     *
     * @param <T>   数组类型
     * @param array 数组
     * @param value 被检查的元素
     * @return 数组中指定元素所在位置，未找到返回{@link #INDEX_NOT_FOUND}
     * @since 3.0.7
     */
    public static <T> int indexOf(T[] array, Object value) {
        if (null != array) {
            for (int i = 0; i < array.length; i++) {
                if (ObjectUtil.equal(value, array[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @param <T>   数组类型
     * @return 是否为空
     */
    public static <T> boolean isNullOrEmpty(T... array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(final int... array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(final long... array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(final byte... array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(final char... array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(final double... array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(final float... array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(final short... array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断数组是否为null或空。
     *
     * @param array 被检测的数组
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(final boolean... array) {
        return array == null || array.length == 0;
    }


    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @param <T>   数组类型
     * @return 是否为非空
     */
    public static <T> boolean isNotEmpty(final T... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final int... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final long... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final byte... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final char... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final double... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final float... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final boolean... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 判断数组是否为非空。
     *
     * @param array 被检测的数组
     * @return 是否为非空
     */
    public static boolean isNotEmpty(final short... array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @return 连接后你的字符串
     */
    public static String join(int[] array, String conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * <pre>
     *     int[] array = {1,2,3,4};
     *     ArrayUtil.join(array,",","[","]")    ->      [1],[2],[3],[4]
     * </pre>
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @return 连接后你的字符串
     */
    public static String join(int[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (int item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            builder.append(prefix).append(item).append(suffix);
        }
        return builder.toString();
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @return 连接后你的字符串
     */
    public static String join(long[] array, String conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * <pre>
     *     long[] array = {1L,2L,3L,4L};
     *     ArrayUtil.join(array,",","[","]")    ->      [1],[2],[3],[4]
     * </pre>
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @return 连接后你的字符串
     */
    public static String join(long[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (long item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            builder.append(prefix).append(item).append(suffix);
        }
        return builder.toString();
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @return 连接后你的字符串
     */
    public static String join(double[] array, String conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * <pre>
     *     double[] array = {1,2,3,4};
     *     ArrayUtil.join(array,",","[","]")    ->      [1],[2],[3],[4]
     * </pre>
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @return 连接后你的字符串
     */
    public static String join(double[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (double item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            builder.append(prefix).append(item).append(suffix);
        }
        return builder.toString();
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @return 连接后你的字符串
     */
    public static String join(float[] array, String conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * <pre>
     *     float[] array = {1,2,3,4};
     *     ArrayUtil.join(array,",","[","]")    ->      [1],[2],[3],[4]
     * </pre>
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @return 连接后你的字符串
     */
    public static String join(float[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (float item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            builder.append(prefix).append(item).append(suffix);
        }
        return builder.toString();
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @return 连接后你的字符串
     */
    public static String join(short[] array, String conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * <pre>
     *     short[] array = {1,2,3,4};
     *     ArrayUtil.join(array,",","[","]")    ->      [1],[2],[3],[4]
     * </pre>
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @return 连接后你的字符串
     */
    public static String join(short[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (short item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            builder.append(prefix).append(item).append(suffix);
        }
        return builder.toString();
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @return 连接后你的字符串
     */
    public static String join(char[] array, String conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * <pre>
     *     char[] array = {'1','2','3','4'};
     *     ArrayUtil.join(array,",","[","]")    ->      [1],[2],[3],[4]
     * </pre>
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @return 连接后你的字符串
     */
    public static String join(char[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (char item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            builder.append(prefix).append(item).append(suffix);
        }
        return builder.toString();
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @return 连接后你的字符串
     */
    public static String join(byte[] array, String conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @return 连接后你的字符串
     */
    public static String join(byte[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (byte item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            builder.append(prefix).append(item).append(suffix);
        }
        return builder.toString();
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @return 连接后你的字符串
     */
    public static String join(boolean[] array, String conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @return 连接后你的字符串
     */
    public static String join(boolean[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (boolean item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }
            builder.append(prefix).append(item).append(suffix);
        }
        return builder.toString();
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param <T>         数组类型
     * @return 连接后的字符串
     */
    public static <T> String join(T[] array, CharSequence conjunction) {
        return join(array, conjunction, null, null);
    }

    /**
     * 以CharSequence为分隔符将数组连接起来。
     *
     * <pre>
     *     String[] array = {"1","2","3","4"};
     *     ArrayUtil.join(array,",","[","]")    ->      [1],[2],[3],[4]
     * </pre>
     *
     * @param array       数组
     * @param conjunction 连接符
     * @param prefix      数组元素被包装的前缀
     * @param suffix      数组元素被包装的后缀
     * @param <T>         数组类型
     * @return 连接后你的字符串
     */
    public static <T> String join(T[] array, CharSequence conjunction, String prefix, String suffix) {
        if (array == null) {
            return null;
        }

        final StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (T item : array) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(conjunction);
            }

            if (isArray(item)) {
                builder.append(array);
            } else if (item instanceof Iterator<?>) {
                builder.append(IterationUtil.join((Iterator<?>) item, conjunction, prefix, suffix));
            } else if (item instanceof Iterable) {
                builder.append(IterationUtil.join((Iterable<?>) item, conjunction, prefix, suffix));
            } else {
                builder.append(StringUtil.wrap(String.valueOf(item), prefix, suffix));
            }
        }
        return builder.toString();
    }

    /**
     * 获取数组长度。
     * <p>
     * 如果参数为{@code null}，返回0
     *
     * <pre>
     * ArrayUtil.length(null)            = 0
     * ArrayUtil.length([])              = 0
     * ArrayUtil.length([null])          = 1
     * ArrayUtil.length([true, false])   = 2
     * ArrayUtil.length([1, 2, 3])       = 3
     * ArrayUtil.length(["a", "b", "c"]) = 3
     * </pre>
     *
     * @param array 数组对象
     * @return 数组长度
     * @throws IllegalArgumentException 如果参数不为数组，抛出此异常
     * @see Array#getLength(Object)
     */
    public static int length(Object array) throws IllegalArgumentException {
        if (null == array) {
            return 0;
        }
        return Array.getLength(array);
    }

    /**
     * 新建一个空数组。
     *
     * @param <T>           数组元素类型
     * @param componentType 元素类型
     * @param newSize       大小
     * @return 空数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<?> componentType, int newSize) {
        return (T[]) Array.newInstance(componentType, newSize);
    }

    /**
     * 将数组元素反转。
     *
     * @param array 数组
     * @param <T>   类型
     * @return 反转后的数组
     */
    public static <T> T[] reverse(final T[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }
        return reverse(array, 0, array.length - 1);
    }

    /**
     * 将数组元素反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @param <T>        数组类型
     * @return 反转后的数组
     */
    public static <T> T[] reverse(final T[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        T temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array 数组
     * @return 反转后的数组
     */
    public static int[] reverse(final int[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        return reverse(array, 0, array.length - 1);
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @return 反转后的数组
     */
    public static int[] reverse(final int[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        int temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转。
     *
     * @param array 数组
     * @return 反转后的数组
     */
    public static long[] reverse(final long[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        return reverse(array, 0, array.length - 1);
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @return 反转后的数组
     */
    public static long[] reverse(final long[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        long temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转。
     *
     * @param array 数组
     * @return 反转后的数组
     */
    public static short[] reverse(final short[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        return reverse(array, 0, array.length - 1);
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @return 反转后的数组
     */
    public static short[] reverse(final short[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        short temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转。
     *
     * @param array 数组
     * @return 反转后的数组
     */
    public static double[] reverse(final double[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        return reverse(array, 0, array.length - 1);
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @return 反转后的数组
     */
    public static double[] reverse(final double[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        double temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转。
     *
     * @param array 数组
     * @return 反转后的数组
     */
    public static float[] reverse(final float[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        return reverse(array, 0, array.length - 1);
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @return 反转后的数组
     */
    public static float[] reverse(final float[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        float temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转。
     *
     * @param array 数组
     * @return 反转后的数组
     */
    public static char[] reverse(final char[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        return reverse(array, 0, array.length - 1);
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @return 反转后的数组
     */
    public static char[] reverse(final char[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        char temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array 数组
     * @return 反转后的数组
     */
    public static byte[] reverse(final byte[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        return reverse(array, 0, array.length - 1);
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @return 反转后的数组
     */
    public static byte[] reverse(final byte[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        byte temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 数组反转。
     *
     * @param array 数组
     * @return 反转后的数组
     */
    public static boolean[] reverse(final boolean[] array) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        return reverse(array, 0, array.length - 1);
    }

    /**
     * 数组反转。
     * <p>
     * 反转位置超出索引，默认反转整个数组.
     *
     * @param array      数组
     * @param indexStart 反转起始位置
     * @param indexEnd   反转结束位置
     * @return 反转后的数组
     */
    public static boolean[] reverse(final boolean[] array, final int indexStart, final int indexEnd) {
        if (isNullOrEmpty(array)) {
            return array;
        }

        int i = indexStart < 0 ? 0 : indexStart;
        int j = Math.min(array.length - 1, indexEnd);
        boolean temp;
        while (j > i) {
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
            j--;
            i++;
        }
        return array;
    }

    /**
     * 判断对象是否为数组。
     * <p>
     * 如果对象为null则默认为非数组.
     *
     * @param object
     * @return 是否数组
     */
    public static boolean isArray(Object object) {
        if (object == null) {
            return false;
        }

        return object.getClass().isArray();
    }

    /**
     * {@link ByteBuffer} 转byte数组
     *
     * @param bytebuffer {@link ByteBuffer}
     * @return byte数组
     */
    public static byte[] toArray(ByteBuffer bytebuffer) {
        if (!bytebuffer.hasArray()) {
            int oldPosition = bytebuffer.position();
            bytebuffer.position(0);
            int size = bytebuffer.limit();
            byte[] buffers = new byte[size];
            bytebuffer.get(buffers);
            bytebuffer.position(oldPosition);
            return buffers;
        } else {
            return Arrays.copyOfRange(bytebuffer.array(), bytebuffer.position(), bytebuffer.limit());
        }
    }

    /**
     * 将集合转为数组
     *
     * @param <T>           数组元素类型
     * @param iterable      {@link Iterable}
     * @param componentType 集合元素类型
     * @return 数组
     */
    public static <T> T[] toArray(Iterable<T> iterable, Class<T> componentType) {
        return toArray(CollectionUtil.toCollection(iterable), componentType);
    }

    /**
     * 将集合转为数组
     *
     * @param <T>           数组元素类型
     * @param iterator      {@link Iterator}
     * @param componentType 集合元素类型
     * @return 数组
     */
    public static <T> T[] toArray(Iterator<T> iterator, Class<T> componentType) {
        return toArray(CollectionUtil.newArrayList(iterator), componentType);
    }

    /**
     * 将集合转为数组
     *
     * @param <T>           数组元素类型
     * @param collection    集合
     * @param componentType 集合元素类型
     * @return 数组
     */
    public static <T> T[] toArray(Collection<T> collection, Class<T> componentType) {
        final T[] array = newArray(componentType, collection.size());
        return collection.toArray(array);
    }

    public static String toString(Object object) {
        if (object == null) {
            return null;
        }

        if (isArray(object)) {
            try {
                return Arrays.deepToString((Object[]) object);
            } catch (Exception e) {
                final String typeName = object.getClass().getComponentType().getName();
                switch (typeName) {
                    case "int":
                        return Arrays.toString((int[]) object);
                    case "long":
                        return Arrays.toString((long[]) object);
                    case "short":
                        return Arrays.toString((short[]) object);
                    case "char":
                        return Arrays.toString((char[]) object);
                    case "double":
                        return Arrays.toString((double[]) object);
                    case "float":
                        return Arrays.toString((float[]) object);
                    case "byte":
                        return Arrays.toString((byte[]) object);
                    case "boolean":
                        return Arrays.toString((boolean[]) object);
                    default:
                        throw new UtilException(e);
                }

            }
        }
        return object.toString();
    }
}
