package top.estech.core.util;

/**
 * @author taoml
 * @date 2019-06-05
 */
public class CharUtil {

    public static final char SPACE = ' ';
    public static final char TAB = '	';
    public static final char DOT = '.';
    public static final char SLASH = '/';
    public static final char BACKSLASH = '\\';
    public static final char CR = '\r';
    public static final char LF = '\n';
    public static final char UNDERLINE = '_';
    public static final char DASHED = '-';
    public static final char COMMA = ',';
    public static final char DELIM_START = '{';
    public static final char DELIM_END = '}';
    public static final char BRACKET_START = '[';
    public static final char BRACKET_END = ']';
    public static final char COLON = ':';
    public static final char DOUBLE_QUOTES = '"';
    public static final char SINGLE_QUOTE = '\'';
    public static final char AMP = '&';

    /**
     * 是否空白符。
     * <p>
     * 空白符包括空格、制表符、全角空格和不间断空格。
     *
     * @param c 字符
     * @return 是否空白符
     */
    public static boolean isBlank(int c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == '\ufeff' || c == '\u202a';
    }

    /**
     * 是否空白符。
     * <p>
     * 空白符包括空格、制表符、全角空格和不间断空格。
     *
     * @param c 字符
     * @return 是否空白符
     */
    public static boolean isBlank(char c) {
        return isBlank((int) c);
    }

    /**
     * 是否emoji表情符。
     *
     * @param c 字符
     * @return 是否emoji表情符
     */
    public static boolean isEmoji(char c) {
        return false == ((c == 0x0) ||
                (c == 0x9) ||
                (c == 0xA) ||
                (c == 0xD) ||
                ((c >= 0x20) && (c <= 0xD7FF)) ||
                ((c >= 0xE000) && (c <= 0xFFFD)) ||
                ((c >= 0x10000) && (c <= 0x10FFFF)));
    }

    /**
     * 是否为字符。
     *
     * @param object 被检测对象
     * @return 是否字符
     */
    public static boolean isChar(Object object) {
        return object instanceof Character || object.getClass() == char.class;
    }

    /**
     * 是否为数字。
     *
     * @param c 检测对象
     * @return 是否为数字
     */
    public static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 是否为16进制规范的字符。
     * <p>
     * 判断是否为如下字符：
     * <pre>
     * 1. 0~9
     * 2. a~f
     * 4. A~F
     * </pre>
     *
     * @param c 字符
     * @return 是否为16进制规范的字符
     */
    public static boolean isHexChar(char c) {
        return isNumber(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    /**
     * 是否为Windows或者Linux（Unix）文件分隔符。
     * <p>
     * Windows平台下分隔符为\，Linux（Unix）为/
     *
     * @param c 字符
     * @return 是否为Windows或者Linux（Unix）文件分隔符
     */
    public static boolean isFileSeparator(char c) {
        return SLASH == c || BACKSLASH == c;
    }

    /**
     * 判断两个字符是否相等。
     *
     * @param c1 字符1
     * @param c2 字符2
     * @return 是否相等
     */
    public static boolean equals(char c1, char c2) {
        return equals(c1, c2, false);
    }

    /**
     * 判断两个字符是否相等。
     *
     * @param c1         字符1
     * @param c2         字符2
     * @param ignoreCase 是否忽略大小写
     * @return 是否相等
     */
    public static boolean equals(char c1, char c2, boolean ignoreCase) {
        return ignoreCase ?
                Character.toLowerCase(c1) == Character.toLowerCase(c2) :
                c1 == c2;
    }

    /**
     * 是否为可见ASCII字符，可见字符位于32~126之间。
     *
     * <pre>
     *   CharUtil.isAsciiPrintable('a')  -> true
     *   CharUtil.isAsciiPrintable('A')  -> true
     *   CharUtil.isAsciiPrintable('3')  -> true
     *   CharUtil.isAsciiPrintable('-')  -> true
     *   CharUtil.isAsciiPrintable('\n') -> false
     *   CharUtil.isAsciiPrintable('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符处
     * @return true表示为ASCII可见字符，可见字符位于32~126之间
     */
    public static boolean isAsciiPrintable(char ch) {
        return ch >= 32 && ch < 127;
    }

    /**
     * 是否为ASCII控制符（不可见字符），控制符位于0~31和127。
     *
     * <pre>
     *   CharUtil.isAsciiControl('a')  -> false
     *   CharUtil.isAsciiControl('A')  -> false
     *   CharUtil.isAsciiControl('3')  -> false
     *   CharUtil.isAsciiControl('-')  -> false
     *   CharUtil.isAsciiControl('\n') -> true
     *   CharUtil.isAsciiControl('&copy;') = false
     * </pre>
     *
     * @param ch 被检查的字符
     * @return true表示为控制符，控制符位于0~31和127
     */
    public static boolean isAsciiControl(final char ch) {
        return ch < 32 || ch == 127;
    }
}
