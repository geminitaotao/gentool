package top.estech.core.exception;

import top.estech.core.util.ExceptionUtil;
import top.estech.core.util.StringUtil;

/**
 * @author taoml
 * @date 2019-06-07
 */
public class UtilException extends RuntimeException {
    public UtilException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public UtilException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public UtilException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params), throwable);
    }
}
