package top.estech.core.lang;

import java.util.regex.Pattern;

/**
 * 验证器。
 *
 * @author taoml
 * @date 2019-08-08
 */
public class Validator {

    /**
     * 判断是否为IPV4。
     *
     * @param ip ip地址
     * @return Boolean
     */
    public static boolean isIpv4(String ip) {
        return isMatch(PatternPool.IPV4, ip);
    }

    /**
     * 判断是否为内网IP。
     * <p>
     * 内网IP网段：
     * 10.0.0.0-10.255.255.255
     * 172.16.0.0-172.31.255.255
     * 192.168.0.0-192.168.255.255
     *
     * @param ip ip地址
     * @return Boolean
     */
    public static boolean isInnerIP(String ip) {
        return !isMatch(PatternPool.INTERNAL_IP, ip);
    }

    /**
     * 判断是否为数字（含小数点）。
     *
     * @param value
     * @return
     */
    public static boolean isNumeric(String value) {
        return isMatch(PatternPool.NUMBER, value);
    }

    private static boolean isMatch(Pattern pattern, String content) {
        if (content == null || pattern == null) {
            // 提供null的字符串为不匹配
            return false;
        }
        return pattern.matcher(content).matches();
    }
}
