package top.estech.core.util;

import top.estech.core.lang.Validator;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * 字符串工具类
 *
 * @author taoml
 * @date 2019-06-04
 */
public class StringUtil {

    public static final int INDEX_NOT_FOUND = -1;

    /**
     * 字符: 空格
     */
    public static final char CHAR_SPACE = CharUtil.SPACE;
    /**
     * 字符: 制表符
     */
    public static final char CHAR_TAB = CharUtil.TAB;
    /**
     * 字符: 英文句号
     **/
    public static final char CHAR_DOT = CharUtil.DOT;
    /**
     * 字符: 斜杠
     */
    public static final char CHAR_SLASH = CharUtil.SLASH;
    /**
     * 字符: 反斜杠
     */
    public static final char CHAR_BACKSLASH = CharUtil.BACKSLASH;
    /**
     * 字符: 回车
     */
    public static final char CHAR_CR = CharUtil.CR;
    /**
     * 字符: 换行
     */
    public static final char CHAR_LF = CharUtil.LF;
    /**
     * 字符: 下划线
     */
    public static final char CHAR_UNDERLINE = CharUtil.UNDERLINE;
    /**
     * 字符: 逗号
     */
    public static final char CHAR_COMMA = CharUtil.COMMA;
    /**
     * 字符: 左大括号
     */
    public static final char CHAR_DELIM_START = CharUtil.DELIM_START;
    /**
     * 字符: 右大括号
     */
    public static final char CHAR_DELIM_END = CharUtil.DELIM_END;
    /**
     * 字符: 左中括号
     */
    public static final char CHAR_BRACKET_START = CharUtil.BRACKET_START;
    /**
     * 字符: 右中括号
     */
    public static final char CHAR_BRACKET_END = CharUtil.BRACKET_END;
    /**
     * 字符: 冒号
     */
    public static final char CHAR_COLON = CharUtil.COLON;

    public static final String SPACE = " ";
    public static final String TAB = "	";
    public static final String DOT = ".";
    public static final String DOUBLE_DOT = "..";
    public static final String SLASH = "/";
    public static final String BACKSLASH = "\\";
    public static final String EMPTY = "";
    public static final String NULL = "null";
    public static final String CR = "\r";
    public static final String LF = "\n";
    public static final String CRLF = "\r\n";
    public static final String UNDERLINE = "_";
    public static final String DASHED = "-";
    public static final String COMMA = ",";
    public static final String DELIM_START = "{";
    public static final String DELIM_END = "}";
    public static final String BRACKET_START = "[";
    public static final String BRACKET_END = "]";
    public static final String COLON = ":";

    public static final String HTML_NBSP = "&nbsp;";
    public static final String HTML_AMP = "&amp;";
    public static final String HTML_QUOTE = "&quot;";
    public static final String HTML_APOS = "&apos;";
    public static final String HTML_LT = "&lt;";
    public static final String HTML_GT = "&gt;";

    public static final String EMPTY_JSON = "{}";

    /**
     * 格式化字符串,使用{varName}占位符。
     *
     * <pre>
     *      map = {varName1: a, varName2: b};
     *      String template = "var1 is {varName1}, var2 is {varName2}";
     *      StringUtil.format(template, map)    ->      var1 is a, var2 is b
     * </pre>
     *
     * @param template 格式化模板
     * @param map      参数
     * @return 格式化后的字符串
     */
    public static String format(CharSequence template, Map<?, ?> map) {
        if (template == null) {
            return null;
        }
        if (map == null || map.isEmpty()) {
            return template.toString();
        }

        final String[] newTemplate = {template.toString()};
        map.forEach((k, v) -> {
            String value = of(v, CharsetUtil.charset(CharsetUtil.UTF_8));
            if (value != null) {
                String target = "{" + k + "}";
                newTemplate[0] = newTemplate[0].replace(target, value);
            }
        });
        return newTemplate[0];
    }

    /**
     * 格式化字符串, 使用{}占位符，占位符按顺序替换。
     * <p>
     * 占位符多出按照原样输出。
     * 参数多于占位符，多出的参数自动忽略掉。
     * <pre>
     *     StringUtil.format("var1: {},var2: {}", "a")  ->  var1: a,var2: {}
     *     StringUtil.format("var1: {},var2: {}", "a","b","c")  ->  var1: a,var2: b
     * </pre>
     *
     * @param template 格式化模板
     * @param array    参数
     * @return 格式化后的字符串
     */
    public static String format(CharSequence template, Object... array) {
        if (template == null) {
            return null;
        }
        if (ArrayUtil.isNullOrEmpty(array)) {
            return template.toString();
        }

        final String newTemplate = template.toString();
        StringBuilder result = new StringBuilder();
        int placeIndex = 0;
        for (int i = 0; i < array.length; i++) {
            int index = newTemplate.indexOf(EMPTY_JSON, placeIndex);
            if (index == -1) {
                if (placeIndex == 0) {
                    return newTemplate;
                }
                result.append(newTemplate, placeIndex, newTemplate.length());
                placeIndex = newTemplate.length();
            } else {
                result.append(newTemplate, placeIndex, index).append(array[i]);
                placeIndex = index + 2;
            }
        }
        //占位符超过参数，将模板剩下的字符串合并
        result.append(newTemplate, placeIndex, newTemplate.length());

        return result.toString();
    }

    /**
     * 判断序列是否为空白。
     *
     * <pre>
     *      空白标准:
     *      1. 为null
     *      2. 为不可见字符: 空格、制表符、全角空格和不间断空格
     * </pre>
     *
     * @param sequence 检测对象
     * @return 是否空白
     */
    public static boolean isBlank(CharSequence sequence) {
        int lenght;
        if (sequence == null || (lenght = sequence.length()) == 0) {
            return true;
        }

        for (int i = 0; i < lenght; i++) {
            if (!CharUtil.isBlank(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串是否为非空白。
     *
     * @param sequence 检测对象
     * @return 是否非空白
     */
    public static boolean isNotBlank(CharSequence sequence) {
        return !isBlank(sequence);
    }

    /**
     * 判断字符串是否为空。
     * <p>
     * 字符串为空条件: <br/>
     * 1. 为null<br/>
     * 2. 为""<br/>
     *
     * @param sequence 被检测的字符串
     * @return 是否为空
     */
    public static boolean isNullOrEmpty(CharSequence sequence) {
        return sequence == null || sequence.length() == 0;
    }

    /**
     * 判断字符串是否为数字。
     *
     * @param sequence 字符串
     * @return 是否数字
     */
    public static boolean isNumber(final CharSequence sequence) {
        if (isNullOrEmpty(sequence)) {
            return false;
        }

        return Validator.isNumeric(sequence.toString());
    }

    /**
     * 判断字符串是否为非空。
     * <p>
     * 字符串非空条件: <br/>
     * 1. 不为null <br/>
     * 2. 不为"" <br/>
     *
     * @param sequence 被检测的字符串
     * @return 是否为非空
     */
    public static boolean isNotEmpty(CharSequence sequence) {
        return !isNullOrEmpty(sequence);
    }

    /**
     * 如果字符串为<code>null</code>,则返回<code>""</code>，否则返回字符串本身。
     *
     * @param sequence 原始字符串
     * @return 空或者本身
     */
    public static String nullToEmpty(CharSequence sequence) {
        return nullToDefault(sequence, EMPTY);
    }

    /**
     * 如果字符串为<code>null</code>,则返回指定的字符串，否则返回字符串本身。
     *
     * @param sequence   原始字符串
     * @param defaultStr 指定的字符串
     * @return 指定的字符串或者本身
     */
    public static String nullToDefault(CharSequence sequence, String defaultStr) {
        return sequence == null ? defaultStr : sequence.toString();
    }

    /**
     * byte数组转字符串。
     * <p>
     * 默认使用系统的编码格式。
     *
     * @param bytes byte数组
     * @return 字符串
     */
    public static String of(byte[] bytes) {
        return of(bytes, Charset.defaultCharset());
    }

    /**
     * byte数组转字符串。
     *
     * @param bytes   byte数组
     * @param charset 字符集
     * @return 字符串
     */
    public static String of(byte[] bytes, Charset charset) {
        if (bytes == null) {
            return null;
        }

        return new String(bytes, charset == null ? Charset.defaultCharset() : charset);
    }

    /**
     * Byte数组转字符串。
     *
     * @param bytes   Byte数组
     * @param charset 字符集
     * @return 字符串
     */
    public static String of(Byte[] bytes, Charset charset) {
        if (bytes == null) {
            return null;
        }

        byte[] temp = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            temp[i] = bytes[i].byteValue();
        }
        return of(temp, charset);
    }

    /**
     * Byte数组转字符串。
     *
     * @param bytes Byte数组
     * @return 字符串
     */
    public static String of(Byte[] bytes) {
        return of(bytes, Charset.defaultCharset());
    }

    /**
     * ByteBuffer转字符串。
     *
     * @param buffer
     * @param charset
     * @return
     */
    public static String of(ByteBuffer buffer, Charset charset) {
        if (buffer == null) {
            return null;
        }
        if (charset == null) {
            charset = Charset.defaultCharset();
        }

        return charset.decode(buffer).toString();
    }

    public static String of(ByteBuffer buffer) {
        return of(buffer, Charset.defaultCharset());
    }

    /**
     * object转换为字符串(使用默认的字符集)。
     *
     * @param object 转换对象
     * @return 字符串
     */
    public static String of(Object object) {
        return of(object, Charset.defaultCharset());
    }

    /**
     * object转换为字符串。
     *
     * @param object  转换对象
     * @param charset 字符集
     * @return 字符串
     */
    public static String of(Object object, Charset charset) {
        if (object == null) {
            return null;
        }
        if (object instanceof String) {
            return object.toString();
        } else if (object instanceof byte[]) {
            return of((byte[]) object, charset);
        } else if (object instanceof Byte[]) {
            return of((Byte[]) object, charset);
        } else if (object instanceof ByteBuffer) {
            return of((ByteBuffer) object, charset);
        } else if (ArrayUtil.isArray(object)) {
            return ArrayUtil.toString(object);
        }

        return object.toString();
    }

    /**
     * 字符串左补齐。
     * <p>
     * 当被补齐字符串的长度超过指定总长度，默认不做处理，直接返回原始字符串。
     *
     * @param sequence    原始数据
     * @param totalLength 补齐总长度
     * @param padChar     补齐的字符
     * @return 补齐字符串
     */
    public static String padLeft(CharSequence sequence, int totalLength, char padChar) {
        if (sequence == null) {
            return null;
        }

        final int strLength = sequence.length();
        return strLength >= totalLength ?
                sequence.toString() :
                repeat(padChar, totalLength - strLength).concat(sequence.toString());
    }

    /**
     * 字符串右补齐。
     * <p>
     * 当被补齐字符串的长度超过指定总长度，默认不做处理，直接返回原始字符串.
     *
     * @param sequence    原始对象
     * @param totalLength 补齐总长度
     * @param padChar     补齐的字符
     * @return 补齐字符串
     */
    public static String padRight(CharSequence sequence, int totalLength, char padChar) {
        if (sequence == null) {
            return null;
        }
        final int strLength = sequence.length();
        return strLength >= totalLength ?
                sequence.toString() :
                sequence.toString().concat(repeat(padChar, totalLength - strLength));
    }

    /**
     * 重复构造指定字符。
     *
     * @param c     指定字符
     * @param count 重复次数
     * @return 重复字符串
     */
    public static String repeat(char c, int count) {
        if (count <= 0) {
            return EMPTY;
        }

        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = c;
        }

        return new String(chars);
    }

    /**
     * 重复构造指定序列。
     * <p>
     * <pre>
     *      StringUtil.repeat("ab", 2) ->  "abab"
     * </pre>
     * 此实现在重复次数数值较大时效率较高.
     * 测试在序列长度100，重复次数10000，是StringBuild的2倍.
     *
     * @param sequence 指定序列
     * @param count    重复次数
     * @return 重复字符串
     */
    public static String repeat(CharSequence sequence, int count) {
        if (sequence == null) {
            return null;
        }
        if (count <= 0) {
            return EMPTY;
        }
        if (count == 1) {
            return sequence.toString();
        }

        final int lenSequence = sequence.length();
        final int lenTotal = lenSequence * count;
        // int类型相乘超出最大值时会溢出，结果会变为负数
        if (lenTotal < 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid index charsequence len: " + lenSequence + " repeat count: " + count);
        }
        char[] chars = new char[lenTotal];
        sequence.toString().getChars(0, lenSequence, chars, 0);

        int n;
        // n <<= 1 为*2运算，位运算可提高效率
        for (n = lenSequence; n < lenTotal - n; n <<= 1) {
            System.arraycopy(chars, 0, chars, n, n);
        }
        System.arraycopy(chars, 0, chars, n, lenTotal - n);
        return new String(chars);
    }

    /**
     * 字符串反转。
     *
     * <pre>
     *     StringUtil.reverse("abcd") -> "dcba"
     * </pre>
     *
     * @param sequence 反转的字符串
     * @return 反转后的字符串
     */
    public static String reverse(String sequence) {
        if (isNullOrEmpty(sequence)) {
            return sequence;
        }

        return new String(ArrayUtil.reverse(sequence.toCharArray()));
    }

    /**
     * 从序列开始到指定位置提取字符串。
     * <p>
     * 如果指定位置为负数，则为反向提取。
     * <pre>
     *      StringUtil.subLeft("abcdefg", -1) -> "abcdef"
     * </pre>
     *
     * @param sequence 被提取序列
     * @param toIndex  指定位置
     * @return 提取后的字符串
     */
    public static String subLeft(CharSequence sequence, int toIndex) {
        return subString(sequence, 0, toIndex);
    }

    /**
     * 从指定位置开始到结尾提取字符串。
     * <p>
     * 提取索引支持负数，当索引为负数时即为反方向提取。
     * <pre>
     *      StringUtil.subString("abcdefg", -1) -> "g"
     * </pre>
     *
     * @param sequence  被提取的数据
     * @param fromIndex 开始索引
     * @return 提取后的字符串
     */
    public static String subString(CharSequence sequence, int fromIndex) {
        if (isNullOrEmpty(sequence)) {
            return toString(sequence);
        }

        return subString(sequence, fromIndex, sequence.length());
    }

    /**
     * 提取字符串。
     * <p>
     * 提取索引支持负数，当索引为负数时即为反方向提取。
     * <pre>
     *      StringUtil.subString("abcdefg", -1) -> "g"
     * </pre>
     *
     * @param sequence  被提取的数据
     * @param fromIndex 开始索引
     * @param toIndex   结束索引
     * @return 提取后的字符串
     */
    public static String subString(CharSequence sequence, int fromIndex, int toIndex) {
        if (isNullOrEmpty(sequence)) {
            return toString(sequence);
        }

        final int length = sequence.length();
        if (fromIndex < 0) {
            fromIndex = fromIndex + length;
            if (fromIndex < 0) {
                fromIndex = 0;
            }
        }

        if (toIndex < 0) {
            toIndex = toIndex + length;
            if (toIndex < 0) {
                toIndex = length;
            }
        } else if (toIndex > length) {
            toIndex = length;
        }

        if (fromIndex > toIndex) {
            int temp = toIndex;
            toIndex = fromIndex;
            fromIndex = temp;
        }

        if (fromIndex == toIndex) {
            return EMPTY;
        }

        return sequence.toString().substring(fromIndex, toIndex);
    }

    /**
     * 将{@link CharSequence}转为字符串(null安全)。
     * <p>
     * 如果被转数据为空直接返回null。
     *
     * @param object 被转换数据
     * @return 字符串
     */
    public static String toString(Object object) {
        return object == null ? null : object.toString();
    }

    /**
     * 包装字符串。
     *
     * <pre>
     *     StringUtil.wrap("中国","[","]") -> [中国]
     * </pre>
     *
     * @param sequence 被包装的对象
     * @param prefix   前缀
     * @param suffix   后缀
     * @return 包装后的字符串
     */
    public static String wrap(CharSequence sequence, String prefix, String suffix) {
        return nullToEmpty(prefix).concat(nullToEmpty(sequence)).concat(nullToEmpty(suffix));
    }
}
