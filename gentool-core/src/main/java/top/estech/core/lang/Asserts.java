package top.estech.core.lang;

import top.estech.core.util.ArrayUtil;
import top.estech.core.util.StringUtil;

/**
 * 断言
 *
 * @author taoml
 * @date 2019-06-05
 */
public final class Asserts {

    /**
     * 断言是否为true,否输出异常信息。
     *
     * @param expression 断言的表达式
     */
    public static void isTrue(boolean expression) {
        if (expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 断言是否为true,否输出异常信息。
     *
     * @param expression   表达式
     * @param errorMessage 输出的异常信息
     */
    public static void isTrue(boolean expression, String errorMessage) {
        if (expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * 断言是否为true,否输出异常信息。
     *
     * @param expression           表达式
     * @param errorMessageTemplate 异常输出模板
     * @param params               模板参数
     */
    public static void isTrue(boolean expression, String errorMessageTemplate, Object... params) {
        if (expression) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
    }

    /**
     * 断言是否为false,否输出异常信息。
     *
     * @param expression 断言的表达式
     */
    public static void isFalse(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 断言是否为false,否输出异常信息。
     *
     * @param expression   表达式
     * @param errorMessage 输出的异常信息
     */
    public static void isFalse(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * 断言是否为false,否输出异常信息。
     *
     * @param expression           表达式
     * @param errorMessageTemplate 异常输出模板
     * @param params               模板参数
     */
    public static void isFalse(boolean expression, String errorMessageTemplate, Object... params) {
        if (!expression) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
    }

    /**
     * 断言是否为指定类型,否输出异常信息。
     *
     * @param type 指定的类型
     * @param obj  断言的对象
     * @param <T>  类型
     * @return 断言的对象
     */
    public static <T> T isInstanceOf(Class<?> type, T obj) {
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException();
        }
        return obj;
    }

    /**
     * 断言是否为指定类型,否输出异常信息。
     *
     * @param type         指定的类型
     * @param obj          断言的对象
     * @param errorMessage 输出的异常信息
     * @param <T>          类型
     * @return 断言的对象
     */
    public static <T> T isInstanceOf(Class<?> type, T obj, String errorMessage) {
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return obj;
    }

    /**
     * 断言是否为指定类型,否输出异常信息。
     *
     * @param type                 指定的类型
     * @param obj                  断言的对象
     * @param errorMessageTemplate 异常模板
     * @param params               异常模板参数
     * @param <T>                  类型
     * @return 断言的对象
     */
    public static <T> T isInstanceOf(Class<?> type, T obj, String errorMessageTemplate, Object... params) {
        if (!type.isInstance(obj)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return obj;
    }

    /**
     * 断言是否为空,否输出异常信息。
     *
     * @param argument 断言对象
     */
    public static void isNull(Object argument) {
        if (argument != null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 断言是否为空,否输出异常信息。
     *
     * @param argument     断言对象
     * @param errorMessage 输出的异常信息
     */
    public static void isNull(Object argument, String errorMessage) {
        if (argument != null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * 断言是否为空,否输出异常信息。
     *
     * @param argument             断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     */
    public static void isNull(Object argument, String errorMessageTemplate, Object... params) {
        if (argument != null) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
    }

    /**
     * 断言是否不为空,否输出异常信息。
     *
     * @param argument 断言对象
     * @param <T>      类型
     * @return 断言对象
     */
    public static <T> T isNotNull(T argument) {
        if (argument == null) {
            throw new NullPointerException();
        }
        return argument;
    }

    /**
     * 断言是否不为空,否输出异常信息。
     *
     * @param argument     断言对象
     * @param errorMessage 异常信息
     * @param <T>          类型
     * @return 断言对象
     */
    public static <T> T isNotNull(T argument, String errorMessage) {
        if (argument == null) {
            throw new NullPointerException(errorMessage);
        }
        return argument;
    }

    /**
     * 断言是否不为空,否输出异常信息。
     *
     * @param argument             断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               异常参数
     * @param <T>                  类型
     * @return 断言对象
     */
    public static <T> T isNotNull(T argument, String errorMessageTemplate, Object... params) {
        if (argument == null) {
            throw new NullPointerException(StringUtil.format(errorMessageTemplate, params));
        }
        return argument;
    }

    /**
     * 断言是否不为null或者空字符串,否输出异常信息。
     *
     * @param argument 断言对象
     * @return 断言对象
     */
    public static String isNotEmpty(String argument) {
        if (StringUtil.isNullOrEmpty(argument)) {
            throw new IllegalArgumentException();
        }
        return argument;
    }

    /**
     * 断言是否不为null或者空字符串,否输出异常信息。
     *
     * @param argument     断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static String isNotEmpty(String argument, String errorMessage) {
        if (StringUtil.isNullOrEmpty(argument)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return argument;
    }

    /**
     * 断言是否不为null或者空字符串,否输出异常信息。
     *
     * @param argument             断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static String isNotEmpty(String argument, String errorMessageTemplate, Object... params) {
        if (StringUtil.isNullOrEmpty(argument)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return argument;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static int[] isNotEmpty(int[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static int[] isNotEmpty(int[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static int[] isNotEmpty(int[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static long[] isNotEmpty(long[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static long[] isNotEmpty(long[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static long[] isNotEmpty(long[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static short[] isNotEmpty(short[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static short[] isNotEmpty(short[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static short[] isNotEmpty(short[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static byte[] isNotEmpty(byte[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static byte[] isNotEmpty(byte[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static byte[] isNotEmpty(byte[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static float[] isNotEmpty(float[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static float[] isNotEmpty(float[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static float[] isNotEmpty(float[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static double[] isNotEmpty(double[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static double[] isNotEmpty(double[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static double[] isNotEmpty(double[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static char[] isNotEmpty(char[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static char[] isNotEmpty(char[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static char[] isNotEmpty(char[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static boolean[] isNotEmpty(boolean[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static boolean[] isNotEmpty(boolean[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static boolean[] isNotEmpty(boolean[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments 断言对象
     * @return 断言对象
     */
    public static <T> T[] isNotEmpty(T[] arguments) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException();
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments    断言对象
     * @param errorMessage 异常信息
     * @return 断言对象
     */
    public static <T> T[] isNotEmpty(T[] arguments, String errorMessage) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(errorMessage);
        }
        return arguments;
    }

    /**
     * 断言是否不为null或者空数组,否输出异常信息。
     *
     * @param arguments            断言对象
     * @param errorMessageTemplate 异常模板
     * @param params               模板参数
     * @return 断言对象
     */
    public static <T> T[] isNotEmpty(T[] arguments, String errorMessageTemplate, Object... params) {
        if (ArrayUtil.isNullOrEmpty(arguments)) {
            throw new IllegalArgumentException(StringUtil.format(errorMessageTemplate, params));
        }
        return arguments;
    }
}
