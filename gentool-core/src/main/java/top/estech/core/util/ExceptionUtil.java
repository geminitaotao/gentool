package top.estech.core.util;

/**
 * @author taoml
 * @date 2019-06-07
 */
public class ExceptionUtil {
    /**
     * 获得完整消息，包括异常名
     *
     * @param e 异常
     * @return 完整消息
     */
    public static String getMessage(Throwable e) {
        if (null == e) {
            return StringUtil.NULL;
        }
        return StringUtil.format("{}: {}", e.getClass().getSimpleName(), e.getMessage());
    }
}
