package top.estech.core.convert;

import top.estech.core.util.ExceptionUtil;
import top.estech.core.util.StringUtil;

/**
 * @author taoml
 * @date 2019-08-29
 */
public class ConvertException extends RuntimeException {
    public ConvertException(Throwable e) {
        super(ExceptionUtil.getMessage(e), e);
    }

    public ConvertException(String message) {
        super(message);
    }

    public ConvertException(String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params));
    }

    public ConvertException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ConvertException(Throwable throwable, String messageTemplate, Object... params) {
        super(StringUtil.format(messageTemplate, params), throwable);
    }
}
